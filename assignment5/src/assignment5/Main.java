package assignment5;

import assignment5.business.abstracts.UserService;
import assignment5.business.concretes.UserCheckManager;
import assignment5.business.concretes.UserManager;
import assignment5.core.EmailManager;
import assignment5.core.GoogleRegisterManagerAdapter;
import assignment5.core.GoogleRegisterService;
import assignment5.core.RegexManager;
import assignment5.dataAccess.concretes.HibernateUserDao;
import assignment5.entities.concretes.User;

public class Main {

	public static void main(String[] args) {

		User user1 = new User(1, "Arda", "Nogay", "ardanogay@hotmail.com", "ar15no");
		User user2 = new User(2, "Yasir", "Çiftçi", "ardanogay@hotmail.com", "ya16çi");
		User user3 = new User(3, "Kubilay", "Tunç", "kubit@outlook.co", "ku17tu");

		UserService userService = new UserManager(new HibernateUserDao(),new UserCheckManager(new RegexManager()), new EmailManager());

		//scenario 1	SignUp to system
		userService.signUp(user1); userService.userVerify(user1);
		System.out.println("------------------------------");
		userService.signUp(user2); //userService.userVerify(user2);
		System.out.println("------------------------------");
		userService.signUp(user3); userService.userVerify(user3);
		System.out.println("------------------------------");
		 	 
		
		//scenario 2	SignIn to system
		userService.signIn("ardanogay@hotmail.com", "ar15no");
		
		
		//scenario 3	SignUp to system with Google account
		System.out.println("------------------------------"); 
		GoogleRegisterService googleRegisterService = new GoogleRegisterManagerAdapter();
		googleRegisterService.signUpWithGoogle(": Hoþ geldiniz.");
	}

}
