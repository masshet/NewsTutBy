package by.mrstark.newstutby.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import by.mrstark.newstutby.R;
import by.mrstark.newstutby.dto.Item;

/**
 * Created by mrstark on 6.4.16.
 */
public class NewsListAdapter extends RecyclerView.Adapter<NewsListAdapter.NewsViewHolder> {

    private List<Item> data;
    private Context context;

    public NewsListAdapter(List<Item> data) {
        this.data = data;
    }

    @Override
    public NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_item, parent, false);
        context = view.getContext();
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NewsViewHolder holder, int position) {
        holder.title.setText(data.get(position).getTitle());
        holder.date.setText(data.get(position).getPubDate());
        Picasso.with(context).load(data.get(position).getUrl().getUrl()).into(holder.icon);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class NewsViewHolder extends RecyclerView.ViewHolder {

        CardView cardView;
        TextView title;
        TextView date;
        ImageView icon;

        public NewsViewHolder(View itemView) {
            super(itemView);

            cardView = (CardView) itemView.findViewById(R.id.cardview);
            title = (TextView) itemView.findViewById(R.id.item_title);
            date = (TextView) itemView.findViewById(R.id.item_date);
            icon = (ImageView) itemView.findViewById(R.id.item_icon);
        }
    }

}
