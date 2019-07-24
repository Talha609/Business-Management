class Products
{
    String partname;
    String partno;
    String mrp,cp,qty,disc;
    public Products()
    {
    }
    public Products(String name,String no,String qty,String cp,String p,String disc)
    {
        setProductName(name);
        setPartNo(no);
        setMRP(p);
        setCP(cp);
        setQty(qty);
        setDisc(disc);
    }
    
    public void setProductName(String name)
    {
        partname=name;
    }
    public String getProductName()
    {
        return partname;
    }
    
    public void setPartNo(String p)
    {
        partno=p;
    }
    public String getPartNo()
    {
        return partno;
    }
    
    public void setCP(String c)
    {
        cp=c;
    }
    public String getCP()
    {
        return cp;
    }
    
    public void setMRP(String mp)
    {
        mrp=mp;
    }
    public String getMRP()
    {
        return mrp;
    }
    
    public void setQty(String c)
    {
        qty=c;
    }
    public String getQty()
    {
        return qty;
    }
    
    public void setDisc(String mp)
    {
        disc=mp;
    }
    public String getDisc()
    {
        return disc;
    }
}