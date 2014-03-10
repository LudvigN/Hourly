package se.ludvig.hourly.GUI;

import se.ludvig.hourly.R;
import se.ludvig.hourly.R.array;
import se.ludvig.hourly.R.id;
import se.ludvig.hourly.R.layout;
import se.ludvig.hourly.R.menu;
import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	private String[] navDrawerItems;
	private DrawerLayout navDrawerLayout;
	private ListView mDrawerList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation_drawer);
       // ActionBar actionBar = getActionBar();
        
        //Navigationdrawer implementation
        navDrawerItems = getResources().getStringArray(R.array.actionbar_items);
        navDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);
        mDrawerList.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, navDrawerItems));	
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());

    }

    private class DrawerItemClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView parent, View view, int position, long id) {
        	Toast t = Toast.makeText(getApplicationContext(), navDrawerItems[position], 2000);
        	t.show();
            selectItem(position);
        }

    }
    //On-item selected
    private void selectItem(int position) {
    	  	
    	Fragment fr = null;
    	Bundle bundle = new Bundle();
    	FragmentManager fragmentManager = getFragmentManager();
    	switch(position)
    	{
    		case 0:
    			bundle.putStringArray("employerArray", navDrawerItems);
    			
    			fr = new CalendarFragment();
    			fr.setArguments(bundle);
    		case 1:
    			fr = new TimeControlFragment();  			
    		case 2:
    			fr = new EmployersFragment();
    	}
    	
 
    	fragmentManager.beginTransaction().add(R.id.content_frame, fr).commit();

    	setTitle(navDrawerItems[position]);
    	mDrawerList.setItemChecked(position, true);
    	navDrawerLayout.closeDrawer(mDrawerList);
    	
    	
	}


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
