/**
 * 
 */
package assignments3150.assignment1.duck;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

/**
 * @author Raj
 * 
 */
public class DuckDuckGoose {

	/**
	 * File Location
	 */
	public static final String STUDENT_FILE = "data/Students.txt";

	private static int startNumber = 1;
	private static int endNumber = 10;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LinkedList<String> students = createListFromFile(STUDENT_FILE);
		System.out.println(students);

		while (students.size() > 1) {
			int randomNumber = getRandomNumberInclusive(startNumber, endNumber);
			System.out.println(randomNumber);
			students = removeGoose(students, randomNumber);
			System.out.println(students);
		}
	}

	private static LinkedList<String> removeGoose(LinkedList<String> students,
			int randomNumber) {
		LinkedList<String> newStudentList = students;
		Iterator<String> iterator = newStudentList.iterator();
		
		for (int i = 0; i < randomNumber; i++) {
			if (iterator.hasNext()) {
				iterator.next();
			} else {
				iterator = newStudentList.iterator();
			}
		}
		iterator.remove();
		return newStudentList;
	}

	private static int getRandomNumberInclusive(int start, int end) {
		Random random = new Random();
		return random.nextInt(end) + start;
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
