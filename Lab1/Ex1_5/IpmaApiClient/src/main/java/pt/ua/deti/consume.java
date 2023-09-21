package pt.ua.deti;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

public class consume {

    public static Retrofit getRetrofit() {
        // get a retrofit instance, loaded with the GSon lib to convert JSON into objects
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.ipma.pt/open-data/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        CreateInterface(retrofit); //chama o metodo para criar a interface


        // prepare the call to remote endpoint
        return retrofit;
    }

    public static IpmaService CreateInterface(Retrofit retrofit){
        // create a typed interface to use the remote API (a client)
        return retrofit.create(IpmaService.class);
    }

    public static IpmaCityForecast getForecast(IpmaService service, int cityID) throws IOException {
        Call<IpmaCityForecast> callSync = service.getForecastForACity(cityID);

        Response<IpmaCityForecast> apiResponse = callSync.execute();


        return apiResponse.body();
    }







}
