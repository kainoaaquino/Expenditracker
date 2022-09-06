package DAO;

import Model.Entry;
import util.connectionUtil;

import java.sql.*;
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
                Entry loadedEntry = new Entry(rs.getString("amount"), rs.getString("date"), rs.getInt("category"));
                allEntries.add(loadedEntry);
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }

        return allEntries;

    }
    public Entry getEntriesByDate(String date)
    {

        try
        {
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM Entry WHERE date = ?");

            statement.setString(1, date);
            ResultSet rs = statement.executeQuery();
            while(rs.next())
            {
                Entry p = new Entry(rs.getString("amount"), rs.getString("date"), rs.getInt("category"));
                return p;
            }

        }
        catch(SQLException e)
        {

        }

        return null;
    }

    public List<Entry> getEntriesByCategoryID(int category)
    {
        List<Entry> entries = new ArrayList<>();
        try
        {
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM entry WHERE category = ? ");
            statement.setInt(1, category);
            ResultSet rs = statement.executeQuery();
            while(rs.next())
            {
               Entry loadedentry = new Entry(rs.getString("amount"), rs.getString("date"), rs.getInt("category"));
               entries.add(loadedentry);

            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        if(entries.size() == 0)
        {
            return entries;
        }
        else {
            return entries;
        }
    }
    public void addEntry(Entry p)
    {
        List<Entry> entries = new ArrayList<>();
        try{
            PreparedStatement statement = conn.prepareStatement("insert into Entry(amount, date, category)" + "values(?, ?, ?)");
            statement.setString(1, p.getAmount());
            statement.setString(2, p.getDate());
            statement.setInt(3, p.getCategory());
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
