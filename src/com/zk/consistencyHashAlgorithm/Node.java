package com.zk.consistencyHashAlgorithm;

import java.util.Map;

/**
 * 在一个分布式缓存系统中，每台机器可以认为是一个节点，节点作为数据存储的地方，由一些节点来组成一个集群。
 */
public class Node {

    public Node(String domain, String ip, Map<String,Object> data){
        this.domain = domain;
        this.ip = ip;
        this.data = data;
    }

    public String getDomain() {
        return domain;
    }

    public String getIp() {
        return ip;
    }

    public Map<String, Object> getData() {
        return data;
    }

    private String domain;

    private String ip;

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

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
