package jp.techacademy.konoka.fujiwara.calcapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        double result = intent.getDoubleExtra("RESULT" ,0);

        mTextView = (TextView) findViewById(R.id.textView1);
        mTextView.setText(String.valueOf(result));
    }
}

