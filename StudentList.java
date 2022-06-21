import java.io.*;
import java.text.*;
import java.util.*;

public class StudentList {
	public static BufferedReader bufferReader;
	public static String nameList;
	public static void read(){
		try{
		       bufferReader = new BufferedReader(new InputStreamReader(new FileInputStream(Constant.FileName)));
		       nameList = bufferReader.readLine();
		}catch (Exception e){

		}
	}
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
		if (args.length != 1) {
			System.out.println(Constant.Invalid);
			System.exit(1);
		}
//		Check arguments
		if (args[0].equals(Constant.namePrint)) {
			System.out.println(Constant.loadingData);
			read();
			String names[] = nameList.split(Constant.comma);
			for (String word : names) {
				System.out.println(word);
			}
			System.out.println(Constant.dataLoaded);
		} else if (args[0].equals(Constant.randomName)) {
			System.out.println(Constant.loadingData);
			read();
			String names[] = nameList.split(Constant.comma);
			Random randomNumber = new Random();
			int random = randomNumber.nextInt(names.length);
			System.out.println(names[random]);
			System.out.println(Constant.dataLoaded);
		} else if (args[0].contains(Constant.addName)) {
			System.out.println(Constant.loadingData);

			read();
			//bufferedReader.close();
			String newString = args[0].substring(1);

			Date date = new Date();
			String dateString = Constant.dateFormat;
			DateFormat dateFormat = new SimpleDateFormat(dateString);
			String formatDate = dateFormat.format(date);
                        String textUpdate = nameList + Constant.comma + newString + Constant.lastUpdate + formatDate;
			write(textUpdate);

			System.out.println(Constant.dataLoaded);
		} else if (args[0].contains(Constant.query)) {
			System.out.println(Constant.loadingData);
			String name[] = nameList.split(Constant.comma);
			boolean done = false;
			String word = args[0].substring(1);
			for (int index = 0; index < name.length && (!done); index++) {
				if (name[index].equals(word)) {
					System.out.println(Constant.found);
					done = true;
				}
			}
			if (!done) {
				System.out.println(Constant.notFound);
			}

		        System.out.println(Constant.dataLoaded);
		} else if (args[0].contains(Constant.countWords)) {
			System.out.println(Constant.loadingData);
			read();
			char name[] = nameList.toCharArray();
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
		        System.out.println(count + Constant.wordsFound);
		        System.out.println(Constant.dataLoaded);
		} else {
			System.out.println(Constant.Invalid);
		}
	}
}
