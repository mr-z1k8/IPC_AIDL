package com.demo.client;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.widget.Toast;

import com.example.aidlservice.aidl.IMyService;

public class MyClientActivity extends Activity {

    IMyService iMyService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        bindService(new Intent(this, MyService.class),connection, Context.BIND_AUTO_CREATE);
        Intent intent = new Intent();
        intent.setAction("com.demo.aidl");
        intent.setPackage("com.example.aidlservice");
        bindService(intent,connection, Context.BIND_AUTO_CREATE);
    }

    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            iMyService = IMyService.Stub.asInterface(iBinder);
            try {
//                Toast.makeText(MyClientActivity.this,iMyService.getName(),Toast.LENGTH_LONG).show();
                Toast.makeText(MyClientActivity.this,iMyService.getUser().toString(),Toast.LENGTH_LONG).show();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            iMyService = null;
        }
    };


}
