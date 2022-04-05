package vn.cmctelecom.scheduler.service;
import com.google.gson.JsonElement;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

/**
 * @author cuong.nv5
 * define api call external service
 */
public interface KeycloakApi {

    @GET("protocol/openid-connect/userinfo")
    Call<JsonElement> getUserInfo(@Header("Authorization") String accessToken);

}
