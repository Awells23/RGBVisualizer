package com.example.rgbvisualizerlinear;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    calculator ch = new calculator();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialize seekbars
        SeekBar redSeek = (SeekBar)findViewById(R.id.redSeekBar);
        SeekBar blueSeek = (SeekBar)findViewById(R.id.blueSeekBar);
        SeekBar greenSeek = (SeekBar)findViewById(R.id.greenSeekBar);

        //Initalize changehandler and attach to each seek bar
        ChangeHandler tch = new ChangeHandler();
        redSeek.setOnSeekBarChangeListener(tch);
        greenSeek.setOnSeekBarChangeListener(tch);
        blueSeek.setOnSeekBarChangeListener(tch);
    }

    public class ChangeHandler implements SeekBar.OnSeekBarChangeListener {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            //Get value of seekbar and change text accordingly
            int id = seekBar.getId();

            if(id == R.id.redSeekBar){
               int redVal = seekBar.getProgress();
                TextView redText = (TextView)findViewById(R.id.redText);
                redText.setText(redVal + "");
                 ch.setRed(redVal);

            }
            //get value of seekbar and change text accordingly

            if(id == R.id.greenSeekBar){
                int greenVal = seekBar.getProgress();
                TextView greenText = (TextView)findViewById(R.id.greenText);
                greenText.setText(greenVal + "");
                ch.setGreen(greenVal);

            }

            if(id == R.id.blueSeekBar){
                int blueVal = seekBar.getProgress();
                TextView blueText = (TextView)findViewById(R.id.blueText);
                blueText.setText(blueVal + "");
                ch.setBlue(blueVal);
            }
            //get value and display in text box next to seekbar
            int redInt = ch.getRed();
            int blueInt = ch.getBlue();
            int greenInt = ch.getGreen();
            TextView colorText =(TextView)findViewById(R.id.colorBox);
            colorText.setBackgroundColor(Color.rgb(redInt,greenInt,blueInt));
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    }

}