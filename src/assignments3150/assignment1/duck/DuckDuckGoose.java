/**
 * 
 */
package assignments3150.assignment1.duck;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

/**
 * @author Raj
 * 
 */
public class DuckDuckGoose {

	/**
	 * File Location
	 */
	public static final String STUDENT_FILE = "data/Students.txt";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LinkedList<String> students = createListFromFile(STUDENT_FILE);
	}

	private static LinkedList<String> createListFromFile(String studentFile) {
		LinkedList<String> students = new LinkedList<String>();
		File inputFile = new File(studentFile);
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(inputFile));
			String student = null;
			while (((student = reader.readLine()) != null)) {
				students.add(student);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (reader != null) {
					reader.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return students;
	}

}
