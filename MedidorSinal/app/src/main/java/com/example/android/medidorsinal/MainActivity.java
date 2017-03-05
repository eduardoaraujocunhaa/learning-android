package com.example.android.medidorsinal;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.CellInfo;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoWcdma;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

import static java.lang.Integer.parseInt;

public class MainActivity extends AppCompatActivity {

    private static final int MY_PERMISSIONS_REQUEST_ACCESS_COARSE_LOCATION = 1;
    TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1 = (TextView) findViewById(R.id.tv1);
        final TelephonyManager telephonyManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);

        if (android.os.Build.VERSION.SDK_INT < 17) {
            PhoneStateListener phoneStateListener = new PhoneStateListener() {
                @Override
                public void onSignalStrengthsChanged(SignalStrength signalStrength) {
                    String ssignal = signalStrength.toString();
                    String[] parts = ssignal.split(" ");

                    if (telephonyManager.getNetworkType() == TelephonyManager.NETWORK_TYPE_LTE) {
                        tv1.setText(String.valueOf(parseInt(parts[8]) - 140));
                    } else if (telephonyManager.getNetworkType() == TelephonyManager.NETWORK_TYPE_CDMA) {
                        tv1.setText(String.valueOf(signalStrength.getCdmaDbm()));
                    } else {
                        if (signalStrength.getGsmSignalStrength() != 99) {
                            tv1.setText(String.valueOf(-113 + 2 * signalStrength.getGsmSignalStrength()));
                        }
                    }
                }
            };
            telephonyManager.listen(phoneStateListener, PhoneStateListener.LISTEN_SIGNAL_STRENGTHS);
        } else {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, MY_PERMISSIONS_REQUEST_ACCESS_COARSE_LOCATION);
            } else {
                usaCellInfo();
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_ACCESS_COARSE_LOCATION: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    usaCellInfo();
                }
            }
        }
    }

    protected void usaCellInfo(){
        Timer t = new Timer();
        t.scheduleAtFixedRate(new TimerTask() {
            TelephonyManager telephonyManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);

            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR2)
            @Override
            public void run() {
                for (CellInfo info : telephonyManager.getAllCellInfo()) {
                    if(info != null) {
                        if (info instanceof CellInfoGsm) {
                            final int gsm = ((CellInfoGsm) info).getCellSignalStrength().getDbm();
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    tv1.setText(String.valueOf(gsm));
                                }
                            });
                        } else if (info instanceof CellInfoWcdma) {
                            final int wcdma = ((CellInfoWcdma) info).getCellSignalStrength().getDbm();
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    tv1.setText(String.valueOf(wcdma));
                                }
                            });
                        } else if (info instanceof CellInfoLte) {
                            final int lte = ((CellInfoLte) info).getCellSignalStrength().getDbm();
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    tv1.setText(String.valueOf(lte));
                                }
                            });
                        }
                    }
                }
            }
        }, 0, 5000);
    }
}