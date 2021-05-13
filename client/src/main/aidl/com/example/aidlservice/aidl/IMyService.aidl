// IMyService.aidl
package com.example.aidlservice.aidl;

// Declare any non-default types here with import statements
import com.example.aidlservice.aidl.User;

interface IMyService {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
            double aDouble, String aString);

    String getName();

    User getUser();
}
