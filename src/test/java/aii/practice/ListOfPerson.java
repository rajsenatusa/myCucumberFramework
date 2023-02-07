package aii.practice;

import java.util.ArrayList;
import java.util.List;

public class ListOfPerson {

	public static void main(String[] args) {

		List<Person> listOfPeople = new ArrayList<>();
		listOfPeople.add(new Person("Enerik",25));
		listOfPeople.add(new Person("Farkhad", 28));
		listOfPeople.add(new Person("Gurkan", 24));
		
		System.out.println(listOfPeople);
		
		
		for ( Person element : listOfPeople)
		{
			System.out.println(element);
		}
	}

}

class Person {
	String name;
	int age;

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String toString() {
		return name + " : " + age;

	}

}