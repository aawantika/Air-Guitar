package pennapps.air.guitar.airguitar;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class ItemAdapter extends ArrayAdapter<String> {

    private Context context;
    private int rowResourceId;
    private List<String> objects;
    private TextView textView;
    private View rowView;

    public ItemAdapter(Context context, int resource, List<String> objects) {
        super(context, resource, objects);
        this.context = context;
        this.rowResourceId = resource;
        this.objects = objects;
    }

    @Override
    public final View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        rowView = inflater.inflate(rowResourceId, parent, false);
        textView = (TextView) rowView.findViewById(R.id.textView);
        textView.setTextColor(Color.BLACK);
        textView.setText(objects.get(position));
        return rowView;
    }

    @Override
    public final int getCount() {
        return objects.size();
    }

    public final int getItemPosition(Object item) {
        return objects.indexOf(item);
    }

    @Override
    public final long getItemId(int position) {
        return position;
    }

    @Override
    public final String getItem(int position) {
        return objects.get(position);
    }

    @Override
    public final boolean hasStableIds() {
        return true;
    }


}