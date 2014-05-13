package com.thedamfr.android.BleEventAdapter.events;

import android.bluetooth.BluetoothGatt;


public class ServiceDiscoveredEvent {

    private final int mStatus;
    private final BluetoothGatt mGatt;

    public ServiceDiscoveredEvent(BluetoothGatt gatt, int status) {
        mGatt = gatt;
        mStatus = status;
    }

    public BluetoothGatt getmGatt() {
        return mGatt;
    }

    public int getmStatus() {
        return mStatus;
    }

    @Override
    public String toString() {
        return "ServiceDiscoveredEvent{" +
                "mStatus=" + mStatus +
                ", mGatt=" + mGatt +
                '}';
    }
}
