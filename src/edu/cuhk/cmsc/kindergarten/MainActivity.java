package edu.cuhk.cmsc.kindergarten;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

public class MainActivity extends Activity {
	
	private ImageAdapter imageAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_main);

	    imageAdapter = new ImageAdapter(this);
	    GridView gridview = (GridView) findViewById(R.id.main_view);
	    gridview.setAdapter(imageAdapter);

	    gridview.setOnItemClickListener(new OnItemClickListener() {
	        public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
	        	Intent intent = new Intent(v.getContext(), imageAdapter.getActivityClass(position));
	        	startActivity(intent);


	        }
	    });

	}
}
