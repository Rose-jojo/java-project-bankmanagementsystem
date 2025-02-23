
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BalanceEnquiry extends JFrame implements ActionListener {
    
    JButton back;
    String pinNumber;
    
    BalanceEnquiry(String pinNumber){
        this.pinNumber = pinNumber;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        back = new JButton("BACK");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);
        
        Conn c = new Conn();
        int balance = 0;
            try{
                ResultSet rs =c.s.executeQuery("select * from bank where pinNumber = '"+pinNumber+"'");
                
                while(rs.next())
                {
                    if(rs.getString("type").equals("deposit"))
                    {
                        balance += Integer.parseInt(rs.getString("amount"));
                    }
                    else
                    {
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                
                }
            }
                
                catch(Exception ae){
                System.out.println(ae);
            }
            
            JLabel text = new JLabel("Your current account balance is Rs " +balance);
            text.setBounds(190,280,700,35);
            text.setForeground(Color.white);
            text.setFont(new Font("System",Font.BOLD,16));
            image.add(text);
        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
        
    }
    
     public void actionPerformed(ActionEvent e){
         
         setVisible(false);
         new Transactions(pinNumber).setVisible(true);
         
     }
    public static void main(String args[]) {
        
        new BalanceEnquiry("");
    }
    
}
