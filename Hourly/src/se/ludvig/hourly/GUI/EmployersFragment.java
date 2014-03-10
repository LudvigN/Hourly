package se.ludvig.hourly.GUI;

import java.util.ArrayList;

import se.ludvig.hourly.EmployeeManager;
import se.ludvig.hourly.Employer;
import se.ludvig.hourly.R;
import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class EmployersFragment extends Fragment implements ActionBar.OnNavigationListener {

	
	private EmployeeManager mngr;
	

	TextView tvName;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) 
	{
		mngr = new EmployeeManager(getActivity());
	

		EmployeeManager man = new EmployeeManager(getActivity());
		
		ArrayList<Employer> listEMp = man.getList();
		
		Log.i("Employee Fragment", "count:" + listEMp.size());
		
		for(Employer e : listEMp)
		{
			Log.i("Employee Fragment", e.propName(null));
		}
		
		

	   // View view = inflater.inflate(R.layout.employer_fragment, container, false);
		return inflater.inflate(R.layout.employer_fragment, container,false);
	}
	
	
	
	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		  tvName = (TextView) getView().findViewById(R.id.tvEmployerName);
		super.onViewCreated(view, savedInstanceState);
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
	public void onAttach(Activity activity) {
		
		super.onAttach(activity);
	}



	@Override
	public boolean onNavigationItemSelected(int itemPosition, long itemId) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
	 

	
}
