package edu.puxianxingyuan.jgsd.service.impl;

import edu.puxianxingyuan.jgsd.base.dao.BaseDao;
import edu.puxianxingyuan.jgsd.base.service.impl.BaseServiceImpl;
import edu.puxianxingyuan.jgsd.dao.PracticeDao;
import edu.puxianxingyuan.jgsd.domain.PracticeUserWork;
import edu.puxianxingyuan.jgsd.service.PracticeUserWorkService;
import org.springframework.stereotype.Service;

/**
 * Created by 周炜 on 2017/4/2.
 */
@Service("practiceUserWorkService")
public class PracticeUserWorkServiceImpl extends BaseServiceImpl<PracticeUserWork> implements PracticeUserWorkService {
    private PracticeDao practiceUserWorkService;

    @Override
    public BaseDao getBaseDao() {
        return practiceUserWorkService;
    }
}
