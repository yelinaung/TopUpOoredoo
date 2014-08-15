package com.yelinaung.topupooredoo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class TopUpActivity extends ActionBarActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_top_up);

    String code1 = ((EditText) findViewById(R.id.code_1)).getText().toString();
    String code2 = ((EditText) findViewById(R.id.code_2)).getText().toString();
    String code3 = ((EditText) findViewById(R.id.code_3)).getText().toString();
    String code4 = ((EditText) findViewById(R.id.code_4)).getText().toString();

    final String code = code1 + code2 + code3 + code4;

    findViewById(R.id.top_up_btn).setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        String hash = Uri.encode("#");
        String topUpString = "*" + 123 + "*" + code + hash;
        Log.i("code", topUpString);
        callIntent.setData(Uri.parse("tel:" + topUpString));
        startActivity(callIntent);
      }
    });
  }
}
