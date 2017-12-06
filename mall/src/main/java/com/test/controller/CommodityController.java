package com.test.controller;

import com.test.entity.Commodity;
import com.test.service.CommodityService;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfig;

import javax.annotation.Resource;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class CommodityController {
    @Resource
    private CommodityService cs;
    @Resource
    private FreeMarkerConfig freeMarkerConfig;
    @RequestMapping("findAllComms")
    public List<Commodity> findAllComms(){
        return cs.findAllComms();
    }

    @RequestMapping("addCommodity")
    public String addComms(@RequestParam("f1") MultipartFile  file, @RequestParam Map<String,String> map){
       cs.addComms(file,map);
       return "添加成功";
    }
    @RequestMapping("showCommodity")
    public String showCommodity(String sku){
         Commodity comm =  cs.findCommodityBySku(sku);
        try {
            Map<String,Object> map = new HashMap<>();
            map.put("comm",comm);
            //模板对象  item.ftl
            Template template = freeMarkerConfig.getConfiguration().getTemplate("item.ftl");
            //用模板生成哪一个静态html
            FileWriter out = new FileWriter("D:/image/"+sku+".html");

            //创建静态页面
            template.process(map,out);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }
        return "1";
    }
}
