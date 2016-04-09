package by.mrstark.newstutby.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import by.mrstark.newstutby.Client.TutByClient;
import by.mrstark.newstutby.R;
import by.mrstark.newstutby.adapter.NewsListAdapter;
import by.mrstark.newstutby.dto.Item;
import by.mrstark.newstutby.dto.Rss;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.converter.SimpleXMLConverter;

/**
 * Created by mrstark on 6.4.16.
 */
public class ListNewsFragment extends AbstractFragment{

    private static final int LAYOUT = R.layout.list_news_fragment;
    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(LAYOUT, container, false);

        recyclerView = (RecyclerView) root.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        test();
        return root;
    }

    private List<Item> createList() {
        List<Item> list = new ArrayList<>();
        list.add(new Item());

        return list;
    }

    private void test() {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint("http://news.tut.by/")
                .setConverter(new SimpleXMLConverter())
                .build();
        TutByClient client = restAdapter.create(TutByClient.class);
        client.getItems(new Callback<Rss>() {
            @Override
            public void success(Rss rss, Response response) {
                recyclerView.setAdapter(new NewsListAdapter(rss.getChannel().getItems()));
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });

    }
}
