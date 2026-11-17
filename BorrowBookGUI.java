package tuto5AB;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BorrowBookGUI extends JFrame
{
    private JLabel lblStudent;
    private JLabel lblBook;
    private JLabel lblBorrowInfo;
    private JLabel lblResult;
    private JComboBox<Student> comboStudent;
    private JComboBox<Book> comboBook;
    private JButton btnBorrow;
    
    public BorrowBookGUI()
    {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
        setTitle("Borrow Book"); 
        setBounds(100, 100, 520, 340); 
        
        Container pane = getContentPane();
        pane.setLayout(new BorderLayout(10, 10));
        
        
        lblStudent = new JLabel("Student Name & Matric:");
        lblStudent.setFont(new Font("Tahoma", Font.PLAIN, 13));
        
        lblBook = new JLabel("Book Title & Author:");
        lblBook.setFont(new Font("Tahoma", Font.PLAIN, 13));
        
        lblBorrowInfo = new JLabel("Borrow Information :");
        lblBorrowInfo.setFont(new Font("Tahoma", Font.BOLD, 13));
        
        lblResult = new JLabel("");
        lblResult.setFont(new Font("Tahoma", Font.PLAIN, 12));
        
       
        comboStudent = new JComboBox<>();
        comboBook = new JComboBox<>();
        
        
        comboStudent.addItem(new Student("Ali Imran", "A123456"));
        comboStudent.addItem(new Student("Siti Aminah", "A147895"));
        comboStudent.addItem(new Student("Abu Bakar", "A112365"));
        
        comboBook.addItem(new Book("Harry Potter", "J K Rowling"));
        comboBook.addItem(new Book("Lord of The Ring", "J R R Tolkien"));
        comboBook.addItem(new Book("The Secret of Lost Stone", "Melissa Payne"));
        
        
        btnBorrow = new JButton("Borrow");
        btnBorrow.setFont(new Font("Tahoma", Font.PLAIN, 13));
        
        
        JPanel formPanel = new JPanel(new GridLayout(2, 2, 8, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 10, 20));
        formPanel.add(lblStudent);
        formPanel.add(comboStudent);
        formPanel.add(lblBook);
        formPanel.add(comboBook);
        
        
        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnPanel.add(btnBorrow);
        
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(formPanel, BorderLayout.CENTER);
        topPanel.add(btnPanel, BorderLayout.SOUTH);
        
        
        JPanel bottomPanel = new JPanel(new BorderLayout(5, 5));
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 20, 20));
        bottomPanel.add(lblBorrowInfo, BorderLayout.NORTH);
        bottomPanel.add(lblResult, BorderLayout.CENTER);
        
        pane.add(topPanel, BorderLayout.NORTH);
        pane.add(bottomPanel, BorderLayout.CENTER);
        
        
        btnBorrow.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                
                Student selectedStudent = (Student) comboStudent.getSelectedItem();
                Book selectedBook = (Book) comboBook.getSelectedItem();
                
                if (selectedStudent != null && selectedBook != null)
                {
                    
                    String message = selectedStudent.getName() + " with matric number " + 
                                     selectedStudent.getMatric() + " has borrow a book with title " + 
                                     selectedBook.getTitle() + ".";
                    
                    lblResult.setText(message);
                }
            }
        });
    }

    public static void main(String[] args) 
    { 
        BorrowBookGUI frame = new BorrowBookGUI(); 
        frame.setVisible(true); 
    } 
}