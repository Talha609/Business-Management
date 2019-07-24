class Customers
{
    String name;
    String no;
    String bal,add;
    public Customers()
    {
    }
    public Customers(String name,String no,String add,String bal)
    {
        setName(name);
        setNo(no);
        setAdd(add);
        setBal(bal);
    }
    
    public void setName(String name)
    {
        this.name=name;
    }
    public String getName()
    {
        return name;
    }
    
    public void setNo(String p)
    {
        no=p;
    }
    public String getNo()
    {
        return no;
    }
    
    public void setAdd(String c)
    {
        add=c;
    }
    public String getAdd()
    {
        return add;
    }
    
    public void setBal(String mp)
    {
        bal=mp;
    }
    public String getBal()
    {
        return bal;
    }
}