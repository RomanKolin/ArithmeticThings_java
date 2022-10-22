package com.example.romankolinarithmeticthings;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class ArithmeticExamples extends AppCompatActivity
{
    EditText editText1examplenumber;
    TextView textView3result;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.arithmeticexamples);

        editText1examplenumber = findViewById(R.id.editText1examplenumber);
        textView3result = findViewById(R.id.textView3result);

        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @SuppressLint("NonConstantResourceId")
    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        int miid = menuitem.getItemId();

        switch (miid)
        {
            case R.id.item1arithmeticexamples:
                Intent aeactivity = new Intent(ArithmeticExamples.this, ArithmeticExamples.class);
                startActivity(aeactivity);
                return true;
            case R.id.item2actionswithnumbers:
                Intent awnactivity = new Intent(ArithmeticExamples.this, ActionsWithNumbers.class);
                startActivity(awnactivity);
                return true;
            case R.id.item3arrays:
                Intent aactivity = new Intent(ArithmeticExamples.this, Arrays.class);
                startActivity(aactivity);
                return true;
            case R.id.item4triangleexistence:
                Intent teactivity = new Intent(ArithmeticExamples.this, TriangleExistence.class);
                startActivity(teactivity);
                return true;
            case R.id.item5temperature:
                Intent tactivity = new Intent(ArithmeticExamples.this, Temperature.class);
                startActivity(tactivity);
                return true;
            case R.id.item6bodymassindex:
                Intent bmiactivity = new Intent(ArithmeticExamples.this, BodyMassIndex.class);
                startActivity(bmiactivity);
                return true;
        }

        return super.onOptionsItemSelected(menuitem);
    }

    @SuppressLint("DefaultLocale")
    public void onclickcalculate(View calculate)
    {
        int numb;
        double resd;
        boolean resb = true;

        if (editText1examplenumber.getText().toString().equals(""))
            Toast.makeText(getApplicationContext(), "Print example number", Toast.LENGTH_SHORT).show();
        else
        {
            numb = Integer.parseInt(editText1examplenumber.getText().toString());
            switch (numb)
            {
                case 1:
                    resd = (101.0 + 0.0) / 3.0;
                    textView3result.setText(String.format("%.2f", resd));
                    break;
                case 2:
                    resd = 3.0 * Math.pow(10, -6) * 10000000.1;
                    textView3result.setText(String.valueOf(resd));
                    break;
                case 3:
                    resb = true && true;
                    break;
                case 4:
                    resb = false && true;
                    break;
                case 5:
                    resb = (false && false) || (true && true);
                    break;
                case 6:
                    resb = (false || false) && (true && true);
                    break;
            }

            if (numb != 1 && numb != 2)
                textView3result.setText(String.valueOf(resb));
        }
    }

    public void onclickclear(View clear)
    {
        editText1examplenumber.setText("");
        textView3result.setText("");
    }
}