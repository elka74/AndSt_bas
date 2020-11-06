package ev.mikheeva.AndBaz_Les1_HW1;

import android.annotation.SuppressLint;
import android.app.FragmentTransaction;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class Fragment_city extends Fragment {
    public static final String CURRENT_CITY = "CurrentCity";
    boolean isExistHome;//можно ли поставить рядом фрагмент
    Parsel currentParsel; //посылка
    CheckBox wind;
    CheckBox humidity;
    CheckBox pressure;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_city, container, false);

        wind = (CheckBox) rootView.findViewById(R.id.checkBox);
        humidity = (CheckBox)rootView.findViewById(R.id.checkBox2);
        pressure = (CheckBox)rootView.findViewById(R.id.checkBox3);
        return inflater.inflate(R.layout.fragment_city, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initList(view);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        isExistHome = getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE;

        if (savedInstanceState != null) {
            currentParsel = (Parsel) savedInstanceState.getSerializable("CurrentCity");
        }
        else {
            currentParsel = new Parsel(0,getResources().getStringArray(R.array.cities)[0]);
        }

        if ( isExistHome) {
            showFrHome(currentParsel);
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putSerializable("CurrentCity", currentParsel);
        super.onSaveInstanceState(outState);
    }

    private void initList(View view) {
        LinearLayout layoutView = (LinearLayout) view;
        String[] cities = getResources().getStringArray(R.array.cities);
        for (int i = 0; i < cities.length; i++) {
            String city = cities[i];
            TextView tv = new TextView(getContext());
            tv.setText(city);
            tv.setTextSize(20);

            layoutView.addView(tv);
            final int fi = Integer.parseInt(getResources().getStringArray(R.array.temperature)[i]);
            tv.setOnClickListener((x) -> {
                currentParsel = new Parsel(fi,
                        getResources().getStringArray(R.array.cities)[fi]);

                if (wind.isChecked()) {
                    currentParsel.wind = wind.getText().toString();
                }
                if (humidity.isChecked()) {
                    currentParsel.humidity = humidity.getText().toString();
                }
                if (pressure.isChecked()) {
                    currentParsel.pressure = pressure.getText().toString();
                }
                showFrHome(currentParsel);
            });

        }
    }

    @SuppressLint("WrongConstant")
    private void showFrHome(Parsel parsel) {
        if(isExistHome) {
            Fragment_Home_1 detail = (Fragment_Home_1)
                    getFragmentManager().findFragmentById(R.id.frg_city);
            if (detail == null || detail.getParsel().getTemp() != parsel.getTemp()) {
                detail = Fragment_Home_1.create(parsel);

                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frg_city, detail)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                        .commit();
            }
        }else{
            getFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frg_city,Fragment_Home_1.create(parsel))
                    .commit();
        }
    }
}

