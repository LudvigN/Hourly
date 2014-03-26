package se.ludvig.hourly.GUI;

import se.ludvig.hourly.Employer;
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

public class AddEmployerDialog extends DialogFragment {
	
	public OnDialogFinished mDialogFinished; 
	
	EditText txtName;
	EditText txtPhone;
	EditText txtEmail;
	EditText txtSalary;
	
	
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		Log.i(this.getTag(), "OnCreate Was called");
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        
        LayoutInflater inflater = getActivity().getLayoutInflater();  
       View view = inflater.inflate(R.layout.add_emp_dialog, null);
        
       txtName=(EditText) view.findViewById(R.id.dialog_txt_new_emp_name);
		 txtPhone=(EditText) view.findViewById(R.id.dialog_txt_new_emp_phone);
		 txtEmail=(EditText) view.findViewById(R.id.dialog_txt_new_emp_email);
		 txtSalary=(EditText) view.findViewById(R.id.dialog_txt_new_emp_salery);
               		 
		 
		 
        builder.setView(view)
        // Add action buttons
               .setPositiveButton("OK", new DialogInterface.OnClickListener() {
            	   
				@Override
				public void onClick(DialogInterface dialog, int which) {
					   //if(mDialogFinished !=null)
		               //   {
					
				
								Log.i("I came to onclick", mDialogFinished.toString());/*,String.valueOf(txtName.getText()) + 
			                			  String.valueOf(txtEmail.getText()) +
			                			  String.valueOf(txtSalary.getText())+ 
			                			  String.valueOf(txtPhone.getText() ));
								
								*/
								
		                	  mDialogFinished.finish(new Employer(txtName.getText().toString(), 
		                			  txtEmail.getText().toString(), 
		                			  txtSalary.getText().toString(), 
		                			  txtPhone.getText().toString(), 1));
		                //  }     
		                	  Log.i("and now after add",dialog.getClass().toString());
		                	 
				}
            	   
                      
               })
               .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                   public void onClick(DialogInterface dialog, int id) {
                	   AddEmployerDialog.this.getDialog().cancel();
                   }
               }); 
        

		
        return builder.create();
    }



	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		 
		AddObListAdapter adapter = new AddObListAdapter(getActivity());
		 ListView list = (ListView) getView().findViewById(R.id.lstOB);
		 list.setAdapter(adapter);
		 Log.i("I came to onviewCreated", view.toString());
			
		super.onViewCreated(view, savedInstanceState);
	}
	public interface OnDialogFinished{
	       void finish(Employer newEmp); 
	       
	       
	       
	    }
	public void setDialogresult(OnDialogFinished onDialogFinished) {
		mDialogFinished = onDialogFinished;
		
	}
	

}
