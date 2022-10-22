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

public class Temperature extends AppCompatActivity
{
    EditText editText1temperature;
    TextView textView2result;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.temperature);

        editText1temperature = findViewById(R.id.editText1temperature);
        textView2result = findViewById(R.id.textView2result);

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
                Intent aeactivity = new Intent(Temperature.this, ArithmeticExamples.class);
                startActivity(aeactivity);
                return true;
            case R.id.item2actionswithnumbers:
                Intent awnactivity = new Intent(Temperature.this, ActionsWithNumbers.class);
                startActivity(awnactivity);
                return true;
            case R.id.item3arrays:
                Intent aactivity = new Intent(Temperature.this, Arrays.class);
                startActivity(aactivity);
                return true;
            case R.id.item4triangleexistence:
                Intent teactivity = new Intent(Temperature.this, TriangleExistence.class);
                startActivity(teactivity);
                return true;
            case R.id.item5temperature:
                Intent tactivity = new Intent(Temperature.this, Temperature.class);
                startActivity(tactivity);
                return true;
            case R.id.item6bodymassindex:
                Intent bmiactivity = new Intent(Temperature.this, BodyMassIndex.class);
                startActivity(bmiactivity);
                return true;
        }

        return super.onOptionsItemSelected(menuitem);
    }

    @SuppressLint("DefaultLocale")
    public void onclickcalculate(View calculate)
    {
        double ftemp;

        if (editText1temperature.getText().toString().equals(""))
            Toast.makeText(getApplicationContext(), "Print temperature", Toast.LENGTH_SHORT).show();
        else
        {
            ftemp = (Double.parseDouble(editText1temperature.getText().toString()) - 32) / 1.8;
            textView2result.setText(String.format("%.2f", ftemp).replace(".00", ""));
        }
    }

    public void onclickclear(View clear)
    {
        editText1temperature.setText("");
        textView2result.setText("");
    }
}