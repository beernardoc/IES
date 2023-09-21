package pt.ua.deti;




public class WeatherStarter {

    public static void  main(String[] args ) {

        try {
            int cityID = Integer.parseInt(System.getenv("CITY_ID")); //para usar var de ambiente par ao docker

            IpmaCityForecast forecast = consume.getForecast(consume.CreateInterface(consume.getRetrofit()), cityID);

            if (forecast != null) {
                var firstDay = forecast.getData().listIterator().next();

                System.out.printf( "max temp for %s is %4.1f %n",
                        firstDay.getForecastDate(),
                        Double.parseDouble(firstDay.getTMax()));

            } else {
                System.out.println( "No results for this request!");
            }

            System.exit(0);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}