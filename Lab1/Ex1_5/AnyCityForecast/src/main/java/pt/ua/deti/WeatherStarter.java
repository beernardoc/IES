package pt.ua.deti;



import java.util.Random;
import java.util.concurrent.TimeUnit;



public class WeatherStarter {


        public static void main(String[] args) {
            Random random = new Random();
            int minCityID = 1000000;
            int maxCityID = 9999999;

            try {
                while (true) {
                    int cityID = random.nextInt(maxCityID - minCityID + 1) + minCityID;
                    IpmaCityForecast forecast = consume.getForecast(consume.CreateInterface(consume.getRetrofit()), cityID);

                    if (forecast != null) {
                        var firstDay = forecast.getData().listIterator().next();

                        System.out.printf("max temp for %s in city %d is %4.1f %n",
                                firstDay.getForecastDate(),
                                cityID,
                                Double.parseDouble(firstDay.getTMax()));
                    } else {
                        System.out.println("No results for city " + cityID);
                    }

                    TimeUnit.SECONDS.sleep(20); // Aguarde 20 segundos antes de fazer a próxima solicitação
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

