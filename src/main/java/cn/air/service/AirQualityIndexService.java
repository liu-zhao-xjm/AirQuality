package cn.air.service;

import cn.air.pojo.AirQualityIndex;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AirQualityIndexService {
    //分页查询
    public List<AirQualityIndex> getAirList(Integer id, Integer currentPageNo, Integer pageSize);

    //查询数量
    public Integer count(Integer id);

    //添加
    public boolean addAir(AirQualityIndex airQualityIndex);

    //查询单条信息
    public AirQualityIndex air(Integer id);

    //修改信息
    public boolean updateAir(AirQualityIndex airQualityIndex);

    //删除
    public boolean deleteAir(@Param("id") Integer id);
}
