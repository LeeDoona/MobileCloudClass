package pushpushbaby.kakao.com.pushapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Scene;

import com.unity3d.player.UnityPlayer;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //call from native
        UnityPlayer.UnitySendMessage("Main Camera", "CallFromNative", "MainActivity");
    }
}
