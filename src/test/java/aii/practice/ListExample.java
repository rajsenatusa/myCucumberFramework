package aii.practice;

import java.util.ArrayList;
import java.util.List;

public class ListExample {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("Sherzod");
		list.add("Murat");
		list.add("Kamer");
		
		System.out.println(list);
		
		for (String str : list)
		{
			System.out.println(str);
		}

	}

}
