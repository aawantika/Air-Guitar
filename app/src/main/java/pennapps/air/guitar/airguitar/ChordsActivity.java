package pennapps.air.guitar.airguitar;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;


public class ChordsActivity extends Activity {
    private String key;
    private List<String> chords;
    private String itemSelected;
    private Set<String> chordsSelected;

    private Button chordsButton;
    private String finalChords;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chords);

        chordsSelected = new LinkedHashSet<String>();
        key = getIntent().getStringExtra("key").trim();
        ListView chordsList = (ListView) findViewById(R.id.chordsList);
        if (key.equals("G")) {
            chords = Arrays.asList("G", "A minor", "B minor", "C", "D", "E minor");
        } else if (key.equals("C")) {
            chords = Arrays.asList("C", "D minor", "E minor", "F", "G", "A minor");
        }

        ItemAdapter chordsAdapter = new ItemAdapter(this, R.layout.chords_row, chords);
        chordsList.setAdapter(chordsAdapter);
        chordsAdapter.notifyDataSetChanged();
        chordsButton = (Button) findViewById(R.id.nextChords);

        chordsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                view.setSelected(true);
                itemSelected = chords.get(position);
                if (chordsSelected.contains(itemSelected)) {
                    chordsSelected.remove(itemSelected);
                } else {
                    chordsSelected.add(itemSelected);
                }
                finalChords = "";
                for (String chord : chordsSelected) {
                    finalChords += ", " + chord;
                }
                if (!finalChords.equals("")) {
                    finalChords = finalChords.substring(2);
                }
                chordsButton.setTextSize(23);
                chordsButton.setText(finalChords);
            }
        });
    }

    public void onNextClick(View view) {
        if (chordsSelected.size() != 4) {
            new AlertDialog.Builder(this)
                    .setTitle("Oops!")
                    .setMessage("Make sure to have selected exactly four chords.")
                    .setPositiveButton(android.R.string.ok,
                            new DialogInterface.OnClickListener() {
                                public void onClick(
                                        final DialogInterface dialog,
                                        final int which) {
                                }
                            }).show();
        } else {
            Intent intent = new Intent(this, AirGuitarActivity.class);
            intent.putExtra("chords", finalChords);
            intent.putExtra("key", key);
            startActivity(intent);
        }
    }

}
