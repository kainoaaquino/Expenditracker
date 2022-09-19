package Service;


import DAO.spendingRepository;
import Model.Entry;

import java.util.List;

public class spendingService {
    spendingRepository sr;
    usersService us;
    categoryService cs;
    public spendingService(){
        cs = new categoryService();
        sr = new spendingRepository();
        us = new usersService();
    }
    public List<Entry> getAllEntries(){
        return sr.getAllEntries();
    }
    public Entry getEntriesByDate(String entryDate){

        return sr.getEntriesByDate(entryDate);

    }
    public Entry getEntriesByMonth(String entryDate){
        return getEntriesByMonth(entryDate);
    }
    public List<Entry> getEntriesByCategoryID(int cat_id)
    {
        return sr.getEntriesByCategoryID(cat_id);
    }
    public void addEntry(String amount, String entryDate, int category, int entryuserid) {

        Entry newEntry = new Entry(amount, entryDate, category, entryuserid);
        sr.addEntry(newEntry);
    }

    public List<Entry> getEntriesByCategoryName(String name){
        int cat_id = cs.getCategoryIDFromName(name);
        return sr.getEntriesByCategoryID(cat_id);

    }
    public List<Entry> getEntriesByUserName(String name){
        int user_id = us.getUserIdFromName(name);
        return sr.getEntriesByUserId(user_id);

    }

    public List<Entry> getNecessaryUserEntriesByUserName(String name){
        int user_id = us.getUserIdFromName(name);
        return sr.getNecessaryUserEntriesByUserId(user_id);
    }
    public List<Entry> getNotNecessaryUserEntriesByUserName(String name){
        int user_id = us.getUserIdFromName(name);
        return sr.getNotNecessaryUserEntriesByUserId(user_id);
    }
}
