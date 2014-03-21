package tempStorage;

import java.util.ArrayList;

public class Employer {

	private String name;
	private String address;
	private String hourlySalery;
	private ArrayList<OB> obList;
	private int db_id;

	public String getPhoneNumber() {
		return phoneNumber;
	}

	private String phoneNumber;

	public Employer(String mName, String mAddress, String mSalery,
			String mPhoneNumber) {
		propName(mName);
		propAddress(mAddress);
		propSalery(mSalery);
		propPhone(phoneNumber);
	}

	public String propName(String newName) {
		if (newName != null) {
			name = newName;
			return null;
		} else
			return name;
	}

	public String propAddress(String newAddress) {
		if (newAddress != null) {
			address = newAddress;
			return null;
		} else
			return address;
	}

	public String propSalery(String newSalery) {
		if (newSalery != null) {
			hourlySalery = newSalery;
			return hourlySalery;
		} else
			return hourlySalery;
	}

	public String propPhone(String number) {
		if (number != null) {
			address = number;
			return null;
		} else
			return phoneNumber;
	}

	public int propId(int newID) {
		if (newID == -1) {
			return db_id;
		} else
			db_id = newID;
		return -1;
	}
}
