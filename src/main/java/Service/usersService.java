package Service;


import DAO.usersRepository;
import Model.Users;

import java.util.List;

public class usersService {
    usersRepository ur;

    public usersService(){

        ur = new usersRepository();
    }


    public List<Users> getAllUsers(){

        return ur.getAllUsers();
    }

    public void addUser(int user_id, String username, String password){
        Users newUser = new Users(user_id, username,password);
        ur.addUser(newUser);
    }
    public int getUserIdFromName(String name)
    {

        return ur.getUserIdFromName(name);
    }

}
