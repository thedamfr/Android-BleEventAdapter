package com.indy.labs.android.BleEventAdapter.service.discovery.device;

import android.app.Service;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.widget.Toast;
import com.indy.labs.android.BleEventAdapter.BleEventBus;
import com.indy.labs.android.BleEventAdapter.events.DiscoveredDevicesEvent;
import com.indy.labs.android.BleEventAdapter.events.ScanningEvent;
import com.squareup.otto.Produce;
import java.util.HashSet;
import java.util.Set;


public class DeviceDiscoveryService extends Service {

    private static final long SCAN_PERIOD = 10000;
    private BleEventBus mBleEventBus;
    private Set<BluetoothDevice> mBluetoothDevices = new HashSet<BluetoothDevice>();
    private BluetoothAdapter mBluetoothAdapter;
    private Handler mHandler;
    private boolean mScanning = false;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        mBleEventBus = BleEventBus.getInstance();
        mBleEventBus.register(this);


        final BluetoothManager bluetoothManager = (BluetoothManager) getSystemService(this.BLUETOOTH_SERVICE);
        mBluetoothAdapter = bluetoothManager.getAdapter();

        if (mBluetoothAdapter == null || !mBluetoothAdapter.isEnabled()) {
            Toast.makeText(this, "Pas de Ble, Blaireau", Toast.LENGTH_SHORT).show();
            stopSelf();
        } else {
            scanLeDevice(true);
        }

        return START_NOT_STICKY;
    }

    private void scanLeDevice(final boolean enable) {
        if (enable) {
            startScanning();
        } else {
            stopScanning();
        }
    }

    private void startScanning() {
        mHandler = new Handler();
        // Stops scanning after a
        //... pre-defined scan period.
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                stopScanning();
            }
        }, SCAN_PERIOD);

        mScanning = true;
        mBluetoothAdapter.startLeScan(mLeScanCallback);
        mBleEventBus.post(new ScanningEvent(mScanning));
    }

    private void stopScanning() {
        mScanning = false;
        mBluetoothAdapter.stopLeScan(mLeScanCallback);
        mBleEventBus.post(new ScanningEvent(false));
        DeviceDiscoveryService.this.stopSelf();
    }


    private BluetoothAdapter.LeScanCallback mLeScanCallback =
            new BluetoothAdapter.LeScanCallback() {
                @Override
                public void onLeScan(final BluetoothDevice device, int rssi, byte[] scanRecord) {
                    mBluetoothDevices.add(device);
                    mBleEventBus.post(new DiscoveredDevicesEvent(device, mBluetoothDevices));
                }
            };

    @Produce
    public DiscoveredDevicesEvent produceAnswer() {
        return new DiscoveredDevicesEvent(null, mBluetoothDevices);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        stopScanning();
        mBleEventBus.unregister(this);
    }

    public IBinder onBind(Intent intent) {
        return null;
    }
}
