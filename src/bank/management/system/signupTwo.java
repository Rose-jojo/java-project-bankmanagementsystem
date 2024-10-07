
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class signupTwo  extends JFrame implements ActionListener{
    
    JTextField pan, aadhar;
    JButton next;
    JRadioButton syes, sno , eyes, eno ;
    JComboBox religion, category, income, education ,occupation;
    String formno;
    
    signupTwo( String formno)
    {
        this.formno = formno;
        setLayout(null);
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2:");
        
        JLabel additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Raleway" , Font.BOLD,22));
        additionalDetails.setBounds(290,80,400,30);
        add(additionalDetails);
        
        JLabel rel = new JLabel("Religion :");
        rel.setFont(new Font("Raleway" , Font.BOLD,20));
        rel.setBounds(100,140,100,30);
        add(rel);
        
        String valReligion[] = {"Christain","Hindu","Muslim","Other"};
        religion = new JComboBox(valReligion);
        religion.setFont(new Font("Raleway",Font.BOLD,14));
        religion.setBounds(300,140 , 400, 30);
        religion.setBackground(Color.white);
        add(religion);
        
        
        JLabel ctry = new JLabel("Category :");
        ctry.setFont(new Font("Raleway" , Font.BOLD,20));
        ctry.setBounds(100,190,200,30);
        add(ctry);
        
        String valCategory[]={"General","OBC","SC","ST","Other"};
        category = new JComboBox(valCategory);
        category.setFont(new Font("Raleway",Font.BOLD,14));
        category.setBounds(300,190 , 400, 30);
        category.setBackground(Color.white);
        add(category);
   
        
        JLabel i = new JLabel("Income :");
        i.setFont(new Font("Raleway" , Font.BOLD,20));
        i.setBounds(100,240,200,30);
        add(i);
        
        String incomeCategory[]={"Null","< 1,50,000","<2,50,000","<5,00,000","Upto 10,00,000"};
        income = new JComboBox(incomeCategory);
        income.setFont(new Font("Raleway",Font.BOLD,14));
        income.setBounds(300,240 , 400, 30);
        income.setBackground(Color.white);
        add(income);
        
        
        JLabel edu = new JLabel("Educational");
        edu.setFont(new Font("Raleway" , Font.BOLD,20));
        edu.setBounds(100,290,200,30);
        add(edu); 
        
        JLabel qli = new JLabel("Qualification :");
        qli.setFont(new Font("Raleway" , Font.BOLD,20));
        qli.setBounds(100,315,200,30);
        add(qli);
        
        String educationValues[]={"Non-Graduation","Graduation","Post-Graduation","Doctorate","Others"};
        education = new JComboBox(educationValues);
        education.setFont(new Font("Raleway",Font.BOLD,14));
        education.setBounds(300,315 , 400, 30);
        education.setBackground(Color.white);
        add(education);
        
        JLabel oc = new JLabel("Occupation :");
        oc.setFont(new Font("Raleway" , Font.BOLD,20));
        oc.setBounds(100,390,200,30);
        add(oc);
        
        String occupationValues[]={"Salaried","Self-employed","Business","Student","Retired","Others"};
        occupation = new JComboBox(occupationValues);
        occupation.setFont(new Font("Raleway",Font.BOLD,14));
        occupation.setBounds(300,390, 400, 30);
        occupation.setBackground(Color.white);
        add(occupation);
      
        
        JLabel pannumber = new JLabel("Pan Number :");
        pannumber.setFont(new Font("Raleway" , Font.BOLD,20));
        pannumber.setBounds(100,440,200,30);
        add(pannumber);
        
        pan = new JTextField();
        pan.setFont(new Font("Raleway",Font.BOLD,14));
        pan.setBounds(300,440 , 400, 30);
        add(pan);
        
        JLabel aadharnumber = new JLabel("Aadhar Number :");
        aadharnumber.setFont(new Font("Raleway" , Font.BOLD,20));
        aadharnumber.setBounds(100,490,200,30);
        add(aadharnumber);
        
        aadhar = new JTextField();
        aadhar.setFont(new Font("Raleway",Font.BOLD,14));
        aadhar.setBounds(300,490 , 400, 30);
        add(aadhar);
        
        JLabel seniorcitizen = new JLabel("Senior Citizen :");
        seniorcitizen.setFont(new Font("Raleway" , Font.BOLD,20));
        seniorcitizen.setBounds(100,540,200,30);
        add(seniorcitizen);
        
        syes = new JRadioButton("Yes ");
        syes.setBounds(300, 540, 100, 30);
        syes.setBackground(Color.WHITE);
        add(syes);
        
        sno =new JRadioButton("No ");
        sno.setBounds(450, 540, 100, 30);
        sno.setBackground(Color.WHITE);
        add(sno);
        
        ButtonGroup sencitizengroup = new ButtonGroup();
        sencitizengroup.add(syes);
        sencitizengroup.add(sno);
        
        JLabel pincode = new JLabel("Existing Account :");
        pincode.setFont(new Font("Raleway" , Font.BOLD,20));
        pincode.setBounds(100,590,200,30);
        add(pincode);
        
        
        eyes = new JRadioButton("Yes ");
        eyes.setBounds(300, 590, 100, 30);
        eyes.setBackground(Color.WHITE);
        add(eyes);
        
        eno =new JRadioButton("No ");
        eno.setBounds(450, 590, 100, 30);
        eno.setBackground(Color.WHITE);
        add(eno);
        
        ButtonGroup existinggroup = new ButtonGroup();
        existinggroup.add(eyes);
        existinggroup.add(eno);

        
        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(620,660 , 80, 30);
        next.addActionListener(this);
        add(next);
        
        getContentPane().setBackground(Color.white);
        setSize(850,800);
        setVisible(true);
        setLocation(350,10);
        
    }
    
    @Override
     public void actionPerformed(ActionEvent e){
         
         String sreligion = (String)religion.getSelectedItem();
         String scategory = (String)category.getSelectedItem();
         String sincome =(String)income.getSelectedItem();
         String seducation =(String)education.getSelectedItem();
         String soccupation =(String)occupation.getSelectedItem();
         String sseniorcitizen = null;
         if(syes.isSelected())
         {
             sseniorcitizen = "Yes";
         }
         
         else if (sno.isSelected())
         {
             sseniorcitizen = "No";
         } 
         
         String sexistingaccount = null;
         if(eyes.isSelected())
                 {
                     sexistingaccount = "Yes";
                 }
         else if (eno.isSelected())
                 {
                     sexistingaccount = "No";
                 }
         
         String span = pan.getText();
         String saadhar = aadhar.getText();
         
         try{
                 Conn c = new Conn();
                 String query = "insert into signupTwo values('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+sseniorcitizen+"','"+sexistingaccount+"','"+span+"','"+saadhar+"')";
                 c.s.executeUpdate(query);
             
                 setVisible(false);
             new signupThree(formno).setVisible(true);
         }
         catch(Exception eu)
         {
             System.out.println(eu);
         }

     }

   
    public static void main(String args[]) {
      new signupTwo("");
    }
}
