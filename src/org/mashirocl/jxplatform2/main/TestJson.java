package org.mashirocl.jxplatform2.main;

import com.alibaba.fastjson.JSON;


public class TestJson {
	
	static void encode() {
		Group group = new Group();
		group.setId(0L);
		group.setName("admin");
		
		
		User guestUser = new User();
		guestUser.setId(2L);
		guestUser.setName("guest");
		
		User rootUser = new User();
		rootUser.setId(3L);
		rootUser.setName("root");
		group.addUser(guestUser);
		group.addUser(rootUser);


		String jsonString = JSON.toJSONString(group);
		

		System.out.println(jsonString);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		encode();
	}

}
