package com.tms.mapper;

import com.tms.vo.ScheduleStatusReportVO;

import java.util.List;

/**
 * Interface for mybatis sql map.
 *
 * @author doyle911
 *
 */
public interface ScheduleMapper {

    public abstract void saveScheduleStatusReport(ScheduleStatusReportVO ssrvo);
    public abstract List<ScheduleStatusReportVO> getScheduleStatusReport();
}
