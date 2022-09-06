package Service;


import DAO.spendingRepository;
import Model.Entry;

import java.util.List;

public class spendingService {
    spendingRepository sr;
    categoryService cs;
    public spendingService(){
        cs = new categoryService();
        sr = new spendingRepository();
    }
    public List<Entry> getAllEntries(){
        return sr.getAllEntries();
    }
    public Entry getEntriesByDate(String date){

        return sr.getEntriesByDate(date);

    }
    public List<Entry> getEntriesByCategoryID(int cat_id)
    {
        return sr.getEntriesByCategoryID(cat_id);
    }
    public void addEntry(String amount, String date, int category) {

        Entry newEntry = new Entry(amount, date, category);
        sr.addEntry(newEntry);
    }

    public List<Entry> getEntriesByCategoryName(String name){
        int cat_id = cs.getCategoryIDFromName(name);
        return sr.getEntriesByCategoryID(cat_id);

    }

}
