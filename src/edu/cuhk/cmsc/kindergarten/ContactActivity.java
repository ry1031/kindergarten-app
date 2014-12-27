package edu.cuhk.cmsc.kindergarten;

import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.method.ScrollingMovementMethod;
import android.text.util.Linkify;
import android.widget.TextView;

public class ContactActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_contact);
		
		TextView textView = (TextView) findViewById(R.id.contact);
		textView.setMovementMethod(new ScrollingMovementMethod());
		textView.setMovementMethod(LinkMovementMethod.getInstance());
		
		String message = getString(R.string.contact_us);
		final SpannableString mes = new SpannableString(Html.fromHtml(message));
		Linkify.addLinks(mes, Linkify.EMAIL_ADDRESSES | Linkify.PHONE_NUMBERS);
		

		textView.setText(mes);
	}
}
