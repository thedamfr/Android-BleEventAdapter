package com.indy.labs.android.BleEventAdapter.events;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;

public class CharacteristicChangedEvent {
    private final BluetoothGatt mGatt;
    private final BluetoothGattCharacteristic mCharacteristic;

    public CharacteristicChangedEvent(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic) {
        mGatt = gatt;
        mCharacteristic = characteristic;
    }

    public BluetoothGatt getGatt() {
        return mGatt;
    }

    public BluetoothGattCharacteristic getCharacteristic() {
        return mCharacteristic;
    }



    @Override
    public String toString() {
        return "CharacteristicWriteEvent{" +
                "mGatt=" + mGatt +
                ", mCharacteristic=" + mCharacteristic +
                '}';
    }
}
