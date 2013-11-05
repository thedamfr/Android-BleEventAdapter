package com.indy.labs.android.BleEventAdapter.events;

/**
 * Created with IntelliJ IDEA.
 * User: damien
 * Date: 13-09-28
 * Time: 19:29
 * To change this template use File | Settings | File Templates.
 */
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
