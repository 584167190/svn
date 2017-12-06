package com.test.service;

import com.test.dao.CommdityDao;
import com.test.dao.ImgsDao;
import com.test.entity.Commodity;
import com.test.utiil.ThreadUtil;
import com.test.utiil.UUIDUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CommodityService {
    @Resource
    private CommdityDao cd;

    @Resource
    private ImgsDao imgsDao;

    public List<Commodity> findAllComms(){
        return cd.findAllComms();
    }

    @Transactional
    public void addComms(MultipartFile file, Map<String, String> map) {
        String owner = UUIDUtil.createID();
        ThreadUtil.poll.execute(new Runnable() {
            @Override
            public void run() {
                File path = new File("D:/image/" + file.getOriginalFilename());
                Map<String,Object> m = new HashMap<>();
                m.put("path",path.getAbsolutePath());
                m.put("owner",owner);
                try {
                    file.transferTo(path);
                    imgsDao.saveImg(m);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        map.put("sku",owner);
        cd.addComms(map);
    }

    public Commodity findCommodityBySku(String sku) {
        return cd.findCommodityBySku(sku);
    }
}
