package com.godoro.client;
import static com.godoro.utils.StreamUtils.*;
public class GetPlayerClient {
	public static void main(String[] args) throws Exception {
		long playerId = 123;
		String address = String.format("http://localhost:8080/Project05/player/get?id=%d", playerId);
		String text = get(address);
		System.out.println("İçerik: ");
		System.out.println(text);
		
	}
}
