package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import com.constants.Env;
import com.google.gson.Gson;
import com.ui.pojo.Config;
import com.ui.pojo.Environment;

public class JSONUtility {
	
	public static Environment
	readJSON(Env env) {
		Gson gson= new Gson();
		File file=new File(System.getProperty("user.dir")+"\\config\\config.json");
		FileReader filereader = null;
		try {
			filereader = new FileReader(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Config config=gson.fromJson(filereader, Config.class);
		Environment environment=config.getEnvironments().get(env.name());
		return environment;
	}

}
