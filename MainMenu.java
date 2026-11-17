package tuto5AB;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JFrame 

{
	 private JLabel label1; 
	 private JButton btnStudentInfo; 
	 private JButton btnBookInfo;
	 private JButton btnBorrowBook;
	  
	 public MainMenu () 
	 { 
		 Container pane = getContentPane(); 
		 pane.setLayout(new BorderLayout(0,4)); 
		   
		 JPanel p1 = new JPanel(); 
		 JPanel p2 = new JPanel(new GridLayout(3, 1, 5, 8));
		 
		 p1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		 
		 pane.add(p1, BorderLayout.NORTH); 
		 pane.add(p2, BorderLayout.CENTER); 
		 
		 
		 label1 = new JLabel("~~ BORROW BOOK SYSTEM ~~", JLabel.CENTER); 
		 label1.setFont(new Font("Tahoma", Font.BOLD, 13)); 
		   		    
		 p1.add(label1); 
 
		    
		 btnStudentInfo = new JButton("Add Student Info"); 
		 btnStudentInfo.setFont(new Font("Tahoma", Font.PLAIN, 13)); 
		  
		 btnBookInfo = new JButton("Add Book Info"); 
		 btnBookInfo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		 
		 btnBorrowBook = new JButton("Borrow Book"); 
		 btnBorrowBook.setFont(new Font("Tahoma", Font.PLAIN, 13)); 
		  
		 p2.add(btnStudentInfo); 
		 p2.add(btnBookInfo); 
		 p2.add(btnBorrowBook);
		 
		 p2.setBorder(BorderFactory.createEmptyBorder(10, 30, 20, 30));
		 
		 btnStudentInfo.addActionListener(new ActionListener() 
		 {
	            @Override
	            public void actionPerformed(ActionEvent e)
	            {
	                AddStudentInfo studentFrame = new AddStudentInfo();
	                studentFrame.setVisible(true);
	            }
	        });

	        btnBookInfo.addActionListener(new ActionListener()
	        {
	            @Override
	            public void actionPerformed(ActionEvent e) 
	            {
	                AddBookInfo bookFrame = new AddBookInfo();
	                bookFrame.setVisible(true);
	            }
	        });

	        btnBorrowBook.addActionListener(new ActionListener()
	        {
	            @Override
	            public void actionPerformed(ActionEvent e) 
	            {
	            	BorrowBookGUI borrowFrame = new BorrowBookGUI();
	                borrowFrame.setVisible(true);
	            }
	        });
	    }
	
	 
	  public static void main(String[] args) 
	  { 
		    MainMenu frame = new MainMenu (); 
		    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		    frame.setTitle("Main Menu"); 
		    frame.setBounds(100, 100, 300,  240); 
		    frame.setVisible(true); 
		    
		   } 
		} 

