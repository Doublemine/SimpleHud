package work.wanghao.simplehud;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.ColorRes;
import android.support.annotation.StringRes;
import android.text.TextUtils;

public class SimpleHUD {

  private static SimpleHUDDialog dialog;
  private static Context context;
  private static SimpleHUDCallback callback;

  public static int dismissDelay = SimpleHUD.DISMISS_DELAY_SHORT;
  public static final int DISMISS_DELAY_SHORT = 2000;
  public static final int DISMISS_DELAY_MIDIUM = 4000;
  public static final int DISMISS_DELAY_LONG = 6000;
  public static String backgroundHexColor = SimpleHUD.DEFAULT_BG_COLOR;
  public final static String DEFAULT_BG_COLOR = "#aa000000";

  public static void showLoadingMessage(Context context, String msg, boolean cancelable,
      SimpleHUDCallback callback) {
    SimpleHUD.callback = callback;
    showLoadingMessage(context, msg, cancelable);
  }

  public static void showLoadingMessage(Context context, String msg, @StringRes String bgColor,
      boolean cancelable, SimpleHUDCallback callback) {
    SimpleHUD.callback = callback;
    showLoadingMessage(context, msg, bgColor, cancelable);
  }

  public static void showLoadingMessage(Context context, String msg, @ColorRes int bgColor,
      boolean cancelable, SimpleHUDCallback callback) {
    SimpleHUD.callback = callback;
    showLoadingMessage(context, msg, bgColor, cancelable);
  }

  public static void showLoadingMessage(Context context, String msg, boolean cancelable) {
    dismiss();
    setDialog(context, msg, R.drawable.simplehud_spinner, null, cancelable);
    if (dialog != null) dialog.show();
  }

  public static void showLoadingMessage(Context context, String msg, @StringRes String bgColor,
      boolean cancelable) {
    dismiss();
    setDialog(context, msg, R.drawable.simplehud_spinner, bgColor, cancelable);
    if (dialog != null) dialog.show();
  }

  public static void showLoadingMessage(Context context, String msg, @ColorRes int bgColor,
      boolean cancelable) {
    dismiss();
    setDialog(context, msg, R.drawable.simplehud_spinner, bgColor, cancelable);
    if (dialog != null) dialog.show();
  }

  public static void showErrorMessage(Context context, String msg, SimpleHUDCallback callback) {
    SimpleHUD.callback = callback;
    showErrorMessage(context, msg);
  }

  public static void showErrorMessage(Context context, String msg, @StringRes String bgColor,
      SimpleHUDCallback callback) {
    SimpleHUD.callback = callback;
    showErrorMessage(context, msg, bgColor);
  }

  public static void showErrorMessage(Context context, String msg, @ColorRes int bgColor,
      SimpleHUDCallback callback) {
    SimpleHUD.callback = callback;
    showErrorMessage(context, msg, bgColor);
  }

  public static void showErrorMessage(Context context, String msg) {
    dismiss();
    setDialog(context, msg, R.drawable.simplehud_error, null, true);
    if (dialog != null) {
      dialog.show();
      dismissAfterSeconds();
    }
  }

  public static void showErrorMessage(Context context, String msg, @StringRes String bgColor) {
    dismiss();
    setDialog(context, msg, R.drawable.simplehud_error, bgColor, true);
    if (dialog != null) {
      dialog.show();
      dismissAfterSeconds();
    }
  }

  public static void showErrorMessage(Context context, String msg, @ColorRes int bgColor) {
    dismiss();
    setDialog(context, msg, R.drawable.simplehud_error, bgColor, true);
    if (dialog != null) {
      dialog.show();
      dismissAfterSeconds();
    }
  }

  public static void showSuccessMessage(Context context, String msg, SimpleHUDCallback callback) {
    SimpleHUD.callback = callback;
    showSuccessMessage(context, msg);
  }

  public static void showSuccessMessage(Context context, String msg, @StringRes String bgColor,
      SimpleHUDCallback callback) {
    SimpleHUD.callback = callback;
    showSuccessMessage(context, msg, bgColor);
  }

  public static void showSuccessMessage(Context context, String msg, @ColorRes int bgColor,
      SimpleHUDCallback callback) {
    SimpleHUD.callback = callback;
    showSuccessMessage(context, msg, bgColor);
  }

  public static void showSuccessMessage(Context context, String msg) {
    dismiss();
    setDialog(context, msg, R.drawable.simplehud_success, null, true);
    if (dialog != null) {
      dialog.show();
      dismissAfterSeconds();
    }
  }

