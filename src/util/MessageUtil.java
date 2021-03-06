package util;

import java.nio.CharBuffer;
import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;
public class MessageUtil {
	
	public final static String TYPE = "type";
	public final static String DATA = "data";
	
	public final static String MESSAGE = "message";
	
	public final static String USER = "user";
	
	public static HashMap<String,String> getMessage(CharBuffer msg) {
		HashMap<String,String> map = new HashMap<String,String>();
		String msgString  = msg.toString();
		String m[] = msgString.split(",");
		map.put("fromName", m[0]);
		map.put("toName", m[1]);
		map.put("content", m[2]);
		return map;
	}

	public static String sendContent(String type, String content) {
		Map<String,Object> userMap = new HashMap<String,Object>();
		userMap.put(MessageUtil.TYPE, type);
		userMap.put(MessageUtil.DATA, content);
		JSONObject json = JSONObject.fromObject(userMap);
		return json.toString();
	}
}