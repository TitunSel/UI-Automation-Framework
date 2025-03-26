package com.ui.dataproviders;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;

import com.google.gson.Gson;
import com.ui.pojo.TestData;
import com.ui.pojo.User;
import com.utility.CSVReaderUtility;
import com.utility.ExcelReaderUtility;

public class LoginDataProvider {
	
	@DataProvider(name="LoginTestDataProvider")
	 public Iterator<Object[]> loginDataProvider() {
		      Gson gson=new Gson();
		      File file=new File(System.getProperty("user.dir")+"\\test-data\\logindata.json");
		      FileReader filereader = null;
			try {
				filereader = new FileReader(file);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		      
		    TestData data=gson.fromJson(filereader, TestData.class);
		    
		    List<Object[]> userlist=new ArrayList<>();
		    
		    for(User user:data.getData()) {
		    	userlist.add(new Object[] {user});
		    }
		    
		    return userlist.iterator();

	 }
	 
	 @DataProvider(name="LoginTestCSVDataProvider")
	 public Iterator<User> loginCSVDataProvider() {
		return  CSVReaderUtility.readCSVFile("logindata.csv");
		 
	 }
	 
	 @DataProvider(name="LoginTestExcelDataProvider")
	 public Iterator<User> loginExcelDataProvider() {
		return  ExcelReaderUtility.getDatafromXSLXFile("logindata.xlsx");
		 
	 }
}
