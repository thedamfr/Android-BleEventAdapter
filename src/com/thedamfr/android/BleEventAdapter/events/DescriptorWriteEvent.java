package com.thedamfr.android.BleEventAdapter.events;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattDescriptor;


public class DescriptorWriteEvent {
    private final BluetoothGatt mGatt;
    private final BluetoothGattDescriptor mDescriptor;
    private final int mStatus;

    public DescriptorWriteEvent(BluetoothGatt gatt, BluetoothGattDescriptor descriptor, int status) {
        mGatt = gatt;
        mDescriptor = descriptor;
        mStatus = status;
    }

    public BluetoothGatt getmGatt() {
        return mGatt;
    }

    public BluetoothGattDescriptor getDescriptor() {
        return mDescriptor;
    }

    public int getStatus() {
        return mStatus;
    }
}
