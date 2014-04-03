package se.ludvig.hourly;

import java.util.ArrayList;

public class Employer {

	private String name;
	private String address; 
	private String hourlySalery;
	private ArrayList<OB> obList;
    private String phoneNumber;
    private int key;
    
    //Constructor
    public Employer(String mName, String mAddress, String mSalery, String mPhoneNumber)
	{
		propName(mName);
		propAddress(mAddress);
		propSalery(mSalery);
        propPhone(phoneNumber);
	}

	

    //Properties for variables
    //If you pass null you get the old value returned
	public String propName(String newName)
	{
		if (newName != null)
		{
			name = newName;
			return null;
		}
		else
			return name;
	}
	 //Properties for variables
    //If you pass null you get the old value returned
	public String propAddress(String newAddress)
	{
		if (newAddress != null)
		{
			address = newAddress;
			return null;
		}
		else 
			return address;
	}
	 //Properties for variables
    //If you pass null you get the old value returned
	public String propSalery(String newSalery)
	{
		if (newSalery != null)
		{
			hourlySalery = newSalery;
			return hourlySalery;
		}
		else 
			return hourlySalery;
	}
	

	 //Properties for variables
    //If you pass null you get the old value returned
    public String propPhone(String number)
    {
        if (number != null)
        {
            address = number;
            return null;
        }
        else
            return phoneNumber;
    }



    //Properties for variables
    //If you pass null you get the old value returned
	public int setKey(int columnIndex) {
		if (columnIndex == -1)
		{
			return key;
		}
		else
		{
			return key = columnIndex;
		}
	}
}