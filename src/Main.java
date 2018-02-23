import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		System.out.println("How do you want to input the data? Write 'console' or 'file'.");
		String decision = reader.next();
		IReader testReader = null;
		if (decision.compareToIgnoreCase("console") == 0) {
			testReader = new ConsoleReader();
		} else if(decision.compareToIgnoreCase("file") == 0) {
			testReader = new FileReader();
		} else {
			System.out.println("No valid input mode.");
		}
		
		if (testReader != null) {
			testReader.read();
		}
		//once finished
		reader.close(); 
	}

}
