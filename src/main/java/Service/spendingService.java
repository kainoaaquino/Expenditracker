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
    public List<Entry> getEntriesByDate(){
       // return sr.getEntriesByDate(date);
        return null;
    }
    public void addEntry(String title, String date) {

        sr.addEntry();
    }

}
