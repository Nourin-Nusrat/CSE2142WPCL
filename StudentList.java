import java.io.*;
import java.text.*;
import java.util.*;

public class StudentList {
	public static BufferedReader bufferReader;
	public static String nameList;
	// read the file
	public static void read(){
		try{
			bufferReader = new BufferedReader(new InputStreamReader(new FileInputStream(Constant.FileName)));
			nameList = bufferReader.readLine();
		}catch (Exception e){

		}
	}
	// write to the file
	public static void write(String updateText){
		try{
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(Constant.FileName, false));
			bufferedWriter.flush();
			bufferedWriter.write(updateText);
			bufferedWriter.close();
		}catch (Exception e){

		}
	}
	public static void main(String[] args) {
	//		Check arguments
		if (args.length != 1) {
			System.out.println(Constant.Invalid);
			System.exit(1);
		}
	//	Display all the names in student.txt
		if (args[0].equals(Constant.namePrint)) {
			System.out.println(Constant.loadingData);
			read();
			String names[] = nameList.split(Constant.comma);
			for (String word : names) {
				System.out.println(word);
			}
			System.out.println(Constant.dataLoaded);
		}
	//	display a word randomly from student.txt
		else if (args[0].equals(Constant.randomName)) {
			System.out.println(Constant.loadingData);
			read();
			String names[] = nameList.split(Constant.comma);
			Random randomNumber = new Random();
			System.out.println(names[randomNumber.nextInt(names.length)]);
			System.out.println(Constant.dataLoaded);
		}
	//	Add word and update time.
		else if (args[0].contains(Constant.addName)) {
			System.out.println(Constant.loadingData);

			read();
			String newString = args[0].substring(1);

			Date date = new Date();
			DateFormat dateFormat = new SimpleDateFormat(Constant.dateFormat);
			String textUpdate = nameList + Constant.comma + newString + Constant.lastUpdate + dateFormat.format(date);
			write(textUpdate);

			System.out.println(Constant.dataLoaded);
		}
	//	Check whether a word exits in the student.txt or not
		else if (args[0].contains(Constant.query)) {
			System.out.println(Constant.loadingData);
			read();
			String names[] = nameList.split(Constant.comma);
			String word = args[0].substring(1);
			for (int index = 0; index < names.length ; index++) {
				if (names[index].equals(word)) {
					System.out.println(Constant.found);
					break;
				}
			}
			System.out.println(Constant.dataLoaded);
		}
	//	count total number of words
		else if (args[0].contains(Constant.countWords)) {
			System.out.println(Constant.loadingData);
			read();
			String names[] = nameList.split(Constant.comma);
			System.out.println(names.length + Constant.wordsFound);

			System.out.println(Constant.dataLoaded);
		}
	//	case when user enters invalid arguments
		else {
			System.out.println(Constant.Invalid);
		}
	}
}