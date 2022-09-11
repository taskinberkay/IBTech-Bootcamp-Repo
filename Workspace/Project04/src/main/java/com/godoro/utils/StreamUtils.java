package com.godoro.utils;

import java.net.URL;
import java.net.URLConnection;

import org.apache.coyote.http11.filters.BufferedInputFilter;

import java.io.*;
public class StreamUtils {
 
	public static String read(InputStream in) 
			throws Exception{
		BufferedReader reader = new BufferedReader(new InputStreamReader(in, "utf-8"));
		String line;
		StringBuilder builder = new StringBuilder();
		while((line=reader.readLine())!=null){
			builder.append(line).append("\r\n");
		}
		reader.close();
		String text = builder.toString();
		return text;
	}
	public static String get(String address) 
			throws Exception 
	{
		URL url = new URL(address);
		URLConnection connection = url.openConnection();
		InputStream in = connection.getInputStream();
		String text = read(in);
		return text;
	}
	public static void write(OutputStream out, String output) throws Exception {
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out,"utf-8"));
		writer.write(output+"\r\n");
		writer.flush();
		out.close();
		writer.close();
		
	}
	public static String post(String adress, String response) {
		return "asd";
	}
}

