package com.example.myapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    // declarations of the edittexts
    EditText textbox1;
    EditText textbox2;
    EditText textbox3;
    EditText textbox4;



    // compound interest calculator button declaration
    Button calculate_button;

    // clear button
    Button clearButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // edittext for principal balance
        textbox1 = findViewById(R.id.principal_balance_textbox);
        // edittext for interest rate
        textbox2 = findViewById(R.id.interest_rate_textbox);
        // textbox for the number of times the interest is implemented for each period of time
        textbox3 = findViewById(R.id.number_of_times_interest_is_used_textbox);
        // edittext for the number of periods
        textbox4 = findViewById(R.id.periods_textbox);


        // calculate button is initialized
        calculate_button = findViewById(R.id.calculate_button);
        clearButton = findViewById(R.id.clear_button);

        // when the calculate button is clicked, the compound interest is calculated and then displayed on a textview
        calculate_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double compound_interest = calculateCompoundInterest(textbox1,textbox2,textbox3,textbox4);
                Toast.makeText(MainActivity.this, "Your Compound Interest: $" + String.valueOf(compound_interest), Toast.LENGTH_SHORT).show();
            }
        });

        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearBoxes(textbox1,textbox2,textbox3,textbox4);
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }


    // method to calculate compound interest
    private static double calculateCompoundInterest(EditText textbox1, EditText textbox2, EditText textbox3, EditText textbox4) {
        double principle_balance = Double.valueOf(textbox1.getText().toString());
        double interest_rate = Double.valueOf(textbox2.getText().toString());
        double number_of_times_interest_is_used = Double.valueOf(textbox3.getText().toString());
        double number_of_periods = Double.valueOf(textbox4.getText().toString());

        double compound_interest = Math.pow(principle_balance*(interest_rate/number_of_times_interest_is_used), number_of_periods*number_of_times_interest_is_used);

        return compound_interest;

    }

    private static void clearBoxes(EditText textbox1, EditText textbox2, EditText textbox3, EditText textbox4) {
        textbox1.setText("");
        textbox2.setText("");
        textbox3.setText("");
        textbox4.setText("");
    }




}