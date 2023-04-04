public class Mock {
    public static WeatherData findWeather() {
        System.out.println("Finding info about weather in Tokyo");
        return new WeatherData("Tokyo",22.22,44.44);
    }
}
