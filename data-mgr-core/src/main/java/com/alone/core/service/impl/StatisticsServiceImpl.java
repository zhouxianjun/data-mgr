package com.alone.core.service.impl;

import com.alibaba.fastjson.JSON;
import com.alone.core.mapper.StatisticsMapper;
import com.alone.thrift.service.StatisticsService;
import com.alone.thrift.struct.InvalidOperation;
import com.gary.thriftext.spring.annotation.ThriftService;
import org.apache.thrift.TException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * @author zhouxianjun(Alone)
 *
 * @ClassName:
 * @Description:
 * @date 16-8-4 下午8:54
 */
@ThriftService
public class StatisticsServiceImpl implements StatisticsService.Iface {
    @Autowired
    private StatisticsMapper statisticsMapper;

    @Override
    public String getStaticIndexByDateForSuper(long user, long startDate, long endDate, long province, long city, String sortName, String sortDir) throws InvalidOperation, TException {
        return null;
    }

    @Override
    public String getStaticIndexByDateForAdmin(long user, long startDate, long endDate, long province, long city, String sortName, String sortDir) throws InvalidOperation, TException {
        return JSON.toJSONString(statisticsMapper.getStaticIndexByDate(user, new Date(startDate), new Date(endDate),
                province <= 0 ? null : province, city <= 0 ? null : city, sortName, sortDir));
    }

    @Override
    public String getStaticIndexByDate(long user, long startDate, long endDate, long province, long city, String sortName, String sortDir) throws InvalidOperation, TException {
        return null;
    }
}
