package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.ui.pojo.User;

public class CSVReaderUtility {
	
	public static Iterator<User> readCSVFile(String filename) {
		
		  File file= new File(System.getProperty("user.dir")+"\\test-data\\"+filename);
		  FileReader reader = null;
		  CSVReader csvreader=null;
		  String[] line=null;
		  List<User> userList=null;
		  User userdata;
		  try {
			 reader=new FileReader(file);
			 csvreader=new CSVReader(reader);
			 csvreader.readNext();   //Reading the column names-- Row1, we want to skip the column
			 userList=new ArrayList<User>();
			 
			 while((line=csvreader.readNext())!=null) {
				 userdata=new User(line[0],line[1]);
				 userList.add(userdata);
			 }
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (CsvValidationException | IOException e) {
				e.printStackTrace();
		}
		  
		  return userList.iterator();
	}

}
