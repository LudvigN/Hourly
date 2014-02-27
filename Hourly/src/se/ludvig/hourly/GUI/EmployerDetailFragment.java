package se.ludvig.hourly.GUI;

import android.app.Fragment;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class EmployerDetailFragment extends Fragment {
	  public static final String ARG_SECTION_NUMBER = "placeholder_text";

	    @Override
	    public View onCreateView(LayoutInflater inflater, ViewGroup container,
	        Bundle savedInstanceState) 
	    {
	      TextView textView = new TextView(getActivity());
	      textView.setGravity(Gravity.CENTER);
	      textView.setText(Integer.toString(getArguments().getInt(ARG_SECTION_NUMBER)));
	      return textView;
	    }
}
