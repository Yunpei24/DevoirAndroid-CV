package sn.esmt.projetcvoffreemploie.httpconfig;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface Api {
    @GET("/userscv/login")
    public Call<UsersCVApiResponse> login(@Query("email") String email, @Query("nom") String nom, @Query("prenom") String prenom);

    @GET("/userscv/all")
    public Call<ArrayList<UsersCVResponse>> all();

    @POST("/userscv/save")
    Call<UsersCVSend> save(@Body UsersCVSend usersCVSend);
}
