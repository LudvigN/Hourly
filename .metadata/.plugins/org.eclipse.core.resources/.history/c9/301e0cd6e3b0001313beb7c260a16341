package se.ludvig.hourly.GUI;

import java.util.ArrayList;

import se.ludvig.hourly.EmployeeManager;
import se.ludvig.hourly.Employer;
import se.ludvig.hourly.R;
import android.app.Activity;

import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class CalendarFragment extends Fragment {

	String[] events;
	ListView list;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) 
	{

		

		return inflater.inflate(R.layout.calendar_fragment, container, false);
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		
		Toast t = Toast.makeText(getActivity(), "CalendarFragmentLoaded", 2000);
    	t.show();
		
    	Bundle args = getArguments();
		events = args.getStringArray("employerArray");
		
		for(String e : events)
		{
			Log.i("Calendar", e);
		}
		
		CalendarList cAdapter = new CalendarList(getActivity(), events);
		
		
		
		list = (ListView)view.findViewById(R.id.calendarList);
		
		list.setAdapter(cAdapter);
		
		 list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
             @Override
             public void onItemClick(AdapterView<?> parent, View view,
                                     int position, long id) {
                 Toast.makeText(getActivity(), "You Clicked at " + events[+ position] , Toast.LENGTH_SHORT).show();
             }
         });
		
	}


	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		super.onAttach(activity);
	}
	
	

}
