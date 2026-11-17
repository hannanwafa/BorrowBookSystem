package tuto5AB;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AddBookInfo extends JFrame
{
    private JLabel lblBookTitle;
    private JLabel lblAuthor;
    private JLabel lblBooks;
    private JTextField txtBookTitle;
    private JTextField txtAuthor;
    private JButton btnAdd;
    private JButton btnList;
    private JTextArea txtAreaBooks;
    
    
    private ArrayList<Book> bookList = new ArrayList<>();
    
    public AddBookInfo()
    {
    	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
        setTitle("Add Book Info"); 
        setBounds(100, 300, 500, 340); 
        
        Container pane = getContentPane();
        pane.setLayout(new BorderLayout(10, 10));
        
        lblBookTitle = new JLabel("Book Title:");
        lblBookTitle.setFont(new Font("Tahoma", Font.BOLD, 13));
        
        lblAuthor = new JLabel("Author:");
        lblAuthor.setFont(new Font("Tahoma", Font.BOLD, 13));
        
        lblBooks = new JLabel("Books:");
        lblBooks.setFont(new Font("Tahoma", Font.BOLD, 13));
        
        txtBookTitle = new JTextField(20);
        txtAuthor = new JTextField(20);
        
        btnAdd = new JButton("Add");
        btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 13));
        
        btnList = new JButton("List");
        btnList.setFont(new Font("Tahoma", Font.PLAIN, 13));
        
        txtAreaBooks = new JTextArea(6, 25);
        txtAreaBooks.setEditable(false);
        txtAreaBooks.setFont(new Font("Tahoma", Font.PLAIN, 13));
        JScrollPane scrollPane = new JScrollPane(txtAreaBooks);
        
        JPanel p1 = new JPanel(new GridLayout(2, 2, 8, 8));
        p1.setBorder(BorderFactory.createEmptyBorder(10, 10, 5, 20));
        p1.add(lblBookTitle);
        p1.add(txtBookTitle);
        p1.add(lblAuthor);
        p1.add(txtAuthor);
        
        JPanel p2 = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
        p2.add(btnAdd);
        p2.add(btnList);
        
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(p1, BorderLayout.CENTER);
        topPanel.add(p2, BorderLayout.SOUTH);
        
        JPanel centerPanel = new JPanel(new BorderLayout(5, 5));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
        centerPanel.add(lblBooks, BorderLayout.NORTH);
        centerPanel.add(scrollPane, BorderLayout.CENTER);
        
        pane.add(topPanel, BorderLayout.NORTH);
        pane.add(centerPanel, BorderLayout.CENTER);
        
        
        btnAdd.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String title = txtBookTitle.getText().trim();
                String author = txtAuthor.getText().trim();
                
                if(title.isEmpty() || author.isEmpty()) 
                {
                    JOptionPane.showMessageDialog(null, "Please enter both Book Title and Author!");
                    return;
                }
                
               
                Book b = new Book(title, author);
                bookList.add(b);
                JOptionPane.showMessageDialog(null, "Book added successfully!");
                
                txtBookTitle.setText("");
                txtAuthor.setText("");
            }
        });
        
        
        btnList.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if(bookList.isEmpty())
                {
                    txtAreaBooks.setText("No books registered yet.");
                    return;
                }
                
                StringBuilder sb = new StringBuilder();
                for(Book b : bookList) {
                    sb.append("Book Title : ").append(b.getTitle()).append(" (Author:").append(b.getAuthor()).append(")\n");
                }
                txtAreaBooks.setText(sb.toString());
            }
        });
    }

    public static void main(String[] args) 
    { 
    	AddBookInfo frame = new AddBookInfo(); 
        frame.setVisible(true); 
    } 
}