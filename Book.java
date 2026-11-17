package tuto5AB;

public class Book 
{
    private String title;
    private String author;

    public Book(String titleA, String authorA) 
    {
        title = titleA;
        author = authorA;
    }


    public String getTitle() 
    { 
    	return title;
    }
    
    public String getAuthor()
    {
    	return author; 
    }

    @Override
    public String toString() 
    {
        return "Book title : " + title + " (Author : " + author + ")";
    }
}