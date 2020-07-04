package uha.anis.fr.dao.user;

import java.util.List;

import uha.anis.fr.entities.User;

public interface UserDAO {
     void addUser(User user);
     User getUserByEmailPassword(String email,String password);
     List<User> getUsers();
     void updateUser(User user);
     void deleteUser(int id);
     User getUserById(int id);
     long getNumberUsers();
     
}
