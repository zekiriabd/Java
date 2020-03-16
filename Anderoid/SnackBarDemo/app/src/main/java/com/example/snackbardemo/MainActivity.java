package com.example.snackbardemo;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    Snackbar snackbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showTostMessage(View v){
        Toast toast =  Toast.makeText(this,"Hi All ",Toast.LENGTH_SHORT);
        View  toastView = toast.getView();
        toastView.setBackgroundColor(Color.BLUE);
        toast.show();
    }

    public void showCostomToast(View v)
    {
        // Create layout inflator object to inflate toast.xml file
        LayoutInflater inflater = getLayoutInflater();
        View toastView = inflater.inflate(R.layout.toast, null);
        Toast toast = new Toast(getApplicationContext());
        toast.setView(toastView);
        toast.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL,0, 0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.show();
        }
    public void btnShowSnackBar(View v){
        snackbar = Snackbar.make(findViewById(R.id.mainpage),"My snack Bar ",Snackbar.LENGTH_SHORT);
        snackbar.setAction("open",new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this,"Action is clicked ",Toast.LENGTH_LONG).show();
                    }
                });

        snackbar.setActionTextColor(Color.GREEN);
        TextView snackText = (TextView)snackbar.getView().findViewById(com.google.android.material.R.id.snackbar_text);
        snackText.setTextColor(Color.RED);
        snackText.setTextSize(25);
        snackbar.show();
    }

}
