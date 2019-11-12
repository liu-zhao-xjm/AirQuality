package cn.air.pojo;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

@Data
public class AirQualityIndex {
    private Integer id;
    private Integer districtId;
    private String monitorTime;
    private Integer pm10;
    private Integer pm;
    private String monitoringStation;
    private String lastModifyTime;
    private String name;
}
