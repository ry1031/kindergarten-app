package edu.cuhk.cmsc.kindergarten;

import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

public class AboutUsActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_about_us);
		
		TextView textView = (TextView) findViewById(R.id.about_school);
		textView.setText(Html.fromHtml(getString(R.string.about_school)));
		textView.setMovementMethod(new ScrollingMovementMethod());
	}
}
