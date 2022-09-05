package Model;

public class Entry
{
    public String amount;
    public String date;

    public Entry(String amount, String date)
    {
        this.amount = amount;
        this.date = date;
    }

    @Override
    public String toString()
    {
        return "Entry: " +
                "amount= " + amount +
                ", date= " + date + "\n";
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
}
