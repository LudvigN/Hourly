package se.ludvig.hourly.GUI;


import se.ludvig.hourly.EmployeeManager;
import se.ludvig.hourly.R;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class EmployersFragment extends Fragment implements ActionBar.OnNavigationListener {


	private EmployeeManager mngr;
	ListView list;
	IEmployers mCallback;
	
	TextView tvName;

	public interface IEmployers {
		public void createNewEmployerDialog();
    }
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) 
	{
		mngr = new EmployeeManager(getActivity());

		return inflater.inflate(R.layout.employer_fragment, container,false);

	}



	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);

		if(mngr == null)
		{
			Log.d("EmployerFragment OnviewCreated", "employeemanager was null?!");
			mngr = new EmployeeManager(getActivity());
		}

		
		EmployerList empAdapter = new EmployerList(getActivity(), mngr.getList());
		
		//instantiates listview in employer_fragment.xml
		list = (ListView)view.findViewById(R.id.employerList);
		
		//Fills the employers list
		list.setAdapter(empAdapter);
		list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(getActivity(), "You Clicked at " + mngr.getList().get(position).propName(null) , Toast.LENGTH_SHORT).show();
            }
        });


	}



	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		super.onCreateOptionsMenu(menu, inflater);
		menu.clear();
		
		inflater.inflate(R.menu.emp_menu, menu);
		
		
		
	}


	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.setHasOptionsMenu(true);
	}



	@Override
	public void onAttach(Activity activity) {
		
		try{
			mCallback=(IEmployers) activity;
			}
			catch(ClassCastException cce){
			throw new ClassCastException(activity.toString()+" must implement IEmployer interface");
			}
		super.onAttach(activity);
		
	}



	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	Log.i("onOptionsItemSelected", item.toString());	
		switch(item.getItemId())
		{
		case R.id.new_employer:
			mCallback.createNewEmployerDialog();
			
			break;
			default:
				break;
		}
		return super.onOptionsItemSelected(item);
	}



	@Override
	public boolean onNavigationItemSelected(int itemPosition, long itemId) {
		// TODO Auto-generated method stub
		return false;
	}






}