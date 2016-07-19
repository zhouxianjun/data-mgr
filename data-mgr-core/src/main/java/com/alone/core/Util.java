package com.alone.core;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alone.common.dto.Page;
import com.alone.thrift.struct.PageParamStruct;
import com.alone.thrift.struct.PageStruct;

import java.util.List;

/**
 * @author zhouxianjun(Alone)
 * @ClassName:
 * @Description:
 * @date 16-7-19 下午7:52
 */
public class Util {
    public static <T> PageStruct buildListPage(PageParamStruct page, PageMapper<T> pageMapper) {
        Page<T> p = new Page<>();
        p.setPageNum(page.getPage());
        p.setPageSize(page.getPageSize());
        List list = pageMapper.listByPage(p, page.getSortName(), page.getSortDir());
        return new PageStruct(p.getPageNum(), p.getPageSize(),
                p.getCount(), page.getPage(), JSONArray.toJSONString(list, SerializerFeature.WriteMapNullValue));
    }
}
