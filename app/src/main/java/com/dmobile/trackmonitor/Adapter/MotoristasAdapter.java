package com.dmobile.trackmonitor.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.dmobile.trackmonitor.MainActivity;
import com.dmobile.trackmonitor.Model.Motorista;
import com.dmobile.trackmonitor.R;
import com.dmobile.trackmonitor.View.ViagemDetalhesActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Douglas on 07/09/2016.
 */
public class MotoristasAdapter extends RecyclerView.Adapter<MotoristasAdapter.MotoristaViewHolder>{

    private List<Motorista> motoristaList;
    private int rowLayout;
    private Context context;

    public static class MotoristaViewHolder extends RecyclerView.ViewHolder {
        
        LinearLayout motoristaLayout;
        TextView motoristaNome;
        TextView motoristaCpf;
        TextView motoristaTelefone;
        TextView motoristaAtivo;

        public MotoristaViewHolder(View view) {
            super(view);

            motoristaNome = (TextView) view.findViewById(R.id.motor_nome);
            motoristaCpf = (TextView) view.findViewById(R.id.motor_cpf);
            motoristaTelefone = (TextView) view.findViewById(R.id.motor_telefone);
            motoristaAtivo = (TextView) view.findViewById(R.id.motor_ativo);
            //motoristaLayout = (LinearLayout) view.findViewById(R.id.motor_ativo);
        }
    }

    public MotoristasAdapter(List<Motorista> motoristaList, int rowLayout, Context context) {
        this.motoristaList = motoristaList;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @Override
    public MotoristasAdapter.MotoristaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        ButterKnife.bind(this, view);
        // TODO Use fields...
        return new MotoristaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MotoristasAdapter.MotoristaViewHolder holder, final int position) {
        holder.motoristaNome.setText(motoristaList.get(position).getNome());
        holder.motoristaCpf.setText(motoristaList.get(position).getCpf());
        holder.motoristaTelefone.setText(motoristaList.get(position).getTelefone());
        //holder.motoristaAtivo.setText(motoristaList.get(position).getAtivo());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = motoristaList.get(position).getRegistroMotoristaId();
                Intent intent = new Intent(context, ViagemDetalhesActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                Bundle b = new Bundle();
                b.putString("idMotorista", id);
                intent.putExtras(b);
                context.startActivity(intent);
                //Toast.makeText(context, "Recycle Click" + id, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return motoristaList.size();
    }
}
