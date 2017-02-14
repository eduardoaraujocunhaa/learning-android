package com.example.android.phonestats;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv1, tv2, tv3, tv4, tv5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1 = (TextView)findViewById(R.id.tv1);
        tv2 = (TextView)findViewById(R.id.tv2);
        tv3 = (TextView)findViewById(R.id.tv3);
        tv4 = (TextView)findViewById(R.id.tv4);
        tv5 = (TextView)findViewById(R.id.tv5);
        TelephonyManager tm = (TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);
        String IMEI = tm.getDeviceId();
        String SIM_OP = tm.getNetworkOperatorName();
        String SIM_NUMBER = tm.getSimSerialNumber();
        String SIM_COUNTRY = tm.getSimCountryIso();
        String LOCATION = tm.getCellLocation().toString();


        tv1.setText(IMEI);
        tv2.setText(SIM_OP);
        tv3.setText(SIM_NUMBER);
        tv4.setText(SIM_COUNTRY);
        tv5.setText(LOCATION);

    }
}
