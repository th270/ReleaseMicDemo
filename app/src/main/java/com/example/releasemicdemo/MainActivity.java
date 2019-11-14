package com.example.releasemicdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public Button mReleaseMic;
    public Button mUseMic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getButton();

        setListener();

    }

    private void setListener() {
        MyOnClick mOnClick = new MyOnClick();

        if (null != mReleaseMic)
        {
            mReleaseMic.setOnClickListener(mOnClick);
        }
        if (null != mUseMic)
        {
            mUseMic.setOnClickListener(mOnClick);
        }
    }

    private void getButton() {
        mReleaseMic = findViewById(R.id.releaseMic);
        mUseMic = findViewById(R.id.useMic);
    }

    class MyOnClick implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.releaseMic:
                    //释放MIC
                    Log.d("test", "---------------releaseMic---------------");
                    //rkaife_local.setPickup(false);
                    Intent closeMicIntent = new Intent("com.fenghuo.closemic");
                    sendBroadcast(closeMicIntent);
                    break;
                case R.id.useMic:
                    //占用MIC
                    Log.d("test", "----------------useMic---------------");
                    //rkaife_local.setPickup(false);
                    Intent openMicintent = new Intent("com.fenghuo.openmic");
                    sendBroadcast(openMicintent);
                    break;
                default:
                    break;
            }
        }
    }
}
