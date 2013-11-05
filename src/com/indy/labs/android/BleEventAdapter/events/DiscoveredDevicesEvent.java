package com.indy.labs.android.BleEventAdapter.events;

import android.bluetooth.BluetoothDevice;

import java.util.Arrays;
import java.util.Set;

public class DiscoveredDevicesEvent {

    private final BluetoothDevice[] bluetoothDevices;
    private final BluetoothDevice device;

    public DiscoveredDevicesEvent(BluetoothDevice device, Set<BluetoothDevice> mBluetoothDevices) {
        this.device = device;
        bluetoothDevices = mBluetoothDevices.toArray(new BluetoothDevice[mBluetoothDevices.size()]);
    }

    public BluetoothDevice[] getBluetoothDevices() {
        return bluetoothDevices;
    }

    public BluetoothDevice getDevice() {
        return device;
    }

    @Override
    public String toString() {
        return "DiscoveredDevicesEvent{" +
                "bluetoothDevices=" + Arrays.toString(bluetoothDevices) +
                '}';
    }
}
