package Bitcoin;

import retrofit2.Call;
import retrofit2.http.*;

public interface API {

    @GET("assets")
    Call<Data> bitcoins();

    @GET("assets/{bitcoin}")
    Call<Bitcoin> bitcoin(@Path("bitcoin") String bitcoin);
}
