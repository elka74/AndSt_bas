package ev.mikheeva.AndBaz_Les1_HW1;

import java.io.Serializable;

public class Parsel implements Serializable {
    private int temp;
    private String cityName;
    public String wind;
    public String humidity;
    public String pressure;

    public Parsel(){

    }

    public Parsel(int t , String s) {
        this.temp = temp;
        this.cityName = cityName;

    }

    public String getCityName(){
      return cityName;
  }
    public int getTemp(){
        return temp;
  }

}
