package com.godoro.collections;

import java.util.ArrayList;
import java.util.List;

public class ListTest {
	public static void main(String[] args) {
	List<String> provinceList = new ArrayList<String>();
	provinceList.add("İstanbul");
	provinceList.add("İzmir");
	provinceList.add("Ankara");
	provinceList.add("Eskişehir");
	provinceList.add("Bursa");
	provinceList.add("Kocaeli");
	System.out.println("3. il: " + provinceList.get(3) + "\n");
	provinceList.remove("İzmir");
	for(String province : provinceList) {
		System.out.println(province);
	}
	}
}
