package fr.nexa.billquote.activity.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import fr.nexa.billquote.R;
import fr.nexa.billquote.activity.data.model.Quote;

public class QuoteAdapter extends RecyclerView.Adapter<QuoteAdapter.QuoteViewHolder> {

    private List<Quote> quoteList;

    public QuoteAdapter(List<Quote> quoteList) {
        this.quoteList = quoteList;
    }

    @NonNull
    @Override
    public QuoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_quote, parent, false);
        return new QuoteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull QuoteViewHolder holder, int position) {
        Quote quote = quoteList.get(position);
        holder.textViewQuoteNumero.setText("Devis : " + quote.getNumeroDevis());
        holder.textViewQuoteDate.setText("Date : " + quote.getDateDevis());
        holder.textViewQuoteTotal.setText("Total : " + quote.getMontantDevis() + " €");
    }

    @Override
    public int getItemCount() {
        return quoteList.size();
    }

    public void setQuotes(List<Quote> body) {

    }

    public static class QuoteViewHolder extends RecyclerView.ViewHolder {
        TextView textViewQuoteNumero, textViewQuoteDate, textViewQuoteTotal;

        public QuoteViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewQuoteNumero = itemView.findViewById(R.id.textViewQuoteTitle);
            textViewQuoteDate = itemView.findViewById(R.id.textViewQuoteDate);
            textViewQuoteTotal = itemView.findViewById(R.id.textViewQuoteTotal);
        }
    }
}
