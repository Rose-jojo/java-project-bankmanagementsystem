
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class MiniStatement extends JFrame implements ActionListener {
    
    JLabel mini,card,Balance;
//    String pinNumber;
    
    MiniStatement(String pin){
//        this.pinNumber = pinNumber;
        setTitle("Mini Statement");
        setLayout(null);
        mini = new JLabel();
        add(mini);
        
        JLabel bank = new JLabel("Indian Bank");
        bank.setBounds(150,20,100,20);
        add(bank);
        
        card = new JLabel();
        card.setBounds(20,80,300,20);
        add(card);
        
        Balance = new JLabel();
        Balance.setBounds(20,400,300,20);
        add(Balance);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("SELECT * FROM login where pinNumber = '"+pin+"'");
            while(rs.next())
            {
            card.setText("Card Number: " +rs.getString("cardnumber").substring(0,4)+ "XXXXXXXX" +rs.getString("cardnumber").substring(12));
          
            }
        }
        
        catch(Exception e){
          System.out.println(e);
        }
        
        try{
           
            Conn c = new Conn();
            int bal = 0;
            ResultSet rs =c.s.executeQuery("select * from bank where pinNumber = '"+pin+"'");
            while(rs.next())
            {
            mini.setText(mini.getText() + "<html>" +rs.getString("date")+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");
            
            if(rs.getString("type").equals("deposit"))
                    {
                        bal += Integer.parseInt(rs.getString("amount"));
                    }
                    else
                    {
                        bal -= Integer.parseInt(rs.getString("amount"));
                    }
        }
        
        
        Balance.setText("Your current balance is Rs" +bal);
        
        }
        catch(Exception e){

        }
        
        mini.setBounds(20, 140, 400, 200);
        setSize(400,600);
        setLocation(20,20);
        getContentPane().setBackground(Color.white);
        setVisible(true);
    
}
   public void actionPerformed(ActionEvent e){
         
//         setVisible(false);
//         new Transactions().setVisible(true);

         
     }
    
    public static void main(String args[]) {
       
         new MiniStatement("").setVisible(true);
        
    }
}
