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
                Entry loadedEntry = new Entry(rs.getString("amount"), rs.getString("entryDate"), rs.getInt("category"), rs.getInt("entryuserid"));
                allEntries.add(loadedEntry);
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }

        return allEntries;

    }
    public Entry getEntriesByDate(String entryDate)
    {

        try
        {
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM Entry WHERE entryDate = ?");

            statement.setString(1, entryDate);
            ResultSet rs = statement.executeQuery();
            while(rs.next())
            {
                Entry p = new Entry(rs.getString("amount"), rs.getString("entryDate"), rs.getInt("category"), rs.getInt("entryuserid"));
                return p;
            }

        }
        catch(SQLException e)
        {

        }
        System.out.println("No entries exist with that date.");
        return null;
    }
    public Entry getEntriesByMonth(String entryDate)
    {

        try
        {
            PreparedStatement statement = conn.prepareStatement("SELECT *  FROM Entry WHERE MONTH(entryDate) = ?");

            statement.setString(1, (entryDate));
            ResultSet rs = statement.executeQuery();
            while(rs.next())
            {
                Entry p = new Entry(rs.getString("amount"), rs.getString("entryDate"), rs.getInt("category"), rs.getInt("entryuserid"));
                return p;
            }

        }
        catch(SQLException e)
        {

        }
        System.out.println("No entries exist with that month.");
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
               Entry loadedentry = new Entry(rs.getString("amount"), rs.getString("entryDate"), rs.getInt("category"), rs.getInt("entryuserid"));
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

    public List<Entry> getEntriesByUserId(int entryuserid)
    {
        List<Entry> entries = new ArrayList<>();
        try
        {
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM entry WHERE entryuserid = ? ");
            statement.setInt(1, entryuserid);
            ResultSet rs = statement.executeQuery();
            while(rs.next())
            {
                Entry loadedentry = new Entry(rs.getString("amount"), rs.getString("entryDate"), rs.getInt("category"), rs.getInt("entryuserid"));
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

    public List<Entry> getNecessaryUserEntriesByUserId(int entryuserid)
    {
        List<Entry> entries = new ArrayList<>();
        try
        {
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM entry WHERE category = 1 AND entryuserid = ?");

            statement.setInt(1, entryuserid);

            ResultSet rs = statement.executeQuery();
            while(rs.next())
            {
                Entry loadedentry = new Entry(rs.getString("amount"), rs.getString("entryDate"), rs.getInt("category"), rs.getInt("entryuserid"));
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
    public List<Entry> getNotNecessaryUserEntriesByUserId(int entryuserid)
    {
        List<Entry> entries = new ArrayList<>();
        try
        {
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM entry WHERE category = 2 AND entryuserid = ?");

            statement.setInt(1, entryuserid);

            ResultSet rs = statement.executeQuery();
            while(rs.next())
            {
                Entry loadedentry = new Entry(rs.getString("amount"), rs.getString("entryDate"), rs.getInt("category"), rs.getInt("entryuserid"));
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
            PreparedStatement statement = conn.prepareStatement("insert into Entry(amount, entryDate, category, entryuserid)" + "values(?, ?, ?, ?)");
            statement.setString(1, p.getAmount());
            statement.setString(2, p.getentryDate());
            statement.setInt(3, p.getCategory());
            statement.setInt(4, p.getentryuserid());
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
