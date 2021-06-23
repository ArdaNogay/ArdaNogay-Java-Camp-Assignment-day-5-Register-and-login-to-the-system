package assignment5.business.concretes;

import assignment5.business.abstracts.UserCheckService;
import assignment5.core.RegexService;
import assignment5.entities.concretes.User;

public class UserCheckManager implements UserCheckService {

	private RegexService regexService;

	public UserCheckManager(RegexService regexService) {
		super();
		this.regexService = regexService;
	}

	@Override
	public boolean checkFirstName(User user) {

		if (user.getFirstName().isEmpty()) {
			System.out.println("Zorunlu alanlar bo� b�rak�lamaz!");
			return false;
		} else {
			if (user.getFirstName().length() <= 1) {
				System.out.println("�sminiz 2 karakterden k�sa olamaz!");
				return false;
			}
		}

		return true;
	}

	@Override
	public boolean checkLastName(User user) {

		if (user.getLastName().isEmpty()) {
			System.out.println("Zorunlu alanlar bo� b�rak�lamaz!");
			return false;
		} else {
			if (user.getLastName().length() <= 1) {
				System.out.println("�sminiz 2 karakterden k�sa olamaz!");
				return false;
			}
		}

		return true;
	}

	@Override
	public boolean checkEmailValidation(User user) {
		if (this.regexService.checkEmailFormat(user.getEmail()) == true) {
			// System.out.println("Email format� uygun");
			return true;
		} else {
			System.out.println("Email format� uygun de�il");
			return false;
		}

	}

	@Override
	public boolean checkPassword(User user) {

		if (user.getPassword().isEmpty()) {
			System.out.println("Zorunlu alanlar bo� b�rak�lamaz!");
			return false;
		} else {
			if (user.getPassword().length() < 6) {
				System.out.println("�ifreniz 6 karakterden k�sa olamaz!");
				return false;
			}
		}

		return true;
	}
}

