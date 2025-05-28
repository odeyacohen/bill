package fr.nexa.billquote.activity.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import fr.nexa.billquote.R;
import fr.nexa.billquote.activity.data.model.Client;

public class ClientAdapter extends RecyclerView.Adapter<ClientAdapter.ClientViewHolder> {

    private List<Client> clientList;

    public ClientAdapter(List<Client> clientList) {
        this.clientList = clientList;
    }

    public void setClientList(List<Client> clientList) {
        this.clientList = clientList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ClientViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_client, parent, false);
        return new ClientViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ClientViewHolder holder, int position) {
        Client client = clientList.get(position);
        holder.clientName.setText(client.getNomClient());
        holder.clientEmail.setText(client.getMailClient());
        holder.clientPhone.setText(client.getTelClient());
    }

    @Override
    public int getItemCount() {
        return clientList != null ? clientList.size() : 0;
    }

    static class ClientViewHolder extends RecyclerView.ViewHolder {
        TextView clientName;
        TextView clientEmail;
        TextView clientPhone;

        public ClientViewHolder(@NonNull View itemView) {
            super(itemView);
            clientName = itemView.findViewById(R.id.textViewClientName);
            clientEmail = itemView.findViewById(R.id.textViewClientEmail);
            clientPhone = itemView.findViewById(R.id.textViewClientPhone);
        }
    }
}
