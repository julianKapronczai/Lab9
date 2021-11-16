
package services;

import dataaccess.RoleDB;
import dataaccess.UserDB;
import java.util.List;
import models.Role;
import models.User;

public class UserService {
    public User get(String email) throws Exception {
        UserDB userDB = new UserDB();
        User user = userDB.get(email);
        return user;
    }
    
    public List<User> getAll() throws Exception {
        UserDB userDB = new UserDB();
        List<User> users = userDB.getAll();
        return users;
    }
    
    public void insert(String email, boolean active, String firstName, String lastName, String password, int role) throws Exception {
        User user = new User(email, active, firstName, lastName, password);
        Role role1 = new RoleDB().get(role);
        user.setRole(role1);
        UserDB noteDB = new UserDB();
        noteDB.insert(user);
    }
    
    public void update(String email, boolean active, String firstName, String lastName, String password, int role) throws Exception {
        User user = new User(email, active, firstName, lastName, password);
        Role role1 = new RoleDB().get(role);
        user.setRole(role1);
        UserDB userDB = new UserDB();
        userDB.update(user);
    }
    
    public void delete(String email) throws Exception {
        User user = new User();
        user = new UserDB().get(email);
        UserDB noteDB = new UserDB();
        noteDB.delete(user);
    }

 
}

    

