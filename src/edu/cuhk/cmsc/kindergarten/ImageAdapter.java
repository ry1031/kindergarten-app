package edu.cuhk.cmsc.kindergarten;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ImageAdapter extends BaseAdapter {
    private Context mContext;

    public ImageAdapter(Context c) {
        mContext = c;
    }

    public int getCount() {
        return mThumbIds.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView textView;
        if (convertView == null) {  // if it's not recycled, initialize some attributes
        	textView = new TextView(mContext);
        	textView.setText(mContext.getResources().getString(mThumbStrings[position]));
        	textView.setGravity(Gravity.CENTER);
        	textView.setCompoundDrawablesWithIntrinsicBounds(0, mThumbIds[position], 0, 0);
        } else {
        	textView = (TextView) convertView;
        }

        return textView;
    }
    
    @SuppressWarnings("rawtypes")
	public Class getActivityClass(int position) {
    	return mActivity[position];
    }
    
    @SuppressWarnings("rawtypes")
	private Class[] mActivity = {
    		NewsActivity.class, AboutUsActivity.class,
    		LocationActivity.class, CalendarActivity.class,
    		GalleryActivity.class, ParentAreaActivity.class,
    		PlacementInfoActivity.class, SchoolBusActivity.class,
    		ContactActivity.class
    };

    // references to our images
    private Integer[] mThumbIds = {
            R.drawable.news, R.drawable.about_us,
            R.drawable.location, R.drawable.calendar,
            R.drawable.gallery, R.drawable.parent_area,
            R.drawable.placement_info, R.drawable.school_bus,
            R.drawable.contact
    };
    
    private Integer[] mThumbStrings = {
            R.string.news , R.string.about_us,
            R.string.location, R.string.calendar,
            R.string.gallery, R.string.parent_area,
            R.string.placement_info, R.string.school_bus,
            R.string.contact
    };
}