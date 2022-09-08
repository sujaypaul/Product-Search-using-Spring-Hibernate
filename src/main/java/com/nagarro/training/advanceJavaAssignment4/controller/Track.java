package com.nagarro.training.advanceJavaAssignment4.controller;

public class Track implements Runnable  {
	@Override
	public void run() {
		// TODO Auto-generated method stub
		ModificationWatcher.modificationTrack();
	}
	
	public static void fetchData() {
//		allTshirtData = TshirtCsvFileReader.getAllTshirts();
		Track obj1 = new Track();
		Thread t = new Thread(obj1);
		t.start();
		TshirtCsvFileReader.getAllTshirts();
	}
}