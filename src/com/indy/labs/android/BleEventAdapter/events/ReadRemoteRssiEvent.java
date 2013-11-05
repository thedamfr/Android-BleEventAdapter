package com.indy.labs.android.BleEventAdapter.events;

import android.bluetooth.BluetoothGatt;

/**
 * Created with IntelliJ IDEA.
 * User: damien
 * Date: 13-09-28
 * Time: 18:57
 * To change this template use File | Settings | File Templates.
 */
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
