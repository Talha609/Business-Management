import java.lang.Object;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.List;
import javax.swing.table.*;
import java.util.Vector;
class First implements ActionListener
{
    DB_Queries dbqueries;
    JFrame f;
    JPanel p;
    JTextField parts,prds;
    JLabel part1,prd1,part2,prd2,sno,qty,mrp,discnt,sp,add,custmrs,srchs,addps,prdcts;
    JButton ent,clr,custmr,srch,addp;
    Font font1,font2;
    ImageIcon img;
    List< Products > result1,result2;
    Products currententry,currententry2;
    JTable table;
    DefaultTableModel model;
    int row,col;
    double sps=0;
    final String remove="Remove";
    public First()
    {
        dbqueries=new DB_Queries();
        font1 = new Font("SansSerif", Font.BOLD, 14);
        font2 = new Font("TimesNewRoman", Font.BOLD, 15);
        f=new JFrame("Anwar & Sons Autoparts");
        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        p=new JPanel();
        p.setLayout(null);
        f.add(p);

        part1=new JLabel("Part No.");
        prd1=new JLabel("Product");
        parts=new JTextField(20);
        prds=new JTextField(20);
        ent=new JButton("Enter");
        clr=new JButton("Clear");
        img=new ImageIcon(new ImageIcon("Path").getImage().getScaledInstance(80,80, Image.SCALE_DEFAULT));
        custmr=new JButton(img);
        add=new JLabel("Add");
        custmrs=new JLabel("Customer");
        srch=new JButton(new ImageIcon(new ImageIcon("Path").getImage().getScaledInstance(80,80, Image.SCALE_DEFAULT)));
        srchs=new JLabel("Search");
        img=new ImageIcon(new ImageIcon("Path").getImage().getScaledInstance(80,80, Image.SCALE_DEFAULT));
        addp=new JButton(img);
        addps=new JLabel("Add");
        prdcts=new JLabel("Products");
        //remove=new ImageIcon(new ImageIcon("Path").getImage().getScaledInstance(10,10, Image.SCALE_DEFAULT));

        part1.setFont(font2);
        prd1.setFont(font2);
        parts.setFont(font1);
        prds.setFont(font1);
        ent.setFont(font2);
        clr.setFont(font2);

        part1.setBounds(10,50,100,22);
        parts.setBounds(90,50,330,30);
        prd1.setBounds(10,90,100,22);
        prds.setBounds(90,90,330,30);
        ent.setBounds(90,130,150,25);
        clr.setBounds(270,130,150,25);
        custmr.setBounds(700,50,80,80);
        add.setBounds(730,132,30,22);
        custmrs.setBounds(711,152,70,22);
        srch.setBounds(820,50,80,80);
        srchs.setBounds(835,132,70,22);
        addp.setBounds(940,50,80,80);
        addps.setBounds(970,132,30,22);
        prdcts.setBounds(951,152,70,22);

        add.setFont(font2);
        custmrs.setFont(font2);
        srchs.setFont(font2);
        addps.setFont(font2);
        prdcts.setFont(font2);
        table();
        p.add(part1);p.add(prd1);
        p.add(parts);p.add(prds);
        p.add(ent);p.add(clr);p.add(custmr);
        p.add(add);p.add(custmrs);
        p.add(srch);p.add(srchs);
        p.add(addp);p.add(addps);p.add(prdcts);
        f.setVisible(true);
        f.setDefaultCloseOperation(2);
        f.setResizable(false);
        ent.addActionListener(this);
        custmr.addActionListener(this);
        srch.addActionListener(this);
        addp.addActionListener(this);
        table.addKeyListener(new KeyAdapter() 
            {
                public void keyReleased(final KeyEvent e) 
                {
                    if (e.getSource() == table) 
                    {
                        table = (JTable)e.getSource();
                        row = table.getSelectedRow();
                        col = table.getSelectedColumn();
                        String o = String.valueOf(table.getValueAt(row, col));
                        sps=sps*Double.parseDouble(o);
                        model.setValueAt(sps,row,6);
                        model.setValueAt(remove,row,7);
                        //table.add(remove,BorderLayout.SOUTH);
                    }
                }
            });
        /*remove.addActionListener(new ActionListener() 
        {
        public void actionPerformed(ActionEvent e) 
        {
        int[] selectedRows = table.getSelectedRows();
        for(int i=selectedRows.length-1;i >= 0;i--)
        {
        model.removeRow(selectedRows[i]);;
        }
        }
        });*/
    }

