package ro.pub.cs.systems.eim.ab03.phonedialer;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.provider.SyncStateContract;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;


import ro.pub.cs.systems.eim.ab03.phonedialer.R;


public class PhoneDialerActivity extends AppCompatActivity {

    private EditText phoneNumberEditText = null;

    private NumberButtonClickListener numberButtonClickListener = new NumberButtonClickListener();

    private BackspaceButtonClickListener backspaceButtonClickListener = new BackspaceButtonClickListener();
    private CallButtonClickListener callButtonClickListener = new CallButtonClickListener();
    private HangupButtonClickListener hangupButtonClickListener = new HangupButtonClickListener();

    private class NumberButtonClickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            phoneNumberEditText.setText(phoneNumberEditText.getText().toString()
                                        + ((Button)view).getText().toString());
        }
    }

    private class BackspaceButtonClickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            String s = phoneNumberEditText.getText().toString();
            if(s != null && s.length() >= 1) {
                phoneNumberEditText.setText(s.substring(0, s.length() - 1));
            }
        }
    }

    private class CallButtonClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            // TODO
            String phoneNumber = phoneNumberEditText.getText().toString();
            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:" + phoneNumber));

            if (ContextCompat.checkSelfPermission(PhoneDialerActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
//                ActivityCompat.requestPermissions(
//                        PhoneDialerActivity.this,
//                        new String[]{Manifest.permission.CALL_PHONE},
//                        SyncStateContract.Constants.PERMISSION_REQUEST_CALL_PHONE);
            } else {
//                intent = new Intent(Intent.ACTION_CALL);
//                intent.setData(Uri.parse("tel:" + phoneNumberEditText.getText().toString()));
                startActivity(intent);
            }
        }
    }

    private class HangupButtonClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            // TODO
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_dialer);

//        Toolbar toolbar = (Toolbar) findViewById(R.id.);
//        setSupportActionBar(toolbar);

        phoneNumberEditText = (EditText)findViewById(R.id.textView2);

        ((Button)findViewById(R.id.button)).setOnClickListener(numberButtonClickListener);
        ((Button)findViewById(R.id.button2)).setOnClickListener(numberButtonClickListener);
        ((Button)findViewById(R.id.button3)).setOnClickListener(numberButtonClickListener);
        ((Button)findViewById(R.id.button4)).setOnClickListener(numberButtonClickListener);
        ((Button)findViewById(R.id.button5)).setOnClickListener(numberButtonClickListener);
        ((Button)findViewById(R.id.button7)).setOnClickListener(numberButtonClickListener);
        ((Button)findViewById(R.id.button8)).setOnClickListener(numberButtonClickListener);
        ((Button)findViewById(R.id.button9)).setOnClickListener(numberButtonClickListener);
        ((Button)findViewById(R.id.button10)).setOnClickListener(numberButtonClickListener);
        ((Button)findViewById(R.id.button11)).setOnClickListener(numberButtonClickListener);
        ((Button)findViewById(R.id.button13)).setOnClickListener(numberButtonClickListener);
        ((Button)findViewById(R.id.button14)).setOnClickListener(numberButtonClickListener);

        ImageButton backspaceImageButton = (ImageButton)findViewById(R.id.imageButton);
        backspaceImageButton.setOnClickListener(backspaceButtonClickListener);
        ImageButton callImageButton = (ImageButton)findViewById(R.id.imageButton2);
        callImageButton.setOnClickListener(callButtonClickListener);
        ImageButton hangupImageButton = (ImageButton)findViewById(R.id.imageButton3);
        hangupImageButton.setOnClickListener(hangupButtonClickListener);
    }


}
