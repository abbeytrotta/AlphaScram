package com.example.AlphaScram;

import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.Gravity;
import android.view.View;
import android.widget.*;

import java.util.ArrayList;
import java.util.Random;
import java.lang.StrictMath;

public class MyActivity extends Activity {

    private int score = 0;
    private int numWords = 0;
    private int longestWord = 0;
    private int appleCount = 0;
    private int starCount = 0;
    private static final int POINTS_PER_LETTER = 10;
    private static final int APPLE_MULTIPLIER = 2;
    private static final int STAR_MULTIPLIER = 3;
    private static final int PLAIN_TAG = 0;
    private static final int APPLE_TAG = 1;
    private static final int STAR_TAG = 2;
    private long startTime = 0;

    private static String letter1 = "";
    private static String letter2 = "";
    private static String letter3 = "";
    private static String letter4 = "";
    private static String letter5 = "";
    private static String letter6 = "";
    private static String letter7 = "";
    private static String letter8 = "";

    private static int multiplier1 = PLAIN_TAG;
    private static int multiplier2 = PLAIN_TAG;
    private static int multiplier3 = PLAIN_TAG;
    private static int multiplier4 = PLAIN_TAG;
    private static int multiplier5 = PLAIN_TAG;
    private static int multiplier6 = PLAIN_TAG;
    private static int multiplier7 = PLAIN_TAG;
    private static int multiplier8 = PLAIN_TAG;




//    private static final String [] EASTER_EGGS = new String[]{"ABBEY","SARAH","SARSARBEY"};
    private Chronometer chronometer;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashscreen);
    }

    public void showStatsScreen(View view) {
        setContentView(R.layout.statsscreen);
    }

    public void showGameScreen(View view) {
        setContentView(R.layout.game);
        chronometer = (Chronometer)findViewById(R.id.chronometer);
        chronometer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {
                if (SystemClock.elapsedRealtime() - chronometer.getBase() > 60000){
                    chronometer.stop();
                    setContentView(R.layout.statsscreen);
                    calculateStats();
                }else{
                    long time = chronometer.getBase() + 60000l - SystemClock.elapsedRealtime();
                    time /= 1000;
                    TextView timeLeft = (TextView)findViewById(R.id.txtTimeLeft);
                    timeLeft.setText(String.valueOf(time));
                }
            }
        });

        startGame();
    }

    private void startGame(){
        // Reset Score
        score = 0;
        longestWord = 0;
        numWords = 0;
        startTime = SystemClock.elapsedRealtime();

        // Reset Chronometer
        chronometer.setBase(SystemClock.elapsedRealtime());

        // Start Chronometer
        chronometer.start();

        // Start Round
        startRound();
    }

    private void startRound(){
        Random generator = new Random(SystemClock.elapsedRealtime());
        ArrayList<String> letterList;
        letterList = new ArrayList<String>();
        letterList.add("  B  ");
        letterList.add("  C  ");
        letterList.add("  D  ");
        letterList.add("  F  ");
        letterList.add("  G  ");
        letterList.add("  H  ");
        letterList.add("  J  ");
        letterList.add("  K  ");
        letterList.add("  L  ");
        letterList.add("  M  ");
        letterList.add("  N  ");
        letterList.add("  P  ");
        letterList.add("  Q  ");
        letterList.add("  R  ");
        letterList.add("  S  ");
        letterList.add("  T  ");
        letterList.add("  V  ");
        letterList.add("  W  ");
        letterList.add("  X  ");
        letterList.add("  Z  ");

        // Randomize Letters
        int index = StrictMath.abs(generator.nextInt() % letterList.size());
        multiplier1 = index % 3;
        ImageView imageView = (ImageView)findViewById(R.id.imgLetter1);
        TextView textView =  (TextView)findViewById(R.id.txtLetter1);
        FrameLayout frame = (FrameLayout)findViewById(R.id.frmLetter1);
        letter1 = letterList.remove(index);
        setupLetterButton(multiplier1,frame,imageView,textView,letter1);

        index = StrictMath.abs(generator.nextInt() % letterList.size());
        multiplier2 = index % 3;
        imageView = (ImageView)findViewById(R.id.imgLetter2);
        textView =  (TextView)findViewById(R.id.txtLetter2);
        frame = (FrameLayout)findViewById(R.id.frmLetter2);
        letter2 = letterList.remove(index);
        setupLetterButton(multiplier2,frame,imageView,textView,letter2);

        index = StrictMath.abs(generator.nextInt() % letterList.size());
        multiplier3 = index % 3;
        imageView = (ImageView)findViewById(R.id.imgLetter3);
        textView =  (TextView)findViewById(R.id.txtLetter3);
        frame = (FrameLayout)findViewById(R.id.frmLetter3);
        letter3 = letterList.remove(index);
        setupLetterButton(multiplier3,frame,imageView,textView,letter3);

        index = StrictMath.abs(generator.nextInt() % letterList.size());
        multiplier4 = index % 3;
        imageView = (ImageView)findViewById(R.id.imgLetter4);
        textView =  (TextView)findViewById(R.id.txtLetter4);
        frame = (FrameLayout)findViewById(R.id.frmLetter4);
        letter4 = letterList.remove(index);
        setupLetterButton(multiplier4,frame,imageView,textView,letter4);

        index = StrictMath.abs(generator.nextInt() % letterList.size());
        multiplier5 = index % 3;
        imageView = (ImageView)findViewById(R.id.imgLetter5);
        textView =  (TextView)findViewById(R.id.txtLetter5);
        frame = (FrameLayout)findViewById(R.id.frmLetter5);
        letter5 = letterList.remove(index);
        setupLetterButton(multiplier5,frame,imageView,textView,letter5);

        index = StrictMath.abs(generator.nextInt() % letterList.size());
        multiplier6 = index % 3;
        imageView = (ImageView)findViewById(R.id.imgLetter6);
        textView =  (TextView)findViewById(R.id.txtLetter6);
        frame = (FrameLayout)findViewById(R.id.frmLetter6);
        letter6 = letterList.remove(index);
        setupLetterButton(multiplier6,frame,imageView,textView,letter6);

        index = StrictMath.abs(generator.nextInt() % letterList.size());
        multiplier7 = index % 3;
        imageView = (ImageView)findViewById(R.id.imgLetter7);
        textView =  (TextView)findViewById(R.id.txtLetter7);
        frame = (FrameLayout)findViewById(R.id.frmLetter7);
        letter7 = letterList.remove(index);
        setupLetterButton(multiplier7,frame,imageView,textView,letter7);

        index = StrictMath.abs(generator.nextInt() % letterList.size());
        multiplier8 = index % 3;
        imageView = (ImageView)findViewById(R.id.imgLetter8);
        textView =  (TextView)findViewById(R.id.txtLetter8);
        frame = (FrameLayout)findViewById(R.id.frmLetter8);
        letter8 = letterList.remove(index);
        setupLetterButton(multiplier8,frame,imageView,textView,letter8);


        // Clear word
        ((TextView)findViewById(R.id.textWord)).setText("");

    }

    public void showSplashScreen(View view) {
        setContentView(R.layout.splashscreen);
    }

    public void showDirectionScreen(View view) {
        setContentView(R.layout.howtoplay);
    }

    // They clicked enter, check for new score
    public void onEnter(View view){
        TextView wordText = (TextView)findViewById(R.id.textWord);
        String word = String.valueOf(wordText.getText());

        // not null, and in dictionary score word
        DictionaryDataSource dict = new DictionaryDataSource(getApplicationContext());
        if(word != null && dict.inDictionary(word)){
            int wordScore = word.length() * POINTS_PER_LETTER;

            if(appleCount!=0){
                wordScore *= appleCount * APPLE_MULTIPLIER;
            }
            if(starCount != 0){
                wordScore *= starCount * STAR_MULTIPLIER;
            }
            if(word.length() > longestWord){
                longestWord = word.length();
            }
            numWords++;
            score += wordScore;
            TextView points = (TextView)findViewById(R.id.score);
            points.setText(String.valueOf(score));
        }
        startRound();
    }

    public void onLetterClick1(View view){
        TextView wordText = (TextView)findViewById(R.id.textWord);
        StringBuilder wordBuilder = new StringBuilder(wordText.getText());
        if(view instanceof FrameLayout){
            FrameLayout letterButton = (FrameLayout)view;
            wordBuilder.append(letter1.trim());
            wordText.setText(wordBuilder.toString());
            if(multiplier1 == APPLE_TAG) {
                appleCount++;
            } else if (multiplier1 == STAR_TAG){
                starCount++;
            }
        }
    }
    public void onLetterClick2(View view){
        TextView wordText = (TextView)findViewById(R.id.textWord);
        StringBuilder wordBuilder = new StringBuilder(wordText.getText());
        if(view instanceof FrameLayout){
            FrameLayout letterButton = (FrameLayout)view;
            wordBuilder.append(letter2.trim());
            wordText.setText(wordBuilder.toString());
            if(multiplier2 == APPLE_TAG) {
                appleCount++;
            } else if (multiplier2 == STAR_TAG){
                starCount++;
            }
        }
    }
    public void onLetterClick3(View view){
        TextView wordText = (TextView)findViewById(R.id.textWord);
        StringBuilder wordBuilder = new StringBuilder(wordText.getText());
        if(view instanceof FrameLayout){
            FrameLayout letterButton = (FrameLayout)view;
            wordBuilder.append(letter3.trim());
            wordText.setText(wordBuilder.toString());
            if(multiplier3 == APPLE_TAG) {
                appleCount++;
            } else if (multiplier3 == STAR_TAG){
                starCount++;
            }
        }
    }
    public void onLetterClick4(View view){
        TextView wordText = (TextView)findViewById(R.id.textWord);
        StringBuilder wordBuilder = new StringBuilder(wordText.getText());
        if(view instanceof FrameLayout){
            FrameLayout letterButton = (FrameLayout)view;
            wordBuilder.append(letter4.trim());
            wordText.setText(wordBuilder.toString());
            if(multiplier4 == APPLE_TAG) {
                appleCount++;
            } else if (multiplier4 == STAR_TAG){
                starCount++;
            }
        }
    }
    public void onLetterClick5(View view){
        TextView wordText = (TextView)findViewById(R.id.textWord);
        StringBuilder wordBuilder = new StringBuilder(wordText.getText());
        if(view instanceof FrameLayout){
            FrameLayout letterButton = (FrameLayout)view;
            wordBuilder.append(letter5.trim());
            wordText.setText(wordBuilder.toString());
            if(multiplier5 == APPLE_TAG) {
                appleCount++;
            } else if (multiplier5 == STAR_TAG){
                starCount++;
            }
        }
    }
    public void onLetterClick6(View view){
        TextView wordText = (TextView)findViewById(R.id.textWord);
        StringBuilder wordBuilder = new StringBuilder(wordText.getText());
        if(view instanceof FrameLayout){
            FrameLayout letterButton = (FrameLayout)view;
            wordBuilder.append(letter6.trim());
            wordText.setText(wordBuilder.toString());
            if(multiplier6 == APPLE_TAG) {
                appleCount++;
            } else if (multiplier6 == STAR_TAG){
                starCount++;
            }
        }
    }
    public void onLetterClick7(View view){
        TextView wordText = (TextView)findViewById(R.id.textWord);
        StringBuilder wordBuilder = new StringBuilder(wordText.getText());
        if(view instanceof FrameLayout){
            FrameLayout letterButton = (FrameLayout)view;
            wordBuilder.append(letter7.trim());
            wordText.setText(wordBuilder.toString());
            if(multiplier7 == APPLE_TAG) {
                appleCount++;
            } else if (multiplier7 == STAR_TAG){
                starCount++;
            }
        }
    }
    public void onLetterClick8(View view){
        TextView wordText = (TextView)findViewById(R.id.textWord);
        StringBuilder wordBuilder = new StringBuilder(wordText.getText());
        if(view instanceof FrameLayout){
            FrameLayout letterButton = (FrameLayout)view;
            wordBuilder.append(letter8.trim());
            wordText.setText(wordBuilder.toString());
            if(multiplier8 == APPLE_TAG) {
                appleCount++;
            } else if (multiplier8 == STAR_TAG){
                starCount++;
            }
        }
    }
    public void onLetterClickA(View view){
        TextView wordText = (TextView)findViewById(R.id.textWord);
        StringBuilder wordBuilder = new StringBuilder(wordText.getText());
        wordBuilder.append("A");
        wordText.setText(wordBuilder.toString());
    }
    public void onLetterClickE(View view){
        TextView wordText = (TextView)findViewById(R.id.textWord);
        StringBuilder wordBuilder = new StringBuilder(wordText.getText());
        wordBuilder.append("E");
        wordText.setText(wordBuilder.toString());
    }
    public void onLetterClickI(View view){
        TextView wordText = (TextView)findViewById(R.id.textWord);
        StringBuilder wordBuilder = new StringBuilder(wordText.getText());
        wordBuilder.append("I");
        wordText.setText(wordBuilder.toString());
    }
    public void onLetterClickO(View view){
        TextView wordText = (TextView)findViewById(R.id.textWord);
        StringBuilder wordBuilder = new StringBuilder(wordText.getText());
        wordBuilder.append("O");
        wordText.setText(wordBuilder.toString());
    }
    public void onLetterClickU(View view){
        TextView wordText = (TextView)findViewById(R.id.textWord);
        StringBuilder wordBuilder = new StringBuilder(wordText.getText());
        wordBuilder.append("U");
        wordText.setText(wordBuilder.toString());
    }

    private void calculateStats(){
        TextView lastScore = (TextView)findViewById(R.id.lastScore);
        lastScore.setText(String.valueOf(score));
        TextView wordsCreated = (TextView)findViewById(R.id.numWords);
        wordsCreated.setText(String.valueOf(numWords));
        TextView longest = (TextView)findViewById(R.id.longestWord);
        longest.setText(String.valueOf(longestWord));
    }

/*    public boolean inDictionary(String word){
        return true;
    } */

    private void setupLetterButton(int multiplier, FrameLayout layout, ImageView imageView, TextView textView, String letter){

        if(multiplier == STAR_TAG){
            // Change background
            imageView.setBackgroundResource(R.drawable.button_empty_big_s);
            textView.setGravity(Gravity.CENTER_VERTICAL);

        } else if (multiplier == APPLE_TAG)  {
            // Change background
            imageView.setBackgroundResource(R.drawable.button_empty_big_a);
            textView.setGravity(Gravity.CENTER_VERTICAL);

        } else {
            // change back to plain background
            imageView.setBackgroundResource(R.drawable.button_empty_big);
            textView.setGravity(Gravity.CENTER);
        }

        // set letter
        textView.setText(letter);

    }

}