    public void table()
    {
        model=new DefaultTableModel();
        Container content = f.getContentPane();
        table =new JTable(model);  
        model.addColumn("ProductName");
        model.addColumn("PartNo.");
        model.addColumn("Qty");
        model.addColumn("CP");
        model.addColumn("MRP");
        model.addColumn("Disc");
        model.addColumn("SP");
        model.addColumn("Remove");
        //table.getColumnModel().getColumn(3).setCellEditor(new DefaultCellEditor(new JFormattedTextField()));
        JScrollPane scrollPane = new JScrollPane(table);
        table.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 14));
        content.add(scrollPane, BorderLayout.SOUTH);
    }

    public boolean isCellEditable(int rowIndex, int columnIndex)
    {
        if(columnIndex==7)
        {
            return false;
        }
        return true;
    }
    int i=0;
    public void actionPerformed(ActionEvent evt)
    {
        if(evt.getSource()==ent)
        {
            result1=dbqueries.getPart(parts.getText().toString().trim());
            result2=dbqueries.getName(prds.getText().toString().trim());
            int entries1=result1.size();
            int entries2=result2.size();
            int currentindex,temp;
            if(entries1!=0)
            { 
                currentindex=0;
                currententry=result1.get(currentindex);
                try
                {
                    if(currententry.getDisc().toString().trim().equals(""))
                    {
                        sps=Double.parseDouble(currententry.getMRP().toString().trim());
                    }
                    else
                    {
                        sps=Double.parseDouble(currententry.getMRP().toString().trim()) - ((Double.parseDouble(currententry.getMRP().toString().trim()))*(Double.parseDouble(currententry.getDisc().toString().trim()))/100);
                    }
                }
                catch(Exception e)
                {
                }
                //if(table.isCellEditable(i++,7))
                model.addRow(new Object[]{currententry.getProductName().toString().trim(),currententry.getPartNo().toString().trim(),1,currententry.getCP().toString().trim(),currententry.getMRP().toString().trim(),currententry.getDisc().toString().trim(),sps,remove});
                table.setFont(new Font("Times New Roman", Font.BOLD, 14));                
                DefaultTableCellRenderer renderer=new DefaultTableCellRenderer();
                renderer.setHorizontalAlignment(JLabel.CENTER);
                table.setDefaultRenderer(Object.class,renderer);
                parts.setText("");
            }
            else if(entries2!=0)
            {
                currentindex=0;
                currententry2=result2.get(currentindex);
                try
                {
                    if(currententry2.getDisc().toString().trim().equals(""))
                    {
                        sps=Double.parseDouble(currententry2.getMRP().toString().trim());
                    }
                    else
                    {
                        sps=Double.parseDouble(currententry2.getMRP().toString().trim()) - ((Double.parseDouble(currententry2.getMRP().toString().trim()))*(Double.parseDouble(currententry2.getDisc().toString().trim()))/100);
                    }
                }
                catch(Exception e)
                {
                }
                model.addRow(new Object[]{currententry2.getProductName().toString().trim(),currententry2.getPartNo().toString().trim(),1,currententry2.getCP().toString().trim(),currententry2.getMRP().toString().trim(),currententry2.getDisc().toString().trim(),sps,remove});
                table.setFont(new Font("Times New Roman", Font.BOLD, 14));
                DefaultTableCellRenderer renderer=new DefaultTableCellRenderer();
                renderer.setHorizontalAlignment(JLabel.CENTER);
                table.setDefaultRenderer(Object.class,renderer);
                prds.setText("");
            }
            else
            {
                JOptionPane.showMessageDialog(f,"Product Name or Part No is Incorrect","Product",JOptionPane.PLAIN_MESSAGE);
            }
        }
        if(evt.getSource()==custmr)
        {
            AddCustmr add=new AddCustmr();
        }
        if(evt.getSource()==srch)
        {
            SrchCustmr srch=new SrchCustmr();
        }
        if(evt.getSource()==addp)
        {
            AddPrdcts p=new AddPrdcts();
        }
        if(evt.getSource()==model)
        {
            System.out.println("Qty");
        }
    }

    public static void main(String args[])
    {
        new First();
    }
}