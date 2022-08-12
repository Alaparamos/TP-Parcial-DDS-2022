package Moneda;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.List;

public class LlamarApi {

    private final String url = "https:/api.coincap.io/v2/";
    private Retrofit retrofit;
    private static LlamarApi instance = null;

    public static LlamarApi getInstance(){
        if(instance == null){
            instance = new LlamarApi();
        }
        return instance;
    }

    public List<Bitcoin> conseguirBitcoins() throws IOException {

        //CONEXION
        this.retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        API api = this.retrofit.create(API.class);
        Call<Data> d = api.bitcoins();

        Response<Data> response = d.execute();
        Data bitcoins = response.body();

        return bitcoins.getData();
    }
}
