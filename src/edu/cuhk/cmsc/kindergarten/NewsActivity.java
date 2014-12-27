package edu.cuhk.cmsc.kindergarten;

import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

public class NewsActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_news);
		
		TextView textView = (TextView) findViewById(R.id.news);
		textView.setText(Html.fromHtml(getString(R.string.news_content)));
		textView.setMovementMethod(new ScrollingMovementMethod());
	}
}
