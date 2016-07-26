package com.alone.core.service.impl;

import com.alone.common.entity.UserRef;
import com.alone.common.enums.RefType;
import com.alone.core.mapper.AppMapper;
import com.alone.core.mapper.UserRefMapper;
import com.alone.thrift.service.UserRefService;
import com.alone.thrift.struct.InvalidOperation;
import com.gary.thriftext.spring.annotation.ThriftService;
import org.apache.thrift.TException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author zhouxianjun(Alone)
 * @ClassName:
 * @Description:
 * @date 16-7-17 下午8:37
 */
@ThriftService
@Transactional(rollbackFor = {Exception.class, RuntimeException.class})
public class UserRefServiceImpl implements UserRefService.Iface {

    @Autowired
    private UserRefMapper userRefMapper;

    @Autowired
    private AppMapper appMapper;
    
    @Override
    public boolean setRef(long user, List<Long> refs, int type) throws InvalidOperation, TException {
        Example example = new Example(UserRef.class);
        example.createCriteria().andEqualTo("user_id", user).andEqualTo("type", type);
        userRefMapper.deleteByExample(example);
        int count = 0;
        if (refs != null) {
            for (Long ref : refs) {
                if (ref != null && ref > 0) {
                    UserRef r = new UserRef();
                    r.setUser_id(user);
                    r.setRef_id(ref);
                    r.setType(type);
                    count += userRefMapper.insert(r);
                }
            }
            if (count != refs.size())
                throw new InvalidOperation(500, "操作失败");
        }
        return true;
    }

    @Override
    public boolean setRefs(long user, List<Long> box, List<Long> app_package, List<Long> require_package, List<Long> app_white, List<Long> install_active) throws InvalidOperation, TException {
        return setRef(user, box, RefType.BOX.getVal()) &&
                setRef(user, app_package, RefType.APP_PACKAGE.getVal()) &&
                setRef(user, require_package, RefType.REQUIRE_PACKAGE.getVal()) &&
                setRef(user, app_white, RefType.WHITE.getVal()) &&
                setRef(user, install_active, RefType.ACTIVE.getVal());
    }
}
