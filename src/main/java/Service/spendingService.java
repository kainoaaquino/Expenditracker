package Service;


import DAO.spendingRepository;
import Model.Entry;

import java.util.List;

public class spendingService {
    spendingRepository sr;
    public spendingService(){
        sr = new spendingRepository();
    }
    public List<Entry> getAllEntries(){
        return sr.getAllEntries();
    }
    public Entry getEntriesByDate(String date){

        return sr.getEntriesByDate(date);

    }
    public void addEntry(String amount, String date, int category) {

        Entry newEntry = new Entry(amount, date, category);
        sr.addEntry(newEntry);
    }

}
