package com.ele.system.service;

import com.ele.system.dao.ITestDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 
 * @author wangping-ds5
 *
 */
@Service
public class TestService {

    @Autowired
    private ITestDao testDao;

    public Map<String,Object> testServiceMethod(){

       return testDao.testIdaoMethod();
    }

}
