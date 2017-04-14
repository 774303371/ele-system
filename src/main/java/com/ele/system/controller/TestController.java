package com.ele.system.controller;

import java.net.InetAddress;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ele.system.service.TestService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {
	
	private static final Log log = LogFactory.getLog(TestController.class);

	@Resource
	private TestService testService;
	

	@RequestMapping(value="/testGetView", method = {RequestMethod.GET})
	public ModelAndView testGetView() {

		ModelAndView view = new ModelAndView();
		Map<String, Object> map = testService.testServiceMethod();
		view.addObject("resultmap",map);
		view.addObject("returnResult","testGetView");
		view.setViewName("test/returnResult");
		return view;
	}


	@RequestMapping(value="/testJson", method = {RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Map receiveEBCResult(HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("UTF-8");
		Map params = new HashMap();
		//获得POST 过来参数设置到新的params中
		Map requestParams = request.getParameterMap();
		String valueStr = "";
		for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
			String name = (String) iter.next();
			String[] values = (String[]) requestParams.get(name);
			valueStr = "";
			for (int i = 0; i < values.length; i++) {
				valueStr = (i == values.length - 1) ? valueStr + values[i]
						: valueStr + values[i] + ",";

			}
			params.put(name, valueStr);
		}

//		Map<String, Object> map = testService.testServiceMethod();
//		log.info("map " + map);
		log.info("testJson " + params);
		return params;
	}


}
