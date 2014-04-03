package se.ludvig.hourly.GUI;

import se.ludvig.hourly.Employer;
import se.ludvig.hourly.OB;
import se.ludvig.hourly.R;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TimePicker;

public class AddEmployerDialog extends DialogFragment {
	
	//Interface variable 
	public OnDialogFinished mDialogFinished; 
	
	//Variables for layout elements
	EditText txtName;
	EditText txtPhone;
	EditText txtEmail;
	EditText txtSalary;
	TimePicker startTimePicker;
	TimePicker endTimePicker;
	EditText txtSalaryExtra;
	Spinner whichDays;
	
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		Log.i(this.getTag(), "OnCreate Was called");
        // Use the Builder class for interface building
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        
        LayoutInflater inflater = getActivity().getLayoutInflater();  
        View view = inflater.inflate(R.layout.add_emp_dialog, null);
        
        //Variables instatiation for layout elements
        txtName=(EditText) view.findViewById(R.id.dialog_txt_new_emp_name);
		 txtPhone=(EditText) view.findViewById(R.id.dialog_txt_new_emp_phone);
		 txtEmail=(EditText) view.findViewById(R.id.dialog_txt_new_emp_email);
		 txtSalary=(EditText) view.findViewById(R.id.dialog_txt_new_emp_salery);
		 
		 startTimePicker = (TimePicker) view.findViewById(R.id.dialog_new_ob_starttime);
		 endTimePicker = (TimePicker) view.findViewById(R.id.dialog_new_ob_endtime);
		 txtSalaryExtra =(EditText) view.findViewById(R.id.dialog_txt_new_emp_ob);
		 whichDays =(Spinner) view.findViewById(R.id.dialog_spin_rules);
               		 
		 
		 
        builder.setView(view)
               .setPositiveButton("OK", new DialogInterface.OnClickListener() {
            	   
            	   //Create interface for positive button
				@Override
				public void onClick(DialogInterface dialog, int which) {
					
					
				
								Log.i("I came to onclick", mDialogFinished.toString());
					
								//Callback to mainactivity
								mDialogFinished.finish(new Employer(
		                			  txtName.getText().toString(), 
		                			  txtEmail.getText().toString(), 
		                			  txtSalary.getText().toString(), 
		                			  txtPhone.getText().toString()), new OB(
		                			  txtSalaryExtra.getText().toString(),
		                			  startTimePicker.getCurrentHour() + "."+ startTimePicker.getCurrentMinute(),
		                			  endTimePicker.getCurrentHour() + "."+endTimePicker.getCurrentMinute(), whichDays.getSelectedItem().toString())
		                			  
		                			  );
		                  
		                	  Log.i("and now after add",dialog.getClass().toString());
		                	 
				}
            	   
                      
               })
               //Create interface implementation for negativebutton
               .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                   public void onClick(DialogInterface dialog, int id) {
                	   AddEmployerDialog.this.getDialog().cancel();
                   }
               }); 
        

		
        return builder.create();
    }



	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		//Adding the add ob fields
		//Should be expanding dynamic, but not. 
		AddObListAdapter adapter = new AddObListAdapter(getActivity());
		 ListView list = (ListView) getView().findViewById(R.id.lstOB);
		 list.setAdapter(adapter);
		 Log.i("I came to onviewCreated", view.toString());
			
		super.onViewCreated(view, savedInstanceState);
	}
	
	//interface defined 
	public interface OnDialogFinished{
	      
		void finish(Employer newEmp, OB newOB); 
	       
	       
	       
	    }
	//Sets interface for dialog
	public void setDialogresult(OnDialogFinished onDialogFinished) {
		mDialogFinished = onDialogFinished;
		
	}
	

}
