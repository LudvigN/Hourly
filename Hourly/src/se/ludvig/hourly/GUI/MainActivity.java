package se.ludvig.hourly.GUI;

import java.util.ArrayList;

import se.ludvig.hourly.*;
import se.ludvig.hourly.GUI.AddEmployerDialog.OnDialogFinished;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends Activity implements EmployersFragment.IEmployers{

	private String[] navDrawerItems;
	private DrawerLayout navDrawerLayout;
	private ListView mDrawerList;
	EmployeeManager empMngr;
	AddEmployerDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation_drawer);
        
        //Navigationdrawer-implementation
        navDrawerItems = getResources().getStringArray(R.array.actionbar_items);
        navDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);
        mDrawerList.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, navDrawerItems));	
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());
        
        selectItem(1);
    }

    //Listener for navigation drawer clicks
    private class DrawerItemClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView parent, View view, int position, long id) {
            selectItem(position);
        }

    }

    @Override
	public boolean onOptionsItemSelected(MenuItem item) {
		
		return super.onOptionsItemSelected(item);
	}


    //Chooses fragment from navigationdrawer-index
	private void selectItem(int position) {
    	  	
    	
    	Log.i("Main", "Select item:" + String.valueOf(position));
    	
    	Fragment fr = null;
    	
    	Bundle bundle = new Bundle();
    	FragmentManager fragmentManager = getFragmentManager();
    	
    	
    	
    	switch(position)
    	{
    		case 0:
    			bundle.putStringArray("employerArray", navDrawerItems);
    			fr = new CalendarFragment();
    			fr.setArguments(bundle);
    			break;
    		case 1:
    			fr = new TimeControlFragment(); 
    			break;
    		case 2:
    			fr = new EmployersFragment();
    			break;
    	}
    	
    	
    	FragmentTransaction ft = fragmentManager.beginTransaction();
    	
    	ft.replace(R.id.content_frame, fr);
 
    	ft.commit();
    	
    	
    	
    	
    	setTitle(navDrawerItems[position]);
    	mDrawerList.setItemChecked(position, true);
    	navDrawerLayout.closeDrawer(mDrawerList);
    	
    	
	}


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }



    //Instantiates the dialog for adding an employer, 
    //also instatiating and handling input with interface
	@Override
	public void createNewEmployerDialog() {
		ArrayList<OB> obList = new ArrayList<OB>();
		
		Log.i("mCallback", "was called");
		dialog = new AddEmployerDialog();
	
		dialog.setDialogresult(new OnDialogFinished(){
		    public void finish(Employer newEmp, OB newOB){
		    	empMngr.addEmployer(newEmp);
		    	
		        
		    }

		});
		
		
		
		FragmentManager frmngr = getFragmentManager();
		empMngr = new EmployeeManager(this);
		
		
		dialog.show(frmngr, "dialog");
		
		
	}
    
}