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
			System.out.println("Zorunlu alanlar boþ býrakýlamaz!");
			return false;
		} else {
			if (user.getFirstName().length() <= 1) {
				System.out.println("Ýsminiz 2 karakterden kýsa olamaz!");
				return false;
			}
		}

		return true;
	}

	@Override
	public boolean checkLastName(User user) {

		if (user.getLastName().isEmpty()) {
			System.out.println("Zorunlu alanlar boþ býrakýlamaz!");
			return false;
		} else {
			if (user.getLastName().length() <= 1) {
				System.out.println("Ýsminiz 2 karakterden kýsa olamaz!");
				return false;
			}
		}

		return true;
	}

	@Override
	public boolean checkEmailValidation(User user) {
		if (this.regexService.checkEmailFormat(user.getEmail()) == true) {
			// System.out.println("Email formatý uygun");
			return true;
		} else {
			System.out.println("Email formatý uygun deðil");
			return false;
		}

	}

	@Override
	public boolean checkPassword(User user) {

		if (user.getPassword().isEmpty()) {
			System.out.println("Zorunlu alanlar boþ býrakýlamaz!");
			return false;
		} else {
			if (user.getPassword().length() < 6) {
				System.out.println("Þifreniz 6 karakterden kýsa olamaz!");
				return false;
			}
		}

		return true;
	}
}

