package com.zk.consistencyHashAlgorithm;

/**
 * Created by zk on 18/7/28.
 */

/**
 * 传统取模:
 * 在使用取模的场景中，当一个请求资源，请求某个集群时，通过对请求资源进行hash得到的值，
 * 然后对存储集群的节点数取模来得到，该请求资源，应该存储到哪一个存储节点。
 */
public class NormalHashCluster extends Cluster{
    @Override
    public void addNode(Node node) {
        this.nodes.add(node);
    }

    @Override
    public void removeNode(Node node) {
        this.nodes.removeIf(n -> n.getIp().equals(node.getIp()) || n.getDomain().equals(node.getDomain()));
    }

    @Override
    public Node get(String key) {
        long hash = hash(key);
        long index = hash % (this.nodes.size() + 1);
        return this.nodes.get((int) index);
    }

    private long hash(String key) {
        return Long.parseLong(key);
    }
}
