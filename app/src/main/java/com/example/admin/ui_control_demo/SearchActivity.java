package com.example.admin.ui_control_demo;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SearchActivity extends AppCompatActivity implements
        DatePickerDialog.OnDateSetListener,TimePickerDialog.OnTimeSetListener {

    @BindView(R.id.autoComplete)
    AutoCompleteTextView searchView;
    @BindView(R.id.datePicker)
    TextView  datePicker;
    @BindView(R.id.timePicker)
    TextView timePicker;


    List<String> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);

        data.add("banana");
        data.add("mango");
        data.add("grape");
        data.add("apple");
        data.add("book");
        data.add("pen");
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(
                this,
                android.R.layout.simple_dropdown_item_1line,
                data
        );

        searchView.setThreshold(1);
        searchView.setAdapter(adapter);

    }

    @OnClick(R.id.datePicker)
    public void onDatePickerClicked(View view){

        Calendar c = Calendar.getInstance();
        int year=c.get(Calendar.YEAR);
        int month=c.get(Calendar.MONTH);
        int day=c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog dialog= new DatePickerDialog(
                this,this,year,month,day);
        dialog.show();

    }

    @OnClick({R.id.timePicker})
    public void onTimePickerClicked(View view){

        Calendar calendar= Calendar.getInstance();
        int h=calendar.get(Calendar.HOUR);
        int mn=calendar.get(Calendar.MINUTE);
        TimePickerDialog dialog = new TimePickerDialog(
                this,
                android.R.style.Theme_Material_Light_Dialog_Alert,
                this,
                h,
                mn,
                DateFormat.is24HourFormat(this));
        dialog.show();
    }


    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        String m="",d="";

        if(month<10)
            m="0"+(month+1);
        else m=""+(month+1);
        if(dayOfMonth<10)
            d="0"+dayOfMonth;
        else d=""+dayOfMonth;
        datePicker.setText(d+"/"+m+"/"+year);

    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        timePicker.setText(hourOfDay+":"+minute);
    }
}
