package edu.puxianxingyuan.jgsd.service.impl;

import edu.puxianxingyuan.jgsd.base.dao.BaseDao;
import edu.puxianxingyuan.jgsd.base.service.impl.BaseServiceImpl;
import edu.puxianxingyuan.jgsd.dao.PracticeDao;
import edu.puxianxingyuan.jgsd.domain.Practice;
import edu.puxianxingyuan.jgsd.service.PracticeService;
import org.springframework.stereotype.Service;

/**
 * Created by 周炜 on 2017/4/2.
 */
@Service("practiceService")
public class PracticeServiceImpl extends BaseServiceImpl<Practice> implements PracticeService {
    private PracticeDao practiceService;

    @Override
    public BaseDao getBaseDao() {
        return practiceService;
    }
}
