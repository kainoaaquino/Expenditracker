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

    public void addUser(String username, String password){
        Users newUser = new Users(username,password);
        ur.addUser(newUser);
    }

}
