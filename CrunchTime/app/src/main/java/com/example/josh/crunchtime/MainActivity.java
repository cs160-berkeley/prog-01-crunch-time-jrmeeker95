package com.example.josh.crunchtime;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public Button pushup;
    public Button situp;
    public Button squats;
    public Button leglift;
    public Button plank;
    public Button jumping;
    public Button pullup;
    public Button cycling;
    public Button walking;
    public Button jogging;
    public Button swimming;
    public Button stair;
    public TextView calorie;
    public double weightRatio = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        calorie=(TextView)findViewById(R.id.calorie);
        pushup=(Button)findViewById(R.id.pushup);
        pushup.setText("Pushup");
        situp=(Button)findViewById(R.id.situp);
        situp.setText("Situp");
        squats=(Button)findViewById(R.id.squats);
        squats.setText("Squats");
        leglift=(Button)findViewById(R.id.leglift);
        leglift.setText("Leg-Lift");
        plank=(Button)findViewById(R.id.plank);
        plank.setText("Plank");
        jumping=(Button)findViewById(R.id.jumping);
        jumping.setText("Jumping Jack");
        pullup=(Button)findViewById(R.id.pullup);
        pullup.setText("Pullup");
        cycling=(Button)findViewById(R.id.cycling);
        cycling.setText("Cycling");
        walking=(Button)findViewById(R.id.walking);
        walking.setText("Walking");
        jogging=(Button)findViewById(R.id.jogging);
        jogging.setText("Jogging");
        swimming=(Button)findViewById(R.id.swimming);
        swimming.setText("Swimming");
        stair=(Button)findViewById(R.id.stair);
        stair.setText("Stair-Climbing");
    }

    public void reps(final View view) {
        View v = (LayoutInflater.from(MainActivity.this)).inflate(R.layout.reps, null);
        AlertDialog.Builder alertbuilder = new AlertDialog.Builder(MainActivity.this);
        alertbuilder.setView(v);
        final EditText input = (EditText)v.findViewById(R.id.editTextReps);
        alertbuilder.setCancelable(true)
        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                burnedCalories(Integer.parseInt(input.getText().toString())/calories(view.getId()));
            }
        });
        Dialog dialog = alertbuilder.create();
        dialog.show();
    }

    public void minutes(final View view) {
        View v = (LayoutInflater.from(MainActivity.this)).inflate(R.layout.minutes, null);
        AlertDialog.Builder alertbuilder = new AlertDialog.Builder(MainActivity.this);
        alertbuilder.setView(v);
        final EditText input = (EditText)v.findViewById(R.id.editTextMinutes);
        alertbuilder.setCancelable(true)
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        burnedCalories(Integer.parseInt(input.getText().toString()) / calories(view.getId()));
                    }
                });
        Dialog dialog = alertbuilder.create();
        dialog.show();
    }

    public void targetCalories(View view) {
        View v = (LayoutInflater.from(MainActivity.this)).inflate(R.layout.targetcalories, null);
        AlertDialog.Builder alertbuilder = new AlertDialog.Builder(MainActivity.this);
        alertbuilder.setView(v);
        final EditText input = (EditText)v.findViewById(R.id.editTextCalories);
        alertbuilder.setCancelable(true)
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        wantCalories(Integer.parseInt(input.getText().toString()));
                    }
                });
        Dialog dialog = alertbuilder.create();
        dialog.show();
    }

    public void weight(View view) {
        View v = (LayoutInflater.from(MainActivity.this)).inflate(R.layout.weight, null);
        AlertDialog.Builder alertbuilder = new AlertDialog.Builder(MainActivity.this);
        alertbuilder.setView(v);
        final EditText input = (EditText)v.findViewById(R.id.editTextWeight);
        alertbuilder.setCancelable(true)
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        weightRatio = Integer.parseInt(input.getText().toString())/150.00;
                        Toast.makeText(getApplicationContext(), "Tap an exercise to start", Toast.LENGTH_LONG).show();
                    }
                });
        Dialog dialog = alertbuilder.create();
        dialog.show();
    }

    public void wantCalories(double calories) {
        calorie.setText("You want to burn " + String.valueOf((int) calories) + " calories");
        converter(calories/weightRatio);
    }

    public void burnedCalories(double calories) {
        calorie.setText("You burned " + String.valueOf((int) (calories*weightRatio)) + " calories");
        converter(calories);
    }

    public void converter(double calories){
        pushup.setText(String.valueOf((int)(3.5 * calories)) + " Pushups");
        situp.setText(String.valueOf((int)(2 * calories)) + " Situps");
        squats.setText(String.valueOf((int)(2.25 * calories)) + " Squats");
        leglift.setText(String.valueOf((int)(.25 * calories)) + " Min. of Leg-Lifts");
        plank.setText(String.valueOf((int)(.25 * calories)) + " Min. of Planks");
        jumping.setText(String.valueOf((int)(.1 * calories)) + " Min. of Jumping Jacks");
        pullup.setText(String.valueOf((int)(1 * calories)) + " Pullups");
        cycling.setText(String.valueOf((int)(.12 * calories)) + " Min. of Cycling");
        walking.setText(String.valueOf((int)(.2 * calories)) + " Min. of Walking");
        jogging.setText(String.valueOf((int)(.12 * calories)) + " Min. of Jogging");
        swimming.setText(String.valueOf((int)(.13 * calories)) + " Min. of Swimming");
        stair.setText(String.valueOf((int)(.15 * calories)) + " Min. of Stairs");
    }

    public double calories(int v) {
        switch(v) {
            case R.id.pushup:
                return 3.5;
            case R.id.situp:
                return 2;
            case R.id.squats:
                return 2.25;
            case R.id.leglift:
                return .25;
            case R.id.plank:
                return .25;
            case R.id.jumping:
                return .1;
            case R.id.pullup:
                return 1;
            case R.id.cycling:
                return .12;
            case R.id.walking:
                return .2;
            case R.id.jogging:
                return .12;
            case R.id.swimming:
                return .13;
            case R.id.stair:
                return .15;
        }
        return 0;
    }
}

