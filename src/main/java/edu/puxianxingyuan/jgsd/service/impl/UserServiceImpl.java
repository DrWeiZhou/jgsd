package edu.puxianxingyuan.jgsd.service.impl;

import edu.puxianxingyuan.jgsd.base.dao.BaseDao;
import edu.puxianxingyuan.jgsd.base.service.impl.BaseServiceImpl;
import edu.puxianxingyuan.jgsd.dao.UserDao;
import edu.puxianxingyuan.jgsd.domain.User;
import edu.puxianxingyuan.jgsd.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by 周炜 on 2017/3/30.
 */
@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

    @Resource
    UserDao userDao;
    @Override
    public BaseDao getBaseDao() {
        return this.userDao;
    }
}
