package com.yelinaung.topupooredoo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class TopUpActivity extends ActionBarActivity {

  EditText editText1, editText2, editText3, editText4;
  Button topUpBtn;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_top_up);

    editText1 = (EditText) findViewById(R.id.code_1);
    editText2 = (EditText) findViewById(R.id.code_2);
    editText3 = (EditText) findViewById(R.id.code_3);
    editText4 = (EditText) findViewById(R.id.code_4);

    topUpBtn = (Button) findViewById(R.id.top_up_btn);

    topUpBtn.setEnabled(false);

    editText1.addTextChangedListener(new TextWatcher() {
      @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) {
      }

      @Override public void onTextChanged(CharSequence s, int start, int before, int count) {
      }

      @Override public void afterTextChanged(final Editable s1) {
        editText2.addTextChangedListener(new TextWatcher() {
          @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) {
          }

          @Override public void onTextChanged(CharSequence s, int start, int before, int count) {
          }

          @Override public void afterTextChanged(final Editable s2) {
            editText3.addTextChangedListener(new TextWatcher() {
              @Override public void beforeTextChanged(CharSequence s, int start, int count,
                  int after) {
              }

              @Override public void onTextChanged(CharSequence s, int start, int before,
                  int count) {
              }

              @Override public void afterTextChanged(final Editable s3) {
                editText4.addTextChangedListener(new TextWatcher() {
                  @Override public void beforeTextChanged(CharSequence s, int start, int count,
                      int after) {
                  }

                  @Override public void onTextChanged(CharSequence s, int start, int before,
                      int count) {
                  }

                  @Override public void afterTextChanged(final Editable s4) {
                    if (s1.toString().trim().length() < 4
                        || s2.toString().trim().length() < 4
                        || s2.toString().trim().length() < 4
                        || s4.toString().trim().length() < 4) {
                      topUpBtn.setEnabled(false);
                    } else {
                      topUpBtn.setEnabled(true);
                    }
                  }
                });
              }
            });
          }
        });
      }
    });

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
