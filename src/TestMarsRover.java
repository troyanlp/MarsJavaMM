import java.util.LinkedList;
import java.util.Scanner;

public class TestMarsRover {

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		System.out.println("How do you want to input the data? Write 'console' or 'file'.");
		String decision = reader.next();
		if(decision.compareToIgnoreCase("console") == 0) {
			System.out.println("Enter the size of the grid: ");
			int width = reader.nextInt();
			int height = reader.nextInt();
			System.out.println(width + " " + height);
			LinkedList<String> inputs = new LinkedList<>();
			System.out.println("Write Mars Rovers data and when you're done write 'stop'");
			while(reader.hasNextLine()) {
				inputs.add(reader.nextLine());
				if(inputs.getLast().compareToIgnoreCase("stop") == 0) {
					inputs.poll();
					inputs.pollLast();
					break;
				}
			}
			DataProcessor processor = new DataProcessor();
			processor.LoadData(inputs, width, height);
			processor.ProcessData();
		}else if(decision.compareToIgnoreCase("file") == 0) {
			
		}
		
		
		//once finished
		reader.close(); 
	}

}
