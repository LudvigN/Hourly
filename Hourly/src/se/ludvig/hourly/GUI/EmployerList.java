package se.ludvig.hourly.GUI;

import java.util.ArrayList;

import se.ludvig.hourly.R;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import se.ludvig.hourly.*;

public class EmployerList extends ArrayAdapter<Employer>  {


	private final Activity context;
	private final ArrayList <Employer> empNames;
	
	public EmployerList(Activity context, ArrayList<Employer> eList)
	{
		super(context, R.layout.employer_listrow, eList); 
		this.context = context;
		this.empNames = eList;
		
	}
		
	@Override
	public View getView(int position, View view, ViewGroup parent) {
	
		LayoutInflater inflater = context.getLayoutInflater();
	
		View rowView= inflater.inflate(R.layout.employer_listrow, null, true);
	
		TextView txtEmpName = (TextView) rowView.findViewById(R.id.txtEmployerName);
		txtEmpName.setText(empNames.get(position).propName(null));
		
		TextView txtSalary = (TextView) rowView.findViewById(R.id.txtEmpSalary);
		txtSalary.setText(Double.toString(empNames.get(position).propSalery(0)));
		
		TextView txtEmpTax = (TextView) rowView.findViewById(R.id.txtEmpTax);
		txtEmpTax.setText(Double.toString(empNames.get(position).propTax(0)));
	
		return rowView;
	}
}