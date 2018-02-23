import java.util.LinkedList;
import java.util.Scanner;

public class ConsoleReader implements IReader {

	public ConsoleReader() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void Read() {
		// TODO Auto-generated method stub
		System.out.println("Console Reader");
		
		System.out.println("Enter the size of the grid: ");
		Scanner reader = new Scanner(System.in);
		int width = -1, height = -1;
		if(reader.hasNextInt()) width = reader.nextInt();
		if(reader.hasNextInt()) height = reader.nextInt();
		
		if(width > 0 && height > 0) {
			//System.out.println(width + " " + height);
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
		}else {
			System.out.println("No valid grid size values.");
		}
		
		reader.close(); 
	}

}
