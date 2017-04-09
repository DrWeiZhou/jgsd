package edu.puxianxingyuan.jgsd.service.impl;

import edu.puxianxingyuan.jgsd.base.dao.BaseDao;
import edu.puxianxingyuan.jgsd.base.service.impl.BaseServiceImpl;
import edu.puxianxingyuan.jgsd.dao.RecordDao;
import edu.puxianxingyuan.jgsd.dao.UserDao;
import edu.puxianxingyuan.jgsd.domain.GeneratedRecord;
import edu.puxianxingyuan.jgsd.domain.Record;
import edu.puxianxingyuan.jgsd.domain.User;
import edu.puxianxingyuan.jgsd.service.GeneratedRecordService;
import edu.puxianxingyuan.jgsd.service.RecordService;
import edu.puxianxingyuan.jgsd.util.DateUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by 周炜 on 2017/3/30.
 */
@Service("recordService")
public class RecordServiceImpl extends BaseServiceImpl<Record> implements RecordService {

    @Resource
    RecordDao recordDao;

    @Resource
    UserDao userDao;

    @Resource
    GeneratedRecordService generatedRecordService;

    @Override
    public BaseDao getBaseDao() {
        return recordDao;
    }

    @Override
    public void saveRecord(Record record) {
        Record sameDayRecord = getUserSameDayRecord(record.getUser());
        if(sameDayRecord == null){//没有当天记录新建
            recordDao.save(record);
        }else{//存在当天记录，更新
            record.setId(sameDayRecord.getId());
            recordDao.updateByDTO(record);
        }
    }

    @Override
    public Record getUserSameDayRecord(User user) {
        Record rcd = null;
        List<Record> recordList = recordDao.findByHql("from Record r where r.user = ?0 and r.theDate = ?1", user, DateUtil.getTheDate(DateUtil.changeLocale(new Date())));
        if(recordList != null && recordList.size() > 0){
            rcd = recordList.get(0);
        }
        return rcd;
    }

    @Override
    public List<Record> getUserRecords(User user) {
        List<Record> rst = new ArrayList<Record>();
        rst = recordDao.findByHql("from Record r where r.user = ?0", user);
        return rst;
    }

    @Override
    public List<Record> getTheDayRecords(Date date) {
        List<Record> rst = new ArrayList<Record>();
        rst = recordDao.findByHql("from Record r where r.theDate = ?0", DateUtil.getYesterDate(DateUtil.changeLocale(date)));
        return rst;
    }

    @Override
    public void generateTheDayRecords() {//生成昨天的记录，自己输入的有可能是当天的，但是生成一定是12点1分生成昨天的
//        System.out.println("i am invoked!");
       if(!generatedRecordService.isYesterdayGenerated()){//未生成记录
            List<User> allUsers = userDao.findByHql("from User u where u.recordType = ?0", 1);
            if(allUsers != null){
                for(User user : allUsers){//对所有定课用户操作
                    //获得昨天的记录
                    List<Record> yesterdayRecord = recordDao.findByHql("from Record r where r.user = ?0 and r.theDate = ?1", user, DateUtil.getYesterDate(DateUtil.changeLocale(new Date())));
                    if(yesterdayRecord == null || yesterdayRecord.size() < 1){//不存在记录
                        Record record= new Record();
                        record.setUser(user);
                        record.setDailyJgsdBZM(user.getDailyJgsdBZM());
                        record.setDailyJgsdXZ(user.getDailyJgsdXZ());
                        record.setTheDate(DateUtil.getYesterDate(DateUtil.changeLocale(new Date())));
                        recordDao.save(record);
                    }
                }
            }
           System.out.println("---------Record is generated!");
            //创建生成记录
           generatedRecordService.save(new GeneratedRecord());
           System.out.println("---------GeneratedRecord is generated!生成业务日期为"+DateUtil.getYesterDate(DateUtil.changeLocale(new Date()))+"的记录及生成记录！");
        }//if ygr


    }
}
