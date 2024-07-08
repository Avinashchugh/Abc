package airline;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import  airline.*;
import java.text.NumberFormat;

import java.util.Random;

public class CreateAccountFrame  extends WindowAdapter
{
  public JFrame createForm;
  JLabel lblName,  lblFname, lblEmail, lblNic, lblAddress, lblGender, lblPhoneNo, lblPassword, lblConfirmpass, lblregForm,UserNamelbl; 
  JTextField  tfName, tfFname, tfEmail, tfNic, tfAddress, userNametxt ;
  JFormattedTextField  tfPhoneNo;
  JPasswordField tfPassword, tfConfirmpass;
  JPanel jp = new JPanel();
  JButton submit, reset,backbtn;
  JRadioButton rd_btn1, rd_btn2,rd_auto;
  JPanel jpInfo;
  
  ImageIcon img=new ImageIcon("D:\\Project\\Airline\\src\\airline\\Image\\bk.jpg");
  JLabel lblBImg;
  String gender;
   JCheckBox showCbox;
  
   public CreateAccountFrame()
  {
	  
	 createForm = new JFrame("Create Account ");
     //createForm.setresize(true);
	 lblBImg=new JLabel(img);
	 lblBImg.setBounds(0,0,600,700);
	 execute();
	 LabelSize();
  rd_btn1.addActionListener((ActionEvent e)->{
	      rd_btn1.setSelected(true);
		  rd_btn2.setSelected(false);
                  gender="Male";
	  
  });
  rd_btn2.addActionListener((ActionEvent e)->{
	      rd_btn1.setSelected(false);
		  rd_btn2.setSelected(true);
                  gender="Female";
  
     });
  rd_auto.addActionListener((ActionEvent e)->{
            if(rd_auto.isSelected())
            {
               if(!(tfName.getText().equals("")|| tfFname.getText().equals("")))
               {
	      Random rand=new Random();
              String sub=tfFname.getText().substring(0,1);
              String set= tfName.getText()+sub+rand.nextInt(3)+rand.nextInt(40);
              userNametxt.setText(set);
                     }
               else
               {
                   JOptionPane.showMessageDialog(null, "fill above fields");
                     rd_auto.setSelected(false);
               }
                      
            }
  
     });
  showCbox.addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent e) {
         if (showCbox.isSelected()) {
                if (!(tfPassword.getText().equals("")||tfConfirmpass.getText().equals(""))) {
                    tfPassword.setEchoChar((char) 0);
                    tfConfirmpass.setEchoChar((char) 0);
                } else {
                    JOptionPane.showMessageDialog(createForm, "Password fields must be filled ", "Alert", JOptionPane.WARNING_MESSAGE);
                    showCbox.setSelected(false);
                }
            } else {
                tfPassword.setEchoChar('*');
                tfConfirmpass.setEchoChar('*');
            }
      }

