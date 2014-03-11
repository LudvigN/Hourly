package se.ludvig.hourly;

public class OB 
{
	private double startTime;
	private double endTime;
	private double amount;
	private	Boolean onlyHolidays;
	
	
	public OB(double startTime, double endTime, double amount, boolean onlyHolidays)
	{
		this.startTime = startTime;
		this.endTime = endTime;
		this.amount = amount;
		this.onlyHolidays = onlyHolidays;
	}
	
	public double propStartTime(double newStartTime)
	{
		if (newStartTime != 0)
		{
			startTime = newStartTime;
			return startTime;
		}
		else
			return startTime;
	}
	
	public double propEndTime(double newEndTime)
	{
		if (endTime != 0)
		{
			endTime = newEndTime;
			return endTime;
		}
		else
			return endTime ;
	}
	
	public double propAmount(double newAmount)
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