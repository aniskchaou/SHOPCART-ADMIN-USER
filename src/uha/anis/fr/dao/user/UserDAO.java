package uha.anis.fr.dao.user;

import uha.anis.fr.entities.User;

public interface UserDAO {
     void addUser(User user);
     User getUserByEmailPassword(String email,String password);
}
