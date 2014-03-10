package se.ludvig.hourly;

public class Employer {

	private String name;
	private String address; 
	private double hourlySalery;
	
	public Employer(String mName, String mAddress, double mSalery)
	{
		propName(mName);
		propAddress(mAddress);
		propSalery(mSalery);
	}
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
	public double propSalery(double newSalery)
	{
		if (newSalery != 0)
		{
			hourlySalery = newSalery;
			return 0;
		}
		else 
			return hourlySalery;
	}
}
