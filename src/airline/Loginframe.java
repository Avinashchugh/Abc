package airline;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Toolkit;
import airline.*;

public class Loginframe implements ActionListener, MouseListener {

    JFrame signupFrame;
    JLabel lblTitle, imagelbl, lblSignup, lblPass, eyeShowPass, eyeUnshowPass;
    JTextField txtSignup;
    JPasswordField pTxtPass;
    JCheckBox showCbox;
    //JButton signUp;
    JButton loginUp;
    ImageIcon img;
    JLabel lblImg, lblSign;
    Image icon = Toolkit.getDefaultToolkit().getImage("D:\\Project\\Airline\\src\\airline\\Image\\resizer.jpg");

    Color color = new Color(241, 169, 160);

    public Loginframe() {
        signupFrame = new JFrame("Login");
        lblTitle = new JLabel("Login Form");
        lblTitle.setFont(new Font("Serif", Font.BOLD, 40));
        lblTitle.setForeground(Color.darkGray);
        lblTitle.setBounds(130, 50, 250, 50);
        img = new ImageIcon("D:\\Project\\Airline\\src\\airline\\Image\\resizer.jpg");
        lblImg = new JLabel(img);
        lblImg.setBounds(0, 0, 500, 400);

        lblSignup = new JLabel("User Name:");
        lblSignup.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 20));
        lblSignup.setBounds(60, 158, 100, 35);

        txtSignup = new JTextField();
        txtSignup.setFont(new Font("Georgia", Font.BOLD, 17));
        txtSignup.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.darkGray));
        txtSignup.setOpaque(false);
        txtSignup.setBounds(160, 158, 125, 30);

        lblPass = new JLabel("Password:");
        lblPass.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 20));
        lblPass.setBounds(60, 223, 100, 35);
        pTxtPass = new JPasswordField();
        pTxtPass.setBounds(159, 220, 125, 30);
        pTxtPass.setOpaque(false);
        pTxtPass.setFont(new Font("Georgia", Font.BOLD, 17));
        pTxtPass.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.darkGray));

        showCbox = new JCheckBox("Show Password");
        showCbox.setBounds(155, 250, 150, 23);
        showCbox.setOpaque(false);
        showCbox.setFont(new Font("Tahoma", Font.BOLD, 13));
        showCbox.addMouseListener(this);

        loginUp = new JButton("Login");
        loginUp.setBounds(220, 280, 90, 35);
        loginUp.setForeground(new Color(59, 89, 182));
        loginUp.setBackground(color);

        lblSign = new JLabel("Create New Acount");
        lblSign.setBounds(160, 330, 120, 20);
        lblSign.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
        lblSign.setForeground(Color.BLUE.darker());
        lblSign.setCursor(new Cursor(Cursor.HAND_CURSOR));
       

        loginUp.addActionListener(this);
        lblSign.addMouseListener(this);

        signupFrame.add(lblTitle);
        signupFrame.add(lblSignup);
        signupFrame.add(txtSignup);
        signupFrame.add(lblPass);
        signupFrame.add(pTxtPass);
        signupFrame.add(showCbox);
        signupFrame.add(loginUp);
        signupFrame.add(lblSign);

        signupFrame.add(lblImg);

        signupFrame.setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\Project\\Airline\\src\\airline\\Image\\resizer.jpg"));
        signupFrame.setSize(500, 400);
        signupFrame.setLayout(new BorderLayout());
        signupFrame.setVisible(true);
        signupFrame.setLocationRelativeTo(null);
        signupFrame.setDefaultCloseOperation(signupFrame.EXIT_ON_CLOSE);
    }

    public void addForm() {

    }

    public void actionPerformed(ActionEvent ex) {
             
               if(!(txtSignup.getText().equals("")&&pTxtPass.getText().equals("")))
               {
                UserInfo obj=   new UserInfo(txtSignup.getText(),pTxtPass.getText());
                if(obj.b)   
                {
                     new Bus.Welcome().setVisible(true);
                     signupFrame.dispose();
                }
               } 
               else 
               {
                    JOptionPane.showMessageDialog(signupFrame,"Fields Must be filled","Alert",JOptionPane.WARNING_MESSAGE);
               }
               
    }

    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == showCbox) {
            if (showCbox.isSelected()) {
                if (pTxtPass.getText().equals("") == false) {
                    pTxtPass.setEchoChar((char) 0);
                } else {
                    JOptionPane.showMessageDialog(signupFrame, "Password is empty", "Alert", JOptionPane.WARNING_MESSAGE);
                    showCbox.setSelected(false);
                }
            } else {
                pTxtPass.setEchoChar('*');
            }
        } else if (e.getSource() == lblSign) {
            new CreateAccountFrame();
            signupFrame.dispose();
        }

    }

    public void mouseExited(MouseEvent e) {
        if (e.getSource() == showCbox) {
            pTxtPass.setEchoChar('*');
            showCbox.setSelected(false);
        }
    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mousePressed(MouseEvent e) {

    }

    public void mouseReleased(MouseEvent e) {

    }

    public static void main(String ar[]) {
        new Loginframe();
    }

}
