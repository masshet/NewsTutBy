package by.mrstark.newstutby.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import by.mrstark.newstutby.R;
import by.mrstark.newstutby.dto.Item;

/**
 * Created by mrstark on 10.4.16.
 */
public class DetailsFragment extends AbstractFragment {

    private Item item;

    private TextView title;
    private ImageView icon;
    private TextView date;
    private TextView description;

    public DetailsFragment(Item item) {
        this.item = item;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragmen_details, container, false);
        init(root);
        loadData();
        return root;
    }

    private void loadData() {
        title.setText(item.getTitle());
        Picasso.with(getContext()).load(item.getUrl().getUrl()).into(icon);
        date.setText(item.getPubDate());
        description.setText(item.getDescription());
    }

    private void init(View root) {
        title = (TextView) root.findViewById(R.id.details_title);
        icon = (ImageView) root.findViewById(R.id.details_icon);
        date = (TextView) root.findViewById(R.id.details_date);
        description = (TextView) root.findViewById(R.id.details_description);
    }

}
