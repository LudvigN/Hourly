package se.ludvig.hourly;

import java.util.ArrayList;

import se.ludvig.hourly.database.HourlyDatabase;
import android.content.Context;
import android.database.Cursor;

public class EmployeeManager {

	ArrayList<Employer> employers = new ArrayList<Employer>();
	Context context;
    HourlyDatabase db;

	public EmployeeManager(Context context) 
	{
		this.context = context;
        
	}

	public ArrayList<Employer> updateList()
	{
	     db = new HourlyDatabase(context);

		Cursor c = db.getEmployer();

		if(c.moveToFirst())
		{			
			while(c.moveToNext())
			{
				employers.add(new Employer(
						c.getString(c.getColumnIndex(HourlyDatabase.EMPLOYER_NAME)), 
						c.getString(c.getColumnIndex(HourlyDatabase.EMPLOYER_EMAIL)),
                        c.getString(c.getColumnIndex(HourlyDatabase.EMPLOYER_PHONENUMBER)),
                        c.getString(c.getColumnIndex(HourlyDatabase.EMPLOYER_PHONENUMBER)),
                        c.getInt(c.getColumnIndex(HourlyDatabase.EMPLOYER_ID))
						));
			}
		}

		return employers;

	}

    public ArrayList<Employer> getList()
    {
        if(employers.isEmpty())
        {
            updateList();
            return employers;
        }
        else
            return employers;

    }

    public int addEmployer(Employer employer)
    {
        if(db == null)
        {
            db = new HourlyDatabase(context);
        }

        db.addEmployer(employer.propName(null), employer.propAddress(null), employer.propPhone(null));

        return 1;
    }






}
