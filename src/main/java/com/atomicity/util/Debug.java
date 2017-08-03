package com.atomicity.util;

public class Debug {
	public static void printMessage(Class classObj, String title, String message) {
		String className = classObj.getSimpleName();
		String msg = "|@|";
		msg +=" From " + className;
		msg +="||";
		msg +=title;
		msg +="||";
		msg +=message;	
		System.out.println(msg);		
	}
	
	public static void printErrorMessage(Class classObj, String title, String message) {
		String className = classObj.getSimpleName();
		String msg = "|@|";
		msg +=" ERROR From " + className;
		msg +="||";
		msg +=title;
		msg +="||";
		msg +=message;	
		System.err.println(msg);		
	}
}
