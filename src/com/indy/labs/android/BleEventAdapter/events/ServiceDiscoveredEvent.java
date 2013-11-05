package com.indy.labs.android.BleEventAdapter.events;

import android.bluetooth.BluetoothGatt;

/**
 * Created with IntelliJ IDEA.
 * User: damien
 * Date: 13-09-28
 * Time: 18:41
 * To change this template use File | Settings | File Templates.
 */
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
