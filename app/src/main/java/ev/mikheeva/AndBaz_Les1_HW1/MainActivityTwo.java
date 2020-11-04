package ev.mikheeva.AndBaz_Les1_HW1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivityTwo extends AppCompatActivity implements Constante {
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_two);

        Parsel parsel = (Parsel) getIntent().getExtras().getSerializable(TEXT);
        TextView textView = findViewById(R.id.textView);
        textView.setText(parsel.cityName);
        if (getIntent().getExtras().getSerializable(WIND) != null) {
            TextView textView16 = findViewById(R.id.textView16);
            TextView textView19 = findViewById(R.id.textView19);
            textView16.setText(parsel.wind);
            textView16.setVisibility(View.VISIBLE);
            if (textView16.getText().toString().equals(parsel.wind)) {
                textView19.setText(R.string.windS);
                textView19.setVisibility(View.VISIBLE);
            }
            if (getIntent().getExtras().getSerializable(HUMIDITY) != null) {
                TextView textView17 = findViewById(R.id.textView17);
                TextView textView20 = findViewById(R.id.textView20);
                textView17.setText(parsel.humidity);
                textView17.setVisibility(View.VISIBLE);
                if (textView17.getText().toString().equals(parsel.humidity)) {
                    textView20.setText(R.string.humidityS);
                    textView20.setVisibility(View.VISIBLE);
                }
            }
            if (getIntent().getExtras().getSerializable(PRESSURE) != null) {
                TextView textView18 = findViewById(R.id.textView18);
                TextView textView21 = findViewById(R.id.textView21);
                textView18.setText(parsel.pressure);
                textView18.setVisibility(View.VISIBLE);
                if (textView18.getText().toString().equals(parsel.pressure)) {
                    textView21.setText(R.string.pressureS);
                    textView21.setVisibility(View.VISIBLE);
                }
            }

            TextView textView14 = findViewById(R.id.textView14);
            TextView textView15 = findViewById(R.id.textView15);
            TextView textView18 = findViewById(R.id.textView18);
            ImageView imageView = findViewById(R.id.imageView2);
            button = findViewById(R.id.button2);
            button.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    finish();
                }
            });
        }
    }
}