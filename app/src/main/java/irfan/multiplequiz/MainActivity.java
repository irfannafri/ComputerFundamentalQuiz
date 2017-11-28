package irfan.multiplequiz;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;


public class MainActivity extends AppCompatActivity {
    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    Button pindahHalaman;
    // Question 1
    RadioButton question1_choice3;
    // Question 2
    EditText question2_answer;
    // Question 3
    CheckBox question3_choice1;
    CheckBox question2_choice2;
    CheckBox question3_choice3;
    CheckBox question3_choice4;
    // Question 4
    EditText question4_answer;
    // Question 5
    RadioButton question5_choice2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Hide the keyboard
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        setContentView(R.layout.activity_main);

        // Question 1
        question1_choice3 = (RadioButton) this.findViewById(R.id.question1_choice3);
        // Question 2
        question2_answer = (EditText) this.findViewById(R.id.question2_answer);
        // Question 3
        question3_choice1 = (CheckBox) this.findViewById(R.id.question3_choice1);
        question2_choice2 = (CheckBox) this.findViewById(R.id.question3_choice2);
        question3_choice3 = (CheckBox) this.findViewById(R.id.question3_choice3);
        question3_choice4 = (CheckBox) this.findViewById(R.id.question3_choice4);
        // Question 4
        question4_answer = (EditText) this.findViewById(R.id.question4_answer);
        // Question 5
        question5_choice2 = (RadioButton) this.findViewById(R.id.question5_choice2);

        pindahHalaman = (Button) findViewById(R.id.btnpindah);
        pindahHalaman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Main2Activity.class);

                //------------------------------------------------------------------------------------------
                // Question 1 - Correct Answer is #3 (PASCAL)
                //------------------------------------------------------------------------------------------
                Boolean answer1;
                answer1 = question1_choice3.isChecked();
                int answer1_score;
                if (answer1) {
                    answer1_score = 1;
                } else {
                    answer1_score = 0;
                }

                //------------------------------------------------------------------------------------------
                // Question 2 - Correct Answer is "PROLOG"
                //------------------------------------------------------------------------------------------
                String answer2;

                answer2 = question2_answer.getText().toString().toLowerCase();
                int answer2_score;
                if (answer2.equals("prolog")) {
                    answer2_score = 1;
                } else {
                    answer2_score = 0;
                }

                //------------------------------------------------------------------------------------------
                // Question 3  - Correct Answers are #1 (ALU) and #3 (CU)
                //------------------------------------------------------------------------------------------
                Boolean answer3_choice1;
                Boolean answer3_choice2;
                Boolean answer3_choice3;
                Boolean answer3_choice4;

                answer3_choice1 = question3_choice1.isChecked();
                answer3_choice2 = question2_choice2.isChecked();
                answer3_choice3 = question3_choice3.isChecked();
                answer3_choice4 = question3_choice4.isChecked();
                int answer3_score;
                if (answer3_choice1 && !answer3_choice2 && answer3_choice3 && !answer3_choice4) {
                    answer3_score = 1;
                } else {
                    answer3_score = 0;
                }

                //------------------------------------------------------------------------------------------
                // Question 4 - Correct Answer is "Cylinder"
                //------------------------------------------------------------------------------------------
                String answer4;
                answer4 = question4_answer.getText().toString().toLowerCase();
                int answer4_score;
                if (answer4.equals("cylinder")) {
                    answer4_score = 1;
                } else {
                    answer4_score = 0;
                }
                //------------------------------------------------------------------------------------------
                // Question 5  - Correct Answers is #2 "Technological advancement"
                //------------------------------------------------------------------------------------------
                Boolean answer5;

                answer5 = question5_choice2.isChecked();
                int answer5_score;
                if (answer5) {
                    answer5_score = 1;
                } else {
                    answer5_score = 0;
                }

                i.putExtra("Hasil1", answer1_score);
                i.putExtra("Hasil2", answer2_score);
                i.putExtra("Hasil3", answer3_score);
                i.putExtra("Hasil4", answer4_score);
                i.putExtra("Hasil5", answer5_score);

                startActivity(i);

            }
        });
    }


}

