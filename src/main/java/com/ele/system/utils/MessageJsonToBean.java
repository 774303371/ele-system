package com.ele.system.utils;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * 
 * @author wangping-ds5
 *
 */
public class MessageJsonToBean {
	
	/**
	 * 将消息的文本转换成Javabean
	 * @param message
	 * @return
	 */
//	public static MessageModel toJavaBean(String message) {
//		// TODO Auto-generated method stub
//		JSON json = JSON.parseObject(message);
//		MessageModel messageModel = JSON.toJavaObject(json, MessageModel.class);
//		return messageModel;
//	}
//	
	/**
	 * 将要发送的消息转换成json后再传输
	 * @param message
	 * @return
	 */
	public static String tojson(Object message) {
		// TODO Auto-generated method stub
		return JSONObject.toJSONString(message);
	}
	
	public static void main(String[] args) {
//		MessageModel messageModel = new MessageModel("春江潮水连海平",Type.creatmuc);
//		System.out.println(tojson(messageModel));
//		String str = "{\"text\":\"春江潮水连海平\",\"type\":\"creatmuc\",\"instruct\":\"1\",\"toCustomer\":\"dugujiujian01\"}";
//		MessageModel geModel = toJavaBean(str);
//		System.out.println(geModel.getText());
//		System.out.println(geModel.getType());
//		try {
//			Class demo = Class.forName("com.gome.sessionmanager.model.MessageModel");
//			Field[] fields=demo.getDeclaredFields();
//			Method[] methods=demo.getDeclaredMethods();
//			for(Field f:fields){
//				f.setAccessible( true );  
//				System.out.println("字段:"+f.getName());
//				System.out.println(f.get(geModel));
//			}
//			 for(Method method:methods){
//			       String m=method.getName();
//			       if( m.contains("get")){
//			        System.out.println("方法:"+m+"()");
//			       }
//			 }
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IllegalArgumentException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		Map<String, String> map = new HashMap<String, String>();
//		map.put("text", "春江潮水连海平");
//		map.put("type", "creatmuc");
//		map.put("instruct", "1");
//		map.put("toCustomer", "dugujiujian01");
//		System.out.println(JSONObject.toJSON(map));
	}

}
