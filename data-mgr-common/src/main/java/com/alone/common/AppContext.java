package com.alone.common;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Iterator;
import java.util.Map;

/**
 * @author zhouxianjun(Alone)
 * @ClassName:
 * @Description:
 * @date 2016/7/8 12:48
 */
public class AppContext {
    private static AbstractApplicationContext applicationContext;

    public AppContext(String[] paths) {
        applicationContext = new ClassPathXmlApplicationContext(paths);
    }
    @SuppressWarnings("unchecked")
    public static <T> T getBeanByName(String name) {
        return (T) applicationContext.getBean(name);
    }
    public static <T> T getBean(Class<T> beanClass) {
        if (applicationContext == null)
            return null;
        Map<String, T> beanMap = applicationContext.getBeansOfType(beanClass);
        Iterator<T> iterator = beanMap.values().iterator();
        return iterator.hasNext() ? iterator.next() : null;
    }
    public static <T> Map<String, T> getBeansOfType(Class<T> beanClass){
        return applicationContext.getBeansOfType(beanClass);
    }
    public static <T> T getBean(String name, Class<T> requiredType) {
        try {
            T t = applicationContext.getBean(name, requiredType);
            return t;
        } catch(Exception e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    public static AbstractApplicationContext getApplicationContext(){
        return applicationContext;
    }

    public static void destroy() {
        applicationContext.destroy();
    }
}
