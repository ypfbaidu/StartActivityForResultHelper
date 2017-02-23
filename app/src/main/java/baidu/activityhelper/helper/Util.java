package baidu.activityhelper.helper;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

/**
 * Created by yupengfei02 on 17/2/23.
 */

public class Util {

    public static final String TARGET = "target";
    public static final String RESULT_CODE = "result_code";

    public static Intent getHelperIntent(Context context, Class<? extends Activity> clazz, Intent intent) {
        intent.setClass(context, clazz);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        return intent;
    }

    public static void open(Activity activity, Intent intent, int requestCode, Class<? extends Activity> clazz) {
        intent = getHelperIntent(activity, HelperActivity.class, intent);
        intent.putExtra(TARGET, clazz);
        activity.startActivityForResult(intent, requestCode);
    }

    public static void setResult(Activity activity, Intent intent, int resultCode) {
        intent = getHelperIntent(activity, HelperActivity.class, intent);
        intent.putExtra(RESULT_CODE, resultCode);
        activity.startActivity(intent);
    }
}
