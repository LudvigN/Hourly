package se.ludvig.hourly.GUI;

import se.ludvig.hourly.R;
import se.ludvig.hourly.R.layout;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class CalendarFragment extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) 
	{
		View view = inflater.inflate(R.layout.calendar_fragment, container, false);
		return view;
	}

}
