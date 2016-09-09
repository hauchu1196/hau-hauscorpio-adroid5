package com.example.hau.bmicalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.toString();
    private EditText etWeight;
    private EditText etHeight;
    private Button btnCalculateBMI;
    private TextView tvResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getLayoutReferences();

        btnCalculateBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float weight = Float.parseFloat(etWeight.getText().toString());
                float height = Float.parseFloat(etHeight.getText().toString());

                float bmi = calculateBMI(weight, height);

                tvResult.setText(String.format("Your BMI: %.0f - %s", bmi, getBMIType(bmi)));

                Log.d(TAG, String.format("btCalculateBMI.onClick: %f %f",
                        weight, height));
                Log.d(TAG, String.format("btCalculateBMI.onClick: bmi = %f",
                        bmi));
            }
        });
    }

    String getBMIType(float bmi) {
        if (bmi < 18.5) {
            return "Cân nặng thấp (gầy)";
        } else if (bmi > 18.5 && bmi < 24.9) {
            return "Bình thường";
        } else if (bmi == 25) {
            return "Thừa cân";
        } else if (bmi > 25 && bmi < 29.9) {
            return "Tiền béo phì";
        } else if (bmi > 30 && bmi < 34.9) {
            return "Béo phì độ I";
        } else if (bmi > 35 && bmi < 39.9) {
            return " Béo phì độ II";
        } else if (bmi == 40) {
            return "Béo phì độ III";
        } else {
            return "Sa mạc lời";
        }
    }

    float calculateBMI(float weight, float height) {
        height /= 100;
        return weight / (height * height);
    }

    void getLayoutReferences() {
        etHeight = (EditText) findViewById(R.id.et_height);
        etWeight = (EditText) findViewById(R.id.et_weight);
        btnCalculateBMI = (Button) findViewById(R.id.btn_calculate_bmi);
        tvResult = (TextView) findViewById(R.id.tv_bmi_result);

    }
}
