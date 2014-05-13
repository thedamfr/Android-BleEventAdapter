package com.thedamfr.android.BleEventAdapter.events;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;


public class CharacteristicReadEvent {

    private final BluetoothGatt mGatt;
    private final BluetoothGattCharacteristic mCharacteristic;
    private final int mStatus;

    public CharacteristicReadEvent(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic, int status) {
        mGatt = gatt;
        mCharacteristic = characteristic;
        mStatus = status;
    }

    public BluetoothGatt getmGatt() {
        return mGatt;
    }

    public BluetoothGattCharacteristic getmCharacteristic() {
        return mCharacteristic;
    }

    public int getmStatus() {
        return mStatus;
    }
}
