package edu.puxianxingyuan.jgsd.service;

import edu.puxianxingyuan.jgsd.base.service.BaseService;
import edu.puxianxingyuan.jgsd.domain.GeneratedRecord;

/**
 * Created by 周炜 on 2017/3/31.
 */
public interface GeneratedRecordService extends BaseService<GeneratedRecord> {
    boolean isYesterdayGenerated();
}
