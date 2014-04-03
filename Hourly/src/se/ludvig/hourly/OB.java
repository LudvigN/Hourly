package se.ludvig.hourly;

public class OB 
{
	private String startTime;
	private String endTime;
	private int amount;
	private	Boolean onlyHolidays;


	public OB(String amount, String startTime , String endTime, String onlyHolidays)
	{
		this.startTime = startTime;
		this.endTime = endTime;
		//this.amount = Integer.valueOf(amount);
		
	}

	
	//Properties for variables
	public String propStartTime(String newStartTime)
	{
		if (newStartTime != null)
		{
			startTime = newStartTime;
			return startTime;
		}
		else
			return startTime;
	}

	public String propEndTime(String newEndTime)
	{
		if (endTime != null)
		{
			endTime = newEndTime;
			return endTime;
		}
		else
			return endTime ;
	}

	public double propAmount(int newAmount)
	{
		if (newAmount != 0)
		{
			amount = newAmount;
			return amount;
		}
		else
		{
			return amount;
		}
	}
	public Boolean prop(Boolean newOnlyHolidays)
	{
		if (newOnlyHolidays != null)
		{
			onlyHolidays = newOnlyHolidays;
			return onlyHolidays;
		}
		else
			return onlyHolidays;
	}

}
