package cn.air.util;

import cn.air.pojo.AirQualityIndex;
import cn.air.pojo.District;
import cn.air.service.AirQualityIndexService;
import cn.air.service.DistrictService;
import org.springframework.beans.factory.InitializingBean;

import org.springframework.web.context.ServletContextAware;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import java.util.List;

/**
 * 初始加载数据
 */
public class InitDataListener implements InitializingBean, ServletContextAware {
    @Resource
    private AirQualityIndexService airQualityIndexService;
    @Resource
    private DistrictService districtService;

    @Override
    public void afterPropertiesSet() throws Exception {
    }

    @Override
    public void setServletContext(ServletContext arg0) {

        Integer totalCount = airQualityIndexService.count(null);
        PageSupport pages = new PageSupport();
        pages.setCurrentPageNo(1);//页的下标
        pages.setPageSize(5);//页面容量
        pages.setTotalCount(totalCount);//总条数
        //查询总数量
        int totalPageCount = pages.getTotalPageCount();
        List<AirQualityIndex> airQualityIndices = airQualityIndexService.getAirList(null, 1, 5);
        //查询区域
        List<District> districtList = districtService.getDistList();
        arg0.setAttribute("airQualityIndices", airQualityIndices);
        arg0.setAttribute("districtList", districtList);
        arg0.setAttribute("pages", pages);
    }


}