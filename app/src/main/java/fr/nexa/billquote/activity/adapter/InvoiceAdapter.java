package fr.nexa.billquote.activity.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import fr.nexa.billquote.R;
import fr.nexa.billquote.activity.data.model.Invoice;

public class InvoiceAdapter extends RecyclerView.Adapter<InvoiceAdapter.InvoiceViewHolder> {

    // Garde une seule liste et initialise-la directement
    private List<Invoice> invoiceList = new ArrayList<>();

    public InvoiceAdapter() {
        // constructeur vide
    }

    @NonNull
    @Override
    public InvoiceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_invoice, parent, false);
        return new InvoiceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull InvoiceViewHolder holder, int position) {
        Invoice invoice = invoiceList.get(position);
        holder.textViewInvoiceNumber.setText("Facture #" + invoice.getNumeroFacture());
        holder.textViewInvoiceDate.setText("Date : " + invoice.getDateFacture());
        holder.textViewInvoiceTotal.setText("Total : " + invoice.getMontantFacture() + " €");
    }

    @Override
    public int getItemCount() {
        return invoiceList.size();
    }

    // Mets à jour la liste et notifie le RecyclerView
    public void setInvoices(List<Invoice> invoices) {
        if (invoices != null) {
            this.invoiceList = invoices;
        } else {
            this.invoiceList = new ArrayList<>();
        }
        notifyDataSetChanged();
    }

    public static class InvoiceViewHolder extends RecyclerView.ViewHolder {
        TextView textViewInvoiceNumber, textViewInvoiceDate, textViewInvoiceTotal;

        public InvoiceViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewInvoiceNumber = itemView.findViewById(R.id.textViewInvoiceNumber);
            textViewInvoiceDate = itemView.findViewById(R.id.textViewInvoiceDate);
            textViewInvoiceTotal = itemView.findViewById(R.id.textViewInvoiceTotal);
        }
    }
}
