package com.example.romankolinarithmeticthings;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class ActionsWithNumbers extends AppCompatActivity
{
    RadioButton radiobutton1numberscomparing;
    RadioButton radiobutton2numbersmultiplication;
    RadioButton radiobutton3numberdegrees;
    LinearLayout LinearLayout2;
    EditText editText1newedittext;
    TextView textView3result;
    List<View> etl;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actionswithnumbers);

        radiobutton1numberscomparing = findViewById(R.id.radiobutton1numberscomparing);
        radiobutton2numbersmultiplication = findViewById(R.id.radiobutton2numbersmultiplication);
        radiobutton3numberdegrees = findViewById(R.id.radiobutton3numberdegrees);
        LinearLayout2 = findViewById(R.id.LinearLayout2);
        editText1newedittext = findViewById(R.id.editText1newedittext);
        textView3result = findViewById(R.id.textView3result);

        etl = new ArrayList<>();
        NumbersComparing();

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
                Intent aeactivity = new Intent(ActionsWithNumbers.this, ArithmeticExamples.class);
                startActivity(aeactivity);
                return true;
            case R.id.item2actionswithnumbers:
                Intent awnactivity = new Intent(ActionsWithNumbers.this, ActionsWithNumbers.class);
                startActivity(awnactivity);
                return true;
            case R.id.item3arrays:
                Intent aactivity = new Intent(ActionsWithNumbers.this, Arrays.class);
                startActivity(aactivity);
                return true;
            case R.id.item4triangleexistence:
                Intent teactivity = new Intent(ActionsWithNumbers.this, TriangleExistence.class);
                startActivity(teactivity);
                return true;
            case R.id.item5temperature:
                Intent tactivity = new Intent(ActionsWithNumbers.this, Temperature.class);
                startActivity(tactivity);
                return true;
            case R.id.item6bodymassindex:
                Intent bmiactivity = new Intent(ActionsWithNumbers.this, BodyMassIndex.class);
                startActivity(bmiactivity);
                return true;
        }

        return super.onOptionsItemSelected(menuitem);
    }

    public void onclicknumberscomparing(View numberscomparing)
    {
        radiobutton2numbersmultiplication.setChecked(false);
        radiobutton3numberdegrees.setChecked(false);
        textView3result.setText("");
        LinearLayout2.removeAllViewsInLayout();
        etl.clear();

        NumbersComparing();
    }

    @SuppressLint("InflateParams")
    public void onclicknumbersmultiplication(View numbersmultiplication)
    {
        radiobutton1numberscomparing.setChecked(false);
        radiobutton3numberdegrees.setChecked(false);
        textView3result.setText("");
        LinearLayout2.removeAllViewsInLayout();
        etl.clear();

        @SuppressLint("InflateParams") View et = getLayoutInflater().inflate(R.layout.edittext, null);
        LinearLayout2.addView(et);
        etl.add(et);
        et = getLayoutInflater().inflate(R.layout.multiplication, null);
        LinearLayout2.addView(et);
        et = getLayoutInflater().inflate(R.layout.edittext, null);
        LinearLayout2.addView(et);
        etl.add(et);
    }

    public void onclicknumberdegrees(View numberdegrees)
    {
        radiobutton1numberscomparing.setChecked(false);
        radiobutton2numbersmultiplication.setChecked(false);
        textView3result.setText("");
        LinearLayout2.removeAllViewsInLayout();
        etl.clear();

        @SuppressLint("InflateParams") View et = getLayoutInflater().inflate(R.layout.edittext, null);
        etl.add(et);
        LinearLayout2.addView(et);
    }

    @SuppressLint("SetTextI18n")
    public void onclickcalculate(View calculate)
    {
        int empet = 0;

        for(int i = 0; i < etl.size(); i++)
            if (((EditText) etl.get(i).findViewById(R.id.editText1newedittext)).getText().toString().equals(""))
                empet += 1;
        if (empet > 0)
            Toast.makeText(getApplicationContext(), "Print numbers", Toast.LENGTH_LONG).show();
        else
        {
            if (radiobutton1numberscomparing.isChecked())
            {
                int fstn, secn, thdn, fthn;

                fstn = Integer.parseInt(((EditText) etl.get(0).findViewById(R.id.editText1newedittext)).getText().toString());
                secn = Integer.parseInt(((EditText) etl.get(1).findViewById(R.id.editText1newedittext)).getText().toString());
                thdn = Integer.parseInt(((EditText) etl.get(2).findViewById(R.id.editText1newedittext)).getText().toString());
                fthn = Integer.parseInt(((EditText) etl.get(3).findViewById(R.id.editText1newedittext)).getText().toString());

                if (fstn == secn && secn == thdn && thdn == fthn)
                    textView3result.setText("Equal");
                else
                    textView3result.setText("Not equal");
            }
            else if (radiobutton2numbersmultiplication.isChecked())
            {
                int fstmult, fstmultn, secmult;

                fstmult = Integer.parseInt(((EditText) etl.get(0).findViewById(R.id.editText1newedittext)).getText().toString());
                secmult = Integer.parseInt(((EditText) etl.get(1).findViewById(R.id.editText1newedittext)).getText().toString());

                fstmultn = fstmult;
                for (int i = 0; i < Math.abs(secmult) - 1; i++)
                    fstmultn += fstmult;

                if (secmult < 0)
                    textView3result.setText(String.valueOf(fstmultn - fstmultn - fstmultn));
                else
                    textView3result.setText(String.valueOf(fstmultn));
            }
            else
            {
                int num;

                num = Integer.parseInt(((EditText) etl.get(0).findViewById(R.id.editText1newedittext)).getText().toString());

                textView3result.setText((Math.pow(num, 2) + ", " + Math.pow(num, 3) + ", " + Math.pow(num, 4)).replace(".0", ""));
            }
        }
    }

    public void onclickclear(View clear)
    {
        LinearLayout2.removeAllViewsInLayout();
        radiobutton1numberscomparing.setChecked(true);
        radiobutton2numbersmultiplication.setChecked(false);
        radiobutton3numberdegrees.setChecked(false);
        textView3result.setText("");
        etl.clear();

        NumbersComparing();
    }

    public void NumbersComparing()
    {
        for (int i = 0; i < 4; i++)
        {
            @SuppressLint("InflateParams") View et = getLayoutInflater().inflate(R.layout.edittext, null);
            etl.add(et);
            LinearLayout2.addView(et);
        }
    }
}