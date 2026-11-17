package tuto5AB;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AddStudentInfo extends JFrame
{
    private JLabel lblName;
    private JLabel lblMatric;
    private JLabel lblStudents;
    private JTextField txtName;
    private JTextField txtMatric;
    private JButton btnAdd;
    private JButton btnList;
    private JTextArea txtAreaStudents;
    
    private ArrayList<Student> studentList = new ArrayList<>();
    
    public AddStudentInfo()
    {
    	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
        setTitle("Add Student Info"); 
        setBounds(100, 300, 500, 340); 
        
        Container pane = getContentPane();
        pane.setLayout(new BorderLayout(10, 10));
        
        
        lblName = new JLabel("Name:");
        lblName.setFont(new Font("Tahoma", Font.BOLD, 13));
        
        lblMatric = new JLabel("Matric:");
        lblMatric.setFont(new Font("Tahoma", Font.BOLD, 13));
        
        lblStudents = new JLabel("Students:");
        lblStudents.setFont(new Font("Tahoma", Font.BOLD, 13));
        
    
        txtName = new JTextField(20);
        txtMatric = new JTextField(20);
        
        
        btnAdd = new JButton("Add");
        btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 13));
        
        btnList = new JButton("List");
        btnList.setFont(new Font("Tahoma", Font.PLAIN, 13));
        
        
        txtAreaStudents = new JTextArea(6, 25);
        txtAreaStudents.setEditable(false);
        txtAreaStudents.setFont(new Font("Tahoma", Font.PLAIN, 13));
        JScrollPane scrollPane = new JScrollPane(txtAreaStudents);
        
        
        JPanel p1 = new JPanel(new GridLayout(2, 2, 8, 8));
        p1.setBorder(BorderFactory.createEmptyBorder(10, 10, 5, 20));
        p1.add(lblName);
        p1.add(txtName);
        p1.add(lblMatric);
        p1.add(txtMatric);
        
        JPanel p2 = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
        p2.add(btnAdd);
        p2.add(btnList);
        
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(p1, BorderLayout.CENTER);
        topPanel.add(p2, BorderLayout.SOUTH);
        
        JPanel centerPanel = new JPanel(new BorderLayout(5, 5));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
        centerPanel.add(lblStudents, BorderLayout.NORTH);
        centerPanel.add(scrollPane, BorderLayout.CENTER);
        
        pane.add(topPanel, BorderLayout.NORTH);
        pane.add(centerPanel, BorderLayout.CENTER);
        
        
        btnAdd.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String name = txtName.getText().trim();
                String matric = txtMatric.getText().trim();
                
                if(name.isEmpty() || matric.isEmpty()) 
                {
                    JOptionPane.showMessageDialog(null, "Please enter both Name and Matric!");
                    return;
                }
                
                Student s = new Student(name, matric);
                studentList.add(s);
                JOptionPane.showMessageDialog(null, "Student added successfully!");
                
                txtName.setText("");
                txtMatric.setText("");
            }
        });
        
        btnList.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if(studentList.isEmpty())
                {
                    txtAreaStudents.setText("No students registered yet.");
                    return;
                }
                
                StringBuilder sb = new StringBuilder();
                for(Student s : studentList) {
                    sb.append("Name: ").append(s.getName()).append(" (").append(s.getMatric()).append(")\n");
                }
                txtAreaStudents.setText(sb.toString());
            }
        });
    }

    public static void main(String[] args) 
    { 
    	AddStudentInfo frame = new AddStudentInfo(); 
        frame.setVisible(true); 
    } 
}