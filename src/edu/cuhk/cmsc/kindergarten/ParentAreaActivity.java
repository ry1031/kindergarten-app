package edu.cuhk.cmsc.kindergarten;

import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.method.ScrollingMovementMethod;
import android.text.util.Linkify;
import android.widget.TextView;

public class ParentAreaActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_parent_area);
		
		TextView textView = (TextView) findViewById(R.id.cooking_course_info);
		textView.setMovementMethod(new ScrollingMovementMethod());
		textView.setMovementMethod(LinkMovementMethod.getInstance());
		
		String message = getString(R.string.cooking_course_info);
		final SpannableString mes = new SpannableString(Html.fromHtml(message));
		Linkify.addLinks(mes, Linkify.EMAIL_ADDRESSES);
		

		textView.setText(mes);
	}
}
