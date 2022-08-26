package com.godoro.collections;

import java.util.HashMap;
import java.util.Map;

public class MapTest {
	public static void main(String[] args) {
		Map<String, String> countryMap = new HashMap<>();
		countryMap.put("tr", "Türkiye");
		countryMap.put("tm", "Türkmenistan");
		countryMap.put("az", "Azerbeycan");
		countryMap.put("kg", "Kırgızistan");
		countryMap.put("uz", "Özbekistan");
		
		countryMap.remove("uz");
		
		for(String country : countryMap.values()) {
			System.out.println("# "+ country);
		}
		for(String code : countryMap.keySet()) {
			String country = countryMap.get(code);
			System.out.println(code + " - " + country);
		}
		
		
		
		
	}
}
