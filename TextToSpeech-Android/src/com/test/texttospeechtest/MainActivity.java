package com.test.texttospeechtest;

import java.util.Locale;

import android.os.Bundle;
import android.app.Activity;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends Activity implements TextToSpeech.OnInitListener {
	
	private TextToSpeech tts;
    	private ImageButton btnSpeak;
    	private TextView txtText;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		tts = new TextToSpeech(this, this);
		btnSpeak = (ImageButton) findViewById(R.id.btnSpeak);
		 
        	txtText= (TextView) findViewById(R.id.hello_world);
		// button on click event
        	btnSpeak.setOnClickListener(new View.OnClickListener() {
 
            		@Override
           		public void onClick(View arg0) {
                		speakOut();
            		}
 
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	 @Override
    public void onDestroy() {
        // Don't forget to shutdown tts!
        if (tts != null) {
            tts.stop();
            tts.shutdown();
        }
        super.onDestroy();
    }
	 
	 @Override
    public void onInit(int status) {
 
        if (status == TextToSpeech.SUCCESS) {
 
            int result = tts.setLanguage(Locale.UK);
 
            if (result == TextToSpeech.LANG_MISSING_DATA
                    || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.e("TTS", "This Language is not supported");
            }
 
        } else {
            Log.e("TTS", "Initilization Failed!");
        }
 
    }
	 
	 private void speakOut() {
		 
        String text = txtText.getText().toString();
 
        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
    }
 
}
