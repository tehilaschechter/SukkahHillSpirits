package com.example.fried.sukkahhillspirits;

import android.app.DatePickerDialog;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.DateFormat;
import java.util.Calendar;

public class Meet extends AppCompatActivity {
    private TextView reservation;
    MediaPlayer mpInterview;
    int playing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meet);
        reservation = (TextView)findViewById(R.id.txtReservation);
        Button button = (Button)findViewById(R.id.btnBook);
        final Button play = (Button)findViewById(R.id.btnPlay);
        mpInterview = new MediaPlayer();
        mpInterview = MediaPlayer.create(this, R.raw.interview);
        playing = 0;

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(Meet.this, d, c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (playing){
                    case 0:
                        mpInterview.start();
                        playing = 1;
                        play.setText("PAUSE");
                        break;
                    case 1:
                        mpInterview.pause();
                        playing = 0;
                        play.setText("PLAY");
                        break;
                }
            }
        });
    }
    Calendar c = Calendar.getInstance();
    DateFormat fmtDate = DateFormat.getDateInstance();
    DatePickerDialog.OnDateSetListener d = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
            c.set(Calendar.YEAR, year);
            c.set(Calendar.MONTH, monthOfYear);
            c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            reservation.setText("Your tour is set for " + fmtDate.format(c.getTime()));
        }
    };
}
