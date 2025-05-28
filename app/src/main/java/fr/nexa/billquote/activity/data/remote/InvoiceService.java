package fr.nexa.billquote.activity.data.remote;

import java.util.List;

import fr.nexa.billquote.activity.data.model.Invoice;
import retrofit2.Call;
import retrofit2.http.GET;

public interface InvoiceService {
    @GET("invoices")
    Call<List<Invoice>> getInvoices();

    Call<Invoice> addInvoice(Invoice invoice);
}