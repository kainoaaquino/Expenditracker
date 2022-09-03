package DAO;

import Model.Entry;
import util.connectionUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

//DAO - data access object
public class spendingRepository
{
    Connection conn;
    public spendingRepository()
    {
        conn = connectionUtil.getConnection();
    }
    public List<Entry> getAllEntries()
    {
        List<Entry> allEntries = new ArrayList<>();
        try
        {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("Select * From Entry");

            while(rs.next())
            {
                Entry loadedEntry = new Entry(rs.getString("amount"), rs.getString("date"));
                allEntries.add(loadedEntry);
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }

        return allEntries;

    }
    public List<Entry> getEntriesByDate(String date)
    {
        return null;
    }
    public void addEntry()
    {

    }

}
