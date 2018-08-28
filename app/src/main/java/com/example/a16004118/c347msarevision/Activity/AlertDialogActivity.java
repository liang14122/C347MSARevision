package com.example.a16004118.c347msarevision.Activity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.example.a16004118.c347msarevision.Adapter.QuizAdapter;
import com.example.a16004118.c347msarevision.Object.Quiz;
import com.example.a16004118.c347msarevision.R;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class AlertDialogActivity extends AppCompatActivity
        implements View.OnClickListener{

    private Button btnNormal, btnList, btnPassPhrase, btnCustomise;
    private ArrayList<Quiz> quizList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog);

        btnNormal = findViewById(R.id.btnNormal);
        btnList = findViewById(R.id.btnList);
        btnPassPhrase = findViewById(R.id.btnPassPhrase);
        btnCustomise = findViewById(R.id.btnCustomise);

        btnList.setOnClickListener(this);
        btnPassPhrase.setOnClickListener(this);
        btnCustomise.setOnClickListener(this);
        btnNormal.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.btnNormal:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Are you sure?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(AlertDialogActivity.this, "You clicked Yes", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(AlertDialogActivity.this, "You clicked No", Toast.LENGTH_SHORT).show();
                            }
                        });

                AlertDialog alertDialog = builder.create();
                alertDialog.show();

                break;

            case R.id.btnList:
                String[] list = new String[]{"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
                AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
                builder1.setTitle("Which is your freest weekday?")
                        .setItems(list, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if (which == 0){
                                    Toast.makeText(AlertDialogActivity.this, "You said Monday", Toast.LENGTH_SHORT).show();
                                }else if (which == 4){
                                    Toast.makeText(AlertDialogActivity.this, "You said Friday", Toast.LENGTH_SHORT).show();
                                }else{
                                    Toast.makeText(AlertDialogActivity.this, "You said middle of the week", Toast.LENGTH_SHORT).show();
                                }

                            }
                        });

                AlertDialog alertDialog1 = builder1.create();
                alertDialog1.show();
                break;

            case R.id.btnPassPhrase:

                LayoutInflater inflater =
                        (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                assert inflater != null;
                @SuppressLint("InflateParams") LinearLayout passPhrase =
                        (LinearLayout) inflater.inflate(R.layout.passphrase, null);
                final EditText etPassphrase = passPhrase.findViewById(R.id.editTextPassPhrase);
                AlertDialog.Builder builder2 = new AlertDialog.Builder(this);
                builder2.setTitle("Please Enter")
                        .setView(passPhrase)
                        .setPositiveButton("Done", new DialogInterface
                                .OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(AlertDialogActivity.this, "You had entered " +
                                        etPassphrase.getText().toString(), Toast.LENGTH_LONG).show();
                            }
                        });

                AlertDialog alertDialog2 = builder2.create();
                alertDialog2.show();

                break;

            case R.id.btnCustomise:
                LayoutInflater inflaterQuiz =
                        (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                assert inflaterQuiz != null;
                @SuppressLint("InflateParams") ConstraintLayout quiz =
                        (ConstraintLayout) inflaterQuiz.inflate(R.layout.quiz, null);

                ListView lvQuiz = quiz.findViewById(R.id.lvQuiz);

                quizList = new ArrayList<>();
                quizList.add(new Quiz("Singapore NationalDay did on 8 Sept"));
                quizList.add(new Quiz("Singapore is 53 yrs old"));
                quizList.add(new Quiz("National Day theme is 'We Are Singapore'"));

                QuizAdapter quizAdapter = new QuizAdapter(AlertDialogActivity.this, R.layout.quiz_row, quizList);

                lvQuiz.setAdapter(quizAdapter);

                AlertDialog.Builder builderQuiz = new AlertDialog.Builder(this);
                builderQuiz.setTitle("Test Yourself!")
                        .setView(quiz)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                int score = 0;

                                for (int i = 0; i < quizList.size(); i++) {
                                    Quiz currentQuiz = quizList.get(i);
                                    if (i == 0 && !currentQuiz.isAnswer()) {
                                        score++;
                                    } else if (i != 0 && currentQuiz.isAnswer()) {
                                        score++;
                                    }
                                }
                                Toast.makeText(AlertDialogActivity.this, "Your Score is " + score, Toast.LENGTH_SHORT).show();
                                quizList.clear();
                            }
                        })
                        .setNegativeButton("Don't Know lah", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                quizList.clear();

                            }
                        });

                AlertDialog alertDialogQuiz = builderQuiz.create();
                alertDialogQuiz.show();
                break;

            default:
                break;
        }
    }
}
