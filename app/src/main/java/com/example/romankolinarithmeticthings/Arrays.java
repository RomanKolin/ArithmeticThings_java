package com.example.romankolinarithmeticthings;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class Arrays extends AppCompatActivity
{
    LinearLayout LinearLayout1;
    LinearLayout LinearLayout2;
    LinearLayout LinearLayout3;
    EditText editText1numberofmaxminarrayelements;
    TextView textView2result;
    List<View> etl;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.arrays);

        LinearLayout1 = findViewById(R.id.LinearLayout1);
        LinearLayout2 = findViewById(R.id.LinearLayout2);
        LinearLayout3 = findViewById(R.id.LinearLayout3);
        editText1numberofmaxminarrayelements = findViewById(R.id.editText1numberofmaxminarrayelements);
        textView2result = findViewById(R.id.textView2result);

        etl = new ArrayList<>();
        @SuppressLint("InflateParams") View et = getLayoutInflater().inflate(R.layout.edittext, null);
        etl.add(et);
        LinearLayout1.addView(et);

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
                Intent aeactivity = new Intent(Arrays.this, ArithmeticExamples.class);
                startActivity(aeactivity);
                return true;
            case R.id.item2actionswithnumbers:
                Intent awnactivity = new Intent(Arrays.this, ActionsWithNumbers.class);
                startActivity(awnactivity);
                return true;
            case R.id.item3arrays:
                Intent aactivity = new Intent(Arrays.this, Arrays.class);
                startActivity(aactivity);
                return true;
            case R.id.item4triangleexistence:
                Intent teactivity = new Intent(Arrays.this, TriangleExistence.class);
                startActivity(teactivity);
                return true;
            case R.id.item5temperature:
                Intent tactivity = new Intent(Arrays.this, Temperature.class);
                startActivity(tactivity);
                return true;
            case R.id.item6bodymassindex:
                Intent bmiactivity = new Intent(Arrays.this, BodyMassIndex.class);
                startActivity(bmiactivity);
                return true;
        }

        return super.onOptionsItemSelected(menuitem);
    }

    public void onclicknewfield(View newfield)
    {
        @SuppressLint("InflateParams") View et = getLayoutInflater().inflate(R.layout.edittext, null);
        etl.add(et);
        if (etl.size() <= 10)
            LinearLayout1.addView(et);
        else if (etl.size() <= 20)
            LinearLayout2.addView(et);
        else
            LinearLayout3.addView(et);
    }

    @SuppressLint("SetTextI18n")
    public void onclickcalculate(View calculate)
    {
        int empet = 0;

        for(int i = 0; i < etl.size(); i++)
            if (((EditText) etl.get(i).findViewById(R.id.editText1newedittext)).getText().toString().equals(""))
                empet += 1;
        if (empet > 0)
            Toast.makeText(getApplicationContext(), "Print array elements", Toast.LENGTH_LONG).show();
        else
        {
            if (editText1numberofmaxminarrayelements.getText().toString().equals(""))
                Toast.makeText(getApplicationContext(), "Print number of max/min array elements", Toast.LENGTH_SHORT).show();
            else
            {
                if (Integer.parseInt(editText1numberofmaxminarrayelements.getText().toString()) > etl.size())
                    Toast.makeText(getApplicationContext(), "Print number of max/min array elements less than or equal to the number of array elements", Toast.LENGTH_LONG).show();
                else
                {
                    int sum = 0, mtasize = 0, mtaid = 0, evsize = 0, evid = 0, oddid = 0, numlen;
                    double aver;
                    String[] numarr = new String[etl.size()];
                    String[] maxelarr = new String[Integer.parseInt(editText1numberofmaxminarrayelements.getText().toString())];
                    String[] minelarr = new String[Integer.parseInt(editText1numberofmaxminarrayelements.getText().toString())];
                    String[] mtaverarr;
                    String[] evarr;
                    String[] oddarr;

                    for(int i = 0; i < etl.size(); i++)
                    {
                        numarr[i] = ((EditText) etl.get(i).findViewById(R.id.editText1newedittext)).getText().toString();

                        sum += Integer.parseInt(numarr[i]);

                        if (Integer.parseInt(numarr[i]) % 2 == 0)
                            evsize += 1;
                    }

                    BubbleSorting(numarr);

                    aver = sum / numarr.length;
                    for (int i = 0; i < numarr.length; i++)
                        if (Integer.parseInt(numarr[i]) > aver)
                            mtasize += 1;
                    mtaverarr = new String[mtasize];
                    evarr = new String[evsize];
                    oddarr = new String[numarr.length - evsize];
                    for (int i = 0; i < numarr.length; i++)
                    {
                        if (Integer.parseInt(numarr[i]) > aver)
                        {
                            mtaverarr[mtaid] = numarr[i];
                            mtaid += 1;
                        }

                        if (Integer.parseInt(numarr[i]) % 2 == 0)
                        {
                            evarr[evid] = numarr[i];
                            evid += 1;
                        }
                        else
                        {
                            oddarr[oddid] = numarr[i];
                            oddid += 1;
                        }
                    }

                    numlen = numarr.length - 1;
                    for (int i = 0; i < Integer.parseInt(editText1numberofmaxminarrayelements.getText().toString()); i++)
                    {
                        maxelarr[i] = numarr[numlen];
                        numlen -= 1;
                        minelarr[i] = numarr[i];
                    }
                    BubbleSorting(maxelarr);

                    textView2result.setText("Max element(-s): " + String.join(", ", maxelarr) + "; min element(-s): " + String.join(", ", minelarr) + "\n" +
                            "Array elements larger than the array average value: " + String.join(", ", mtaverarr) + "\n" +
                            "Even: " + String.join(", ", evarr) + "; odd: " + String.join(", ", oddarr));
                }
            }
        }
    }

    public void onclickclear(View clear)
    {
        LinearLayout1.removeAllViewsInLayout();
        LinearLayout2.removeAllViews();
        LinearLayout3.removeAllViews();
        etl.clear();
        editText1numberofmaxminarrayelements.setText("");
        textView2result.setText("");

        @SuppressLint("InflateParams") View et = getLayoutInflater().inflate(R.layout.edittext, null);
        etl.add(et);
        LinearLayout1.addView(et);
    }

    public void BubbleSorting(String[] arr)
    {
        for (int iext = 0; iext < arr.length; iext ++)
            for (int iint = 0; iint < arr.length - 1; iint ++)
                if (Integer.parseInt(arr[iint]) > Integer.parseInt(arr[iint + 1]))
                {
                    String tmp = arr[iint + 1];
                    arr[iint + 1] = arr[iint];
                    arr[iint] = tmp;
                }
    }
}