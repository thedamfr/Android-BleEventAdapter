package com.thedamfr.android.BleEventAdapter.events;


public class DiscoveryServiceEvent {

    public static final int GATT_DISCOVERING = 1;

    private final int mStatus;

    public DiscoveryServiceEvent(int i) {
        mStatus = i;
    }

    @Override
    public String toString() {
        return "DiscoveryServiceEvent{" +
                "mStatus=" + mStatus +
                '}';
    }
}
