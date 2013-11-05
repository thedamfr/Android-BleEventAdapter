package com.indy.labs.android.BleEventAdapter.events;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattDescriptor;

/**
 * Created with IntelliJ IDEA.
 * User: damien
 * Date: 13-09-28
 * Time: 18:51
 * To change this template use File | Settings | File Templates.
 */
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
