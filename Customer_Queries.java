import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
class Customer_Queries
{
    Connection c;
    PreparedStatement getname=null,getno=null,insert=null,update=null,sort=null;
    //Statement stmnt;
    public Customer_Queries()
    {
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            c=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Products;integratedSecurity=true;");
            //stmnt=c.createStatement();
            getname=c.prepareStatement("SELECT * FROM Customer WHERE name = ?");
            getno=c.prepareStatement("SELECT * FROM Customer WHERE num = ?");
            //getno=c.prepareStatement("SELECT * FROM Customer WHERE num = ? ORDER BY num,name,addrs,balance");
            //("CREATE TABLE PrdTable(ProductName VARCHAR(255),no VARCHAR(255),Qty VARCHAR(3),CP VARCHAR(10),MRP VARCHAR(10),Disc VARCHAR(10)");
            insert=c.prepareStatement("INSERT INTO Customer VALUES(?,?,?,?)");
            //update=c.prepareStatement("UPDATE Customer SET name=?, addrs=?, balance=? WHERE num=?");
            //System.out.println("Query Passed");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    public List< Customers > getName(String name)
    {
        List< Customers > results=null;
        ResultSet resultSet=null;
        try
        {
            getname.setString(1,name);
            resultSet=getname.executeQuery();
            results=new ArrayList< Customers >();
            while(resultSet.next())
            {
                results.add(new Customers(resultSet.getString("name"),resultSet.getString("num"),resultSet.getString("addrs"),resultSet.getString("balance")));
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        finally
        {
            try
            {
                resultSet.close();
            }
            catch(SQLException e)
            {
                e.printStackTrace();
                close();
            }
        }
        return results;
    }

    public List< Customers > getNo(String no)
    {
        List< Customers > results=null;
        ResultSet resultSet=null;
        try
        {
            getno.setString(1,no);
            resultSet=getno.executeQuery();
            results=new ArrayList< Customers >();
            while(resultSet.next())
            {
                results.add(new Customers(resultSet.getString("name"),resultSet.getString("num"),resultSet.getString("addrs"),resultSet.getString("balance")));
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        finally
        {
            try
            {
                resultSet.close();
            }
            catch(SQLException e)
            {
                e.printStackTrace();
                close();
            }
        }
        return results;
    }

    public int addCustomer(String name,String num,String addrs,String balance)
    {
        //boolean result=false;
        int r=0;
        try
        {
            insert.setString(1,name);
            insert.setString(2,num);
            insert.setString(3,addrs);
            insert.setString(4,balance);
            //result=insert.execute();
            r=insert.executeUpdate();
            //System.out.println("Customers Added");
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            close();
        }
        //return result;
        return r;
    }

    public int updateCustomer(String name,String num,String addrs,String balance)
    {
        //boolean result=false;
        int r=0;
        try
        {
            update.setString(1,name);
            update.setString(2,num);
            update.setString(3,addrs);
            update.setString(4,balance);
            //result=update.execute();
            r=update.executeUpdate();
            //System.out.println("Customers Added");
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            close();
        }
        //return result;
        return r;
    }

    public void close()
    {
        try
        {
            c.close();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }

    public static void main(String args[])
    {
        new Customer_Queries();
    }
}