package com.godoro.composition.entity;

public class Category {
	private long playerId;
	private String playerName;
	private double score;
	public long getId() {
		return playerId;
	}
	public void setId(long id) {
		this.playerId = id;
	}
	public String getName() {
		return playerName;
	}
	public void setName(String name) {
		this.playerName = name;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public Category(long id, String name, double score) {
		this.playerId = id;
		this.playerName = name;
		this.score = score;
	}
	public Category() {

	}
	

}
