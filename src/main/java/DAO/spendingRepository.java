package DAO;

import Model.Entry;
import util.connectionUtil;

import java.sql.Connection;
import java.util.List;

//DAO - data access object
public class spendingRepository {
    Connection conn;
    public spendingRepository() {
        conn = connectionUtil.getConnection();
    }
    public List<Entry> getAllEntries() {
        return null;

    }
    public List<Entry> getEntriesByDate(String date){
        return null;
    }
    public void addEntry(){

    }

}
