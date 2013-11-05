package com.indy.labs.android.BleEventAdapter.service.gatt;

import android.app.Service;
import android.bluetooth.*;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import com.indy.labs.android.BleEventAdapter.BleEventAdapter;
import com.indy.labs.android.BleEventAdapter.BleEventBus;
import com.indy.labs.android.BleEventAdapter.events.*;

public class GattService extends Service {


    private BleEventBus mBleEventBus;
    private BluetoothGatt mBluetoothGatt;
    private String TAG = this.getClass().getSimpleName();
    private BluetoothDevice mDevice;

    @Override
    public IBinder onBind(Intent intent) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        mBleEventBus = BleEventBus.getInstance();
        mDevice = BleEventAdapter.getInstance().getBluetoothDevice();
        if (mBluetoothGatt == null || mBluetoothGatt.connect())
            mBluetoothGatt = mDevice.connectGatt(this, false, mGattCallBack);

        Log.e(TAG, "JE VIS BORDEL");

        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();    //To change body of overridden methods use File | Settings | File Templates.

        if (mBluetoothGatt != null) {
            mBluetoothGatt.close();
            mBluetoothGatt = null;
        }


        Log.e(TAG, "JE MEURS BORDEL");
    }

    private BluetoothGattCallback mGattCallBack = new BluetoothGattCallback() {
        @Override
        public void onConnectionStateChange(BluetoothGatt gatt, int status, int newState) {
            super.onConnectionStateChange(gatt, status, newState);
            mBleEventBus.post(new GattConnectionStateChangedEvent(mBluetoothGatt, status, newState));

            if (newState == GattConnectionState.STATE_CONNECTED) {
                mBluetoothGatt.discoverServices();
                mBleEventBus.post(new DiscoveryServiceEvent(1));
            } else if (newState == BluetoothGatt.STATE_DISCONNECTED) {
                mBluetoothGatt = mDevice.connectGatt(GattService.this, false, mGattCallBack);
            }


        }

        @Override
        public void onServicesDiscovered(BluetoothGatt gatt, int status) {
            super.onServicesDiscovered(gatt, status);
            mBleEventBus.post(new ServiceDiscoveredEvent(mBluetoothGatt, status));
        }

        @Override
        public void onCharacteristicRead(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic, int status) {
            super.onCharacteristicRead(gatt, characteristic, status);
            mBleEventBus.post(new CharacteristicReadEvent(mBluetoothGatt, characteristic, status));
        }

        @Override
        public void onCharacteristicWrite(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic, int status) {
            super.onCharacteristicWrite(gatt, characteristic, status);
            mBleEventBus.post(new CharacteristicWriteEvent(mBluetoothGatt, characteristic, status));
        }

        @Override
        public void onCharacteristicChanged(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic) {
            super.onCharacteristicChanged(gatt, characteristic);
            mBleEventBus.post(new CharacteristicChangedEvent(mBluetoothGatt, characteristic));
        }

        @Override
        public void onDescriptorRead(BluetoothGatt gatt, BluetoothGattDescriptor descriptor, int status) {
            super.onDescriptorRead(gatt, descriptor, status);
            mBleEventBus.post(new DescriptorReadEvent(mBluetoothGatt, descriptor, status));
        }

        @Override
        public void onDescriptorWrite(BluetoothGatt gatt, BluetoothGattDescriptor descriptor, int status) {
            super.onDescriptorWrite(gatt, descriptor, status);
            mBleEventBus.post(new DescriptorWriteEvent(mBluetoothGatt, descriptor, status));
        }

        @Override
        public void onReliableWriteCompleted(BluetoothGatt gatt, int status) {
            super.onReliableWriteCompleted(gatt, status);
            mBleEventBus.post(new ReliableWriteCompleted(mBluetoothGatt, status));

        }

        @Override
        public void onReadRemoteRssi(BluetoothGatt gatt, int rssi, int status) {
            super.onReadRemoteRssi(gatt, rssi, status);
            mBleEventBus.post(new ReadRemoteRssiEvent(mBluetoothGatt, rssi, status));
        }
    };


}
