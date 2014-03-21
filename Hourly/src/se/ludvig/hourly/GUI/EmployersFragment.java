package se.ludvig.hourly.GUI;

import java.util.ArrayList;

import se.ludvig.hourly.EmployeeManager;
import se.ludvig.hourly.Employer;
import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import se.ludvig.hourly.*;

public class EmployersFragment extends Fragment implements ActionBar.OnNavigationListener {

    //TODO Skapa en dialog för att lägga till arbetsgivare
    //Hantera actionbaren för tilläggsknappen
	private EmployeeManager mngr;
	ListView list;

	TextView tvName;

    public EmployersFragment()
    {

    }
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) 
	{
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
        ArrayList<Employer> listEMp = mngr.getList();

        Log.i("Employee Fragment", "count:" + listEMp.size());
        for(Employer e : listEMp)
        {
            Log.i("Employee Fragment", e.propName(null));
        }


        EmployerList empAdapter = new EmployerList(getActivity(), mngr.getList());
		
		//list = (ListView)view.findViewById(R.id.employerList);
		
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
