package main;
import database.*;
import xuly.CountDownThread;

public class Main {
	public static void main(String[] args) {
		try {
			KetNoidata.getin().getcon();
			CountDownThread countDownThread = new CountDownThread();
			countDownThread.start();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}