package se.ludvig.hourly.GUI;

import se.ludvig.hourly.OB;
import se.ludvig.hourly.R;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

public class AddObListAdapter extends ArrayAdapter<OB> {

	private final Activity context;
	public AddObListAdapter(Activity context) {
		super(context, R.layout.add_ob_row);
		
		this.context = context;
		
		
	}
	
	@Override
	public View getView(int position, View view, ViewGroup parent) {

		LayoutInflater inflater = context.getLayoutInflater();
		View rowView= inflater.inflate(R.layout.add_ob_row, parent, true);
		
		TimePicker startTimePicker = (TimePicker) rowView.findViewById(R.id.dialog_new_ob_starttime);
		TimePicker endTimePicker = (TimePicker) rowView.findViewById(R.id.dialog_new_ob_endtime);
		Spinner options = (Spinner) rowView.findViewById(R.id.dialog_spin_rules);
		TextView tvOb = (TextView) rowView.findViewById(R.id.dialog_tv_new_emp_ob);
		
		startTimePicker.setIs24HourView(true);
		endTimePicker.setIs24HourView(true);
		return rowView;
	}
	
	
}
