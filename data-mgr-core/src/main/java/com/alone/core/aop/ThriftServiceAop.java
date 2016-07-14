package com.alone.core.aop;

import com.alone.common.dto.DataSourceType;
import com.alone.common.mybatis.DataSource;
import com.alone.common.mybatis.DataSourceHolder;
import com.alone.thrift.struct.InvalidOperation;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author zhouxianjun(Alone)
 * @ClassName:
 * @Description:
 * @date 2016/7/14 9:57
 */
@Component
@Aspect
@Slf4j
public class ThriftServiceAop {
    @Pointcut("execution(* com.alone.core.service.impl..*(..))")
    private void allMethod() {}

    @Before("allMethod()")
    public void doDataSource(JoinPoint point){
        MethodSignature methodSignature = (MethodSignature) point.getSignature();
        Method method = methodSignature.getMethod();
        DataSource dataSource = AnnotationUtils.getAnnotation(method, DataSource.class);
        DataSourceType dataSourceType = dataSource == null ? DataSourceType.WRITE : dataSource.value();
        DataSourceHolder.changeDs(dataSourceType);
        log.debug("method<${}> change data source ==> {}", method.getName(), dataSourceType);
    }

    @Order(1)
    @AfterThrowing(value = "allMethod()", throwing = "ex")
    public void doAfterThrow(Throwable ex) throws InvalidOperation {
        log.error("Thrift service 异常:", ex);
        throw new InvalidOperation(500, "调用接口异常");
    }
}
