package Model;

public class Entry
{
    public String amount;
    public String date;

    public int category;

    public Entry(String amount, String date, int category)
    {
        this.amount = amount;
        this.date = date;
        this.category = category;
    }

    @Override
    public String toString()
    {
        return "Entry: " +
                "amount= " + amount +
                ", date= " + date + ", category= " + category + "\n";
    }

    public String getAmount()
    {
        return amount;
    }

    public void setAmount(String amount)
    {
        this.amount = amount;
    }

    public String getDate()
    {
        return date;
    }

    public void setDate(String date)
    {
        this.date = date;
    }

    public int getCategory()
    {
        return category;
    }

    public void setCategory(int category){
        this.category = category;
    }
}
