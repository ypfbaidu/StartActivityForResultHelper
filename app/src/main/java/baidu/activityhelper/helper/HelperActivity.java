package baidu.activityhelper.helper;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;


/**
 * Created by yupengfei02 on 17/1/4.
 */

public class HelperActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        startTarget();
        setStyle();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent != null) {
            int resultCode = intent.getIntExtra(Util.RESULT_CODE, -1);
            if (resultCode > 0) {
                intent.setFlags(0);
                setResult(resultCode, intent);
                finish();
            }
        }
    }

    private void startTarget() {
        Intent intent = getIntent();
        if (intent == null || !intent.hasExtra(Util.TARGET)) {
            return;
        }
        Class<? extends Activity> clazz = (Class<? extends Activity>) intent.getSerializableExtra(Util.TARGET);
        if (clazz == null) {
            return;
        }
        intent.setFlags(0);
        intent.setClass(this, clazz);
        startActivity(intent);
    }

    private void setStyle() {
        Window window = getWindow();
        window.setGravity(Gravity.LEFT | Gravity.BOTTOM);
        WindowManager.LayoutParams lp = window.getAttributes();
        lp.x = 0;
        lp.y = 0;
        lp.width = 1;
        lp.height = 1;
        window.setAttributes(lp);
    }
}
