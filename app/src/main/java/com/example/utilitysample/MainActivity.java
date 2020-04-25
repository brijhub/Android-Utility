package com.example.utilitysample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.brijexecon.support.ApplicationUtility;
import com.brijexecon.support.NetworkUtility;
import com.example.utilitysample.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        binding.btnConnection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // check internet connection
                boolean isConnected = NetworkUtility.isNetworkConnection(MainActivity.this);
                if (isConnected)
                    Toast.makeText(MainActivity.this, "Successful!", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this, "Failed!", Toast.LENGTH_SHORT).show();
            }
        });

        binding.btnAppinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String appVersion  = ApplicationUtility.getAppVersion(MainActivity.this);
                    Toast.makeText(MainActivity.this, ""+appVersion, Toast.LENGTH_SHORT).show();
                } catch (PackageManager.NameNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
