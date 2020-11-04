package ev.mikheeva.AndBaz_Les1_HW1;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements Constante {
    private final static int REQUEST_CODE = 101;
    private  EditText cityName;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Menu menu_main;
        TextView editText = findViewById(R.id.editTextTime);
        TextView editTextdata = findViewById(R.id.editTextDate);
        Button button = findViewById(R.id.button);
        final Button btn = findViewById(R.id.button4);
        cityName = findViewById(R.id.editTextTextPersonName);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Parsel parsel = new Parsel();
                switch (cityName.getText().toString()){
                    case "Moscow":
                        String str = "https://www.tripzaza.com/ru/destinations/luchshie-dostoprimechatelnosti-moskvyi/";
                        Uri uri = Uri.parse(str);
                        Intent browser = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(browser);
                        break;
                    case "Snt. Petersburg":
                        str = "https://www.tripzaza.com/ru/destinations/luchshie-dostoprimechatelnosti-sankt-peterburga/";
                        uri = Uri.parse(str);
                        browser = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(browser);
                        break;
                    case "Krasnodar":
                        str = "https://krasnodar.sutochno.ru/info/gorod";
                        uri = Uri.parse(str);
                        browser = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(browser);
                        break;
                }

               /* if (cityName.getText().toString().equals("Moscow")){
                    Uri uri = Uri.parse(parsel.Moscow);
                    Intent browser = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(browser);
                }*/
            }
        });


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                CheckBox wind = findViewById(R.id.checkBox);
                CheckBox humidity = findViewById(R.id.checkBox2);
                CheckBox pressure = findViewById(R.id.checkBox3);
                Parsel parsel = new Parsel();
                if (wind.isChecked()) {
                    parsel.wind = wind.getText().toString();
                }
                if (humidity.isChecked()) {
                    parsel.humidity = humidity.getText().toString();
                }
                if (pressure.isChecked()) {
                    parsel.pressure = pressure.getText().toString();
                }
                parsel.cityName = cityName.getText().toString();
                Intent intent = new Intent(MainActivity.this, MainActivityTwo.class);
                intent.putExtra(TEXT, parsel);
                intent.putExtra(WIND, parsel);
                intent.putExtra(HUMIDITY, parsel);
                intent.putExtra(PRESSURE, parsel);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode != REQUEST_CODE) {
            super.onActivityResult(requestCode, resultCode, data);
        }
         if (resultCode == RESULT_OK){
             EditText cityName = findViewById(R.id.editTextTextPersonName);
             cityName.setText(data.getStringExtra(NUMBER_RESULT));
         }
    }

     @Override
        public boolean onCreateOptionsMenu (Menu menu){
            getMenuInflater().inflate(R.menu.menu_main, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected (MenuItem item){
            switch (item.getItemId()) {
                case R.id.action_setting:
                    startActivity(new Intent(MainActivity.this, MainActivity3.class));
            }
            return super.onOptionsItemSelected(item);
        }



}


