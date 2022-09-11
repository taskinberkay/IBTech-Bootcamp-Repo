package com.godoro.client;

import com.godoro.utils.StreamUtils;

public class PostClient {
	public static void main(String[] args) {
		String address="http://localhost:8080/Project04/post";
		String input = StreamUtils.post(address,"giden");
		System.out.println("Girdi: ");
		System.out.println(input);
		
	}

}
