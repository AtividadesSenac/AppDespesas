package view;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

import milton.appdespesas.R;

public class MainActivity extends AppCompatActivity {

    private DatePicker datePicker;
    private Calendar calendar;
    private TextView dateView;
    private EditText editTextDtInicio, editTextDtFinal;
    private int year, yearFinal, month, monthFinal, day, dayFinal;
    private DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker arg0, int arg1, int arg2, int arg3) {
            // TODO Auto-generated method stub
            // arg1 = year
            // arg2 = month
            // arg3 = day
            showDate(arg1, arg2 + 1, arg3);
        }
    };
    private DatePickerDialog.OnDateSetListener myDateListener2 = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker arg0, int arg1, int arg2, int arg3) {
            // TODO Auto-generated method stub
            // arg1 = year
            // arg2 = month
            // arg3 = day
            showDateFinal(arg1, arg2 + 1, arg3);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        yearFinal = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        monthFinal = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        dayFinal = calendar.get(Calendar.DAY_OF_MONTH);

        editTextDtInicio = (EditText) findViewById(R.id.editTextDtInicio);
        editTextDtFinal = (EditText) findViewById(R.id.editTextDtFinal);

        showDate(year, month + 1, day);
        showDateFinal(yearFinal, monthFinal, dayFinal);
    }

    @SuppressWarnings("deprecation")
    public void setDate(View view) {
        showDialog(999);
        Toast.makeText(getApplicationContext(), "ca", Toast.LENGTH_SHORT)
                .show();
    }

    @SuppressWarnings("deprecation")
    public void setDateFinal(View view) {
        showDialog(002);
        Toast.makeText(getApplicationContext(), "ca", Toast.LENGTH_SHORT)
                .show();
    }

    @Override
    @SuppressWarnings("deprecation")
    protected Dialog onCreateDialog(int id) {
        // TODO Auto-generated method stub
        if (id == 999) {
            return new DatePickerDialog(this, myDateListener, year, month, day);
        }

        if (id == 002) {
            return new DatePickerDialog(this, myDateListener2, yearFinal, monthFinal, dayFinal);
        }
        return null;
    }

    private void showDate(int year, int month, int day) {

        editTextDtInicio.setText(new StringBuilder().append(day).append("/")
                .append(month).append("/").append(year));

    }

    private void showDateFinal(int year, int month, int day) {

        editTextDtFinal.setText(new StringBuilder().append(day).append("/")
                .append(month).append("/").append(year));

    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.main, menu);
//        return true;
//    }

}