package com.example.aidlservice.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;

import com.example.aidlservice.aidl.IMyService;
import com.example.aidlservice.aidl.User;

public class MyService extends Service {

    private String name;


    private Binder binder = new IMyService.Stub() {

        @Override
        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {

        }

        @Override
        public String getName() throws RemoteException {
            return name;
        }

        @Override
        public User getUser() throws RemoteException {
            return new User("User.service","User.18");
        }
    };


    @Override
    public IBinder onBind(Intent intent) {
        name = "service";
        return binder;
    }


}
