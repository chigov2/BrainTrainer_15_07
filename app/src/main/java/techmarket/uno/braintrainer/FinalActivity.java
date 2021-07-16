package techmarket.uno.braintrainer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class FinalActivity extends Activity {
    private TextView tvTitle, tvResult, tvBestResult, tvChamp;
    private float finalTime = 0;
    private  float bestResult = 10;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.final_layout);
        tvTitle = findViewById(R.id.tvTitle);
        tvResult = findViewById(R.id.tvResult);
        tvBestResult = findViewById(R.id.tvBestResult);
        tvChamp = findViewById(R.id.tvChamp);
        //2. необходимо создать функцию, которая будет получать результат и лучший результат
        setResult();
    }

    public void onClickBack(View view)
    {
        Intent i = new Intent(FinalActivity.this,StartActivity.class);
        startActivity(i);
    }

    //2..
    private void setResult()
    {
        //3. подготовить код в MainActivity ....  if (true_answer >= max_true_answer){
        Intent intent_final = getIntent();
        if (intent_final != null)
        {
            finalTime = intent_final.getFloatExtra("result_time",0);
            tvResult.setText(String.valueOf(finalTime));
            if(finalTime < bestResult)
            {
                tvChamp.setText(String.valueOf(finalTime));
                bestResult = finalTime;
            }
            else
            {
                tvChamp.setText(String.valueOf(bestResult));
            }

        }
    }
}
