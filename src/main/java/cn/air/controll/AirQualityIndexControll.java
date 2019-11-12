package cn.air.controll;

import cn.air.pojo.AirQualityIndex;
import cn.air.pojo.District;
import cn.air.service.AirQualityIndexService;
import cn.air.service.DistrictService;
import cn.air.util.Constants;
import cn.air.util.JsonMsg;
import cn.air.util.PageSupport;
import cn.air.util.Tool;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/air")
public class AirQualityIndexControll {
    @Resource
    private AirQualityIndexService airQualityIndexService;
    @Resource
    private DistrictService districtService;

    //分页查询
    @RequestMapping(value = "/pagelist.html", method = RequestMethod.GET)
    public String pagelist(@RequestParam(value = "pageIndex", required = false) String pageIndex,
                           @RequestParam(value = "districtId", required = false) Integer disid, Model model) {
        int pageSize = Constants.pageSize;//5
        //当前页码
        int currentPageNo = 1;
        if (pageIndex != null) {
            try {
                currentPageNo = Integer.valueOf(pageIndex); //页的容量
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }

        //查询总数量
        Integer totalCount = airQualityIndexService.count(disid);
        PageSupport pages = new PageSupport();
        pages.setCurrentPageNo(currentPageNo);//页的下标
        pages.setPageSize(pageSize);//页面容量
        pages.setTotalCount(totalCount);//总条数
        //查询总数量
        int totalPageCount = pages.getTotalPageCount();

        /*Integer countAir = airQualityIndexService.count();*/

        //分页查询
        if (currentPageNo < 1) {
            currentPageNo = 1;
        } else if (currentPageNo > totalPageCount) {
            currentPageNo = totalPageCount;
        }
        List<AirQualityIndex> airQualityIndices = airQualityIndexService.getAirList(disid, currentPageNo, pageSize);
        //查询区域
        List<District> districtList = districtService.getDistList();
        model.addAttribute("airQualityIndices", airQualityIndices);
        model.addAttribute("districtList", districtList);
        model.addAttribute("pages", pages);
        return "index";
    }

    //打开添加页面
    @RequestMapping(value = "/openAdd.html")
    public String openAdd(Model model) {
        //查询区域
        List<District> districtList = districtService.getDistList();
        model.addAttribute("districtList", districtList);

        return "addAir";
    }

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");


    //添加方法
    @RequestMapping(value = "/addAir", method = RequestMethod.POST)
    @ResponseBody
    public JsonMsg addAir(AirQualityIndex airQualityIndex) {

        airQualityIndex.setLastModifyTime(sdf.format(new Date()));

        System.out.println(airQualityIndex.toString());
        if (airQualityIndexService.addAir(airQualityIndex)) {

            System.out.println("执行成功");
            return JsonMsg.success();
        } else {

            System.out.println("执行失败");
            return JsonMsg.fail().addInfo("add_error", "添加失败");
        }

    }


    //打开删除界面
    @RequestMapping(value = "/openupdate.html", method = RequestMethod.GET)
    public String openUpdate(@RequestParam(value = "id") String id, Model model) {
        Integer _id = Integer.parseInt(id);
        //查询单条记录
        AirQualityIndex qualityIndex = airQualityIndexService.air(_id);
        //查询区域的值
        List<District> distList = districtService.getDistList();
        model.addAttribute("districtList", distList);
        model.addAttribute("qualityIndex", qualityIndex);
        return "updateAir";
    }

    //执行删除操作
    @RequestMapping(value = "/update", method = RequestMethod.GET)
    @ResponseBody
    public JsonMsg update(AirQualityIndex airQualityIndex) {

        airQualityIndex.setLastModifyTime(sdf.format(new Date()));
        if (airQualityIndexService.updateAir(airQualityIndex)) {

            System.out.println("执行成功");

            return JsonMsg.success();
        } else {

            System.out.println("执行失败");
            return JsonMsg.fail().addInfo("upd_error", "修改失败");
        }
    }

    //执行删除操作
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    @ResponseBody
    public JsonMsg delete(AirQualityIndex airQualityIndex) {
        if (airQualityIndexService.deleteAir(airQualityIndex.getId())) {
            return JsonMsg.success();
        } else {
            System.out.println("执行失败");
            return JsonMsg.fail().addInfo("del_error", "删除失败");
        }
    }

}
