package pennapps.air.guitar.airguitar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.thalmic.myo.scanner.ScanActivity;

public class MainActivity extends Activity {
    Button getStartedBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        getStartedBtn = (Button)findViewById(R.id.getStartedBtn);
    }

    public void onGetStartedClick(View view){
        Intent intent = new Intent(this, SyncoDeMyo.class);
        startActivity(intent);
    }
}
