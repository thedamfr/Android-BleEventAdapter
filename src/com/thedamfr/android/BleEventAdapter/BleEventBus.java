package com.thedamfr.android.BleEventAdapter;

import com.squareup.otto.Bus;
import com.squareup.otto.ThreadEnforcer;


public class BleEventBus extends Bus {
    private static BleEventBus ourInstance = new BleEventBus(ThreadEnforcer.ANY);

    public static BleEventBus getInstance() {
        return ourInstance;
    }

    public BleEventBus(ThreadEnforcer enforcer) {
        super(enforcer, "Indy-Ble-LowLevel");
    }
}
