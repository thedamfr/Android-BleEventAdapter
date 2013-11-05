package com.indy.labs.android.BleEventAdapter.events;


public class ScanningEvent {
    private Boolean mScanning;

    public ScanningEvent(Boolean scanning) {
        this.mScanning = scanning;
    }

    public Boolean getMScanning() {
        return mScanning;
    }

    @Override
    public String toString() {
        return "Scanning Event : " + mScanning;
    }
}
