package com.example.work1;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText inputField;
    private Spinner unitSpinner;
    private Button convertButton;
    private TextView resultText;

    Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputField = findViewById(R.id.unitEditText);
        unitSpinner = findViewById(R.id.unitSpinner);
        convertButton = findViewById(R.id.convertButton);
        resultText = findViewById(R.id.resultText);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(context,R.array.units, android.R.layout.simple_spinner_item);
        unitSpinner.setAdapter(adapter);

        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertUnit();
            }
        });
    }

    private void convertUnit() {
        String inputText = inputField.getText().toString();
        if (inputText.isEmpty()) {
            resultText.setText("Please enter a value");
            return;
        }

        double inputValue = Double.parseDouble(inputText);
        double result = 0;
        String selectedUnit = unitSpinner.getSelectedItem().toString();
        String unitSymbol = "";

        switch (selectedUnit) {
            case "Centimeters to Meters":
                result = inputValue / 100;
                unitSymbol = "m";
                break;
            case "Meters to Kilometers":
                result = inputValue / 1000;
                unitSymbol = "km";
                break;
            case "Celsius to Fahrenheit":
                result = (inputValue * 9/5) + 32;
                unitSymbol = "°F";
                break;
            case "Fahrenheit to Celsius":
                result = (inputValue - 32) * 5/9;
                unitSymbol = "°C";
                break;
            case "Grams to Kilograms":
                result = inputValue / 1000;
                unitSymbol = "kg";
                break;
        }

        resultText.setText(String.format("%.2f %s", result, unitSymbol));
    }
}
