package pennapps.air.guitar.airguitar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SyncoDeMyo extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_synco_de_myo);
    }

    public void onSyncoClick(View view) {
        Intent intent = new Intent(this, HowToActivity.class);
        startActivity(intent);
        finish();
    }
}
