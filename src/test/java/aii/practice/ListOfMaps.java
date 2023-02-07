package aii.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListOfMaps {

	public static void main(String[] args) {

		List<Map<String, String>>  listOfMaps = new ArrayList<>();
		
		Map<String, String> murat = new HashMap<>();
		murat.put("firstname", "murat");
		murat.put("lastname", "bulad");

		listOfMaps.add(murat);
		
		Map<String, String> gurkan = new HashMap<>();
		gurkan.put("firstname", "gurkan");
		gurkan.put("lastname", "tuncer");
		
		listOfMaps.add(gurkan);
		
		System.out.println(listOfMaps);
		
	}
	

}
