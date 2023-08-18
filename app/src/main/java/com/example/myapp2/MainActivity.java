package com.example.myapp2;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class MainActivity extends AppCompatActivity {
    private ImageButton imageButton;
    private CardView cardView;
    private TextView textView;
    private String[] user = {"I am a", "Female", "male"};
    private String[] phone = {"(US+) 1", "(OM+) 968", "(SAU) 966"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageButton = findViewById(R.id.bu1);
        textView = findViewById(R.id.te4);
        cardView = findViewById(R.id.te1);

        Spinner spinner = findViewById(R.id.spinner);
        Spinner spinner1 = findViewById(R.id.spinner2);


        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, user);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,phone);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);
        spinner1.setAdapter(adapter1);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedUserName = user[position];
                Toast.makeText(MainActivity.this, "Selected User: " + selectedUserName, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedPhoneNum = phone[position];
                Toast.makeText(MainActivity.this, "Selected Phone: " + selectedPhoneNum, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        EditText editText = findViewById(R.id.text1);
        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    animateViewsLift();
                    animateCardViewUp();
                } else {
                    animateViewsRight();
                    animateCardViewDown();
                }
            }
        });
    }

    private void animateViewsLift() {
        Animation animation = new TranslateAnimation(0, -imageButton.getWidth() - textView.getWidth(), 0, 0);
        animation.setDuration(300);
        imageButton.startAnimation(animation);
        textView.startAnimation(animation);
        imageButton.setVisibility(View.INVISIBLE);
        textView.setVisibility(View.INVISIBLE);
    }

    private void animateViewsRight() {
        Animation animation = new TranslateAnimation(0, -imageButton.getWidth() / 2, 0, 0);
        animation.setDuration(300);
        imageButton.startAnimation(animation);
        textView.startAnimation(animation);
        imageButton.setVisibility(View.VISIBLE);
        textView.setVisibility(View.VISIBLE);
    }
    private void animateCardViewUp() {
        Animation animation = new TranslateAnimation(-imageButton.getWidth() / 2, 0, 0, 0);
        animation.setDuration(300);
        cardView.startAnimation(animation);
    }
    private void animateCardViewDown() {
        Animation animation = new TranslateAnimation(0, 0, -cardView.getHeight(), 0);
        animation.setDuration(300);
        cardView.startAnimation(animation);
    }
}