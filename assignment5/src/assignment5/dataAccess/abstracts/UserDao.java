package assignment5.dataAccess.abstracts;

import java.util.List;

import assignment5.entities.concretes.User;

public interface UserDao {
	void add(User user);
    List<User> getAll();
    boolean emailCheck(String email);
    boolean passwordCheck(String password);

}
