package com.indy.labs.android.BleEventAdapter;


import android.bluetooth.BluetoothGattService;
import android.util.Log;
import com.indy.labs.android.BleEventAdapter.events.*;
import com.squareup.otto.Subscribe;

import java.util.List;

public class EventLogger {

    private static final String TAG = "BLE_EVENT_BUS";
    private final BleEventBus mBleEventBus;

    public EventLogger() {
        mBleEventBus = BleEventBus.getInstance();
        mBleEventBus.register(this);
    }

    @Subscribe
    public void logDeviceDiscovered(DiscoveredDevicesEvent event) {
        Log.i(TAG, event.toString());
    }

    @Subscribe
    public void logScanningEvent(ScanningEvent event) {
        Log.i(TAG, event.toString());
    }

    @Subscribe
    public void log(CharacteristicChangedEvent event) {
        Log.i(TAG, event.toString());
    }

    @Subscribe
    public void log(CharacteristicReadEvent event) {
        Log.i(TAG, event.toString());
    }

    @Subscribe
    public void log(CharacteristicWriteEvent event) {
        Log.i(TAG, event.toString());
    }

    @Subscribe
    public void log(DescriptorReadEvent event) {
        Log.i(TAG, event.toString());
    }

    @Subscribe
    public void log(DescriptorWriteEvent event) {
        Log.i(TAG, event.toString());
    }

    @Subscribe
    public void log(GattConnectionStateChangedEvent event) {
        Log.i(TAG, event.toString());
    }

    @Subscribe
    public void log(ReadRemoteRssiEvent event) {
        Log.i(TAG, event.toString());
    }

    @Subscribe
    public void log(ReliableWriteCompleted event) {
        Log.i(TAG, event.toString());
    }

    @Subscribe
    public void log(ServiceDiscoveredEvent event) {
        Log.i(TAG, event.toString());
        List<BluetoothGattService> services = event.getmGatt().getServices();
        for(BluetoothGattService service : services)
        {
            Log.i(TAG, service.getClass().getSimpleName() + " : "
                    + service.getUuid().toString() + " "
                    + service.getCharacteristics().size() + " Characteristics" + " "
                    + service.getIncludedServices().size() + " Included Services");
        }
    }

    @Subscribe
    public void log(DiscoveryServiceEvent event) {
        Log.i(TAG, event.toString());
    }
}
