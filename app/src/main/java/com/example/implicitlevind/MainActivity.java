package com.example.implicitlevind;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.Editable;
import android.text.Selection;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private EditText mWebsiteEditText;
    private Button mOpenContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mWebsiteEditText = (EditText) findViewById(R.id.website_edit_text);
        mWebsiteEditText.setText("https://");
        mOpenContact = (Button) findViewById(R.id.contact_button);
    }

    public void openWebsite(View view)
    {
        //Mendapatkan URL
        String url = mWebsiteEditText.getText().toString();

        //menguraikan Uri dan membuat intent
        Uri webpage = Uri.parse(url);
        Intent i = new Intent(Intent.ACTION_VIEW, webpage);

        //menjalankan intent
        if(getIntent().resolveActivity(getPackageManager()) != null)
        {
            startActivity(i);
        }
        else
        {
            Log.d("Implicit Intents", "Cannot handle this intent!");
        }
    }

    public void openContact(View view) {
        Intent i = new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI);
        startActivity(i);
    }
}
