package ev.mikheeva.AndBaz_Les1_HW1;

import android.content.Intent;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;


public class Fragment_Home_1 extends Fragment {
    public static final String PARSEL = "parsel";

    public static Fragment_Home_1 create(Parsel parsel) {

        Fragment_Home_1 fragment = new Fragment_Home_1();

        Bundle args = new Bundle();
        args.putSerializable(PARSEL, parsel);

        fragment.setArguments(args);
        return fragment;
    }

    public Parsel getParsel() {
        Parsel parsel = (Parsel) getArguments().getSerializable(PARSEL);
        return parsel;
    }
    Button button;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment__home_1, container, false);

        TextView temp = layout.findViewById(R.id.textView13);
        TextView city = layout.findViewById(R.id.textView);
        button = layout.findViewById(R.id.button);
        Button btn = layout.findViewById(R.id.button4);
        TypedArray temper = getResources().obtainTypedArray(R.array.temperature);
        Parsel parcel = getParsel();
        temp.setText(temper.getResourceId(parcel.getTemp(), -1));
        city.setText(parcel.getCityName());

        Parsel parsel = new Parsel();
        if (parcel.wind != null) {
            TextView textView16 = layout.findViewById(R.id.textView16);
            TextView textView19 = layout.findViewById(R.id.textView19);
            textView16.setText(parsel.wind);
            textView16.setVisibility(View.VISIBLE);
            if (textView16.getText().toString().equals(parsel.wind)) {
                textView19.setText(R.string.windS);
                textView19.setVisibility(View.VISIBLE);
            }
        }
        if (parcel.humidity != null) {
                TextView textView17 = layout.findViewById(R.id.textView17);
                TextView textView20 = layout.findViewById(R.id.textView20);
                textView17.setText(parsel.humidity);
                textView17.setVisibility(View.VISIBLE);
             if (textView17.getText().toString().equals(parsel.humidity)) {
                    textView20.setText(R.string.humidityS);
                    textView20.setVisibility(View.VISIBLE);
                }
            }
            if (parcel.pressure != null) {
                TextView textView18 = layout.findViewById(R.id.textView18);
                TextView textView21 = layout.findViewById(R.id.textView21);
                textView18.setText(parsel.pressure);
                textView18.setVisibility(View.VISIBLE);
                if (textView18.getText().toString().equals(parsel.pressure)) {
                    textView21.setText(R.string.pressureS);
                    textView21.setVisibility(View.VISIBLE);

                }
            }
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 Parsel parsel = new Parsel();
                    switch (city.getText().toString()){
                        case "@string/string.moscow":
                            String str = "https://www.tripzaza.com/ru/destinations/luchshie-dostoprimechatelnosti-moskvyi/";
                            Uri uri = Uri.parse(str);
                            Intent browser = new Intent(Intent.ACTION_VIEW, uri);
                            startActivity(browser);
                            break;
                        case "@string/string.snt_Petersburg":
                            str = "https://www.tripzaza.com/ru/destinations/luchshie-dostoprimechatelnosti-sankt-peterburga/";
                            uri = Uri.parse(str);
                            browser = new Intent(Intent.ACTION_VIEW, uri);
                            startActivity(browser);
                            break;
                        case "@string/string.city_name2":
                            str = "https://krasnodar.sutochno.ru/info/gorod";
                            uri = Uri.parse(str);
                            browser = new Intent(Intent.ACTION_VIEW, uri);
                            startActivity(browser);
                            break;
                    }
            }
        });
        return layout;
        }
    }
