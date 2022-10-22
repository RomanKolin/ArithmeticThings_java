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

public class TriangleExistence extends AppCompatActivity
{
    EditText editText1thefirstside;
    EditText editText2thesecondside;
    EditText editText3thethirdside;
    TextView textView4result;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.triangleexistence);

        editText1thefirstside = findViewById(R.id.editText1thefirstside);
        editText2thesecondside = findViewById(R.id.editText2thesecondside);
        editText3thethirdside = findViewById(R.id.editText3thethirdside);
        textView4result = findViewById(R.id.textView4result);

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
                Intent aeactivity = new Intent(TriangleExistence.this, ArithmeticExamples.class);
                startActivity(aeactivity);
                return true;
            case R.id.item2actionswithnumbers:
                Intent awnactivity = new Intent(TriangleExistence.this, ActionsWithNumbers.class);
                startActivity(awnactivity);
                return true;
            case R.id.item3arrays:
                Intent aactivity = new Intent(TriangleExistence.this, Arrays.class);
                startActivity(aactivity);
                return true;
            case R.id.item4triangleexistence:
                Intent teactivity = new Intent(TriangleExistence.this, TriangleExistence.class);
                startActivity(teactivity);
                return true;
            case R.id.item5temperature:
                Intent tactivity = new Intent(TriangleExistence.this, Temperature.class);
                startActivity(tactivity);
                return true;
            case R.id.item6bodymassindex:
                Intent bmiactivity = new Intent(TriangleExistence.this, BodyMassIndex.class);
                startActivity(bmiactivity);
                return true;
        }

        return super.onOptionsItemSelected(menuitem);
    }

    @SuppressLint("SetTextI18n")
    public void onclickcalculate(View calculate)
    {
        int fsts, secs, thds;

        if (editText1thefirstside.getText().toString().equals("") || editText2thesecondside.getText().toString().equals("") || editText3thethirdside.getText().toString().equals(""))
            Toast.makeText(getApplicationContext(), "Print sides length", Toast.LENGTH_SHORT).show();
        else
        {
            fsts = Integer.parseInt(editText1thefirstside.getText().toString());
            secs = Integer.parseInt(editText2thesecondside.getText().toString());
            thds = Integer.parseInt(editText3thethirdside.getText().toString());

            if (fsts < secs + thds && secs < fsts + thds && thds < fsts + secs)
                textView4result.setText("Triangle exists");
            else
                textView4result.setText("Triangle doesn't exist");
        }
    }

    public void onclickclear(View clear)
    {
        editText1thefirstside.setText("");
        editText2thesecondside.setText("");
        editText3thethirdside.setText("");
        textView4result.setText("");
    }
}