package com.dmobile.trackmonitor.Rest;

import com.dmobile.trackmonitor.Model.Motorista;
import com.dmobile.trackmonitor.Model.Viagem;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Douglas on 07/09/2016.
 */
public interface ApiInterface {
    @GET("motorista/busca-todos")
    Call<List<Motorista>> getAllMotoristas();

    @GET("monitoramento/busca-viagens-motorista")
    Call<List<Viagem>> getViagemById(@Query("id") String id);
}
