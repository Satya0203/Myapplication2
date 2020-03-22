package com.example.anew.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity
{
    Uri u;
    EditText et1,et2,et3;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1=findViewById(R.id.et1);
        et2=findViewById(R.id.et2);
        et3=findViewById(R.id.et3);
    }

    public void javamail(View view)
    {
    }

    public void mail(View view)
    {
        Intent i=new Intent();
        i.setAction(Intent.ACTION_SEND);
        i.putExtra(Intent.EXTRA_EMAIL,et1.getText().toString());
        i.putExtra(Intent.EXTRA_SUBJECT,et2.getText().toString());
        i.putExtra(Intent.EXTRA_TEXT,et3.getText().toString());
        i.putExtra(Intent.EXTRA_STREAM,u);
        i.setType("message/rfc822");
        startActivity(Intent.createChooser(i,"select any mail client"));
    }

    public void attach(View view)
    {
        Intent it=new Intent();
        it.setAction(Intent.ACTION_GET_CONTENT);
        it.setType("*/*");
        startActivityForResult(it,3);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        u=data.getData();
    }
}