      public void mouseExited(MouseEvent me) {
       tfConfirmpass.setEchoChar('*');
       tfPassword.setEchoChar('*');
            showCbox.setSelected(false);
      }
    });
       backbtn.addActionListener((ActionEvent e)->
       {
           int a=JOptionPane.showConfirmDialog(createForm,"Are you sure?");  
        if(a==JOptionPane.YES_OPTION){  
            new Loginframe();
            createForm.dispose();
        } 
          
          });
  submit.addActionListener((ActionEvent e)->
          {
          
              
             if(!(tfName.getText().equals("")|| tfFname.getText().equals("")|| tfEmail.getText().equals("")|| tfNic.getText().equals("")|| tfPhoneNo.getText().equals("")|| tfAddress.getText().equals("")||tfPassword.getText().equals("")))    
             {     
                if(tfPassword.getText().equals(tfConfirmpass.getText()))   
                  {           
                 new createAcount(tfName.getText(), tfFname.getText(), tfEmail.getText(), tfNic.getText(), tfPhoneNo.getText(), tfAddress.getText(),gender,userNametxt.getText(),tfPassword.getText(),tfConfirmpass.getText());
                createForm.dispose();
                 
                 } 
                  else
                {
                 JOptionPane.showMessageDialog(null, "Password are not same", "Alert", JOptionPane.WARNING_MESSAGE);
                 tfPassword.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
                 tfConfirmpass.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
             
                 }
           }
           else
           {
              JOptionPane.showMessageDialog(null, "fields must be filled", "Alert", JOptionPane.WARNING_MESSAGE);
           }
          });
  reset.addActionListener((ActionEvent e)->
          {
                tfName.setText("");
                tfFname.setText("");
                tfEmail.setText("");
                tfNic.setText("");
                tfPhoneNo.setText("");
                tfAddress.setText("");
                tfPassword.setText("");
                tfConfirmpass.setText("");
                rd_btn1.setSelected(false);
                rd_btn2.setSelected(false);
          });
        
	 createForm.add(lblBImg);
	 createForm.setSize(600,650);
	 createForm.setLayout(null);
	 createForm.setLocationRelativeTo(null);
	 createForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 createForm.setVisible(true);
         createForm.setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\Project\\Airline\\src\\airline\\Image\\resizer.jpg"));
  }
  
  void execute()
  {
	  //jpInfo = new JPanel();
	 
   
      lblregForm     = new JLabel("   Create Your Account   ");
	  lblName        = new JLabel("Name        ");
	  lblFname       = new JLabel("Father Name ");
	  lblEmail       = new JLabel("Email       ");
	  lblNic         = new JLabel("CINC        ");
	  lblPhoneNo     = new JLabel("Phone no    ");
	  lblAddress     = new JLabel("Address     ");
	  lblGender      = new JLabel("Gender  ");
	  lblPassword    = new JLabel("Password    ");
	  lblConfirmpass = new JLabel("Confirm password  ");
	  tfName        = new JTextField();
	  tfFname       = new JTextField();
	  tfEmail       = new JTextField();
	  tfNic         = new JTextField();
          NumberFormat principleFormat = NumberFormat.getNumberInstance();
            tfPhoneNo = new JFormattedTextField(principleFormat);
             tfPhoneNo.setColumns(11);
       
           // tfPhoneNo.setName("sain");
            
//	  tfPhoneNo     = new JTextField();
	  tfAddress     = new JTextField();
	  tfPassword    = new JPasswordField();
	  tfConfirmpass = new JPasswordField();
	  rd_btn1       = new JRadioButton("Male");
	  rd_btn2       = new JRadioButton("Female");
          UserNamelbl = new JLabel("User Name  ");
	  userNametxt        = new JTextField();
           rd_auto     = new JRadioButton("Auto");
	  submit        = new JButton("Submit");
	  reset         = new JButton("Reset");
           backbtn         = new JButton("Back");
          showCbox = new JCheckBox("Show Password");
	  createForm.add(lblregForm);
	  lblregForm.setFont(new Font("Georgia",Font.BOLD | Font.ITALIC,30));
          createForm.add(rd_auto);
	  createForm.add(tfName);
	  createForm.add(lblName);
	  createForm.add(tfFname);
	  createForm.add(lblFname);
	  createForm.add(tfEmail);
	  createForm.add(lblEmail);
	  createForm.add(tfNic);
	  createForm.add(lblNic);
	  createForm.add(tfPhoneNo);
	  createForm.add(lblPhoneNo);
	  createForm.add(tfAddress);
	  createForm.add(lblAddress);
	  createForm.add(lblGender);
	  createForm.add(rd_btn1);
	  createForm.add(rd_btn2);
	  createForm.add(tfPassword);
	  createForm.add(lblPassword);
          createForm.add(UserNamelbl);
	  createForm.add(userNametxt);
	  createForm.add(tfConfirmpass);
	  createForm.add(lblConfirmpass);
          createForm.add(backbtn);
	  createForm.add(submit);
	  createForm.add(reset);
            
          createForm.add(showCbox);
  }
  void LabelSize()
  {
	  lblregForm.setBounds(105,50,380,30);
	  
	  lblName.setBounds(60,135,100,30);
	  lblName.setFont(new Font ("Tahoma",Font.ITALIC,15));
	  tfName.setBounds(250,140,210,20);
	  tfName.setFont(new Font ("Tahoma",Font.ITALIC,15));
	  
	  
	  lblFname.setBounds(60,170,110,30);
	  lblFname.setFont(new Font ("Tahoma",Font.ITALIC,15));
	  tfFname.setBounds(250,178,210,20);
	  tfFname.setFont(new Font ("Tahoma",Font.ITALIC,15));
	  
	  lblEmail.setBounds(60,200,90,30);
	  lblEmail.setFont(new Font ("Tahoma",Font.ITALIC,15));
	  tfEmail.setBounds(250,212,210,20);
	  tfEmail.setFont(new Font ("Tahoma",Font.ITALIC,15));
	  
	  lblNic.setBounds(60,235,90,30);
	  lblNic.setFont(new Font ("Tahoma",Font.ITALIC,15));
	  tfNic.setBounds(250,245,210,20);
	  tfNic.setFont(new Font ("Tahoma",Font.ITALIC,15));
	  
           
	  lblPhoneNo.setBounds(60,265,100,30);
	  lblPhoneNo.setFont(new Font ("Tahoma",Font.ITALIC,15));
	  tfPhoneNo.setBounds(250,275,210,20);
	  tfPhoneNo.setFont(new Font ("Tahoma",Font.ITALIC,15));
	  
	  lblAddress.setBounds(60,295,90,30);
	  lblAddress.setFont(new Font ("Tahoma",Font.ITALIC,15));
	  tfAddress.setBounds(250,305,210,20);
	  tfAddress.setFont(new Font ("Tahoma",Font.ITALIC,15));
	  
	  lblGender.setBounds(60,345,90,30);
	  lblGender.setFont(new Font ("Tahoma",Font.ITALIC,15));
	  rd_btn1.setBounds(250,350,80,20);
          rd_btn1.setOpaque(false);
           rd_btn2.setOpaque(false);
	  rd_btn2.setBounds(330,350,90,20);
	  rd_auto.setOpaque(false);
          UserNamelbl.setBounds(60,400,130,30);
	  UserNamelbl.setFont(new Font ("Tahoma",Font.ITALIC,15));	  
	  userNametxt.setBounds(250,410,210,20);	 
	  userNametxt.setFont(new Font ("Tahoma",Font.ITALIC,15));
          rd_auto.setBounds(460,410,210,20);	 
	  rd_auto.setFont(new Font ("Tahoma",Font.ITALIC,15));
          
	  lblPassword.setBounds(60,440,130,30);
	  lblPassword.setFont(new Font ("Tahoma",Font.ITALIC,15));	  
	  tfPassword.setBounds(250,446,210,20);	 
	  tfPassword.setFont(new Font ("Tahoma",Font.ITALIC,15));
	  
	  lblConfirmpass.setBounds(60,473,160,30);
	  lblConfirmpass.setFont(new Font ("Tahoma",Font.ITALIC,15));
	  tfConfirmpass.setBounds(250,479,210,20);
	  tfConfirmpass.setFont(new Font ("Tahoma",Font.ITALIC,15));
	  
          
        showCbox.setBounds(255, 500, 150, 23);
        showCbox.setOpaque(false);
        showCbox.setFont(new Font("Tahoma", Font.BOLD, 13));
         
         //backbtn.setBounds(580,580,70,30);
	  submit.setBounds(260,540,90,30);
          submit.setForeground(new Color(59, 89, 182));
          submit.setBorder(new RoundedBorder(10));
	  reset.setBounds(370,540,90,30);
          reset.setForeground(new Color(59, 89, 182));
          reset.setBorder(new RoundedBorder(10));
           backbtn.setBounds(20,570,70,30);
           backbtn.setForeground(new Color(59, 89, 182));
           backbtn.setBorder(new RoundedBorder(10));

  }
  public void windowClosing(WindowEvent e) {  
    int a=JOptionPane.showConfirmDialog(createForm,"Are you sure?");  
        if(a==JOptionPane.YES_OPTION){  
    createForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
    }  
  }
  public static void main(String [] args)
  {
	  
      new  CreateAccountFrame();
  
  }
}
