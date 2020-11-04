package ev.mikheeva.AndBaz_Les1_HW1;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;


public class MainActivity3 extends AppCompatActivity {
    private RadioButton radioButton;
    private RadioButton radioButton1;
    private ConstraintLayout cBackground;
    private TextView textView;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        textView = findViewById(R.id.textView5);
        ImageView imageView = findViewById(R.id.imageView);
        radioButton = findViewById(R.id.radioButton);
        radioButton1 = findViewById(R.id.radioButton2);
        cBackground = findViewById(R.id.ConL);
        button = findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
        public void BG(View view) {
            switch (view.getId()) {
                case R.id.radioButton:
                    cBackground.setBackgroundResource(R.color.color_background_setting1);
                    textView.setTextColor(Color.parseColor("#000000"));
                    break;
                case R.id.radioButton2:
                    cBackground.setBackgroundResource(R.color.color_background_setting2);
                    textView.setTextColor(Color.parseColor("#FFFFFF"));
                    break;
            }
        }


    }
