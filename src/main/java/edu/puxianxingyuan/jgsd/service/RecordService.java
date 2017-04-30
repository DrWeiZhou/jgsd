package edu.puxianxingyuan.jgsd.service;

import edu.puxianxingyuan.jgsd.base.service.BaseService;
import edu.puxianxingyuan.jgsd.domain.Record;
import edu.puxianxingyuan.jgsd.domain.User;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by 周炜 on 2017/3/30.
 */
public interface RecordService extends BaseService<Record>{
    void saveRecord(Record record);

    Record getUserSameDayRecord(User user);

    List<Record> getUserRecords(User user);

    Map<String,Integer> getUserTotalRecords(User user);

    List<Record> getTheDayRecords(Date date);

    void generateTheDayRecords();
}
