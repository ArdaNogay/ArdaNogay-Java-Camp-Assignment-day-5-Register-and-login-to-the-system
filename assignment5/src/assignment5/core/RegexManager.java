package assignment5.core;

import java.util.regex.Pattern;

public class RegexManager implements RegexService {

	public boolean checkEmailFormat(String email) {

		String regex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+.(com|org|net|edu|gov|mil|biz|info|mobi)(.[A-Z]{2})?$";
		Pattern pattern = Pattern.compile(regex,
		Pattern.CASE_INSENSITIVE);
		return pattern.matcher(email).find();
	}
}

