package com.capg;
import java.math.BigInteger;
import java.util.List;

import javax.persistence.*;

public class AuthorMain {
	EntityManagerFactory emf;
	public static void main(String[] args)
	{
		AuthorMain author=new AuthorMain();
		author.execute();
	}
	public void execute()
	{
		emf=Persistence.createEntityManagerFactory("author-data");
		System.out.println("AUTHOR DETAIL INSERTION IN DATABASE--------------");
		Author author=createAuthor();
		print(author);
		
		List<Author> authors=listAllAuthors();
		System.out.println("PRINTING LIST OF AUTHOR");
		print(authors);
		
		System.out.println("FINDING AUTHOR BY ID");
		int authorId= author.getAuthorId();
		Author found=findAuthorById(authorId);
		print(found);
		
		
       
        System.out.println("UPDATION OPERATION");
        found.setFirstName("Adi");
        found.setMiddleName("M");
        found.setLastName("chouksey");
        UpdateAuthor(found);
        print(found);
       
        System.out.println("DELETION OPERATION ");
		deleteAuthorById(authorId);
         emf.close();
        
	}
       

    void print(Author author)
    {
        System.out.println("author id: "+author.getAuthorId()+" "+"author firstname: "+author.getFirstName()+" "
    +"author middlename :"+author.getMiddleName()+" "+"author lastname :"+author.getLastName()+" "+"author phone no :"+author.getPhoneNo());
        

    }
    void print(List<Author> authors)
    {
    	for(Author author:authors)
    	{
    	print(author);
    	}
    }
    

    public Author createAuthor()
	{
		EntityManager entityManager=emf.createEntityManager();
		 EntityTransaction transaction = entityManager.getTransaction();
	        transaction.begin();
	        Author author=new Author();
	   
	     author.setFirstName("Aditya");
	     author.setMiddleName("M");
	     author.setLastName("Chouksey");
	     author.setPhoneNo(new BigInteger("123456789"));
	     entityManager.persist(author);
	     transaction.commit();
	     System.out.println("Details inserted of id : " +author.getAuthorId());
	     entityManager.close();
	     return author;
	     
		
	}
    
    public Author UpdateAuthor(Author author)
    {
    	EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
    	  author=entityManager.merge(author);
          transaction.commit();
          entityManager.close();
          return author;
    }
    
   public List<Author> listAllAuthors(){
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Query query =entityManager.createQuery("from Author");
        List<Author>authors=query.getResultList();
        transaction.commit();
        entityManager.close();
        return authors;
    }  
    
    
    public void deleteAuthorById(int authorId)
    {
    	EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
	Author author=entityManager.find(Author.class, authorId);
	entityManager.remove(author);
	transaction.commit();
	 entityManager.close();
	System.out.println("Author deleted :"+authorId);
	
    }
    
    public  Author findAuthorById(int authorId)
    {
    	 EntityManager entityManager = emf.createEntityManager();
         EntityTransaction transaction = entityManager.getTransaction();
         transaction.begin();
    	Author author=entityManager.find(Author.class, authorId);
    	transaction.commit();
    	 entityManager.close();
    	return author;
    	
    }
    
    
}
