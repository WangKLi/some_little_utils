package little_util.b2c.controller;

import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @Author: liwang
 * Date:     2021/11/3 10:05 上午
 */
public class TreeMapStudy {

    public static void main(String[] args) {
        //创建TreeMap对象：
        TreeMap<String, Integer> treeMap = new TreeMap<String, Integer>();
        System.out.println("初始化后,TreeMap元素个数为：" + treeMap.size());

        //新增元素:
        treeMap.put("hello", 1);
        treeMap.put("world", 2);
        treeMap.put("my", 3);
        treeMap.put("name", 4);
        treeMap.put("is", 5);
        treeMap.put("jiaboyan", 6);
        treeMap.put("i", 6);
        treeMap.put("am", 6);
        treeMap.put("a", 6);
        treeMap.put("developer", 6);
        treeMap.put("z", 0);
        System.out.println("添加元素后,TreeMap元素个数为：" + treeMap.size());
        //获取元素：
        Integer getValue = treeMap.get("jiaboyan");//获取集合内元素key为"jiaboyan"的值

        String firstKey = treeMap.firstKey();//获取集合内第一个元素
        System.out.println("集合内第一个元素:" + firstKey);
        String lastKey = treeMap.lastKey();//获取集合内最后一个元素
        System.out.println("集合内最后一个元素:" + lastKey);
        String lowerKey = treeMap.lowerKey("jiaboyan");//获取集合内的key小于"jiaboyan"的key
        System.out.println("获取集合内的key小于\"jiaboyan\"的key:" + lowerKey);
        String ceilingKey = treeMap.ceilingKey("jiaboyan");//获取集合内的key大于等于"jiaboyan"的key
        System.out.println("获取集合内的key大于等于\"jiaboyan\"的key:" + ceilingKey);
        SortedMap<String, Integer> sortedMap = treeMap.subMap("a", "my");//获取集合的key从"a"到"jiaboyan"的元素
        System.out.println("获取集合的key从\"a\"到\"jiaboyan\"的元素:" + sortedMap);
        //删除元素：
        Integer removeValue = treeMap.remove("jiaboyan");//删除集合中key为"jiaboyan"的元素
        treeMap.clear(); //清空集合元素：

        //判断方法：
        boolean isEmpty = treeMap.isEmpty();//判断集合是否为空
        boolean isContain = treeMap.containsKey("jiaboyan");//判断集合的key中是否包含"jiaboyan"
    }

}
