package assignment5.business.abstracts;

import assignment5.entities.concretes.User;

public interface UserCheckService {
	boolean checkFirstName(User user);
    boolean checkLastName(User user);
    boolean checkEmailValidation(User user);
    boolean checkPassword(User user);
}
