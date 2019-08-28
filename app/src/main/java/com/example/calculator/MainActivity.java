package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton plus = findViewById(R.id.plus), minus = findViewById(R.id.minus), mul = findViewById(R.id.multiply), div = findViewById(R.id.divide);
        Button cls = findViewById(R.id.clear ),fi = findViewById(R.id.fonti), fd = findViewById(R.id.fontd), log = findViewById(R.id.log);
        minus.setOnClickListener(this);
        plus.setOnClickListener(this);
        cls.setOnClickListener(this);
        fi.setOnClickListener(this);
        fd.setOnClickListener(this);
        mul.setOnClickListener(this);
        div.setOnClickListener(this);
        log.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        EditText inp1 = findViewById(R.id.input1), inp2 = findViewById(R.id.input2);
        String s1 = inp1.getText().toString(),s2 = inp2.getText().toString();
        TextView res = findViewById(R.id.result);
        if(s1.trim().length() == 0 && s2.trim().length() == 0)
        {
            Toast.makeText(this,"Please input values and try again",Toast.LENGTH_SHORT).show();
            return;
        }
        else if(s1.trim().length() == 0 && s2.trim().length() != 0)
        {
            Toast.makeText(this,"Please input the first value and try again",Toast.LENGTH_SHORT).show();
            return;
        }
        else if(s2.trim().length() == 0 && s1.trim().length() != 0)
        {
            if(v.getId()==R.id.log)
            {
                double r;
                String rs;
                r = Double.parseDouble(s1);
                rs = Double.toString(Math.log10(r));
                res.setText(rs);
                Toast.makeText(this,"Showing log of input 1",Toast.LENGTH_SHORT ).show();
            }
            else {
                Toast.makeText(this, "Please input the second value and try again", Toast.LENGTH_SHORT).show();
                return;
            }
        }
        else
        {
            double r;
            String rs;
            switch(v.getId()) {
                case R.id.plus:
                    r = Double.parseDouble(s1) + Double.parseDouble(s2);
                    rs = Double.toString(r);
                    res.setText(rs);
                    break;

                case R.id.minus:
                    r = Double.parseDouble(s1) - Double.parseDouble(s2);
                    rs = Double.toString(r);
                    res.setText(rs);
                    break;
                case R.id.clear:
                    res.setText("");
                    break;
                case R.id.fonti:
                    if(res.getTextSize() >= 164.0)
                    {
                        Toast.makeText(this,"Font Size is at Max",Toast.LENGTH_SHORT).show();
                    }
                    else
                        res.setTextSize(TypedValue.COMPLEX_UNIT_PX, res.getTextSize()+ 5);
                    break;
                case R.id.fontd:
                    if(res.getTextSize() <= 54.0)
                    {
                        Toast.makeText(this,"Font Size is at Min",Toast.LENGTH_SHORT).show();
                    }
                    else
                        res.setTextSize(TypedValue.COMPLEX_UNIT_PX, res.getTextSize()- 5);
                        break;
                case R.id.multiply:
                    r = Double.parseDouble(s1) * Double.parseDouble(s2);
                    rs = Double.toString(r);
                    res.setText(rs);
                    break;
                case R.id.divide:
                    if(Double.parseDouble(s2)==0)
                    {
                        Toast.makeText(this,"Divide by Zero invalid",Toast.LENGTH_SHORT).show();
                        break;
                    }
                    else {
                        r = Double.parseDouble(s1) / Double.parseDouble(s2);
                        rs = Double.toString(r);
                        res.setText(rs);
                    }
                    break;

            }
        }
    }
}
