package database;



import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.util.Log;

public class HourlyDatabase {
	//TODO Impmementera ytterligare queries
	
	  //The index (key) column name for use in where clauses.
	  public static final String KEY_ID = "_id";
	  
	  
	  
		
		//TABLE EMPLOYERs columns
		public static final String EMPLOYER_ID = "eId";
		public static final String EMPLOYER_NAME ="employerName";
		public static final String EMPLOYER_EMAIL ="employerEmail";
		public static final String EMPLOYER_PHONENUMBER ="employerPhoneNumber";
		public static final String EMPLOYER_FOREIGN_KEY_SALERY ="salery";

		
		//TABLE SALERYs columns
		public static final String SALERY_ID = "sId";
		public static final String SALERY_AMOUNT = "sAmount";
		public static final String SALERY_TAX ="taxPercent";
		
		//TABLE WORKEVENTs columns
		public static final String WORKEVENT_ID = "wId";
		public static final String WORKEVENT_FOREIGN_KEY_EMPLOYER = "employer";
		public static final String WORKEVENT_START_TIME = "startTime";
		public static final String WORKEVENT_END_TIME = "endTime";
		public static final String WORKEVENT_DURATION ="duration";
		
		//TABLE OBs columns
		public static final String OB_ID = "oId";
		public static final String OB_AMOUNT = "amount";
		public static final String OB_START_TIME = "startTime";
		public static final String OB_END_TIME = "endTime";
		public static final String OB_ONLY_RED_DAYS ="onlyRedDays";
    public static final String OB_FOREIGN_KEY_EMPLOYER = "associatedEmployer";
	  


	
	  private DatabaseHelper dbHelper;

	  public HourlyDatabase(Context context) {
	    dbHelper  = new DatabaseHelper(context, DatabaseHelper.DATABASE_NAME, null, 
                DatabaseHelper.DATABASE_VERSION);
	    
	    seed();
	  }
	  

	  
		private void seed()
		{
			addEmployer("IKEA", "info@ikea.se", "0708794568");
			addEmployer("ICA", "info@ikea.se", "0708794568");
			addEmployer("LUDVIG", "info@ikea.se", "0708794568");
			addEmployer("ATEA", "info@ikea.se", "0708794568");
		}
	  
	  // Called when you no longer need access to the database.

	

	  public void closeDatabase() {
	    dbHelper.close();
	  }


	 
	  public Cursor getEmployer() {
	   
	    String[] result_columns = new String[] { 
	      EMPLOYER_ID, EMPLOYER_NAME, EMPLOYER_EMAIL, EMPLOYER_PHONENUMBER, EMPLOYER_FOREIGN_KEY_SALERY };
	    
	    // Specify the where clause that will limit our results.
	    //String where = EMPLOYER_ID + "=" + 1;
	    
	    SQLiteDatabase db = dbHelper.getWritableDatabase();
	    
	    Cursor cursor = db.rawQuery(
	    		"SELECT * FROM " + DatabaseHelper.TABLE_EMPLOYER + " INNER JOIN " + DatabaseHelper.TABLE_SALERY + " ON " + EMPLOYER_ID + " = " + SALERY_ID, null);
	    	    

	    return cursor;
	  }
	 

	  
	  public void addEmployer(String eName, String eEmail, String ePhone) {

	    
	    // Create a new row of values to insert.
	    ContentValues newValues = new ContentValues();
	  

	    newValues = new ContentValues();
	    newValues.put(SALERY_AMOUNT, 999);
	    newValues.put(SALERY_TAX, 0.3);
	    
	    
	    SQLiteDatabase db = dbHelper.getWritableDatabase();
	    long id = db.insert(DatabaseHelper.TABLE_SALERY, null, newValues);
	    
	    newValues = new ContentValues();

	    // Assign values for each row.
	    newValues.put(EMPLOYER_NAME, eName);
	    newValues.put(EMPLOYER_EMAIL, eEmail);
	    newValues.put(EMPLOYER_PHONENUMBER, ePhone);
	    newValues.put(EMPLOYER_FOREIGN_KEY_SALERY, id);
	   
	    db.insert(DatabaseHelper.TABLE_EMPLOYER, null, newValues);
	    
	  }
	  
