import com.tms.mapper.ScheduleMapper;
import com.tms.vo.ScheduleStatusReportVO;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.ibatis.common.resources.Resources;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

class MyBatisPlayground {
    public static void main(String... args) {
        DateTimeFormatter formatter = DateTimeFormat.forPattern("dd/MM/yyyy HH:mm:ss");
        DateTime dt = formatter.parseDateTime("21/09/2015 16:00:00");
        List<ScheduleStatusReportVO> scheduleStatusReportVOList = getReports();
        for(ScheduleStatusReportVO report: scheduleStatusReportVOList)
            System.out.println(report);
//        scheduleStatusReportVOList.add(new ScheduleStatusReportVO("11630","epgs-au-atv",dt,"COMPLETE"));
//        updateReport(scheduleStatusReportVOList, ExecutorType.BATCH, false);
//        updateReport(scheduleStatusReportVOList, ExecutorType.SIMPLE, true);
    }

    public static List<ScheduleStatusReportVO> getReports() {
        System.out.println("Starting getReports");
        List<ScheduleStatusReportVO> scheduleStatusReportVOSet = null;
        SqlSession sqlSession = null;
        try {
            sqlSession = getSQLSession(ExecutorType.SIMPLE,true);
            scheduleStatusReportVOSet = sqlSession.getMapper(ScheduleMapper.class).getScheduleStatusReport();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null)
                sqlSession.close();
        }
        return scheduleStatusReportVOSet;
    }


    public static void updateReport(List<ScheduleStatusReportVO> scheduleStatusReportVOSet, ExecutorType type, boolean isAutoCommit) {
        System.out.println("Starting Batched Update ");
        Long start = System.currentTimeMillis();
        SqlSession sqlSession = null;
        try {
            sqlSession = getSQLSession(type,isAutoCommit);
            final ScheduleMapper mapper = sqlSession.getMapper(ScheduleMapper.class);
            for (ScheduleStatusReportVO scheduleStatusReportVO : scheduleStatusReportVOSet) {
                System.out.println(" calling saveScheduleStatusReport");
                mapper.saveScheduleStatusReport(scheduleStatusReportVO);
            }
            if (!isAutoCommit)
                sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null)
                sqlSession.close();
        }
        System.out.println("Time taken in Batched Mode : " + (System.currentTimeMillis() - start) + " millisec");
    }

    public static SqlSession getSQLSession(ExecutorType type, boolean isAutoCommit) throws Exception{
        String resource = "mybatis/mybatis-standalone-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        return sqlSessionFactory.openSession(type, isAutoCommit);
    }
}