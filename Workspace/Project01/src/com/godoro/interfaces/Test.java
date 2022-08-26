package com.godoro.interfaces;

public class Test {
	public static void main(String[] args) {
		Pigeon pigeon = new Pigeon("Paçalı");
		pigeon.fly();
		pigeon.land();
		
		Flighted flighted = new Pigeon("Postacı");
		flighted.fly();
		flighted.land();
		
		Bat bat = new Bat("Fruit Bat");
		bat.fly();
		bat.land();
		
		Flighted flighted1 = new Bat("Vamipire Bat");
		flighted1.land();
		flighted1.fly();
		
		makeFly(pigeon);
		
	}
	private static void makeFly(Flighted flighted) {
		System.out.println();
		System.out.println("FLY!");
		flighted.fly();
		System.out.println("LAND!");
		flighted.land();
	}
}
