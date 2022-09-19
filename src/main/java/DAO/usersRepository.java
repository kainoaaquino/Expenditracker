package DAO;

import Model.Entry;
import Model.Users;
import org.eclipse.jetty.server.Authentication;
import util.connectionUtil;
import java.sql.PreparedStatement;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;

public class usersRepository {

   Connection conn = connectionUtil.getConnection();

    public List<Users> getAllUsers()
    {
        List<Users> allUsers = new ArrayList<>();
        try
        {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("Select * From users");

            while(rs.next())
            {
                Users loadedUsers = new Users(rs.getInt("user_id"), rs.getString("username"), rs.getString("password"));
                allUsers.add(loadedUsers);
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }

        return allUsers;

    }
    public void addUser(Users p)
    {
        List<Users> users = new ArrayList<>();
        try{
            PreparedStatement statement = conn.prepareStatement("insert into users(username, password )" + "values(?, ?)");
            statement.setString(1, p.getUsername());
            statement.setString(2, p.getPassword());
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getUserIdFromName(String name)
    {
        try
        {
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM users WHERE username = ? ");
            statement.setString(1, name);
            ResultSet rs = statement.executeQuery();
            while(rs.next())
            {
                int id = rs.getInt("user_id");
                return id;
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        System.out.println("username not found");
        return -1;
    }

}
