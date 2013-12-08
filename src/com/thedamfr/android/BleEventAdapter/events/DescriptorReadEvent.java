package com.thedamfr.android.BleEventAdapter.events;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattDescriptor;


public class DescriptorReadEvent {
    private final BluetoothGatt mGatt;
    private final BluetoothGattDescriptor mDescriptor;
    private final int mStatus;

    public DescriptorReadEvent(BluetoothGatt gatt, BluetoothGattDescriptor descriptor, int status) {
        mGatt = gatt;
        mDescriptor = descriptor;
        mStatus = status;
    }

    public BluetoothGatt getmGatt() {
        return mGatt;
    }

    public BluetoothGattDescriptor getmDescriptor() {
        return mDescriptor;
    }

    public int getmStatus() {
        return mStatus;
    }
}
