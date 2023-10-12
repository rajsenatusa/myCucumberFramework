package aii.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import aii.utils.CommonMethods;

public class TC36681_HO3_ValidateRoofAgeLetterForRolledBitumen_RWL extends CommonMethods{

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static LocalDateTime currentDate2= LocalDateTime.now();
	static int cYear= currentDate2.getYear();
	static int rYear= cYear - 9;
	static String roofYear = String.valueOf(rYear);
	static String policyNum;
	static String AppNum;
	static String FileLocation = System.getProperty("user.dir") + "\\target\\";
}
