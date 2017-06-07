package com.example.helloworld.intent;

import android.content.Intent;
import android.provider.AlarmClock;
import android.provider.CalendarContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.helloworld.R;

import java.util.Calendar;

public class IntentTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_test);
        Button btn_create_alarm = (Button) findViewById(R.id.btn_create_alarm);
        btn_create_alarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createAlarm("我是闹钟",1,1);
            }
        });
    }

    private void createAlarm(String message,int hour,int minute) {
        Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM);
        intent.putExtra(AlarmClock.EXTRA_MESSAGE,message);
        intent.putExtra(AlarmClock.EXTRA_HOUR,hour);
        intent.putExtra(AlarmClock.EXTRA_MINUTES,minute);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void createTimer(View v){
        Intent intent = new Intent(AlarmClock.ACTION_SET_TIMER);
        intent.putExtra(AlarmClock.EXTRA_MESSAGE,"我是定时器");
        intent.putExtra(AlarmClock.EXTRA_LENGTH,10);
        intent.putExtra(AlarmClock.EXTRA_SKIP_UI,true);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void addDateEvent(View view) {
        Intent intent = new Intent(Intent.ACTION_INSERT);
        intent.setData(CalendarContract.Events.CONTENT_URI);
        intent.putExtra(CalendarContract.Events.TITLE,"今天是个好日子");
        intent.putExtra(CalendarContract.Events.EVENT_LOCATION,"北京");
        intent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME,Calendar.getInstance());
        intent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME,Calendar.getInstance());
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}
