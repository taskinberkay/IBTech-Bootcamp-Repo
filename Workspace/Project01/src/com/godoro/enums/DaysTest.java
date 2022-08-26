package com.godoro.enums;

public class DaysTest {
	public static void main(String[] args) {
		int day = 47;
		printDay(day);
		printDay(Days.MODAY);
		}
		
		public static void printDay(int day) {
			switch(day) {
			case 1:
				System.out.println("Pazartesi");
				break;
			case 2:
				System.out.println("Salı");
				break;
			case 3:
				System.out.println("Çarşamba");
				break;
			default:
				System.out.println("Geçersiz gün");
			}
	}
}
