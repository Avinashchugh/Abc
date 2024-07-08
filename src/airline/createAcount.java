                                                                                                                                                                                                                                                                                                                                   
package airline;
import javax.swing.*;  
import java.sql.*;
import airline.CreateAccountFrame;
public class createAcount {
    String database="jdbc:ucanaccess://busTicketMangementSystem.accdb";
    String Name, FName, Email, Cnic, PhoneNo, Gender;
    private String password,cPassword;
    String Address,UserName;
    public createAcount() {
    }
    
    
  public createAcount(String Name,String FName, String Email,String Cnic,String PhoneNo,String Address,String Gender,String UserName,String password,String cPassword  )         
  {
      this.Name=Name;
      this.FName=FName;
      this.Email=Email;
      this.Cnic=Cnic;
      this.PhoneNo=PhoneNo;
      this.Address=Address;
      this.Gender=Gender;
      this.UserName=UserName;
      this.password=password;
      this.cPassword=cPassword;
      connection();
             
  }
  public void connection()
  {
      try
      {
          Connection con =DriverManager.getConnection(database);
           System.out.println(Name+FName+Email+Cnic+PhoneNo+Address+Gender+UserName+password+cPassword);
          
          
            String query= "INSERT INTO createAccount(ID,Name,FatherName,Email,Cnic,PhoneNo,Address,Gender,UserName,Password,Confirmpassword)   VALUES('"+1+"','"+Name+"','"+FName+"','"+Email+"','"+Cnic+"','"+PhoneNo+"','"+Address+"','"+Gender+"','"+UserName+"','"+password+"','"+cPassword+"')";
           Statement st= con.createStatement();
          st.executeUpdate(query);
          
                 new Loginframe();
          JOptionPane.showMessageDialog(null,"  Account Created Successfully");
         
      }
      catch(Exception e)
      {
          JOptionPane.showMessageDialog(null,"  not Successfully");
          e.printStackTrace();
      }
  }
    public static void main(String[] args) {
        
    }
    
  
}

