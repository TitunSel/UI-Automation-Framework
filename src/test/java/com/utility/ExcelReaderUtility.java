package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.ui.pojo.User;


public class ExcelReaderUtility {

	public static Iterator<User> getDatafromXSLXFile(String file)  {
		
		  File xlxFile=new File(System.getProperty("user.dir")+"\\test-data\\"+file);
		 
		   XSSFWorkbook xworkbook = null;
		   List<User> userlist=null;
		   Row row;
		   Cell emailAddresscell;
		   Cell passwordcell;
		   User user;
		   Iterator<Row> rowiterator;
		try {
			   xworkbook = new XSSFWorkbook(xlxFile);
			   userlist=new ArrayList<User>();
			   XSSFSheet xssfsheet=  xworkbook.getSheet("TestData");
			   rowiterator=xssfsheet.iterator();
			   rowiterator.next(); //skipping the column name
			   while(rowiterator.hasNext()) {
				     row=rowiterator.next();
				    
				     emailAddresscell=row.getCell(0);
				     passwordcell=row.getCell(1);
				     user=new User(emailAddresscell.toString(),passwordcell.toString());
				     userlist.add(user);
			   }
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		  
		   try {
			 xworkbook.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		   return userlist.iterator();
		   
	}
}