  public static void showSuccessMessage(Context context, String msg, @StringRes String bgColor) {
    dismiss();
    setDialog(context, msg, R.drawable.simplehud_success, bgColor, true);
    if (dialog != null) {
      dialog.show();
      dismissAfterSeconds();
    }
  }

  public static void showSuccessMessage(Context context, String msg, @ColorRes int bgColor) {
    dismiss();
    setDialog(context, msg, R.drawable.simplehud_success, bgColor, true);
    if (dialog != null) {
      dialog.show();
      dismissAfterSeconds();
    }
  }

  public static void showInfoMessage(Context context, String msg, SimpleHUDCallback callback) {
    SimpleHUD.callback = callback;
    showInfoMessage(context, msg);
  }

  public static void showInfoMessage(Context context, String msg, @StringRes String bgColor,
      SimpleHUDCallback callback) {
    SimpleHUD.callback = callback;
    showInfoMessage(context, bgColor, msg);
  }

  public static void showInfoMessage(Context context, String msg, @ColorRes int bgColor,
      SimpleHUDCallback callback) {
    SimpleHUD.callback = callback;
    showInfoMessage(context, bgColor, msg);
  }

  public static void showInfoMessage(Context context, String msg) {
    dismiss();
    setDialog(context, msg, R.drawable.simplehud_info, null, true);
    if (dialog != null) {
      dialog.show();
      dismissAfterSeconds();
    }
  }

  public static void showInfoMessage(Context context, @StringRes String bgColor, String msg) {
    dismiss();
    setDialog(context, msg, R.drawable.simplehud_info, bgColor, true);
    if (dialog != null) {
      dialog.show();
      dismissAfterSeconds();
    }
  }

  public static void showInfoMessage(Context context, @ColorRes int bgColor, String msg) {
    dismiss();
    setDialog(context, msg, R.drawable.simplehud_info, bgColor, true);
    if (dialog != null) {
      dialog.show();
      dismissAfterSeconds();
    }
  }

  private static void setDialog(Context ctx, String msg, int resId, @ColorRes int alphaResColor,
      boolean cancelable) {
    context = ctx;
    if (!isContextValid()) return;
    dialog = SimpleHUDDialog.createDialog(ctx);
    if (alphaResColor != 0) dialog.setBackground(ctx, alphaResColor);
    dialog.setMessage(msg);
    dialog.setImage(ctx, resId);
    dialog.setCanceledOnTouchOutside(false);
    dialog.setCancelable(cancelable);    // back键是否可dimiss对话框
  }

  private static void setDialog(Context ctx, String msg, int resId, @StringRes String alphaHexColor,
      boolean cancelable) {
    context = ctx;
    if (!isContextValid()) return;
    dialog = SimpleHUDDialog.createDialog(ctx);
    if (!TextUtils.isEmpty(backgroundHexColor)) dialog.setBackground(ctx, backgroundHexColor);
    if (!TextUtils.isEmpty(alphaHexColor)) dialog.setBackground(ctx, alphaHexColor);
    dialog.setMessage(msg);
    dialog.setImage(ctx, resId);
    dialog.setCanceledOnTouchOutside(false);
    dialog.setCancelable(cancelable);
  }

  public static void dismiss() {
    if (isContextValid() && dialog != null && dialog.isShowing()) dialog.dismiss();
    dialog = null;
    context = null;
  }

  /**
   * 计时关闭对话框
   */
  private static void dismissAfterSeconds() {
    new Thread(new Runnable() {
      @Override public void run() {
        try {
          Thread.sleep(dismissDelay);
          handler.sendEmptyMessage(0);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }).start();
  }

  private static Handler handler = new Handler() {
    public void handleMessage(Message msg) {
      if (msg.what == 0) {
        dismiss();
        if (SimpleHUD.callback != null) {
          callback.onSimpleHUDDismissed();
          callback = null;
          context = null;
        }
      }
    }

    ;
  };

  /**
   * 判断parent view是否还存在
   * 若不存在不能调用dismis，或setDialog等方法
   */
  private static boolean isContextValid() {
    if (context == null) return false;
    if (context instanceof Activity) {
      Activity act = (Activity) context;
      if (act.isFinishing()) return false;
    }
    return true;
  }

  public interface SimpleHUDCallback {
    void onSimpleHUDDismissed();
  }
}
