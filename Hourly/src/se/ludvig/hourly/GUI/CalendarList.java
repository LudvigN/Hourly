package se.ludvig.hourly.GUI;

import se.ludvig.hourly.R;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class CalendarList extends ArrayAdapter<String> 
{
	private final Activity context;
	private final String[] empNames;
	
	public CalendarList(Activity context, String[] web)
	{
		super(context, R.layout.one_listrow, web);
		this.context = context;
		this.empNames = web;
		
	}
		
	@Override
	public View getView(int position, View view, ViewGroup parent) {
	
		LayoutInflater inflater = context.getLayoutInflater();
	
		View rowView= inflater.inflate(R.layout.one_listrow, null, true);
	
		TextView txtTitle = (TextView) rowView.findViewById(R.id.txtEmpName);
	
		txtTitle.setText(empNames[position]);
	
		return rowView;
	}
	
}
