package com.yeremiaadielyogasasongko.uajy.p3l;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.budiyev.android.codescanner.CodeScanner;
import com.budiyev.android.codescanner.CodeScannerView;
import com.budiyev.android.codescanner.DecodeCallback;
import com.google.zxing.Result;


public class ScanActivity extends AppCompatActivity {
    private final int CAMERA_REQUEST_CODE = 101;
    private CodeScanner mCodeScanner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan);

        if(!checkPermission()) {
            makeRequest();
            finish();
        }
        else {
            setupScanner();
        }
    }

    private void setupScanner() {
        CodeScannerView scannerView = findViewById(R.id.scanner_view);
        mCodeScanner = new CodeScanner(this, scannerView);
        mCodeScanner.setDecodeCallback(new DecodeCallback() {
            @Override
            public void onDecoded(@NonNull Result result) {

                Log.i("QRSCANNER", "onDecoded: " + result.getText());

                Intent returnIntent = new Intent();
                returnIntent.putExtra("qrResult", result.getText());
                setResult(Activity.RESULT_OK, returnIntent);
                finish();
            }
        });
        scannerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCodeScanner.startPreview();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(checkPermission()) {
            mCodeScanner.startPreview();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(checkPermission()) {
            mCodeScanner.releaseResources();
        }
    }

    private boolean checkPermission() {
        int permission = ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA);
        return permission == PackageManager.PERMISSION_GRANTED;
    }

    private void makeRequest() {
        String[] permissions = {Manifest.permission.CAMERA};

        ActivityCompat.requestPermissions(this, permissions, CAMERA_REQUEST_CODE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == CAMERA_REQUEST_CODE) {
            if(grantResults.length == 0 || grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Permission Request Not Granted", Toast.LENGTH_SHORT).show();
            }
        }
    }
}