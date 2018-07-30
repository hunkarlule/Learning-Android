package com.bignerdranch.android.geoquiz;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {
    private Button mTrueButton;
    private Button mFalseButton;
    private TextView mQuestionTextView;
    private Button mNextButton;
    private Question[] mQuestionBank = new Question[]{
            new Question(R.string.question_australia, true),
            new Question(R.string.question_oceans, true),
            new Question(R.string.question_mideast, false),
            new Question(R.string.question_africa, false),
            new Question(R.string.question_americas, true),
            new Question(R.string.question_asia, true)
    };

    private int mCurrentIndex = 0;
    private static final String TAG = "QuizActivity";
    private static final String KEY_INDEX = "index";
    private static final String ANSWERED_QUESTION_INDEX = "answered_question_index";
    private static final String COUNT_OF_TRUES = "count_of_true_answers";
    private static final String COUNT_OF_ANSWERED_QUESTIONS = "count_of_answered_questions";
    private static final String CHEATED_QUESTIONS = "cheated_questions";
    private int[] answeredQuestions = new int[6];
    private boolean[] cheatedQuestions = new boolean[6];
    private int countOfTrues = 0;
    private int countOfAnsweredQuestions = 0;
    private Button mCheatButton;
    private static final int REQUEST_CODE_CHEAT = 0;
   // private boolean mIsCheater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        Log.d(TAG, "onCreate(Bundle) called");
        if (savedInstanceState != null) {
            mCurrentIndex = savedInstanceState.getInt(KEY_INDEX, 0);
            answeredQuestions = savedInstanceState.getIntArray(ANSWERED_QUESTION_INDEX);
            countOfTrues = savedInstanceState.getInt(COUNT_OF_TRUES);
            countOfAnsweredQuestions = savedInstanceState.getInt(COUNT_OF_ANSWERED_QUESTIONS);
            cheatedQuestions = savedInstanceState.getBooleanArray(CHEATED_QUESTIONS);
            for(int i = 0; i < cheatedQuestions.length; i++)  {
                mQuestionBank[i].setQuestionCheated(cheatedQuestions[i]);
            }
        }
        mTrueButton = findViewById(R.id.true_button);
        mFalseButton = findViewById(R.id.false_button);
        mQuestionTextView = findViewById(R.id.question_text_view);
        mNextButton = findViewById(R.id.next_button);
        updateQuestion();

        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                System.out.println("true");
                checkAnswer(true);
            }
        });
        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("false");
                checkAnswer(false);
            }
        });
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("next");
                mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
                updateQuestion();
            }
        });

        mCheatButton = findViewById(R.id.cheat_button);
        mCheatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = CheatActivity.newIntent(QuizActivity.this, mQuestionBank[mCurrentIndex].isAnswerTrue());
                startActivityForResult(intent, REQUEST_CODE_CHEAT);
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart() called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause() called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop() called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume() called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy() called");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TAG, "onSaveInstanceState(Bundle) called");
        outState.putInt(KEY_INDEX, mCurrentIndex);
        outState.putIntArray(ANSWERED_QUESTION_INDEX, answeredQuestions);
        outState.putInt(COUNT_OF_ANSWERED_QUESTIONS, countOfAnsweredQuestions);
        outState.putInt(COUNT_OF_TRUES, countOfTrues);
        outState.putBooleanArray(CHEATED_QUESTIONS, cheatedQuestions);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode != Activity.RESULT_OK) {
            return;
        }
        if (requestCode == REQUEST_CODE_CHEAT) {
            if (data == null) {
                return;
            }
            mQuestionBank[mCurrentIndex].setQuestionCheated(CheatActivity.wasAnswerShown(data));
            cheatedQuestions[mCurrentIndex] = mQuestionBank[mCurrentIndex].isQuestionCheated();
        }
    }

    private void checkAnswer(boolean userPressedTrue) {
        boolean answerIsTrue = mQuestionBank[mCurrentIndex].isAnswerTrue();
        answeredQuestions[mCurrentIndex] = 1;
        mFalseButton.setEnabled(false);
        mTrueButton.setEnabled(false);
        countOfAnsweredQuestions++;
        int messageResId;
        if (mQuestionBank[mCurrentIndex].isQuestionCheated()) {
            messageResId = R.string.judgment_toast;
        } else {
            if (userPressedTrue == answerIsTrue) {
                messageResId = R.string.correct_toast;
                countOfTrues++;
            } else {
                messageResId = R.string.incorrect_toast;
            }
        }
        Toast.makeText(QuizActivity.this, messageResId, Toast.LENGTH_SHORT).show();
        showScore();
    }

    private void updateQuestion() {
        int question = mQuestionBank[mCurrentIndex].getTextResId();
        mQuestionTextView.setText(question);
        if (answeredQuestions[mCurrentIndex] == 0) {
            mTrueButton.setEnabled(true);
            mFalseButton.setEnabled(true);
        } else {
            mTrueButton.setEnabled(false);
            mFalseButton.setEnabled(false);
        }
    }

    private void showScore() {
        if (countOfAnsweredQuestions == mQuestionBank.length) {
            Toast.makeText(QuizActivity.this, "You anwered " + countOfTrues + " questions true.", Toast.LENGTH_SHORT).show();
        }
    }

}
