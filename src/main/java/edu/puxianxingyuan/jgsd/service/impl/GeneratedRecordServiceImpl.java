package edu.puxianxingyuan.jgsd.service.impl;

import edu.puxianxingyuan.jgsd.base.dao.BaseDao;
import edu.puxianxingyuan.jgsd.base.service.impl.BaseServiceImpl;
import edu.puxianxingyuan.jgsd.dao.GeneratedRecordDao;
import edu.puxianxingyuan.jgsd.domain.GeneratedRecord;
import edu.puxianxingyuan.jgsd.service.GeneratedRecordService;
import edu.puxianxingyuan.jgsd.util.DateUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by 周炜 on 2017/3/31.
 */
@Service("generatedRecordService")
public class GeneratedRecordServiceImpl extends BaseServiceImpl<GeneratedRecord> implements GeneratedRecordService {

    @Resource
    GeneratedRecordDao generatedRecordDao;

    @Override
    public BaseDao getBaseDao() {
        return generatedRecordDao;
    }

    @Override
    public boolean isYesterdayGenerated() {
        Date yesterDate = DateUtil.getYesterDate(DateUtil.changeLocale(new Date()));
        System.out.println("-----------当前启动检查的机器时间为："+new Date());
        System.out.println("-----------当前启动检查的业务时间为："+DateUtil.changeLocale(new Date()));

        List<GeneratedRecord> yesterdayGeneratedRecord = generatedRecordDao.findByHql("from GeneratedRecord gr where gr.theDate = ?0", yesterDate);
        if(yesterdayGeneratedRecord == null || yesterdayGeneratedRecord.size() < 1){
            System.out.println("----------检查昨日生成记录"+yesterDate+"没有生成");
            return false;
        }
        else{
            System.out.println("----------检查昨日生成记录"+yesterDate+"已经生成");
            return true;
        }

    }
}