	  public void updateEmployer(String eName, String eEmail, String ePhone, int eID) {
	 
	    ContentValues updatedValues = new ContentValues();
	  
	    // Assign values for each row.
	    updatedValues.put(EMPLOYER_NAME, eName);
	    updatedValues.put(EMPLOYER_EMAIL, eEmail);
	    updatedValues.put(EMPLOYER_PHONENUMBER, ePhone);
	
	  
	    // Specify a where clause the defines which rows should be
	    // updated. Specify where arguments as necessary.
	    String where = EMPLOYER_ID + "=" + eID;
	    String whereArgs[] = null;
	  
	    // Update the row with the specified index with the new values.
	    SQLiteDatabase db = dbHelper.getWritableDatabase();
	    db.update(DatabaseHelper.TABLE_EMPLOYER, updatedValues, 
	              where, whereArgs);
	  }
	  
	  public void deleteEmptyHoards() {
	   
	    // Specify a where clause that determines which row(s) to delete.
	    // Specify where arguments as necessary.
	    String where = EMPLOYER_ID + "=" + 0;
	    String whereArgs[] = null;
	  
	    // Delete the rows that match the where clause.
	    SQLiteDatabase db = dbHelper.getWritableDatabase();
	    db.delete(DatabaseHelper.TABLE_EMPLOYER, where, whereArgs);
	  }


	  
private static class DatabaseHelper extends SQLiteOpenHelper {

      public static final int DATABASE_VERSION = 1;
      public static final String DATABASE_NAME ="hourlyDatabase.db";
	
	  public static final String TABLE_EMPLOYER = "Employer";
	  public static final String TABLE_SALERY = "Salery";
	  public static final String TABLE_WORKEVENT = "WorkEvent";
	  public static final String TABLE_EXTRA_PAYMENT = "OB";

	
	private static final String EMPLOYER_CREATE = "create table " +
		      TABLE_EMPLOYER + " (" + 
		      EMPLOYER_ID +
		      " integer primary key autoincrement, " +
		      EMPLOYER_NAME + " text not null, " +
		      EMPLOYER_EMAIL + " text, " + 
		      EMPLOYER_PHONENUMBER + " integer, " + 
		      EMPLOYER_FOREIGN_KEY_SALERY + " integer, " +
            OB_FOREIGN_KEY_EMPLOYER + " integer, " +
		      "FOREIGN KEY (" + EMPLOYER_FOREIGN_KEY_SALERY+") REFERENCES "+ TABLE_SALERY +"("+SALERY_ID+"));";
	
	private static final String SALERY_CREATE = "create table " +
		      TABLE_SALERY + " (" + SALERY_ID +
		      " integer primary key autoincrement, " +
		      SALERY_AMOUNT + " integer not null, " +
		      SALERY_TAX + " float );";
	
	private static final String WORKEVENT_CREATE = "create table " +
		      TABLE_WORKEVENT + " (" +
		      WORKEVENT_ID +
		      " integer primary key autoincrement, " +
		      WORKEVENT_START_TIME + " float not null, " +
		      WORKEVENT_END_TIME + " float not null, "+ 
		      WORKEVENT_DURATION +" float not null, " + 
		      WORKEVENT_FOREIGN_KEY_EMPLOYER +" integer, " +
		      " FOREIGN KEY "+"("+WORKEVENT_FOREIGN_KEY_EMPLOYER+") REFERENCES "+ TABLE_EMPLOYER +"("+EMPLOYER_ID+"));";
	
	private static final String OB_CREATE = "create table " +
		      TABLE_EXTRA_PAYMENT + " (" + OB_ID +
		      " integer primary key autoincrement, " +
		        OB_AMOUNT + " float not null, " +
		        OB_START_TIME + " float, "+
                OB_END_TIME+" float, "+
                OB_ONLY_RED_DAYS + " integer, "+
                OB_FOREIGN_KEY_EMPLOYER +" integer, " +
            "FOREIGN KEY (" + OB_FOREIGN_KEY_EMPLOYER + ") REFERENCES "+ TABLE_EMPLOYER +"("+EMPLOYER_ID+"));";
	
	private DatabaseHelper(Context context, String name,
            CursorFactory factory, int version) {
		super(context, name, factory, version);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {


        Log.i("create employer sql", EMPLOYER_CREATE);
        Log.i("create workevent sql", WORKEVENT_CREATE);
        Log.i("create SALERY sql", SALERY_CREATE);
        Log.i("create OB sql", OB_CREATE);
		db.execSQL(EMPLOYER_CREATE);
		db.execSQL(WORKEVENT_CREATE);
		db.execSQL(SALERY_CREATE);
		db.execSQL(OB_CREATE);
		
	}



	
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		
		
	}

}
}
