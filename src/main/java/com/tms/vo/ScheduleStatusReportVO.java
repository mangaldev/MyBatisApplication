package com.tms.vo;

import org.joda.time.DateTime;
import org.joda.time.LocalDateTime;

/**
 * A value object for storing information on a single timeslot status.
 *
 * @author doyle911
 *
 */
public class ScheduleStatusReportVO implements Comparable {


    private LocalDateTime airDateTime;

    private String remoteProgservId;
    private DateTime gmtAirDateTime;



    public ScheduleStatusReportVO(String remoteProgservId, String importToken, DateTime gmtAirDateTime,  String status) {
        this.remoteProgservId = remoteProgservId;
        this.gmtAirDateTime = gmtAirDateTime;
        this.importToken = importToken;
        this.status = status;
    }

    private String importToken;
    private String status;

    public ScheduleStatusReportVO() {

    }

    public String getRemoteProgservId() {
        return remoteProgservId;
    }
    public void setRemoteProgservId(String remoteProgservId) {
        this.remoteProgservId = remoteProgservId;
    }
    public LocalDateTime getAirDateTime() {
        return airDateTime;
    }
    public void setAirDateTime(LocalDateTime airDateTime) {
        this.airDateTime = airDateTime;
    }
    public String getImportToken() {
        return importToken;
    }
    public void setImportToken(String importToken) {
        this.importToken = importToken;
    }


    public int compareTo(Object o) {
        // TODO Auto-generated method stub
        return 0;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((airDateTime == null) ? 0 : airDateTime.hashCode());
        result = prime * result + ((importToken == null) ? 0 : importToken.hashCode());
        result = prime * result + ((remoteProgservId == null) ? 0 : remoteProgservId.hashCode());
        result = prime * result + ((gmtAirDateTime == null) ? 0 : gmtAirDateTime.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ScheduleStatusReportVO other = (ScheduleStatusReportVO) obj;
        if (airDateTime == null) {
            if (other.airDateTime != null)
                return false;
        } else if (!airDateTime.equals(other.airDateTime))
            return false;
        if (importToken == null) {
            if (other.importToken != null)
                return false;
        } else if (!importToken.equals(other.importToken))
            return false;
        if (remoteProgservId == null) {
            if (other.remoteProgservId != null)
                return false;
        } else if (!remoteProgservId.equals(other.remoteProgservId))
            return false;
        if (gmtAirDateTime == null) {
            if (other.gmtAirDateTime != null)
                return false;
        } else if (!gmtAirDateTime.equals(other.gmtAirDateTime))
            return false;
        return true;
    }

    public DateTime getGmtAirDateTime() {
        return gmtAirDateTime;
    }

    public void setGmtAirDateTime(DateTime gmtAirDateTime) {
        this.gmtAirDateTime = gmtAirDateTime;
    }

    @Override
    public String toString() {
        return "ScheduleStatusReportVO{" +
                " remoteProgservId='" + remoteProgservId + '\'' +
                ", gmtAirDateTime=" + gmtAirDateTime +
                ", importToken='" + importToken + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
