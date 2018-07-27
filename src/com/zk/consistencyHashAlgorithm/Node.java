package com.zk.consistencyHashAlgorithm;

import java.util.Map;

public class Node {
    private String domain;

    private String ip;

    private Map<String, Object> data;

    public <T> void put(String key, T value) {
        data.put(key, value);
    }

    public void remove(String key){
        data.remove(key);
    }

    public <T> T get(String key) {
        return (T) data.get(key);
    }
}
