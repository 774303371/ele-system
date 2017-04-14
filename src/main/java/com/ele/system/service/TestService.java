package com.ele.system.service;

import com.ele.system.dao.ITestDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

/**
 * 
 * @author wangping-ds5
 *
 */
@Service
public class TestService {

    @Resource
    private ITestDao testDao;

    public Map<String,Object> testServiceMethod(){
        System.out.println("TestService.testServiceMethod");
       return null;//testDao.testIdaoMethod();
    }

}
