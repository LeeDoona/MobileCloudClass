package com.example.doona.mycall;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button bt1 = (Button) findViewById(R.id.button1);
        bt1.setText("바로전화걸기");
        Button bt2 = (Button) findViewById(R.id.button2);
        bt2.setText("다이얼로표시");

        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);

    }

    @Override
    public void onClick(View arg0) {
        // TODO Auto-generated method stub

        switch (arg0.getId()) {

            case R.id.button1:

                startActivity(new Intent("android.intent.action.CALL",
                        Uri.parse("tel:010-0000-0000")));
                break;

            case R.id.button2:

                startActivity(new Intent("android.intent.action.DIAL",
                        Uri.parse("tel:010-0000-0000")));

                break;
        }

    }
}
