package com.godoro.utils;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.io.*;
public class StreamUtils {
 
	public static String read(InputStream in) 
			throws IOException, UnsupportedEncodingException{
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
			throws MalformedURLException, IOException, UnsupportedEncodingException
	{
		URL url = new URL(address);
		URLConnection connection = url.openConnection();
		InputStream in = connection.getInputStream();
		String text = read(in);
		return text;
	}
	public static void write(OutputStream out, String output) throws UnsupportedEncodingException, IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out, "utf-8"));
		bw.write(output);
		bw.flush();
		bw.close();
		out.flush();
		out.close();
	}
	
	public static String post(String address, String output) throws MalformedURLException, IOException, UnsupportedEncodingException {
		URL url = new URL(address);
		URLConnection connection = url.openConnection();
		connection.setDoInput(true);
		connection.setDoOutput(true);
		StreamUtils.write(connection.getOutputStream(), output);
		String input = StreamUtils.read(connection.getInputStream());
		return input;
	}
}

