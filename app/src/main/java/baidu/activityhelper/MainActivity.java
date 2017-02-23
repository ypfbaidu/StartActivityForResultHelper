package baidu.activityhelper;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.baidu.activityhelper.R;

import baidu.activityhelper.helper.Util;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        findViewById(R.id.single_task).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("single_task", 100);
                Util.open(MainActivity.this, intent, 1, SingleTaskActivity.class);

            }
        });

        findViewById(R.id.single_instance).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("single_instance", 200);
                Util.open(MainActivity.this, intent, 2, SingleInstanceActivity.class);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d("YPF", "requestCode = " + requestCode + "\nresultCode = " + resultCode + "\nvalue = " + data.getStringExtra("value"));
    }
}
