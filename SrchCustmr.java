import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
class SrchCustmr implements ActionListener
{
    JFrame f;
    JPanel p;
    JLabel name,no;
    JTextField nos,namess;
    JButton srch,clr;
    Customer_Queries queries;
    List< Customers > result1,result2;
    Customers currententry,currententry2;
    SrchCustmrLyt add;
    public SrchCustmr()
    {
        queries=new Customer_Queries();
        f=new JFrame("Search Customer");
        f.setSize(570,150);
        p=new JPanel();
        p.setLayout(null);
        f.add(p);

        name=new JLabel("Name");
        no=new JLabel("Mobile Number");

        srch=new JButton("Search");
        clr=new JButton("Clear");
        namess=new JTextField(20);
        nos=new JTextField(20);

        name.setBounds(10,10,250,25);
        namess.setBounds(10,40,250,75);
        no.setBounds(300,10,250,25);
        nos.setBounds(300,40,250,25);
        srch.setBounds(300,80,114,30);
        clr.setBounds(434,80,114,30);

        Font fnt = new Font("TimesNewRoman", Font.BOLD, 15);
        name.setFont(fnt);
        no.setFont(fnt);

        srch.setFont(fnt);
        clr.setFont(fnt);
        p.add(name);p.add(no);
        p.add(namess);p.add(nos);
        p.add(srch);p.add(clr);
        f.setVisible(true);
        f.setResizable(false);
        f.setDefaultCloseOperation(2);
        f.setLocationRelativeTo(null);
        srch.addActionListener(this);
    }

    public void actionPerformed(ActionEvent evt)
    {
        if(evt.getSource()==srch)
        {
            add=new SrchCustmrLyt();
            add.f.setTitle("Customer Profile");
            add.f.setVisible(false);
            f.setVisible(false);
            f.dispose();

            result1=queries.getName(namess.getText().toString().trim());
            result2=queries.getNo(nos.getText().toString().trim());
            int entries1=result1.size();
            int entries2=result2.size();
            int currentindex,temp;
            if(entries1!=0)
            { 
                currentindex=0;
                currententry=result1.get(currentindex);
                add.names.setText(currententry.getName().toString().trim());
                add.nos.setText(currententry.getNo().toString().trim());
                add.addrss.setText(currententry.getAdd().toString().trim());
                add.blncs.setText(currententry.getBal().toString().trim());
                add.f.setVisible(true);
            }
            else if(entries2!=0)
            {
                currentindex=0;
                currententry2=result2.get(currentindex);
                add.names.setText(currententry2.getName().toString().trim());
                add.nos.setText(currententry2.getNo().toString().trim());
                add.addrss.setText(currententry2.getAdd().toString().trim());
                add.blncs.setText(currententry2.getBal().toString().trim());
                add.f.setVisible(true);
            }
            else
            {
                JOptionPane.showMessageDialog(f,"Name or Mobile Number is Incorrect","Customer",JOptionPane.PLAIN_MESSAGE);
            }
        }
    }

    public static void main(String args[])
    {
        new SrchCustmr();
    }
}