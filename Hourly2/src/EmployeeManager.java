
import java.util.ArrayList;

import database.HourlyDatabase;

import android.content.Context;
import android.database.Cursor;

public class EmployeeManager {

	ArrayList<Employer> employers = new ArrayList<Employer>();
	Context context;
	HourlyDatabase db;

	public EmployeeManager(Context context) {
		this.context = context;
		fillListWithFake();
	}

	private void fillListWithFake() {

		addEmployer(new Employer("Ikea", "Malm� Kronprinsen", "100.00", "100"));
		addEmployer(new Employer("MAH", "Ub�tshallen", "40", "100.00"));
		addEmployer(new Employer("Svea Rike", "Malmstensland nr 1", "150.00",
				"100"));

	}

	public ArrayList<Employer> updateList() {
		db = new HourlyDatabase(context);

		Cursor c = db.getEmployer();

		if (c.moveToFirst()) {
			while (c.moveToNext()) {
				employers.add(new Employer(c.getString(c
						.getColumnIndex(db.EMPLOYER_NAME)), c.getString(c
						.getColumnIndex(db.EMPLOYER_EMAIL)), c.getString(c
						.getColumnIndex(db.EMPLOYER_PHONENUMBER)), c
						.getString(c.getColumnIndex(db.EMPLOYER_PHONENUMBER))));
			}
		}

		return employers;

	}

	public ArrayList<Employer> getList() {
		if (employers.isEmpty()) {
			updateList();
			return employers;
		} else
			return employers;

	}

	public int addEmployer(Employer employer) {
		if (db == null) {
			db = new HourlyDatabase(context);
		}

		db.addEmployer(employer.propName(null), employer.propAddress(null),
				employer.propPhone(null));

		return 1;
	}

}
