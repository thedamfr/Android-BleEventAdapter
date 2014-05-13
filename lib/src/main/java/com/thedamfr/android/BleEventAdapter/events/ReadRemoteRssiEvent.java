package com.thedamfr.android.BleEventAdapter.events;

import android.bluetooth.BluetoothGatt;


public class ReadRemoteRssiEvent {
    private final BluetoothGatt mGatt;
    private final int mRssi;
    private final int mStatus;

    public ReadRemoteRssiEvent(BluetoothGatt gatt, int rssi, int status) {
        mGatt = gatt;
        mRssi = rssi;
        mStatus = status;
    }

    public BluetoothGatt getmGatt() {
        return mGatt;
    }

    public int getmRssi() {
        return mRssi;
    }

    public int getmStatus() {
        return mStatus;
    }
}
