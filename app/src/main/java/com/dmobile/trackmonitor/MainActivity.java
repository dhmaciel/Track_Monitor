package com.dmobile.trackmonitor;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.dmobile.trackmonitor.Adapter.MotoristasAdapter;
import com.dmobile.trackmonitor.Model.Motorista;
import com.dmobile.trackmonitor.Rest.ApiClient;
import com.dmobile.trackmonitor.Rest.ApiInterface;
import com.dmobile.trackmonitor.Util.InternetUtil;
import com.dmobile.trackmonitor.View.ViagemDetalhesActivity;
import com.dmobile.trackmonitor.View.WebViewActivity;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fab = (FloatingActionButton) findViewById(R.id.fab);

        if(!InternetUtil.isInternetAtiva(this)){
            Toast.makeText(this, "Por favor ative a internet primeiramente!", Toast.LENGTH_LONG).show();
            return;
        }

        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);

        Call<List<Motorista>> call = apiService.getAllMotoristas();
        call.enqueue(new Callback<List<Motorista>>() {
            @Override
            public void onResponse(Call<List<Motorista>> call, Response<List<Motorista>> response) {
                List<Motorista> listMotorista = response.body();
                List<Motorista> listAux = new ArrayList<Motorista>();
                for (Motorista motorista : listMotorista) {
                    if (motorista.getAtivo()) {
                        listAux.add(motorista);
                    }
                }
                recyclerView.setAdapter(new MotoristasAdapter(listAux, R.layout.list_item_motoristas, getApplicationContext()));
                //Log.i(TAG, "Id: " + motorista.getRegistroMotoristaId() + " Nome: " + motorista.getNome());
                //}
            }

            @Override
            public void onFailure(Call<List<Motorista>> call, Throwable t) {
                Log.e(TAG, t.toString());
            }
        });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, WebViewActivity.class);
                startActivity(intent);
            }
        });


    }
}
