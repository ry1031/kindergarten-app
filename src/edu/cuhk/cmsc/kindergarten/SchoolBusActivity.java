package edu.cuhk.cmsc.kindergarten;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import android.app.Activity;
import android.os.Bundle;

public class SchoolBusActivity extends Activity {

	private GoogleMap mMap;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_school_bus);
	}
	@Override
	protected void onStart() {
		super.onStart();

		String defaultSearch = getResources().getString(
				R.string.school_location);

		mMap = ((MapFragment) getFragmentManager().findFragmentById(R.id.map))
				.getMap();
		mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

		String[] location = defaultSearch.split(",");

		CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(
				new LatLng(Double.parseDouble(location[0]), Double
						.parseDouble(location[1])), 15.0f);
		mMap.moveCamera(cameraUpdate);
		mMap.getUiSettings().setMyLocationButtonEnabled(true);
		mMap.setMyLocationEnabled(true);
		mMap.getUiSettings().setZoomControlsEnabled(true);
		mMap.clear();
		mMap.addMarker(new MarkerOptions()
				.position(
						new LatLng(Double.parseDouble(location[0]), Double
								.parseDouble(location[1])))
				.icon(BitmapDescriptorFactory
						.fromResource(R.drawable.schools_maps)));
	}
}
