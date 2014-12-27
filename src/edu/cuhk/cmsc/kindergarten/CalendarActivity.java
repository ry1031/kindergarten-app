package edu.cuhk.cmsc.kindergarten;

import android.app.Activity;
import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.CalendarView.OnDateChangeListener;
import android.widget.Toast;

public class CalendarActivity extends Activity {

	private CalendarView calendar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_calendar);
		
		//initializes the calendarview
		initializeCalendar();
	}

	public void initializeCalendar() {
		calendar = (CalendarView) findViewById(R.id.calendar);
		// sets whether to show the week number.
		calendar.setShowWeekNumber(false);

		// sets the first day of week according to Calendar.
		// here we set Monday as the first day of the Calendar
		calendar.setFirstDayOfWeek(2);

		// sets the listener to be notified upon selected date change.
		calendar.setOnDateChangeListener(new OnDateChangeListener() {
			// show the selected date as a toast
			@Override
			public void onSelectedDayChange(CalendarView view, int year,
					int month, int day) {
				Toast.makeText(getApplicationContext(),
						day + "/" + month + "/" + year, Toast.LENGTH_LONG)
						.show();
			}
		});
	}
}
