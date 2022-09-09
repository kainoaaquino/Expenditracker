package DAO;

import util.connectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class categoryRepository
{
    Connection conn = connectionUtil.getConnection();
    public int getCategoryIDFromName(String name)
    {
        try
        {
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM category WHERE name = ? ");
            statement.setString(1, name);
            ResultSet rs = statement.executeQuery();
            while(rs.next())
            {
                int id = rs.getInt("cat_id");
                return id;
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        System.out.println("Category not found");
        return -1;
    }
}
