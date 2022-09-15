package DAO;

import Model.Entry;
import Model.Users;
import org.eclipse.jetty.server.Authentication;
import util.connectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class usersRepository {

    Connection conn;
    public usersRepository()
    {
        conn = connectionUtil.getConnection();
    }

    public List<Users> getAllUsers()
    {
        List<Users> allUsers = new ArrayList<>();
        try
        {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("Select * From users");

            while(rs.next())
            {
                Users loadedUsers = new Users(rs.getString("username"), rs.getString("password"));
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

}
