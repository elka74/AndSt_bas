package ev.mikheeva.AndBaz_Les1_HW1;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class MainActivity extends AppCompatActivity implements Constante {
    private Button button;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, new Fragment_Home_1())
                    .commit();
        }

        Menu menu_main;
        TextView editText = findViewById(R.id.editTextTime);
        TextView editTextdata = findViewById(R.id.editTextDate);
        button = findViewById(R.id.button);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_setting:
                startActivity(new Intent(MainActivity.this, MainActivity3.class));
        }
        return super.onOptionsItemSelected(item);
    }

    public void Change(View view) {

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment;
                fragment = new Fragment_city();

            }

        });
    }
}

