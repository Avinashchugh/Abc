/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airline;

import javax.swing.*;
import java.awt.*;  
import java.awt.event.*;
import java.awt.Color;
import java.awt.FlowLayout; 
import java.util.ArrayList;
import javax.swing.border.LineBorder;
public class SearchResult implements ActionListener
{
	JFrame scndForm=new JFrame();
	JButton btnDisplay1,backDisplay1;
        JLabel lbltitle,lblImg;
	ArrayList <JList> jlist;
	 ArrayList <DefaultListModel> arrlist=new  ArrayList<DefaultListModel>();
               ArrayList<String> sarray= new  ArrayList<String>();
         JPanel listpanel;
         JLabel setImage=new JLabel();
	SearchResult( ArrayList <DefaultListModel> obj,ArrayList<String> sarray)
	{
		
		arrlist=obj;
                this.sarray=sarray;
		jlist=new ArrayList <JList>(arrlist.size());
                 lbltitle= new JLabel("                Bus Found       ");
                 lbltitle.setForeground(Color.WHITE);
                  lbltitle.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
                 lbltitle.setBounds(0,1,435,49);
                 lbltitle.setOpaque(false);
                 listpanel= new JPanel();
                 listpanel.setOpaque(false);
                 listpanel.setLayout(new FlowLayout());
                 listpanel.setBounds(70,120,300,350);

                 lbltitle.setFont(new Font("Georgia", Font.BOLD|Font.ITALIC, 30));
                 btnDisplay1=new JButton("Continue for Ticket");
                 btnDisplay1.setBackground(new java.awt.Color(0, 0, 204));
                  btnDisplay1.setForeground(new java.awt.Color(255,255,255));
                 btnDisplay1.setBounds(170,380,160,30);
                 
                 backDisplay1=new JButton("back");
                  backDisplay1.setBackground(new java.awt.Color(0, 0, 204));
                  backDisplay1.setForeground(new java.awt.Color(255,255,255));
                 
                backDisplay1.setBounds(20,450,120,30);
                 backDisplay1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                
                new Bus.Welcome().setVisible(true);
                scndForm.dispose();
            }
            });
                 
	         btnDisplay1.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) { 
         try{
            String data = "";
            boolean b=false,bool=true;
           for(int j=0;j<jlist.size();j++)   
           {    
                 if (jlist.get(j).getSelectedIndex()> 0)
                 {  
                      if(!(b))
                      {   
                             b=true;
                          data=sarray.get(j);
                         
                          bool=false;
                      
                      }
                      else
                      {
                          bool=true;
                          JOptionPane.showMessageDialog(scndForm, "JUST Select One Bus","Alert",JOptionPane.WARNING_MESSAGE);
                          break;
                      }   
                          
                 }    
              }
             
            if(!(bool))
            {
                System.out.println(".actionPerformed()");
                 new seatReservation(data).setVisible(true); 
                          scndForm.dispose();
            }
               
         }
         catch(Exception ex)
         {
             System.out.print(ex);
              JOptionPane.showMessageDialog(scndForm, "Select Approprate BUS","Alert",JOptionPane.WARNING_MESSAGE);
         }
         
               
                 
                   
               
            
          
         }});  
		
		scndForm.add(lbltitle);
		addList();
                scndForm.add(listpanel);
                scndForm.add(btnDisplay1);
                scndForm.add(backDisplay1);
                for(int i=0;i<arrlist.size();i++)
                 {
		  jlist.get(i).setModel(arrlist.get(i));
                 }	
		setImage.setBounds(0,0,452, 527);
                scaleImage1();
	       scndForm.add(setImage);
		btnDisplay1.addActionListener(this);
                lblImg = new javax.swing.JLabel();
                lblImg.setBounds(0,0,452, 527);
                scale1(lblImg);
		scndForm.add(lblImg);
		scndForm.setSize(452, 527);
		scndForm.setLayout(null);
		scndForm.setVisible(true);
                scndForm.setLocationRelativeTo(null);
		scndForm.setDefaultCloseOperation(scndForm.EXIT_ON_CLOSE);
                 scndForm.setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\Project\\Airline\\src\\airline\\Image\\resizer.jpg"));
	}
     public void scale1(javax.swing.JLabel j) {
        ImageIcon img=new ImageIcon("D:\\Project\\Airline\\src\\airline\\Image\\createBackground.jpeg");
        Image img1 = img.getImage();
        Image scale = img1.getScaledInstance(j.getWidth(), j.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon img2 = new ImageIcon(scale);
        j.setIcon(img2);
    }
        public void addList()
        {
            for(int i=0;i<arrlist.size();i++)
            {
                jlist.add(new JList());
            }
            for(JList j :jlist)
            {
                listpanel.add(j);
                j.setBounds(70,60,350,300);
                j.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.darkGray));
            }
           
        }
        public void scaleImage1()
    {
        ImageIcon icon =new ImageIcon("D:\\Project\\Airline\\src\\airline\\bustime.jpg");
        Image img= icon.getImage();
        Image  imgScale =img.getScaledInstance(setImage.getWidth(),setImage.getHeight(),Image.SCALE_SMOOTH);
        ImageIcon sImg= new ImageIcon(imgScale);
        setImage.setIcon(sImg);
        
    }
	public void actionPerformed(ActionEvent e)
	{
            
	}
        public static void main(String[] args) {
       // new SearchResult(new ArrayList <DefaultListModel>());
    }
	
}
