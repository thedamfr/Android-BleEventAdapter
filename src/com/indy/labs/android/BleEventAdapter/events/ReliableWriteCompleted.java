package com.indy.labs.android.BleEventAdapter.events;

import android.bluetooth.BluetoothGatt;

/**
 * Created with IntelliJ IDEA.
 * User: damien
 * Date: 13-09-28
 * Time: 18:55
 * To change this template use File | Settings | File Templates.
 */
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
