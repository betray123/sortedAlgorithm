package com.zk.consistencyHashAlgorithm;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * Created by zk on 18/7/28.
 */
public class TestNormalHash {
    public static final int DATA_COUNT = 1;
//    public static final String PRE_KEY = "192.168.0.";

    public static void main(String[] args) {
        Cluster cluster = new NormalHashCluster();
        Map<String,Object> data = new HashMap<String,Object>();
        cluster.addNode(new Node("c1.zk.info","192.168.0.1",data));
        cluster.addNode(new Node("c2.zk.info","192.168.0.2",data));
        cluster.addNode(new Node("c3.zk.info","192.168.0.3",data));
        cluster.addNode(new Node("c4.zk.info","192.168.0.4",data));


        IntStream.range(0,DATA_COUNT).forEach(
                index -> {
                    Node node = cluster.get(String.valueOf(index));
                    node.put(String.valueOf(index),"Test Data");
                }
        );

        System.out.println("数据分布情况: ");
        cluster.nodes.forEach(node -> {
            System.out.println("IP:" + node.getIp() + ",数据量:" + node.getData().size());
        });

        //缓存命中率
        long hitCount = IntStream.range(0, DATA_COUNT)
                .filter(index -> cluster.get(String.valueOf(index)).get(String.valueOf(index)) != null)
                .count();
        System.out.println("缓存命中率：" + hitCount * 1f / DATA_COUNT);

    }
}
