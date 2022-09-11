package com.godoro.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReaderTest {
	public static void main(String[] args) throws IOException {
		String path = "..\\..\\IO\\in.txt";
		BufferedReader br = new BufferedReader(new FileReader(path));
		String line;
		StringBuilder builder = new StringBuilder();
		while( (line = br.readLine()) != null) {
			builder.append(line).append("\r\n");
		}
		System.out.println("Okunan: \n" + builder.toString());
		br.close();
	}
}
