package com.open.little.config;

import java.util.HashMap;
import java.util.Map;


/**
 * <p>本地线程资源管理器</p>
 * 
 * <p>提供便捷的绑定资源到本地线程的方法</p>
 * <p>使用本类，必须要注意进行资源释放，否则会有十分严重的后果。</p>
 * <p>如果你没有掌握ThreadLocal类，那么请不要使用本类。 </p>
 * @see ThreadLocal
 * @author ning.li
 * @version 2016-03-08
 */
public abstract class ThreadResources {

    @SuppressWarnings("rawtypes")
	private static final ThreadLocal resources = new ThreadLocal();

    /**
     * 根据key获取绑定到线程中的资源。
     */
    public static Object getResource(Object actualKey) {
        Object value = doGetResource(actualKey);
        return value;
    }

    /**
     * 绑定资源到当前线程。
     * @param actualKey 资源的key
     * @param value 资源
     * @throws IllegalStateException
     */
    public static void bindResource(Object actualKey, Object value)
            throws IllegalStateException {
        Map map = (Map) resources.get();
        // set ThreadLocal Map if none found
        if (map == null) {
            map = new HashMap();
            resources.set(map);
        }
        map.put(actualKey, value);
    }

    /**
     * 根据key解除资源绑定。
     * @param actualKey 资源的key
     * @return actualKey对应的值
     * @throws IllegalStateException
     */
    public static Object unbindResource(Object actualKey)
            throws IllegalStateException {
        Object value = doUnbindResource(actualKey);
        return value;
    }

    private static Object doUnbindResource(Object actualKey) {
        Map map = (Map) resources.get();
        if (map == null) {
            return null;
        }
        Object value = map.remove(actualKey);
        // Remove entire ThreadLocal if empty...
        if (map.isEmpty()) {
            resources.set(null);
        }
        return value;
    }

    /**
     * 根据key判断是否绑定了这个资源。
     * @param actualKey 资源的key
     * @return 有且不为null则返回true
     */
    public static boolean hasResource(Object actualKey) {
        Object value = doGetResource(actualKey);
        return (value != null);
    }

    private static Object doGetResource(Object actualKey) {
        Map map = (Map) resources.get();
        if (map == null) {
            return null;
        }
        return map.get(actualKey);
    }

    /**
     * 清空所有的资源。
     */
    public static void clear() {
        resources.set(null);
    }

}
