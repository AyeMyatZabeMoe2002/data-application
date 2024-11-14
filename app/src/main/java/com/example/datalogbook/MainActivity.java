package com.example.datalogbook;
import androidx.appcompat.app.AppCompatActivity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.text.DateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

   EditText editTextName,editTextEmail;
   Button btnSave,btnView;
   TextView textViewDob;
   DatabaseHelper databaseHelper;
   String[] m= {"January","February","March","April","May","June","July",
               "August","September","October","November","December"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextName  = findViewById(R.id.edit_text_name);
        editTextEmail = findViewById(R.id.edit_text_email);

        btnSave  = findViewById(R.id.btn_save);
        btnView  = findViewById(R.id.btn_view);

        textViewDob = findViewById(R.id.textview_dob);

        databaseHelper = new DatabaseHelper(this);

        Calendar calendar  = Calendar.getInstance();

        String currentDate = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());

        textViewDob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDateDialog();
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveDetails();
            }
        });

        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewDetails();
            }
        });

    }//end of onCreate

    private void viewDetails() {
        Intent intent = new Intent(MainActivity.this,ContactListActivity.class);
        startActivity(intent);
    }

    private void saveDetails() {
        Contact contact = new Contact(editTextName.getText().toString(),
                          textViewDob.getText().toString(),
                          editTextEmail.getText().toString());

        long id = databaseHelper.saveContact(contact);

        Toast.makeText(this,"Saved: "+id, Toast.LENGTH_LONG).show();

        editTextName.setText("");
        textViewDob.setText("Choose your Date of Birth");
        editTextEmail.setText("");
    }//end of save detail

    private void openDateDialog() {
        Calendar calendar = Calendar.getInstance();
        int year  = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day   = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this,dateSet(),year,month,day);
        datePickerDialog.show();
    }//end of open dialog

    private DatePickerDialog.OnDateSetListener dateSet() {
        return new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                textViewDob.setText(m[month]+" "+dayOfMonth+", "+year);
            }
        };
    }//end of dateset

}//end of class