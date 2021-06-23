package assignment5.core;


import assignment5.entities.concretes.User;

public class EmailManager implements EmailService {

	@Override
	public void sendEmail(User user) {
		System.out.println("Lütfen doðrulama için mailinizi kontrol ediniz.");
	}
}
