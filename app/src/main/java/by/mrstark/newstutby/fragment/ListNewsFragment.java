package by.mrstark.newstutby.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import by.mrstark.newstutby.R;
import by.mrstark.newstutby.adapter.NewsListAdapter;
import by.mrstark.newstutby.dto.NewsDTO;

/**
 * Created by mrstark on 6.4.16.
 */
public class ListNewsFragment extends AbstractFragment{

    private static final int LAYOUT = R.layout.list_news_fragment;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(LAYOUT, container, false);

        RecyclerView recyclerView = (RecyclerView) root.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new NewsListAdapter(createList()));

        return root;
    }

    private List<NewsDTO> createList() {
        List<NewsDTO> list = new ArrayList<>();
        list.add(new NewsDTO("Item 1"));
        list.add(new NewsDTO("Item 2"));
        list.add(new NewsDTO("Item 3"));
        list.add(new NewsDTO("Item 4"));
        list.add(new NewsDTO("Item 5"));
        list.add(new NewsDTO("Item 6"));
        return list;
    }
}
