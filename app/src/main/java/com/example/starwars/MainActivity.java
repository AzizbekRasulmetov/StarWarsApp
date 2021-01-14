package com.example.starwars;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Map<String, String> questions = new HashMap<String, String>();
    private int questionN = 1;
    private TextView outcome;
    private TextView question;
    private TextView answer1;
    private TextView answer2;
    private TextView answer3;
    private EditText name;
    private Button btn;
    private SharedPreferences sharedPreferences;
    private static final String FILE_NAME = "myPrefs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        answer1 = (TextView) findViewById(R.id.answer1ID);
        answer2 = (TextView) findViewById(R.id.answer2ID);
        answer3 = (TextView) findViewById(R.id.answer3ID);
        question = (TextView) findViewById(R.id.questionID);
        outcome = (TextView) findViewById(R.id.outcomeID);
        name = (EditText) findViewById(R.id.editTextTextPersonName);
        btn = (Button) findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sharedPreferences = getSharedPreferences(FILE_NAME, 0);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("message", name.getText().toString());
                editor.commit();
            }
        });

        SharedPreferences prefs = getSharedPreferences(FILE_NAME, 0);
        if(prefs.contains("message")){
            String message = prefs.getString("message","not found");
            outcome.setText(message);
        }

        questions.put("Question1", "What is Kylo Ren's real name?");
        questions.put("Right1", "Ben Solo");
        questions.put("WrongA1", "Anakin Skywalker");
        questions.put("WrongB1", "Mr Cuddies");

        questions.put("Question2", "What color is Dark Maul's Light saber?");
        questions.put("Right2", "Red");
        questions.put("WrongA2", "Blue");
        questions.put("WrongB2", "Green");

        questions.put("Question3", "What is the subtitle of the Star Wars Episode: iV?");
        questions.put("Right3", "A New Hope");
        questions.put("WrongA3", "Return of the Jedi");
        questions.put("WrongB3", "Mr Puddle's Picnic");
        setQuestion();





    }

    private void setQuestion(){

        List currentAnswers = new ArrayList<String>(3);
        currentAnswers.add(questions.get("Right" + questionN));
        currentAnswers.add(questions.get("WrongA" + questionN));
        currentAnswers.add(questions.get("WrongB" + questionN));
        Collections.shuffle(currentAnswers);

        question.setText(questions.get("Question" + questionN));
        answer1.setText(currentAnswers.get(0).toString());
        answer2.setText(currentAnswers.get(1).toString());
        answer3.setText(currentAnswers.get(2).toString());

        if(answer1.getText() == questions.get("Right" + questionN)){
            answer1.setTag("Correct");
        }else{
            answer1.setTag("Incorrect");
        }

        if(answer2.getText() == questions.get("Right" + questionN)){
            answer2.setTag("Correct");
        }else{
            answer2.setTag("Incorrect");
        }

        if(answer3.getText() == questions.get("Right" + questionN)){
            answer3.setTag("Correct");
        }else{
            answer3.setTag("Incorrect");
        }
    }

    public void OnAnswer1Click(View v){
        if(v.getTag() == "Correct"){
            questionN++;
            if((questionN * 4) > questions.size()){
                outcome.setText("You Win!");
            }else{
                outcome.setText("Well Done!");
                setQuestion();
            }
        }else{
            outcome.setText("Try again!");
        }
    }

    public void OnAnswer2Click(View v){
        if(v.getTag() == "Correct"){
            questionN++;
            if((questionN * 4) > questions.size()){
                outcome.setText("You Win!");
            }else{
                outcome.setText("Well Done!");
                setQuestion();
            }
        }else{
            outcome.setText("Try again!");
        }
    }

    public void OnAnswer3Click(View v){
        if(v.getTag() == "Correct"){
            questionN++;
            if((questionN * 4) > questions.size()){
                outcome.setText("You Win!");
            }else{
                outcome.setText("Well Done!");
                setQuestion();
            }
        }else{
            outcome.setText("Try again!");
        }
    }
}

//Aziz was here to test pull changes
