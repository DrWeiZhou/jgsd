package edu.puxianxingyuan.jgsd.service.impl;

import edu.puxianxingyuan.jgsd.base.dao.BaseDao;
import edu.puxianxingyuan.jgsd.base.service.impl.BaseServiceImpl;
import edu.puxianxingyuan.jgsd.dao.WorkDao;
import edu.puxianxingyuan.jgsd.domain.Work;
import edu.puxianxingyuan.jgsd.service.WorkService;
import org.springframework.stereotype.Service;

/**
 * Created by 周炜 on 2017/4/2.
 */
@Service("workService")
public class WorkServiceImpl extends BaseServiceImpl<Work> implements WorkService {
    private WorkDao workService;

    @Override
    public BaseDao getBaseDao() {
        return workService;
    }
}
