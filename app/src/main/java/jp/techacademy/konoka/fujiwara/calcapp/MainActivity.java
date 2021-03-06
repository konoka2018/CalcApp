package jp.techacademy.konoka.fujiwara.calcapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // ①メンバ変数を定義
    EditText mEditText1;
    EditText mEditText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);

        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(this);

        Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(this);

        Button button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        mEditText1 = (EditText) findViewById(R.id.editText1); //エディットのIDを取得して変数に入れる
        String tmp1 = mEditText1.getText().toString(); //EditTextコントロールから値を文字列形式で取得

        double value1;
        value1 =  0.0;

        try {
            if (tmp1.length() > 0) {
                value1 = Double.parseDouble(tmp1);//EditTextコントロールから取得した文字列を数値に変換
            } else {
                Snackbar.make(v, "未入力です。数値を入力してください。", Snackbar.LENGTH_SHORT)
                        .setAction("Action", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Log.d("UI-PARTS", "Snack barをタップした");
                            }
                        }).show();return;
            }
        }catch (NumberFormatException e) {
            Snackbar.make(v, "数値を入力してください。", Snackbar.LENGTH_SHORT)
                    .setAction("Action", new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Log.d("UI-PARTS", "Snack barをタップした");
                        }
                    }).show();return;
        }


        mEditText2 = (EditText) findViewById(R.id.editText2); //エディットのIDを取得して変数に入れる
        String tmp2 = mEditText2.getText().toString(); //EditTextコントロールから値を文字列形式で取得

        double value2;
        value2 =  0.0;

        try {
            if (tmp2.length() > 0) {
                value2 = Double.parseDouble(tmp2);//EditTextコントロールから取得した文字列を数値に変換

            } else{
                Snackbar.make(v, "未入力です。数値を入力してください。", Snackbar.LENGTH_SHORT)
                        .setAction("Action", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Log.d("UI-PARTS", "Snack barをタップした");
                            }
                        }).show();return;
            }
        } catch (NumberFormatException e) {
            Snackbar.make(v, "数値を入力してください。", Snackbar.LENGTH_SHORT)
                    .setAction("Action", new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Log.d("UI-PARTS", "Snack barをタップした");
                        }
                    }).show();return;
        }


        double result = 0;
        switch (v.getId()) {
            case R.id.button1:
                result = value1 + value2;
                break;

            case R.id.button2:
                result = value1 - value2;
                break;

            case R.id.button3:
                result = value1 * value2;

                break;

            case R.id.button4:
                if(value2 == 0){
                    Snackbar.make(v, "0は入力できません。", Snackbar.LENGTH_SHORT)
                            .setAction("Action", new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Log.d("UI-PARTS", "Snack barをタップした");
                                }
                            }).show();return;
                }else {
                    result = value1 / value2;
                }
                break;
            default:
                break;
        }

        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("RESULT", result);
        startActivity(intent);
    }
}