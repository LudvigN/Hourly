package se.ludvig.hourly.GUI;

import se.ludvig.hourly.R;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;

public class AddEmployerDialog extends DialogFragment {
	
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		Log.i(this.getTag(), "OnCreate Was called");
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.add_emp_dialog, null))
        // Add action buttons
               .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialog, int id) {
                       // sign in the user ...
                   }
               })
               .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                   public void onClick(DialogInterface dialog, int id) {
                	   AddEmployerDialog.this.getDialog().cancel();
                   }
               });      
       
        return builder.create();
    }

}