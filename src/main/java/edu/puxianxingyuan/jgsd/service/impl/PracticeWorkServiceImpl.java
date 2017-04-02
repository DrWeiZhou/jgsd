package edu.puxianxingyuan.jgsd.service.impl;

import edu.puxianxingyuan.jgsd.base.dao.BaseDao;
import edu.puxianxingyuan.jgsd.base.service.impl.BaseServiceImpl;
import edu.puxianxingyuan.jgsd.dao.PracticeWorkDao;
import edu.puxianxingyuan.jgsd.domain.PracticeWork;
import edu.puxianxingyuan.jgsd.service.PracticeWorkService;
import org.springframework.stereotype.Service;

/**
 * Created by 周炜 on 2017/4/2.
 */
@Service("practiceWorkService")
public class PracticeWorkServiceImpl extends BaseServiceImpl<PracticeWork> implements PracticeWorkService {
    private PracticeWorkDao practiceWorkService;

    @Override
    public BaseDao getBaseDao() {
        return practiceWorkService;
    }
}
