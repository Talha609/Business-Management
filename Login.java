import java.util.*;
import java.io.File;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.Image;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import javax.swing.ImageIcon;
import static javax.swing.WindowConstants.*;
class Login implements ActionListener,KeyListener
{
    JFrame f;
    JPanel p;
    JTextField id;
    JLabel idd,pas,l;
    JPasswordField pass;
    JButton sub;
    ImageIcon ii;
    public Login()
    {
        Font font1 = new Font("SansSerif", Font.BOLD, 14);
        Font font2 = new Font("TimesNewRoman", Font.BOLD, 15);
        f=new JFrame("Business");
        f.setSize(600,400);
        p=new JPanel();
        p.setLayout(null);

        //ImageIcon img=new ImageIcon("Path");
        ImageIcon img= new ImageIcon(new ImageIcon("Path").getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT));
        l=new JLabel();
        l.setIcon(img);
        f.add(p);
        f.add(l);
        id=new JTextField(10);
        id.setFont(font1);
        idd=new JLabel("User ID");
        idd.setForeground(Color.black);
        pas=new JLabel("Password");
        pas.setForeground(Color.black);
        pass=new JPasswordField(10);
        pass.setEchoChar('\u25CF');
        sub=new JButton("Submit");
        sub.setBackground(Color.gray);
        sub.setForeground(Color.white);
        idd.setFont(font2);
        sub.setFont(font1);
        pas.setFont(font2);

        f.setLocationRelativeTo(null);
        idd.setBounds(180,120,150,25);
        id.setBounds(260,120,150,25);
        pas.setBounds(180,150,150,25);
        pass.setBounds(260,150,150,25);
        sub.setBounds(260,188,150,25);
        l.add(idd);
        l.add(id);
        l.add(pas);
        l.add(pass);
        l.add(sub);
        f.setVisible(true);
        f.setDefaultCloseOperation(2);
        f.setResizable(false);
        sub.addActionListener(this);
        sub.addKeyListener(this);
    }

    public void actionPerformed(ActionEvent evt)
    {
        if(evt.getSource()==sub)
        {
            try
            {
                if(pass.getText().toString().trim().equals("123") && id.getText().toString().trim().equals("123"))
                {
                    First fisrt=new First();
                    f.setVisible(false);
                    f.dispose();
                }
                else
                {
                    JOptionPane.showMessageDialog(f,"User ID or Password is Incorrect","Error",2);
                }
            }
            catch(Exception e)
            {
                
            }
        }
    }

    public void keyPressed(KeyEvent evt)
    {
        if(evt.getSource()==sub)
        {
            try
            {
                if(pass.getText().toString().trim().equals("123") && id.getText().toString().trim().equals("123"))
                {
                    First fisrt=new First();
                    f.setVisible(false);
                    f.dispose();
                }
                else
                {
                    JOptionPane.showMessageDialog(f,"User ID or Password is Incorrect","Error",2);
                }
            }
            catch(Exception e)
            {

            }
        }
    }

    public void keyReleased(KeyEvent evt)
    {
    }

    public void keyTyped(KeyEvent evt)
    {
    }

    public static void main(String args[])
    {
        new Login();
    }
}