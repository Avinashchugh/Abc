
package airline;

import java.sql.*;
import javax.swing.JOptionPane;
import airline.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class UserInfo 
{
     String database="jdbc:ucanaccess://busTicketMangementSystem.accdb";
    String userName;
    private String password;
    public  boolean b=false;
   public UserInfo(String userName,String password)
   {
       this.userName=userName;
       this.password=password;
       checkPassword();
   }
   void checkPassword()
   {
        try
       {
           Connection con =DriverManager.getConnection(database);


          String query= "Select  UserName,Password from  createAccount where UserName= '"+userName+"'";
          PreparedStatement pst= con.prepareStatement(query);
          ResultSet rS = pst.executeQuery();

          while(rS.next())
          {
             if(password.equals(rS.getString("Password")))
               {
                   JOptionPane.showMessageDialog(null, "Succesfully");
                   b=true;
                   break;
               }

          }
         if(!b)
         {
               JOptionPane.showMessageDialog(null, "Worng Username or Passsword");
         }
//         System.out.println(rS.getString("Password"));
          
      //    st.executeUpdate(query);n
          //CreateAccountFrame obj= new CreateAccountFrame();
       con.close();
      }
      catch(Exception e)
      {
          e.printStackTrace();
      }
   }
    public static void main(String[] args) {
       
    }
          
        
    
}
