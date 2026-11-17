package tuto5AB;

public class Student 
{
	private String name;
	private String matric;
	
	public Student(String nameA, String matricA)
	{
		name = nameA;
		matric = matricA;
	}
	
	public String getName() 
	{
		return name;
	}
	
	public String getMatric() 
	{
		return matric;
	}
	
	public String borrowBy(Book book) 
	{
		return name + " with matric number " + matric + " has borrow a book with title " + book.getTitle() + ".";
	}
	
	@Override
	public String toString() 
	{
		return name + " (" + matric + ")"; // Matches the dropdown format in Figure 6
	}
}