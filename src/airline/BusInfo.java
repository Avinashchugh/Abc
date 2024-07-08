/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airline;



import java.sql.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import airline.*;

/**
 *
 * @author 786 TRADERS
 */
public class BusInfo {
    String From,To,Date;
    String database="jdbc:ucanaccess://busTicketMangementSystem.accdb";
    
    
    public BusInfo(String From,String To, String Date)
    {
        this.From=From;
        this.To=To;
        this.Date=Date;
        connectivty();
    }
    String getFrom()
    {
        return "From :"+From;
    }
    String getTo()
    {
        return "To :"+To;
    }
    String getDate()
    {
        return "Date :"+Date;
    }
            
    void connectivty()
    {
        ArrayList <DefaultListModel> arrlist=new  ArrayList<DefaultListModel>();
          DefaultListModel df=new DefaultListModel();
          ArrayList<String> sarray= new  ArrayList<String>();
         try
      {
          Connection con =DriverManager.getConnection(database);
        
          
         String query= "Select  FromDes,ToDes,BusName,BusTime from  BusInfo where FromDes= '"+From+"'and ToDes= '"+To+"' ";
         PreparedStatement pst= con.prepareStatement(query);
         ResultSet rS = pst.executeQuery();
        int i=0;
        
          boolean bool=true;
         while(rS.next())
         {
             SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");
            Timestamp timestamp = rS.getTimestamp("BusTime");
             String data=sdf.format(timestamp);
             
             System.out.println(Date);
              if(Date.equals(data))
              {
              
                   df=new DefaultListModel();
             sarray.add(rS.getString("BusName"));
              
	      df.addElement("***************************************************"+"\n");
	      df.addElement("Bus Name: "+rS.getString("BusName")+"\n");
	      df.addElement("From: "+rS.getString("FromDes")+"\n");
	      df.addElement("TO: "+rS.getString("ToDes")+"\n");
	      df.addElement("Date: "+data+"\n");
              df.addElement("***************************************************"+"\n");
              arrlist.add(df);
	      i++;
              bool=false;
             
               
              }
         }
          new SearchResult(arrlist,sarray);
         if(bool)
         {
             JOptionPane.showMessageDialog(null, "BUS NOT AVAILABLE ");
              new Bus.Welcome().setVisible(true);
         }
         else
         {
            
         }
         
        

      }
      catch(Exception e)
      {
          e.printStackTrace();
           
          
      }
    }
    public static void main(String[] args) {
//       SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");
//         String data =sdf.format( "6/30/2021");
        new BusInfo("Karachi", "Lahore","30/06/2021");
    }
             
    
}
