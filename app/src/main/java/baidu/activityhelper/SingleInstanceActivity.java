package baidu.activityhelper;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

import com.baidu.activityhelper.R;

import baidu.activityhelper.helper.Util;

/**
 * Created by yupengfei02 on 17/2/23.
 */

public class SingleInstanceActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single_task);
        int value = getIntent().getIntExtra("single_instance", -1);
        Log.d("YPF","SingleInstanceActivity value = " + value);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent();
                intent.putExtra("value", "SingleInstanceActivity");
                Util.setResult(SingleInstanceActivity.this, intent, 888);
                finish();
            }
        }, 3000);
    }
}
