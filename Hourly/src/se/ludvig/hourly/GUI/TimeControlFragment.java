package se.ludvig.hourly.GUI;

import java.util.List;

import se.ludvig.hourly.EmployeeManager;
import se.ludvig.hourly.Employer;
import android.app.ActionBar;

import android.app.ActionBar.OnNavigationListener;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Toast;
import se.ludvig.hourly.R;

public class TimeControlFragment extends Fragment /*implements ActionBar.OnNavigationListener */{



	private String[] spinnerActions;
	private ActionBar actionBar;
	private static final String STATE_SELECTED_NAVIGATION_ITEM = "selected_navigation_item";
	//2DO insert chartManager instead
	private EmployeeManager mngr;
	
	public TimeControlFragment() {
		
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) 
	{				
		return inflater.inflate(R.layout.calendar_fragment, container, false);
	}
	
	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		mngr = new EmployeeManager(getActivity());
		spinnerActions = fillSpinnerArray();
		ActionBar actionBar = getActivity().getActionBar();
		setBarNavigation(actionBar);
	
		super.onViewCreated(view, savedInstanceState);
	}

	@Override
	public void onPause() {
		removeBarNavigation(getActivity().getActionBar());
		super.onPause();
	}
	
	private void setBarNavigation(ActionBar bar){
		bar.setDisplayShowTitleEnabled(false);
	   
	    bar.setDisplayHomeAsUpEnabled(true);
	    bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FF8800")));
	    bar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);
	    ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),  
	          android.R.layout.simple_spinner_dropdown_item, spinnerActions);
	    
	    ActionBar.OnNavigationListener navigationListener = new OnNavigationListener() {
	    	 
            @Override
            public boolean onNavigationItemSelected(int itemPosition, long itemId) {
                Toast.makeText(getActivity(), "You selected : " + spinnerActions[itemPosition]  , Toast.LENGTH_SHORT).show();
                return true;
            }
        };
        
        bar.setListNavigationCallbacks(adapter, navigationListener);

	}
	
	private void removeBarNavigation(ActionBar bar)
	{
		bar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
		
		
		
	}

	public void onRestoreInstanceState(Bundle savedInstanceState) {
    // Restore the previously serialized current dropdown position.
    if (savedInstanceState.containsKey(STATE_SELECTED_NAVIGATION_ITEM)) 
    	{
    		actionBar.setSelectedNavigationItem(savedInstanceState.getInt(STATE_SELECTED_NAVIGATION_ITEM));
    	}
	}
	
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

	/*@Override
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
//	    return true;
	//}


	public class SpinnerAdapter extends ArrayAdapter<Employer>
	{

		public SpinnerAdapter(Context context, int resource,
				int textViewResourceId, List<Employer> objects) {
			
			
			
			super(context, resource, textViewResourceId, objects);

		}
		
		
		
		
		
		
		
	}

}

