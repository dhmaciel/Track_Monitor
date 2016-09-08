package com.dmobile.trackmonitor.View;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import com.dmobile.trackmonitor.Adapter.MotoristasAdapter;
import com.dmobile.trackmonitor.Model.Motorista;
import com.dmobile.trackmonitor.Model.Viagem;
import com.dmobile.trackmonitor.R;
import com.dmobile.trackmonitor.Rest.ApiClient;
import com.dmobile.trackmonitor.Rest.ApiInterface;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViagemDetalhesActivity extends AppCompatActivity {

    private static final String TAG = ViagemDetalhesActivity.class.getSimpleName();
    private SimpleDateFormat dt = new SimpleDateFormat("yyyyy-MM-dd hh:mm:ss");

    @BindView(R.id.edt_origem)
    EditText edtOrigem;

    @BindView(R.id.edt_destino)
    EditText edtDestino;

    @BindView(R.id.edt_previsao_embarque)
    TextView edtPrevEmbarque;

    @BindView(R.id.edt_previsao_entrega)
    TextView edtPrevisaoEntrega;

    TextView edtKmEstimados;

    private boolean isDados = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viagem_detalhes);
        ButterKnife.bind(this);

        edtOrigem = (EditText) findViewById(R.id.edt_origem);
        edtDestino = (EditText) findViewById(R.id.edt_destino);
        edtPrevEmbarque = (TextView) findViewById(R.id.edt_previsao_embarque);
        edtPrevisaoEntrega = (TextView) findViewById(R.id.edt_previsao_entrega);
        edtKmEstimados = (TextView) findViewById(R.id.edt_km_estimado2);

        Bundle bundle = getIntent().getExtras();
        String idMotorista = "";

        if(bundle != null) {
            idMotorista = bundle.getString("idMotorista");
        }

        if(idMotorista != null && !idMotorista.equals("")){
            ApiInterface apiService =
                    ApiClient.getClient().create(ApiInterface.class);

            Call<List<Viagem>> call = apiService.getViagemById(idMotorista);
            call.enqueue(new Callback<List<Viagem>>() {
                @Override
                public void onResponse(Call<List<Viagem>> call, Response<List<Viagem>> response) {
                    List<Viagem> viagemList = response.body();
                    if(viagemList != null && viagemList.size() > 0){
                        isDados = true;
                        Log.i(TAG, "Id: " + viagemList.get(0).getViagemId() + " Destino: " + viagemList.get(0).getDestino());
                        carregarCampos(viagemList.get(0));
                    }else{
                        isDados = false;
                        exibirAlerta();
                    }
                }

                @Override
                public void onFailure(Call<List<Viagem>> call, Throwable t) {
                    Log.e(TAG, t.toString());
                }
            });

        }
    }

    private void carregarCampos(Viagem viagem){
        edtOrigem.setText(viagem.getOrigem());
        edtDestino.setText(viagem.getDestino());
        edtKmEstimados.setText(viagem.getKmEstimado() + " KM");
        edtPrevEmbarque.setText(formatDate(viagem.getPreviaoEmbarque()));
        edtPrevisaoEntrega.setText(formatDate(viagem.getPrevisaoEntrega()));
    }

    private void exibirAlerta(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Sem Dados para exibição!!")
                .setTitle("Alerta")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        finish();
                    }
                });

        // Create the AlertDialog object and return it
        builder.show();
    }


    private String formatDate(String data){
        if(data != null && !data.equals("")){
            data = data.replace("T", " ");
            Date date = null;
            try {
                date = dt.parse(data);
                SimpleDateFormat dt1 = new SimpleDateFormat("yyyy-MM-dd");
                String dataUs = dt1.format(date);
                String[] dtArray = dataUs.split("-");
                String dataAp = dtArray[2]+"/" + dtArray[1] + "/" + dtArray[0];
                return  dataAp;
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return "";
    }
}
