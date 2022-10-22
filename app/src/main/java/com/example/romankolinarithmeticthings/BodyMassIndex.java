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

public class BodyMassIndex extends AppCompatActivity
{
    EditText editText1height;
    EditText editText2weight;
    TextView textView3result;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bodymassindex);

        editText1height = findViewById(R.id.editText1height);
        editText2weight = findViewById(R.id.editText2weight);
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
                Intent aeactivity = new Intent(BodyMassIndex.this, ArithmeticExamples.class);
                startActivity(aeactivity);
                return true;
            case R.id.item2actionswithnumbers:
                Intent awnactivity = new Intent(BodyMassIndex.this, ActionsWithNumbers.class);
                startActivity(awnactivity);
                return true;
            case R.id.item3arrays:
                Intent aactivity = new Intent(BodyMassIndex.this, Arrays.class);
                startActivity(aactivity);
                return true;
            case R.id.item4triangleexistence:
                Intent teactivity = new Intent(BodyMassIndex.this, TriangleExistence.class);
                startActivity(teactivity);
                return true;
            case R.id.item5temperature:
                Intent tactivity = new Intent(BodyMassIndex.this, Temperature.class);
                startActivity(tactivity);
                return true;
            case R.id.item6bodymassindex:
                Intent bmiactivity = new Intent(BodyMassIndex.this, BodyMassIndex.class);
                startActivity(bmiactivity);
                return true;
        }

        return super.onOptionsItemSelected(menuitem);
    }

    @SuppressLint("DefaultLocale")
    public void onclickcalculate(View calculate)
    {
        double bmi, w, h;

        if (editText1height.getText().toString().equals("") || editText2weight.getText().toString().equals(""))
            Toast.makeText(getApplicationContext(), "Print height and weight", Toast.LENGTH_SHORT).show();
        else
        {
            h = Double.parseDouble(editText1height.getText().toString());
            w = Double.parseDouble(editText2weight.getText().toString());
            bmi = w / Math.pow(h, 2);

            textView3result.setText(String.format("%.1f", bmi).replace(".0", ""));
        }
    }

    public void onclickclear(View clear)
    {
        editText1height.setText("");
        editText2weight.setText("");
        textView3result.setText("");
    }
}