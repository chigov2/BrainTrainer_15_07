package techmarket.uno.braintrainer;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
    //1. прежде всего подготовить класс shared preferences
    private SharedPreferences pref;
    private TextView tvMain, tvRes, tvTemp;
    private final String saveKey = "saveKey";
    //2. Найти ActionBar
    private ActionBar actionBar;
    //3..
    private int number_1,number_2,number_false,number_res,number_index;
    private int max = 20;
    private int min = 1;
    private int max1 = 40;
    private int min1 = 10;
    private long startTime = 0;
    private long currentTime = 0;
    private float timeResult = 0;
    //переменная для правильных ответов
    private int true_answer = 0;
    private int max_true_answer = 5;
    private Boolean is_true_answer = false;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    private void init(){
        //1..
        pref = getSharedPreferences("Test",MODE_PRIVATE);
        tvMain = findViewById(R.id.tvMain);
        tvRes = findViewById(R.id.tvRes);
        tvTemp = findViewById(R.id.tvTemp);
        //2..
        actionBar = getSupportActionBar();
        //assert actionBar != null;//работает ли actionbar проверка
        //actionBar.setTitle("tesr");
        //5. Запуск счетчика времени
        startTime = System.currentTimeMillis();
        numbers();

    }

    //3. функция генерации случайных чисел
    private void numbers(){
        number_1 = (int) (Math.random() * (max-min));
        number_2 = (int) (Math.random() * (max-min));
        number_false = (int) (Math.random() * (max1-min1));
        number_index = (int) (Math.random() * (4-1));
        number_res = number_1 + number_2;
        //5. Обманочка
        String text;
        if (number_index == 2)
        {
            text = number_1 + " + " + number_2 + " = " + number_res;
            is_true_answer = true;
        }
        else
        {
            text = number_1 + " + " + number_2 + " = " + number_false;
            is_true_answer = false;
        }

        //4. проверка
        //tvMain.setText(String.valueOf(number_1));
        tvRes.setText(String.valueOf(number_index));
        tvMain.setText(text);

        if (true_answer >= max_true_answer){
            Intent i = new Intent(MainActivity.this,FinalActivity.class);
            i.putExtra("result_time",timeResult);
            startActivity(i);

        }
    }

    public void onClickTrue(View view)
    {
        if (is_true_answer)
        {
            true_answer = true_answer + 1;
            numbers();
            currentTime = System.currentTimeMillis();
            timeResult = (float)(currentTime - startTime)/1000;
            String timeBar = "time = " + timeResult;
            actionBar.setTitle(timeBar);
            //tvTemp.setText(String.valueOf(true_answer));
        }
        else//ошибка
        {
            numbers();
            currentTime = System.currentTimeMillis();
            timeResult = (float)(currentTime - startTime)/1000;
            String timeBar = "time = " + timeResult;
            actionBar.setTitle(timeBar);

        }
        tvTemp.setText(String.valueOf(true_answer));
    }

    public void onClickFalse(View view)
    {
        if (!is_true_answer)
        {
            true_answer = true_answer + 1;
            numbers();
            currentTime = System.currentTimeMillis();
            timeResult = (float)(currentTime - startTime)/1000;
            String timeBar = "time = " + timeResult;
            actionBar.setTitle(timeBar);
            //tvTemp.setText(String.valueOf(true_answer));
        }
        else//ошибка
            {
            numbers();
            currentTime = System.currentTimeMillis();
            timeResult = (float)(currentTime - startTime)/1000;
            String timeBar = "time = " + timeResult;
            actionBar.setTitle(timeBar);

            }
        tvTemp.setText(String.valueOf(true_answer));
    }


}