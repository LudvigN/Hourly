package se.ludvig.hourly;

import java.util.ArrayList;

import se.ludvig.hourly.database.HourlyDatabase;
import android.content.Context;
import android.database.Cursor;

public class EmployeeManager {

	ArrayList<Employer> employers;
	Context context;
	
	public EmployeeManager(Context context) 
	{
		this.context = context;
		employers = new ArrayList<Employer>();
		fillListWithFake();
	}
	private void fillListWithFake() {
		
		employers.add(new Employer("Ikea", "Malmö Kronprinsen", 100));
		employers.add(new Employer("MAH", "Ubåtshallen", 40));
		employers.add(new Employer("Svea Rike", "Malmstensland nr 1", 150));
		
	}
	public ArrayList<Employer> getList()
	{
		ArrayList<Employer> list = new ArrayList<Employer>();
		HourlyDatabase db = new HourlyDatabase(context);
		
		Cursor c = db.getEmployer();
		
		if(c.moveToFirst())
		{			
			while(c.moveToNext())
			{
				list.add(new Employer(
						c.getString(c.getColumnIndex(db.EMPLOYER_NAME)), 
						c.getString(c.getColumnIndex(db.EMPLOYER_EMAIL)),
						c.getDouble(c.getColumnIndex(db.EMPLOYER_FOREIGN_KEY_SALERY))
						));
			}
		}
		
		return list;
		
	}
	
	
	
	

}
