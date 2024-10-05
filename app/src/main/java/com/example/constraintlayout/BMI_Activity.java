package com.example.constraintlayout;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class BMI_Activity extends AppCompatActivity {

    public Double BMI_Caculation(double weight, double height){
        return weight / Math.pow(height / 100.0, 2);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bmi);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText weight = findViewById(R.id.edit_text_weight);
        EditText height = findViewById(R.id.edit_text_height);

        TextView result = findViewById(R.id.text_view_result);

        Button btn_caculate = findViewById(R.id.btn_caculating);
        btn_caculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double w = Double.parseDouble(weight.getText().toString().trim());
                double h =Double.parseDouble(height.getText().toString().trim());
                double bmi = Math.round(BMI_Caculation(w, h) * 10) / 10.0;

                if (bmi < 18) {
                    result.setText("BMI = " + bmi + ", Gầy");
                } else if (bmi < 24.9) {
                    result.setText("BMI = " + bmi + ", Bình thường");
                } else if (bmi < 29.9) {
                    result.setText("BMI = " + bmi + ", Béo phì độ I");
                } else if (bmi < 34.9) {
                    result.setText("BMI = " + bmi + ", Béo phì độ II");
                } else {
                    result.setText("BMI = " + bmi + ", Béo phì độ III");
                }
            }
        });
    }
}