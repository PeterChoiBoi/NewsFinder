package com.example.news;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
    }

    public void GoToFoodList (View view) {
        Intent gotofoodlist = new Intent(this,
                NewsActivity.class);
        EditText user_input = (EditText) findViewById(R.id.user_input_ingredient);
        String user_input_ingredient = String.valueOf(user_input.getText());
        gotofoodlist.putExtra("user_input", user_input_ingredient);
        startActivity(gotofoodlist);
    }
}