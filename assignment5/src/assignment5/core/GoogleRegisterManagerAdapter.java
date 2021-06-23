package assignment5.core;

import assignment5.GoogleRegister.GoogleRegisterManager;

public class GoogleRegisterManagerAdapter implements GoogleRegisterService{

	@Override
	public void signUpWithGoogle(String message) {
		
		GoogleRegisterManager googleRegister = new GoogleRegisterManager();
		googleRegister.add(message);
		
	}

}
