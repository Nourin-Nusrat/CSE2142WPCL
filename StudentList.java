import java.io.*;
import java.text.*;
import java.util.*;

public class StudentList {
	public static void main(String[] args) {
//		Check arguments
		if (args[0].equals("a")) {
			System.out.println("Loading data ...");
			try {
				BufferedReader bufferReader = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt")));
				String nameList = bufferReader.readLine();
				String names[] = nameList.split(", ");
				for (String word : names) {
					System.out.println(word);
				}
			} catch (Exception e) {
			}
			System.out.println("Data Loaded.");
		} else if (args[0].equals("r")) {
			System.out.println("Loading data ...");
			try {
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt")));
				String nameList = bufferedReader.readLine();
				String names[] = nameList.split(", ");
				Random randomNumber = new Random();
				int random = randomNumber.nextInt(names.length);
				System.out.println(names[random]);
			} catch (Exception e) {
			}
			System.out.println("Data Loaded.");
		} else if (args[0].contains("+")) {
			System.out.println("Loading data ...");
			try {
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt")));
				String line = bufferedReader.readLine();
				bufferedReader.close();

				BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("students.txt", false));
				String newString = args[0].substring(1);
				bufferedWriter.flush();
				Date date = new Date();
				String dateString = "dd/mm/yyyy-hh:mm:ss a";
				DateFormat dateFormat = new SimpleDateFormat(dateString);
				String formatDate = dateFormat.format(date);
				bufferedWriter.write(line + ", " + newString + "\nList last updated on " + formatDate);
				bufferedWriter.close();
			} catch (Exception e) {
			}

			System.out.println("Data Loaded.");
		} else if (args[0].contains("?")) {
			System.out.println("Loading data ...");
			try {
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt")));
				String line = bufferedReader.readLine();
				String name[] = line.split(", ");
				boolean done = false;
				String word = args[0].substring(1);
				for (int index = 0; index < name.length && (!done); index++) {
					if (name[index].equals(word)) {
						System.out.println("We found it!");
						done = true;
					}
				}
				if (!done) {
					System.out.println("Not found!");
				}
			} catch (Exception e) {

			}
			System.out.println("Data Loaded.");
		} else if (args[0].contains("c")) {
			System.out.println("Loading data ...");
			try {
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt")));
				String line = bufferedReader.readLine();
				char name[] = line.toCharArray();
				boolean in_word = false;
				int count = 0;
				for (char c : name) {
					if (c == ',') {
						if (!in_word) {
							count++;
							//in_word = true;
						} else {
							in_word = false;
						}
					}
				}
				if(count>1)count++;
				System.out.println(count + " word(s) found");
			} catch (Exception e) {
			}
			System.out.println("Data Loaded.");
		}
	}
}