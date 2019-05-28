package com.foxminded.anagrams;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
    private StringProcessor stringProcessor = new StringProcessor();
    private String dataFromUser = "";
    private String inputString = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(savedInstanceState != null) {
            dataFromUser = savedInstanceState.getString("charactersEntered");
            inputString = savedInstanceState.getString("inputString");
            EditText entryField = (EditText) findViewById(R.id.userInput);
            entryField.setText(inputString);
        }
        passValues();
    }

    public void getAnagram(View view){
        EditText entryField = (EditText) findViewById(R.id.userInput);
        String charactersEntered = entryField.getText().toString();
        dataFromUser = charactersEntered;
        passValues();
        entryField.setText("");
    }

    private void passValues(){
        TextView typedText = (TextView) findViewById(R.id.characters_entered);
        TextView processingResult = (TextView) findViewById(R.id.processed_text);
        typedText.setText(dataFromUser);
        processingResult.setText(stringProcessor.getAnagram(dataFromUser));
    }

    @Override
    public void onSaveInstanceState (Bundle savedInstanceState){
        EditText entryField = (EditText) findViewById(R.id.userInput);
        inputString = entryField.getText().toString();
        savedInstanceState.putString("charactersEntered", dataFromUser);
        savedInstanceState.putString("inputString", inputString);
    }
}
