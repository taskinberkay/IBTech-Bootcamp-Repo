package com.godoro.console;

import java.util.Scanner;

public class ConsoleApp {

	public static void main(String[] args) {
		while (true) {
			printMenu();
			int choice = scanChoice();
			handleChoice(choice);
		}
	}

	private static Scanner scanner = new Scanner(System.in);

	private static void printMenu() {
		System.out.println("Menü: ");
		System.out.println("1. Yükle");
		System.out.println("2. Sakla");
		System.out.println("3. Dizelgele");
		System.out.println("4. Ekle");
		System.out.println("5. Güncelle");
		System.out.println("6. Sil");
		System.out.println("0. Çık");
	}

	private static int scanChoice() {
		System.out.println("Seçiniz...");
		int choice = scanner.nextInt();
		return choice;

	}

	private static void handleChoice(int choice) {
		switch (choice) {
		case 1:
			doLoad();
			break;
		case 2:
			doStore();
			break;
		case 3:
			doList();
			break;
		case 4:
			doFind();
			break;
		case 5:
			doAdd();
			break;
		case 6:
			doUpdate();
			break;
		case 7:
			doDelete();
			break;
		case 0:
			doExit();
			break;
		}
	}

	private static void doLoad() {
		// TODO Auto-generated method stub

	}

	private static void doStore() {
		// TODO Auto-generated method stub

	}

	private static void doList() {
		// TODO Auto-generated method stub

	}

	private static void doFind() {
		// TODO Auto-generated method stub

	}

	private static void doAdd() {
		// TODO Auto-generated method stub

	}

	private static void doUpdate() {
		// TODO Auto-generated method stub

	}

	private static void doDelete() {
		// TODO Auto-generated method stub

	}

	private static void doExit() {
		// TODO Auto-generated method stub

	}

}
