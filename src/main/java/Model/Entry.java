package Model;

public class Entry
{
    public String amount;
    public String entryDate;

    public int category;

    public Entry(){

    }

    public Entry(String amount, String entryDate, int category)
    {
        this.amount = amount;
        this.entryDate = entryDate;
        this.category = category;
    }

    @Override
    public String toString()
    {
        return amount + ": entryDate " + entryDate + category + '\n';
    }

    public String getAmount()
    {
        return amount;
    }

    public void setAmount(String amount)
    {
        this.amount = amount;
    }

    public String getentryDate()
    {
        return entryDate;
    }

    public void setentryDate(String entryDate)
    {
        this.entryDate = entryDate;
    }

    public int getCategory()
    {
        return category;
    }

    public void setCategory(int category){
        this.category = category;
    }
}
