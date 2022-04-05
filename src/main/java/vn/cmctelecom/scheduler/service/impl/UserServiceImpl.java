package vn.cmctelecom.scheduler.service.impl;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import org.springframework.stereotype.Service;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import vn.cmctelecom.scheduler.service.ApiConfiguration;
import vn.cmctelecom.scheduler.service.KeycloakApi;

import java.io.IOException;

/**
 * @author cuong.nv5
 * service user
 */

@Service
public class UserServiceImpl implements ApiConfiguration {

    private KeycloakApi service;

    public UserServiceImpl() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_BASE_URL+REALMS)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(KeycloakApi.class);
    }

    public boolean validateToken(String token,StringBuffer json) throws IOException {
        Response<JsonElement> res  = service.getUserInfo(token).execute();
        Gson gson=new Gson();
        if (!res.isSuccessful()) {
            return res.errorBody() == null;
        }else{
            json.append(gson.toJson(res.body()));
            System.out.println(json);
        }
        return true;
    }
}
