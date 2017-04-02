package edu.puxianxingyuan.jgsd.service.impl;

import edu.puxianxingyuan.jgsd.base.dao.BaseDao;
import edu.puxianxingyuan.jgsd.base.service.impl.BaseServiceImpl;
import edu.puxianxingyuan.jgsd.dao.AdministratorDao;
import edu.puxianxingyuan.jgsd.domain.Administrator;
import edu.puxianxingyuan.jgsd.service.AdministratorService;
import org.springframework.stereotype.Service;

/**
 * Created by 周炜 on 2017/4/2.
 */
@Service("administratorService")
public class AdministratorServiceImpl extends BaseServiceImpl<Administrator> implements AdministratorService{
    private AdministratorDao administratorService;

    @Override
    public BaseDao getBaseDao() {
        return administratorService;
    }
}
