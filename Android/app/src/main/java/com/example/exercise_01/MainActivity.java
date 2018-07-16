package com.example.exercise_01;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private View.OnClickListener mShowMessageOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            TextView messageTextView = findViewById(R.id.et_message);
            String messageText = messageTextView.getText().toString();

            Intent intent = new Intent(MainActivity.this, MessageActivity.class);
            intent.putExtra(MessageActivity.MESSAGE, messageText);

            startActivity(intent);
        }
    };

    private View.OnClickListener mSendEmailOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            TextView messageTextView = findViewById(R.id.et_message);
            String messageText = messageTextView.getText().toString();

            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto:"));
            intent.putExtra(Intent.EXTRA_TEXT, messageText);

            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
                return;
            }

            Intent intent2 = new Intent(MainActivity.this, MessageActivity.class);
            intent2.putExtra(MessageActivity.MESSAGE, messageText);

            startActivity(intent2);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button showMessageButton = findViewById(R.id.btn_showMessage);
        showMessageButton.setOnClickListener(mShowMessageOnClickListener);

        Button sendEmailButton = findViewById(R.id.btn_sendEmail);
        sendEmailButton.setOnClickListener(mSendEmailOnClickListener);
    }
}
