# Introduction

Android 4.3 "Jelly Bean" introduced built in support for Bluetooth Low Energy aka Ble or Bluetooth Smart.

Ble is a key to build a Internet Of Thing world. It allow us to connect multiple device to our smartphone or other smart-device.

But using Android SDK to do so might be boring. See [Android SDK Guide](http://developer.android.com/guide/topics/connectivity/bluetooth-le.html).

## We, at Indy Trackers, think it should be easier.

We think that decoupling software component allow us to make a easy-to-maintain software architecture.

Such an architecture enable us in a way that we can ship faster and spend more time innovating.

So we build this BleEventAdapter.

It's an event-based component encapsulating Bluetooth Low Energy communication.

# Usage

## Discovering devices

You register your object to the EventBus.
So somewhere in onResume for example :
```java
BleEventBus.getInstance().register(this);
```
Don't forget to unRegister, for example in your onPause :
```java
BleEventBus.getInstance().unregister(this);
```

Subscribe to the DiscoveredDeviceEvent by adding such kind of method :
```java
@Subscribe
public void onDiscoveredDevice(DiscoveredDeviceEvent event) {
    BluetoothDevice device = event.getDevice();
}
```

When you are ready just do :
```java
BleEventAdapter.getInstance().startScanning(this);
```


## Connecting to a device

That's even easier :
```java
BleEventAdapter.getInstance().connectDevice(this, device);
```
Where this is a some Context.


## More events !

When connected to the device, a GattConnectionStateChangedEvent will be triggered.

Then, the BleAdapter will try discover devices Services and trigger a ServiceDiscoveredEvent.

This event, like many other of this kind give you access to the BluetoothGatt on which you can directly use the writeCharacteristic or readCharacteristic methods.

You will find other events :
    - CharacteristicChangedEvent is called for notifications.
    - CharacteristicReadEvent is called when a characteristic is read.
    - CharacteristicWriteEvent is called when a characteristic has been wrotten.
    - DescriptorReadEvent is called when a Descriptor is read.
    - DescriptorWriteEvent is called when a Descriptor is wrotten.
    - DiscoveryServiceEvent is called when service discovery begin.
    - ReadRemoteRssiEvent is called when Rssi is read.
    - ReliableWriteCompleted is called when a reliable write is completed.
    - ScanningEvent is called when starting or stoping scanning for a device.


# Who we are

We are Indy Trackers.

We build the future of sport using smart hardware and connected device.

Read more about how we do on our tech blog [Indy Labs](http://labs.indytrackers.com).

# License

```
Copyright 2013 Indy Trackers

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```