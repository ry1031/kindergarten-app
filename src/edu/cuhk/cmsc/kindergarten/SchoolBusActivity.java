package edu.cuhk.cmsc.kindergarten;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.Html;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnMarkerClickListener;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class SchoolBusActivity extends Activity implements
		OnMarkerClickListener {

	private GoogleMap mMap;
	private Timer timer = new Timer(true);
	private int start = 0;
	private Marker lastMarker;
	
	final Handler h = new Handler(new Callback() {

        @Override
        public boolean handleMessage(Message msg) {
        	String[] busLatLngs = new String[] {
    				getString(R.string.bus_location_1),
    				getString(R.string.bus_location_2),
    				getString(R.string.bus_location_3),
    				getString(R.string.bus_location_4)
    			};
    			start++;
    			if(start >= busLatLngs.length) {
    				start = 0;
    			}
    			String location = busLatLngs[start];
    			if(lastMarker != null) {
    				lastMarker.remove();
    			}
    			lastMarker = addMarker(location,
    					R.drawable.bus, getString(R.string.bus));
           return true;
        }
    });

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_school_bus);
	}

	@Override
	protected void onStart() {
		super.onStart();

		String viewLocation = getResources().getString(
				R.string.school_bus_view_location);

		mMap = ((MapFragment) getFragmentManager().findFragmentById(R.id.map))
				.getMap();
		mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

		String[] location = viewLocation.split(",");

		CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(
				new LatLng(Double.parseDouble(location[0]), Double
						.parseDouble(location[1])), 15.0f);
		mMap.moveCamera(cameraUpdate);
		mMap.getUiSettings().setMyLocationButtonEnabled(true);
		mMap.setMyLocationEnabled(true);
		mMap.getUiSettings().setZoomControlsEnabled(true);
		mMap.clear();
		addMarker(getString(R.string.school_location), R.drawable.schools_maps,
				getString(R.string.app_name));
		addMarker(getString(R.string.discovery_park_location),
				R.drawable.bus_stop, getString(R.string.discovery_park));
		addMarker(getString(R.string.tsuen_tak_gardens_location),
				R.drawable.bus_stop, getString(R.string.tsuen_tak_gardens));
		addMarker(getString(R.string.allway_gartens_location),
				R.drawable.bus_stop, getString(R.string.allway_gartens));
		addMarker(getString(R.string.belvedere_garden_location),
				R.drawable.bus_stop, getString(R.string.belvedere_garden));
		mMap.setOnMarkerClickListener((OnMarkerClickListener) this);

		timer.schedule(new timerTask(), 1000, 1000);
	}

	private Marker addMarker(String location, int drawableId, String title) {
		String[] latLng = location.split(",");

		Marker marker = mMap.addMarker(new MarkerOptions()
				.position(
						new LatLng(Double.parseDouble(latLng[0]), Double
								.parseDouble(latLng[1])))
				.icon(BitmapDescriptorFactory.fromResource(drawableId))
				.title(title));
		return marker;
	}

	@Override
	public boolean onMarkerClick(Marker marker) {
		TextView textView = (TextView) findViewById(R.id.marker_description);
		textView.setText(Html.fromHtml("<h2>" + marker.getTitle() + "</h2><p>"
				+ getString(R.string.estimated_arrival_time) + "</p>"));

		return true;
	}

	public class timerTask extends TimerTask {
		
		public void run() {
			h.sendEmptyMessage(0);
		}
	};
}
