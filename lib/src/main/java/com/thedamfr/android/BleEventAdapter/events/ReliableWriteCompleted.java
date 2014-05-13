package com.thedamfr.android.BleEventAdapter.events;

import android.bluetooth.BluetoothGatt;


public class ReliableWriteCompleted {
    private final BluetoothGatt mGatt;
    private final int mStatus;

    public ReliableWriteCompleted(BluetoothGatt gatt, int status) {
        mGatt = gatt;
        mStatus = status;
    }

    public BluetoothGatt getmGatt() {
        return mGatt;
    }

    public int getmStatus() {
        return mStatus;
    }
}
