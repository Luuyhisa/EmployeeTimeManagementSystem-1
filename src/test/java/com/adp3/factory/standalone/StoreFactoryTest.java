package com.adp3.factory.standalone;

import com.adp3.entity.standalone.Store;
import com.adp3.factory.standalone.StoreFactory;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Author: Riyaad Ryklief
 * Class: Part Time
 * Student number: 215187849
 * Test: StoreFactory
 */

public class StoreFactoryTest {

    Store store = StoreFactory.createStore("PNP");

    @Test
    public void createStore() {

    }

    @Test // Testing Object Identity and Equality for storeID
    public void getStoreID() throws Exception{

        assertSame("1",store.getStoreID());
        assertEquals("1",store.getStoreID());
        assertNotNull(store.getStoreID());

    }

    @Test // Testing Object Identity and Equality for storeName
    public void getStoreName() throws Exception{

        assertSame("PNP", store.getStoreName());
        assertEquals("PNP",store.getStoreName());
        assertNotNull(store.getStoreName());

    }
}