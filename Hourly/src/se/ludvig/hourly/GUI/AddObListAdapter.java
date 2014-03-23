package se.ludvig.hourly.GUI;

import se.ludvig.hourly.OB;
import se.ludvig.hourly.R;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class AddObListAdapter extends ArrayAdapter<OB> {

	private final Activity context;
	public AddObListAdapter(Activity context, int resource) {
		super(context, resource);
		
		this.context = context;
		
		
	}
	
	@Override
	public View getView(int position, View view, ViewGroup parent) {

		LayoutInflater inflater = context.getLayoutInflater();

		View rowView= inflater.inflate(R.layout.add_ob_row, null, true);

		return rowView;
	}
	
	
}
