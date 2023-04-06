package ru.faang.school.hashmap.task_4.Solution;


//Dummy realisation
public class WeatherStation implements  Weather{
    private final int[] temp = new int[]{1, 3, 6, 8, 4};
    private final int[] humid = new int[]{5, 8, 3, 7, 6};
    private int i = 0;

    private static final WeatherStation weather = new WeatherStation();

    @Override
    public WeatherData getWeather(String city) {
        if(i == temp.length)
            i = 0;
        //simulate long request
        try {
            Thread.sleep(1000);
        } catch(InterruptedException ignored){}

        return new WeatherData(city, temp[i], humid[i]);
    }

    public static WeatherData generateWeather(String city){
        return weather.getWeather(city);
    }

}
