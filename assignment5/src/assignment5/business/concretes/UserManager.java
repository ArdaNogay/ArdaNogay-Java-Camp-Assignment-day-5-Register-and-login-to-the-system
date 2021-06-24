package assignment5.business.concretes;

import assignment5.business.abstracts.UserCheckService;
import assignment5.business.abstracts.UserService;
import assignment5.core.EmailService;
import assignment5.dataAccess.abstracts.UserDao;
import assignment5.entities.concretes.User;

public class UserManager implements UserService {

	public boolean status = false;

	UserDao userDao;
	UserCheckService userCheckService;
	EmailService emailService;

	public UserManager(UserDao userDao, UserCheckService userCheckService, EmailService emailService) {
		super();
		this.userDao = userDao;
		this.userCheckService = userCheckService;
		this.emailService = emailService;

	}

	@Override
	public void signIn(String email, String password) {

		if (userDao.emailCheck(email) == false && userDao.passwordCheck(password) == false) {

			System.out.println("Girilen bilgiler yanlýþ");

		} else if (userDao.emailCheck(email) == false) {

			System.out.println("Yanlýþ Email adresi girdiniz!");

		} else if (userDao.passwordCheck(password) == false) {

			System.out.println("Yanlýþ þifre girdiniz!");

		} else {
			System.out.println("...Sisteme Giriþ BAÞARILI...");
		}
	}

	@Override
	public void signUp(User user) {
		if (userCheckService.checkEmailValidation(user) == true && userCheckService.checkFirstName(user) == true
				&& userCheckService.checkLastName(user) == true && userCheckService.checkPassword(user) == true) {

			if (userDao.emailCheck(user.getEmail()) == false) {
				emailService.sendEmail(user);
				status = true;
			} else {
				System.out.println("Email daha önce kullanýlmýþ");
				status = false;
			}
		} else {
			status = false;
		}
	}

	@Override
	public void userVerify(User user) {
		if (status == true) {
			userDao.add(user);
			System.out
					.println("'" + user.getFirstName() + " " + user.getLastName() + "'" + " Kullanýcý sisteme eklendi");
			status = false;
		} else {
			System.out.println("Böyle bir kullanýcý bulunamadý.");
			status = false;
		}
	}
}
