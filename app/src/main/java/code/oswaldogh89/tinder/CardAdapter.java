package code.oswaldogh89.tinder;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by oswaldogh89 on 16/06/16.
 */
public class CardAdapter extends BaseAdapter {

    private List<String> data;
    private Activity context;

    public CardAdapter(List<String> data, Activity context) {
        this.data = data;
        this.context = context;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        View v = convertView;
        if (v == null) {
            LayoutInflater inflater = context.getLayoutInflater();
            v = inflater.inflate(R.layout.card_view, parent, false);
        }
        ImageView imageView = (ImageView) v.findViewById(R.id.offer_image);
        Glide.with(context).load(data.get(position)).into(imageView);
        return v;
    }
}