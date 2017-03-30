package edu.puxianxingyuan.jgsd.dao.impl;

import edu.puxianxingyuan.jgsd.base.dao.impl.BaseDaoImpl;
import edu.puxianxingyuan.jgsd.dao.UserDao;
import edu.puxianxingyuan.jgsd.domain.User;
import org.springframework.stereotype.Repository;

/**
 * Created by 周炜 on 2017/3/30.
 */
@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

}
