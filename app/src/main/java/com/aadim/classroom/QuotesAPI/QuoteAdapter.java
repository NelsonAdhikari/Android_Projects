package com.aadim.classroom.QuotesAPI;


        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.TextView;

        import androidx.annotation.NonNull;
        import androidx.recyclerview.widget.RecyclerView;


        import com.aadim.classroom.R;

        import java.util.List;

public class QuoteAdapter extends RecyclerView.Adapter<QuoteAdapter.QuoteViewHolder> {

    List<Quote> quotes;

    public QuoteAdapter(List<Quote> quotes) {
        this.quotes = quotes;
    }

    @NonNull
    @Override
    public QuoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_quote, parent, false);
        return new QuoteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull QuoteViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return quotes.size();
    }

    class QuoteViewHolder extends RecyclerView.ViewHolder{

        TextView author, quotetv;

        public QuoteViewHolder(@NonNull View itemView) {
            super(itemView);
            author = itemView.findViewById(R.id.tvAuthor);
            quotetv = itemView.findViewById(R.id.tvQuote);
        }

        public void bindView(Quote quote) {
            author.setText(quote.getAuthor());
            quotetv.setText(quote.getQuote());
        }
    }
}