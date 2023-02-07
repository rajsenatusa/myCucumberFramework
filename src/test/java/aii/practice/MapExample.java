package aii.practice;

import java.util.LinkedHashMap;
import java.util.Map;

public class MapExample {

	public static void main(String[] args) {
		Map<String, String> map = new LinkedHashMap<>() ;
		
		map.put("firstname", "Murat");
		map.put("lastname", "Bulad");
		map.put("age", "27");
		
		System.out.println(map);
		
		String name = map.get("firstname");
		System.out.println(name);
		String lastName = map.get("lastname");
		System.out.println(lastName);
				
		
	}

}
