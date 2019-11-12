package cn.air.mapper;

import cn.air.pojo.AirQualityIndex;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AirQualityIndexMapper {
    //分页查询
    public List<AirQualityIndex> getAirList(@Param("id") Integer id, @Param("currentPageNo") Integer currentPageNo, @Param("pageSize") Integer pageSize);

    //查询数量
    public Integer count(@Param( "id") Integer id);

    //添加
    public Integer addAir(AirQualityIndex airQualityIndex);

    //查询单条信息
    public AirQualityIndex air(@Param("id") Integer id);

    //修改信息
    public Integer updateAir(AirQualityIndex airQualityIndex);

    //删除
    public Integer deleteAir(@Param("id") Integer id);
}
