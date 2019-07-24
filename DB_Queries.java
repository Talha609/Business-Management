import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
class DB_Queries
{
    Connection c;
    PreparedStatement getname=null,getpart=null,insert=null;
    public DB_Queries()
    {
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            c=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Products;integratedSecurity=true;");
            getname=c.prepareStatement("SELECT * FROM PrdTable WHERE ProductName = ?");
            getpart=c.prepareStatement("SELECT * FROM PrdTable WHERE PartNo = ?");
            insert=c.prepareStatement("INSERT INTO PrdTable VALUES(?,?,?,?,?,?)");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    public List< Products > getName(String name)
    {
        List< Products > results=null;
        ResultSet resultSet=null;
        try
        {
            getname.setString(1,name);
            resultSet=getname.executeQuery();
            results=new ArrayList< Products >();
            while(resultSet.next())
            {
                results.add(new Products(resultSet.getString("ProductName"),resultSet.getString("PartNo"),resultSet.getString("Qty"),resultSet.getString("CP"),resultSet.getString("MRP"),resultSet.getString("Disc")));
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

    public List< Products > getPart(String partno)
    {
        List< Products > results=null;
        ResultSet resultSet=null;
        try
        {
            getpart.setString(1,partno);
            resultSet=getpart.executeQuery();
            results=new ArrayList< Products >();
            while(resultSet.next())
            {
                results.add(new Products(resultSet.getString("ProductName"),resultSet.getString("PartNo"),resultSet.getString("Qty"),resultSet.getString("CP"),resultSet.getString("MRP"),resultSet.getString("Disc")));
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

    public int addProduct(String name,String part,String qty,String cp,String mrp,String disc)
    {
        //boolean result=false;
        int r=0;
        try
        {
            insert.setString(1,name);
            insert.setString(2,part);
            insert.setString(3,qty);
            insert.setString(4,cp);
            insert.setString(5,mrp);
            insert.setString(6,disc);
            //result=insert.execute();
            r=insert.executeUpdate();
            //System.out.println("Products Added");
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
        new DB_Queries();
    }
}