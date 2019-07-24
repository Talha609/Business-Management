import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class AddCustmr implements ActionListener,KeyListener
{
    JFrame f;
    JPanel p;
    JLabel name,no,addrs,total,add,ddct,blnc;
    JTextField names,nos,addrss,totl,adds,ddcts,blncs;
    JButton save,clr;
    Customer_Queries customerqueries;
    public AddCustmr()
    {
        customerqueries=new Customer_Queries();
        f=new JFrame("Add Customer");
        f.setSize(800,320);
        p=new JPanel();
        p.setLayout(null);
        f.add(p);

        name=new JLabel("Name");
        no=new JLabel("Mobile Number");
        addrs=new JLabel("Address");
        total=new JLabel("Total Amount (Rs)");
        add=new JLabel("Amount To Add (Rs)");
        ddct=new JLabel("Amount To Deduct (Rs)");
        blnc=new JLabel("Balance (Rs)");

        save=new JButton("Save");
        clr=new JButton("Clear");
        names=new JTextField(20);
        nos=new JTextField(20);
        addrss=new JTextField(20);
        totl=new JTextField(20);
        adds=new JTextField(20);
        ddcts=new JTextField(20);
        blncs=new JTextField(20);

        name.setBounds(10,10,300,25);
        names.setBounds(10,40,300,25);
        no.setBounds(400,10,300,25);
        nos.setBounds(400,40,300,25);
        addrs.setBounds(10,80,300,25);
        addrss.setBounds(10,110,300,25);
        blnc.setBounds(400,80,300,25);
        blncs.setBounds(400,110,300,25);
        add.setBounds(10,150,300,25);
        adds.setBounds(10,180,300,25);
        ddct.setBounds(400,150,300,25);
        ddcts.setBounds(400,180,300,25);
        total.setBounds(10,220,300,25);
        totl.setBounds(10,250,300,25);
        save.setBounds(490,245,100,30);
        clr.setBounds(600,245,100,30);

        Font fnt = new Font("TimesNewRoman", Font.BOLD, 15);
        name.setFont(fnt);
        no.setFont(fnt);
        addrs.setFont(fnt);
        add.setFont(fnt);
        blnc.setFont(fnt);
        add.setFont(fnt);
        ddct.setFont(fnt);
        total.setFont(fnt);
        save.setFont(fnt);
        clr.setFont(fnt);
        p.add(name);p.add(no);p.add(addrs);
        p.add(total);p.add(add);p.add(ddct);
        p.add(save);p.add(clr);p.add(blnc);
        p.add(names);p.add(nos);p.add(addrss);
        p.add(totl);p.add(adds);p.add(ddcts);
        p.add(blncs);
        f.setVisible(true);
        f.setResizable(false);
        f.setDefaultCloseOperation(2);
        f.setLocationRelativeTo(null);
        save.addActionListener(this);
        clr.addActionListener(this);
        adds.addKeyListener(this);
        ddcts.addKeyListener(this);
    }

    public void actionPerformed(ActionEvent evt)
    {
        if(evt.getSource()==save)
        {
            if(addrss.getText().toString().trim().equals(""))
            {
                addrss.setText("");
            }
            else if(names.getText().toString().trim().equals(""))
            {
                names.setText("");
            }
            else if(nos.getText().toString().trim().equals(""))
            {
                nos.setText("");
            }
            else if(blncs.getText().toString().trim().equals(""))
            {
                blncs.setText("0");
            }
            int result=customerqueries.addCustomer(names.getText().toString().trim(),nos.getText().toString().trim(),addrss.getText().toString().trim(),blncs.getText().toString().trim());
            if(result==1)
            {
                JOptionPane.showMessageDialog(f,"Customer Added","Customer",JOptionPane.PLAIN_MESSAGE);
                f.setVisible(false);
                f.dispose();
            }
            else
            {
                JOptionPane.showMessageDialog(f,"Customer Not Added","Customer",JOptionPane.PLAIN_MESSAGE);
            }
        }
    }

    public void keyTyped(KeyEvent evt)
    {
    }

    public void keyPressed(KeyEvent evt)
    {
    }

    public void keyReleased(KeyEvent evt)
    {
        try
        {
            if(evt.getSource()==adds)
            {
                totl.setText(Double.parseDouble(blncs.getText().toString().trim()) + Double.parseDouble(adds.getText().toString().trim()) + "");
            }
            if(evt.getSource()==ddcts)
            {
                totl.setText(Double.parseDouble(blncs.getText().toString().trim()) - Double.parseDouble(ddcts.getText().toString().trim()) + "");
            }
        }
        catch(Exception e)
        {
        }
        if(adds.getText().toString().trim().equals("") && ddcts.getText().toString().trim().equals(""))
        {
            totl.setText(blncs.getText().toString().trim());
        }
    }

    public static void main(String args[])
    {
        new AddCustmr();
    }
}
