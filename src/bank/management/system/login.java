/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class login  extends JFrame implements ActionListener{
    
    JButton login,clear,signup;
    JTextField cardTextField;
    JPasswordField pinTextField;
    
    login()
    {
        setTitle("AUTOMATED TELLER MACHINE");
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(70,10,100,100);
        add(label);
        
        JLabel text = new JLabel("Welcome to ATM");
        text.setFont(new Font("Osward",Font.BOLD,38));
        text.setBounds(200,30,400,40);
        add(text);
        
        JLabel cardno = new JLabel("CARD NO:");
        cardno.setFont(new Font("Raleway",Font.BOLD,28));
        cardno.setBounds(120,150,400,40);
        add(cardno);
        
        cardTextField= new JTextField();
        cardTextField.setBounds(300,150,230,30);
        cardTextField.setFont(new Font("Arial",Font.BOLD ,14));
        add(cardTextField);
        
        JLabel pin = new JLabel("PIN :");
        pin.setFont(new Font("Raleway",Font.BOLD,28));
        pin.setBounds(120,220,400,40);
        add(pin);
        
        pinTextField= new JPasswordField();
        pinTextField.setBounds(300,220,230,30);
        pinTextField.setFont(new Font("Arial",Font.BOLD ,14));
        add(pinTextField);
        
        login = new JButton("LOGIN");
        login.setBounds(300, 300, 100,30);
        login.setBackground(Color.black);
        login.setForeground(Color.white);
        login.addActionListener(this);
        add(login);
        
        clear = new JButton("CLEAR");
        clear.setBounds(430, 300, 100,30);
        clear.setBackground(Color.black);
        clear.setForeground(Color.white);
        clear.addActionListener(this);
        add(clear);
        
        signup = new JButton("SIGNUP");
        signup.setBounds(300, 350, 230,30);
        signup.setBackground(Color.black);
        signup.setForeground(Color.white);
        signup.addActionListener(this);
        add(signup);
       
        getContentPane().setBackground(Color.white);
        setSize(800,400);
        setVisible(true);
        setLocation(350,200);
    }
    
     public void actionPerformed(ActionEvent e)
     {
         if(e.getSource()== login)
         {
             Conn conn = new Conn();
             String cardnumber = cardTextField.getText();
             String pinnumber = pinTextField.getText();
             String query = "select * from login where cardnumber = '"+cardnumber+"'and pinnumber = '"+pinnumber+"'";
             try{
                 ResultSet rs = conn.s.executeQuery(query);
                 if(rs.next()){
                     setVisible(true);
                     new Transactions(pinnumber).setVisible(true);
                 }
                 
                 else{
                     JOptionPane.showMessageDialog(null,"Incorrect card Number or Pin ");
                 }
             }
             catch(Exception eu){
                 System.out.println(eu);
             }
         }
         
         else if(e.getSource()== clear)
         {
             cardTextField.setText("");
             pinTextField.setText("");
         }
         
         else if(e.getSource()== signup)
         {
             setVisible(false);
             new signupOne().setVisible(true);
         }
     }


    public static void main(String[] args) {
        
        new login();
    }
    
}
