package pennapps.air.guitar.airguitar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.Arrays;
import java.util.List;


public class KeysActivity extends Activity {

    private List<String> keys = Arrays.asList("\nG\n", "\nC\n", "");
    private ItemAdapter keysAdapter;
    private ListView keysList;
    private String itemSelected;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keys);

        keysList = (ListView) findViewById(R.id.keysList);
        keysAdapter = new ItemAdapter(this, R.layout.keys_row, keys);
        keysList.setAdapter(keysAdapter);
        keysAdapter.notifyDataSetChanged();

        keysList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int itemPosition = position;
                if (position != keysList.getCount() - 1) {
                    view.setSelected(true);
                    itemSelected = keys.get(position);
                }
            }
        });
    }

    public void onNextClick(View view){
        Intent intent = new Intent(this, ChordsActivity.class);
        intent.putExtra("key",itemSelected);
        startActivity(intent);
    }
}
