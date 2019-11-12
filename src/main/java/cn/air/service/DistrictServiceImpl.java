package cn.air.service;

import cn.air.mapper.DistrictMapper;
import cn.air.pojo.District;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DistrictServiceImpl implements DistrictService {
    @Resource
    private DistrictMapper districtMapper;

    @Override
    public List<District> getDistList() {
        return districtMapper.getDistList();
    }
}
