package util;

/**
 * @author Leibniz Berihuete
 * Just a simple Debug tool, to print messages/error-messages
 */
public class Debug {
	public static void printErrorMessage(Class classObject, String title, String message) {
		String className = classObject.getSimpleName();
		System.err.println("Error from " + className + " | " + title + " | " + message);
	}
	
	public static void printMessage(Class classObject, String title, String message) {
		String className = classObject.getSimpleName();
		System.out.println("Message from " + className + " | " + title + " | " + message);
	}
}
