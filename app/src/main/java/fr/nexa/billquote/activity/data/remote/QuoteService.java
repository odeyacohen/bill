package fr.nexa.billquote.activity.data.remote;

import java.util.List;

import fr.nexa.billquote.activity.data.model.Quote;
import retrofit2.Call;
import retrofit2.http.GET;

public interface QuoteService {
    @GET("quotes")
    Call<List<Quote>> getQuotes();

    Call<Quote> addQuote(Quote quote);
}
