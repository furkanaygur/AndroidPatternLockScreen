package com.example.ekrankilit2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;
import android.widget.Toast;
import com.itsxtt.patternlock.PatternLockView;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity  {


  PatternLockView patternLockView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
               WindowManager.LayoutParams.FLAG_FULLSCREEN);
       getSupportActionBar().hide();


    patternLockView = (PatternLockView)findViewById(R.id.patternLockView);
    patternLockView.setOnPatternListener(new PatternLockView.OnPatternListener() {
        @Override
        public void onStarted() {


        }

        @Override
        public void onProgress(ArrayList<Integer> ids) {

        }

        @Override
        public boolean onComplete(ArrayList<Integer> ids) {

            return isCorrect(ids);

        }
        public boolean isCorrect(ArrayList<Integer> ids)
        {
            boolean Result = false;
            String InputPassword = "";
            for (int i = 0; i < ids.size(); i++) {
                InputPassword +=ids.get(i).toString();
            }
            String MyPassword = "5432";
            if(MyPassword.equals(InputPassword)){
                Result = true;
                Toast.makeText(MainActivity.this, "Başarılı", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getApplicationContext(),OpenActivity.class);
                startActivity(intent);

            }else{
                Toast.makeText(MainActivity.this, "HATA", Toast.LENGTH_SHORT).show();
            }
            return Result;
        }
    });

    }


}
