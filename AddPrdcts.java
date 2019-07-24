import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class AddPrdcts implements ActionListener
{
    DB_Queries dbqueries;
    JFrame f;
    JPanel p;
    JLabel name,pno,mrp,cp,disc,qty;
    JTextField pnos,mrps,cps,discs,qtys;
    JTextArea names;
    JButton save,clr;
    public AddPrdcts()
    {
        dbqueries=new DB_Queries();
        f=new JFrame("Add Prodcuts");
        f.setSize(750,310);
        p=new JPanel();
        p.setLayout(null);
        f.add(p);

        name=new JLabel("Product Name");
        pno=new JLabel("Part Number");
        mrp=new JLabel("MRP (Rs)");
        cp=new JLabel("CP (Rs)");
        disc=new JLabel("Discount %");
        qty=new JLabel("Qty");
        
        save=new JButton("Save");
        clr=new JButton("Clear");

        names=new JTextArea();
        pnos=new JTextField(20);
        mrps=new JTextField(20);
        cps=new JTextField(20);
        discs=new JTextField(20);
        qtys=new JTextField(20);

        name.setBounds(10,10,300,25);
        names.setBounds(10,40,300,100);
        pno.setBounds(400,10,300,25);
        pnos.setBounds(400,40,300,25);
        cp.setBounds(400,80,300,25);
        cps.setBounds(400,110,300,25);
        mrp.setBounds(400,150,300,25);
        mrps.setBounds(400,180,300,25);
        qty.setBounds(10,150,300,25);
        qtys.setBounds(10,180,300,25);
        disc.setBounds(10,210,300,25);
        discs.setBounds(10,240,300,25);
        save.setBounds(490,235,100,30);
        clr.setBounds(600,235,100,30);

        Font fnt = new Font("TimesNewRoman", Font.BOLD, 15);
        name.setFont(fnt);
        names.setFont(fnt);
        pno.setFont(fnt);
        pnos.setFont(fnt);
        mrp.setFont(fnt);
        mrps.setFont(fnt);
        cp.setFont(fnt);
        cps.setFont(fnt);
        disc.setFont(fnt);
        disc.setFont(fnt);
        save.setFont(fnt);
        clr.setFont(fnt);
        qty.setFont(fnt);
        qtys.setFont(fnt);
        
        p.add(name);p.add(pno);
        p.add(cp);p.add(mrp);p.add(disc);
        p.add(save);p.add(clr);
        p.add(names);p.add(pnos);p.add(mrps);
        p.add(cps);p.add(discs);p.add(qty);
        p.add(qtys);
        f.setVisible(true);
        f.setResizable(false);
        f.setDefaultCloseOperation(2);
        f.setLocationRelativeTo(null);
        save.addActionListener(this);
        clr.addActionListener(this);
    }

    public void actionPerformed(ActionEvent evt)
    {
        if(evt.getSource()==save)
        {
            int result=dbqueries.addProduct(names.getText().toString().trim(),pnos.getText().toString().trim(),qtys.getText().toString().trim(),cps.getText().toString().trim(),mrps.getText().toString().trim(),discs.getText().toString().trim());
            //System.out.println("Result " + result);
            if(result==1)
            {
                JOptionPane.showMessageDialog(f,"Product Added","Product",JOptionPane.PLAIN_MESSAGE);
                f.setVisible(false);
                f.dispose();
            }
            else
            {
                JOptionPane.showMessageDialog(f,"Product Not Added","Product",JOptionPane.PLAIN_MESSAGE);
            }
        }
    }
    public static void main(String args[])
    {
        new AddPrdcts();
    }
}