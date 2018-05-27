package testDigitalFrontDoor;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Date;
import org.testng.Reporter;
import org.testng.annotations.Test;

import utilitiesFunctionLibrary.Utility;

public class Test123 {
	Utility objUtility;
	float fl, var;
	String Date1,Date2,monthStr,monthNum,dateNum,YearNum,dateNumStr,yearNum;
	int dateNumTmp ;
	LocalDate date;
	int workdays;
	
	@Test
	public void test345() throws Exception {
		objUtility=new Utility();
		System.out.println(objUtility.getddMMMyyy("April 10, 2018"));
	}
	//@Test
	public void add() {
		//public LocalDate add(LocalDate date, int workdays) {
		date = LocalDate.now();
		workdays=20;
		    if (workdays < 1) {
		      //  return date;
		    }

		    LocalDate result = date;
		    int addedDays = 0;
		    while (addedDays < workdays) {
		        result = result.plusDays(1);
		        if (!(result.getDayOfWeek() == DayOfWeek.SATURDAY ||
		              result.getDayOfWeek() == DayOfWeek.SUNDAY)) {
		            ++addedDays;
		        }
		    }

		  //  return result;
		    
		    Reporter.log("resultant date: "+result,true);
		
		    Date date2 = java.sql.Date.valueOf(result);
		    
		    SimpleDateFormat formatter = new SimpleDateFormat("d MMM yyyy");
		    System.out.println("date========="+formatter.format(date2));
	}
	
	//@Test
	public void method2() throws IOException {
		objUtility = new Utility();
		if(("chrome").equalsIgnoreCase(objUtility.getDFDData(1, "Login"))) {
			System.out.println("This is true");
		};
	}

	//@Test
	public void method1() {
		fl = 1007F;
		String name = new Object() {
		}.getClass().getEnclosingMethod().getName();
		Reporter.log("method name is :" + name, true);

		Map<String, Float> hmap = new HashMap<String, Float>();
		hmap.put(name, fl);

		Float var = hmap.get(name);
		Reporter.log("method name is :" + name, true);
		Reporter.log("var :" + var, true);

	}
	
	//@Test
	public String getmmDDyyDate(String Date1) {
		//input date should be in the format Date1 = "Sunday, August 05, 2018";
		//output should be in the format Date2 = "8/5/2018";
		monthStr = (Date1.substring(Date1.indexOf(",")+2)).substring(0, (Date1.substring(Date1.indexOf(",")+2)).indexOf(",")-3);
		monthNum = getMonthNum(monthStr);
		dateNumStr = (Date1.substring(Date1.indexOf(",")+2)).substring((Date1.substring(Date1.indexOf(",")+2)).indexOf(",")-2, (Date1.substring(Date1.indexOf(",")+2)).indexOf(","));
		dateNumTmp = Integer.parseInt(dateNumStr);
		dateNum = Integer.toString(dateNumTmp);
		yearNum = Date1.substring(Date1.indexOf(",")+2).substring(Date1.substring(Date1.indexOf(",")+2).indexOf(",")+2);
		Date2 = monthNum+"/"+dateNum+"/"+yearNum;
		return Date2;
		
	}
	
	public String getMonthNum(String month) {
		Map<String, String> monthKV = new HashMap<String, String>();
		monthKV.put("January", "1");
		monthKV.put("Febraury", "2");
		monthKV.put("March", "3");
		monthKV.put("April", "4");
		monthKV.put("May", "5");
		monthKV.put("June", "6");
		monthKV.put("July", "7");
		monthKV.put("August", "8");
		monthKV.put("September", "9");
		monthKV.put("October", "10");
		monthKV.put("November", "11");
		monthKV.put("December", "12");
		
		return monthKV.get(month);
	}
	
	

}
