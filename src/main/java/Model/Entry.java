package Model;

public class Entry {
    public String amount;
    public String date;

    public Entry(String amount, String date) {
        this.amount = amount;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Entry {  " + "amount: " + amount + "," + "date: " + date + "}";
    }
}
