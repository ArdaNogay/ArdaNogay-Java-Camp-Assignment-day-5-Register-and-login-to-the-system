package assignment5.core;


import assignment5.entities.concretes.User;

public class EmailManager implements EmailService {

	@Override
	public void sendEmail(User user) {
		System.out.println("L�tfen do�rulama i�in mailinizi kontrol ediniz.");
	}
}
