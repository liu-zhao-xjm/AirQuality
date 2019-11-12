package cn.air.service;

import cn.air.mapper.AirQualityIndexMapper;
import cn.air.pojo.AirQualityIndex;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AirQualityIndexServiceImpl implements AirQualityIndexService {
    @Resource
    private AirQualityIndexMapper airQualityIndexMapper;

    @Override
    public List<AirQualityIndex> getAirList(Integer id, Integer currentPageNo, Integer pageSize) {
        /* 1  5*/
        currentPageNo = (currentPageNo - 1) * pageSize;
        pageSize = currentPageNo + pageSize;

        return airQualityIndexMapper.getAirList(id, currentPageNo, pageSize);
    }

    @Override
    public Integer count(Integer id) {
        return airQualityIndexMapper.count(id);
    }

    @Override
    public boolean addAir(AirQualityIndex airQualityIndex) {
        System.out.println(airQualityIndex.toString());
        Integer sum = airQualityIndexMapper.addAir(airQualityIndex);
        System.out.println(sum + ":111111");
        if (sum > 0) {
            return true;
        }
        return false;
    }

    @Override
    public AirQualityIndex air(Integer id) {
        return airQualityIndexMapper.air(id);
    }

    @Override
    public boolean updateAir(AirQualityIndex airQualityIndex) {
        Integer sum = airQualityIndexMapper.updateAir(airQualityIndex);
        if (sum > 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteAir(Integer id) {
        Integer sum = airQualityIndexMapper.deleteAir(id);
        if (sum > 0) {
            return true;
        }
        return false;
    }
}
