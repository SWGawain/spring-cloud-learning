package org.wjw.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wjw.datasource.FpOrderMapper;

import java.util.Map;

@RestController
@RequestMapping("/data")
public class DataController {

    private static Logger log = LoggerFactory.getLogger(DataController.class);

    @Autowired
    FpOrderMapper fpOrderMapper;

    @GetMapping("/get")
    public String get(Long id){
        log.info("id:"+id);
        Map map = fpOrderMapper.selectByPrimaryKey(id);
        try {
            return new ObjectMapper().writeValueAsString(map);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return "";
    }
}
