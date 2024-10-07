package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Pinchange extends JFrame implements ActionListener {
    
    JLabel text,pintext,repintext;
    JPasswordField newpin,renewpin;
    JButton change,back;
    String pinNumber;

    Pinchange(String pinNumber){
        this.pinNumber = pinNumber;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        text = new JLabel("CHANGE YOUR PIN");
        text.setBounds(250,280,700,35);
        text.setForeground(Color.white);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);
        
        pintext = new JLabel("NEW PIN");
        pintext.setBounds(160,320,700,35);
        pintext.setForeground(Color.white);
        pintext.setFont(new Font("System",Font.BOLD,12));
        image.add(pintext);
        
        newpin = new JPasswordField();
        newpin.setFont(new Font("Raleway",Font.BOLD,22));
        newpin.setBounds(280, 320, 190, 25);
        image.add(newpin);
        
        repintext = new JLabel("RE-ENTER NEW PIN");
        repintext.setBounds(160,370,700,35);
        repintext.setForeground(Color.white);
        repintext.setFont(new Font("System",Font.BOLD,12));
        image.add(repintext);
        
        renewpin = new JPasswordField();
        renewpin.setFont(new Font("Raleway",Font.BOLD,22));
        renewpin.setBounds(280, 370, 190, 25);
        image.add(renewpin);
        
        change = new JButton("CHANGE");
        change.setBounds(355,485,150,30);
        change.addActionListener(this);
        image.add(change);
        
        back = new JButton("BACK");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);
        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }
    
     public void actionPerformed(ActionEvent e){
         
         if(e.getSource().equals(change)){
             
             try{
             String npin = newpin.getText();
             String rpin = renewpin.getText();
             
             if(!npin.equals(rpin)){
                 JOptionPane.showMessageDialog(null,"Entered Pin doesnot match");
                 return;
             }
             
             if(npin.equals("")){
                 
                 JOptionPane.showMessageDialog(null,"Please Enter your new Pin");
                 
             }
             
                if(rpin.equals("")){
                 
                 JOptionPane.showMessageDialog(null,"Please Rw-Enter your new Pin");
                 
             }
                
                Conn c = new Conn();
                String query1 = "update bank set pinNumber ='"+rpin+"' where pinNumber = '"+pinNumber+"'";
                String query2 = "update login set pinNumber ='"+rpin+"' where pinNumber = '"+pinNumber+"'";
                String query3 = "update signupthree set pinNumber ='"+rpin+"' where pinNumber = '"+pinNumber+"'";
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                c.s.executeUpdate(query3);
               
                JOptionPane.showMessageDialog(null,"Pin Changed successfully");
                
                 setVisible(false);
             new Transactions(rpin).setVisible(true);
                
         }
             catch(Exception ae){
                 System.out.println(ae);
             }
         }
         
         else{
             setVisible(false);
             new Transactions(pinNumber).setVisible(true);
         }
         
     }
    
    public static void main(String args[]) {
        
        new Pinchange("").setVisible(true);
    }
}
