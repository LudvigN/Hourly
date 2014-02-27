package se.ludvig.hourly.GUI;

import se.ludvig.hourly.EmployeeManager;
import se.ludvig.hourly.Employer;
import se.ludvig.hourly.R;
import se.ludvig.hourly.R.id;
import se.ludvig.hourly.R.layout;
import android.app.ActionBar;
import android.app.ActionBar.OnNavigationListener;
import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class EmployersFragment extends Fragment implements ActionBar.OnNavigationListener {

	private static final String STATE_SELECTED_NAVIGATION_ITEM = "selected_navigation_item";
	EmployeeManager mngr;
	String[] spinnerActions;

	TextView tvName;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) 
	{
		mngr = new EmployeeManager();
		
		
		View theView = inflater.inflate(R.layout.navigation_drawer, container,false);
		
		spinnerActions = fillSpinnerArray();
		
		final ActionBar actionBar = getActivity().getActionBar();
	  
		
	    setTabNavigation(actionBar);
	    tvName = (TextView) theView.findViewById(R.id.tvEmployerName);

	   // View view = inflater.inflate(R.layout.employer_fragment, container, false);
		return theView;
	}
	/*public void onRestoreInstanceState(Bundle savedInstanceState) {
	    // Restore the previously serialized current dropdown position.
	    if (savedInstanceState.containsKey(STATE_SELECTED_NAVIGATION_ITEM)) 
	    	{
	    		//getActionBar().setSelectedNavigationItem(savedInstanceState.getInt(STATE_SELECTED_NAVIGATION_ITEM));
	    	}*/
	
	private String[] fillSpinnerArray() 
	{
		int i = 0;
		String[] ar = new String[mngr.getList().size()];
		for(Employer e : mngr.getList())
		{
			ar[i] = e.propName(null);
			i++;
		}
		return ar;
	}

	private void setTabNavigation(ActionBar bar){
	    
		bar.setDisplayShowTitleEnabled(false);
	    
	    
	    
	   
	    
		/*ArrayAdapter<String> adapter = new ArrayAdapter<String>(actionBar.getThemedContext(),
	            android.R.layout.simple_spinner_item, 
	            spinnerActions);*/
	    
	    //adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	    //actionBar.setListNavigationCallbacks(adapter, this);	
	    
	    bar.setDisplayHomeAsUpEnabled(true);
	    bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FF8800")));
	    bar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);
	    ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),  
	          android.R.layout.simple_spinner_dropdown_item, spinnerActions);
	    
	    ActionBar.OnNavigationListener navigationListener = new OnNavigationListener() {
	    	 
            @Override
            public boolean onNavigationItemSelected(int itemPosition, long itemId) {
                Toast.makeText(getActivity(), "You selected : " + spinnerActions[itemPosition]  , Toast.LENGTH_SHORT).show();
                return false;
            }
        };
 
	    
	    bar.setListNavigationCallbacks(adapter, navigationListener);
	}
	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		
		super.onCreateOptionsMenu(menu, inflater);
		setHasOptionsMenu(true);

	}


	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}

	@Override
	public boolean onNavigationItemSelected(int itemPosition, long itemId) {
		 // When the given dropdown item is selected, show its contents in the
	    // container view.
		
		
		
		//tvName.setText(mngr.getList().get(itemPosition).propName(null));
		
		
		
	    /*Fragment fragment = new EmployerDetailFragment();
	    Bundle args = new Bundle();
	    args.putInt(null, itemPosition + 1);
	    fragment.setArguments(args);
	    getFragmentManager().beginTransaction()
	        .replace( R.layout.employer_fragment ,fragment).commit();*/
	    return true;
	}

	@Override
	public void onAttach(Activity activity) {
		
		super.onAttach(activity);
	}
	
	 

	
}
