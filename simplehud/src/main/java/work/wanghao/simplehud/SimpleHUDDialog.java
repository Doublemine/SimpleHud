package work.wanghao.simplehud;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.ColorRes;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

class SimpleHUDDialog extends Dialog {

  public SimpleHUDDialog(Context context, int theme) {
    super(context, theme);
  }

  public static SimpleHUDDialog createDialog(Context context) {
    SimpleHUDDialog dialog = new SimpleHUDDialog(context, R.style.SimpleHUD);
    dialog.setContentView(R.layout.simplehud);
    dialog.getWindow().getAttributes().gravity = Gravity.CENTER;
    return dialog;
  }

  public void setMessage(String message) {
    TextView msgView = (TextView) findViewById(R.id.simplehud_message);
    if (!TextUtils.isEmpty(message)) {
      if (msgView.getVisibility() != View.VISIBLE) msgView.setVisibility(View.VISIBLE);
      msgView.setText(message);
    } else {
      if (msgView.getVisibility() != View.GONE) msgView.setVisibility(View.GONE);
    }
  }

  public void setImage(Context ctx, int resId) {
    ImageView image = (ImageView) findViewById(R.id.simplehud_image);
    image.setImageResource(resId);
    if (resId == R.drawable.simplehud_spinner) {
      Animation anim = AnimationUtils.loadAnimation(ctx, R.anim.progressbar);
      anim.start();
      image.startAnimation(anim);
    }
  }

  public void setBackground(Context context, String alphaColor) {
    GradientDrawable background =
        (GradientDrawable) context.getResources().getDrawable(R.drawable.simplehud_bg);
    if (background != null) background.setColor(Color.parseColor(alphaColor));
    getWindow().setBackgroundDrawable(background);
  }

  public void setBackground(Context context, @ColorRes int alphaColor) {
    GradientDrawable background =
        (GradientDrawable) context.getResources().getDrawable(R.drawable.simplehud_bg);
    if (background != null) background.setColor(context.getResources().getColor(alphaColor));
    getWindow().setBackgroundDrawable(background);
  }
}
