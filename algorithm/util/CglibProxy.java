package util;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 *<p>Description:${Description}</p>

 *<p>Create Date:2019年11月30日</p>
 *@author:wangjianghe
 *@version 1.0
 */
public class CglibProxy implements MethodInterceptor {
    public Object newInstall(Object o){
        return Enhancer.create(o.getClass(),this);
    }
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        long startTime = System.nanoTime();
        methodProxy.invokeSuper(o,objects);
        long endTime = System.nanoTime();
        long msTime = (endTime - startTime) / 1000000;
        long sTime = msTime / 1000;
        System.out.println(methodProxy.getSuperName()+" 时间：" + (endTime - startTime) + "ns  " + msTime + "ms  " + sTime + "s  ");
        return null;
    }
}
