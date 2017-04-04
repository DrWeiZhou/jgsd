package edu.puxianxingyuan.jgsd.service.impl;

import edu.puxianxingyuan.jgsd.base.dao.BaseDao;
import edu.puxianxingyuan.jgsd.base.service.impl.BaseServiceImpl;
import edu.puxianxingyuan.jgsd.dao.UserDao;
import edu.puxianxingyuan.jgsd.domain.User;
import edu.puxianxingyuan.jgsd.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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

    @Override
    public User isValidUser(User user) {
        User rst = null;
        if(user.getUserName() != null && user.getPassword() != null){
            List<User> userList = userDao.findByHql("from User u where u.userName = ?0 and u.password = ?1", user.getUserName(), user.getPassword());
            if(userList != null && userList.size() == 1)
                rst = userList.get(0);
        }
        return rst;
    }

    @Override
    public boolean isSameUserName(User user) {
        boolean rst = false;
        List<User> userList = userDao.findByHql("from User u where u.userName = ?0 ", user.getUserName());
        if(userList != null && userList.size() > 0)
            rst = true;
        return rst;
    }
}
