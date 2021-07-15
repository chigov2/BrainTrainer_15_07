package techmarket.uno.braintrainer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

public class StartActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_layout);// без этой строки - пустой экран; нечего показывать

    }

    public void onClickStart1(View view) {
        Intent i = new Intent(StartActivity.this,MainActivity.class);
        startActivity(i);
    }
}
