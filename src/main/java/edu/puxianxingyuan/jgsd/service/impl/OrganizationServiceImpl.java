package edu.puxianxingyuan.jgsd.service.impl;

import edu.puxianxingyuan.jgsd.base.dao.BaseDao;
import edu.puxianxingyuan.jgsd.base.service.impl.BaseServiceImpl;
import edu.puxianxingyuan.jgsd.dao.OrganizationDao;
import edu.puxianxingyuan.jgsd.domain.Organization;
import edu.puxianxingyuan.jgsd.service.OrganizationService;
import org.springframework.stereotype.Service;

/**
 * Created by 周炜 on 2017/4/2.
 */
@Service("organizationService")
public class OrganizationServiceImpl extends BaseServiceImpl<Organization> implements OrganizationService {
    private OrganizationDao organizationService;

    @Override
    public BaseDao getBaseDao() {
        return organizationService;
    }
}
