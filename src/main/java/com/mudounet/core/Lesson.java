package com.mudounet.core;

public class Lesson {

	private StatManager statManager;

	public StatManager getStatManager() {
		return statManager;
	}

	public void setStatManager(StatManager statManager) {
		this.statManager = statManager;
	}
	
	public int displayGlobalStats() {
		return statManager.displayGlobalStats() ;
	}
	
}
