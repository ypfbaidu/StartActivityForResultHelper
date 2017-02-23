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

public class SingleTaskActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single_task);
        int value = getIntent().getIntExtra("single_task", -1);
        Log.d("YPF","SingleTaskActivity value = " + value);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent();
                intent.putExtra("value", "SingleTaskActivity");
                Util.setResult(SingleTaskActivity.this, intent, 666);
                finish();
            }
        }, 3000);
    }
}
