package in.co.rays.model;

public class DataValidator {

	public boolean isNull(String val) {

		if (val == null || val.trim().length() == 0) {
			return true;
		} else {
			return false;
		}

	}

}
