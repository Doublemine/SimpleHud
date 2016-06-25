package work.wanghao.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import work.wanghao.simplehud.SimpleHUD;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    SimpleHUD.backgroundHexColor = "#aa817EDF";
    Button showInfoMessage = (Button) findViewById(R.id.btn_info_message);
    Button showLoadingMessage = (Button) findViewById(R.id.btn_loading_message);
    Button showErrorMessage = (Button) findViewById(R.id.btn_error_message);
    Button showSuccessMessage = (Button) findViewById(R.id.btn_success_message);
    Button empty = (Button) findViewById(R.id.btn_loading);
    empty.setOnClickListener(this);
    showInfoMessage.setOnClickListener(this);
    showLoadingMessage.setOnClickListener(this);
    showErrorMessage.setOnClickListener(this);
    showSuccessMessage.setOnClickListener(this);
  }

  @Override public void onClick(View v) {
    switch (v.getId()) {
      case R.id.btn_loading_message:
        SimpleHUD.showLoadingMessage(this, "loading data, please wait...", true);
        // when you finish loading your data, call SimpleHUD.dismiss();
        break;
      case R.id.btn_info_message:
        SimpleHUD.showInfoMessage(this, "This is a info message.");
        break;
      case R.id.btn_error_message:
        SimpleHUD.showErrorMessage(this, "This ia a error message.");
        break;
      case R.id.btn_success_message:
        SimpleHUD.showSuccessMessage(this, "This a success message, and it's a long sentence!");
        break;
      case R.id.btn_loading:
        SimpleHUD.showLoadingMessage(this, SimpleHUD.dismissDelay + "", true);
    }
  }
}
