package com.indy.labs.android.BleEventAdapter.events;

import android.bluetooth.BluetoothGatt;


public class GattConnectionStateChangedEvent {

    private final BluetoothGatt mGatt;
    private final int mStatus;
    private final int mNewState;

    public GattConnectionStateChangedEvent(BluetoothGatt gatt, int status, int gattConnectionState) {
        mGatt = gatt;
        mStatus = status;
        mNewState = gattConnectionState;
    }

    public BluetoothGatt getmGatt() {
        return mGatt;
    }

    public int getmStatus() {
        return mStatus;
    }


    public int getmNewState() {
        return mNewState;
    }

    @Override
    public String toString() {
        return "GattConnectionStateChangedEvent{" +
                "mGatt=" + mGatt +
                ", mStatus=" + mStatus +
                ", mNewState=" + mNewState +
                '}';
    }
}
