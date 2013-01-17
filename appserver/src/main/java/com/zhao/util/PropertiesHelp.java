package com.zhao.util;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesHelp {
	public static PropertiesHelp ph = new PropertiesHelp();

	private Properties pro;

	public PropertiesHelp() {
		InputStream in;
		try {
			in = new BufferedInputStream(new FileInputStream(
					"conf/config.properties"));
			pro = new Properties();
			pro.load(in);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static PropertiesHelp getInstance() {
		return ph;
	}

	public int getPort() {
		return Integer.parseInt(pro.get("port").toString());
	}
}
