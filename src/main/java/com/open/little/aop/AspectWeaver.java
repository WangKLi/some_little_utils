package com.open.little.aop;

/**
 * @Author: liwang
 * Date:     2022/1/12 8:07 PM
 * 切面织入器
 */
public class AspectWeaver {
    private BeanContainer beanContainer;

    public AspectWeaver(){
        beanContainer = BeanContainer.getInstance();
    }

    public void doAop(){
        // 获取所有切面类

    }
}
