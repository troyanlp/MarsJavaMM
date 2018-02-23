import java.util.LinkedList;
import java.util.Scanner;

public class ConsoleReader implements IReader {

	public ConsoleReader() {
	}

	@Override
	public void Read() {
		
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
			boolean dataOK = processor.ProcessData();
			if(!dataOK) System.out.println("No valid input values.");
		}else {
			System.out.println("No valid grid size values.");
		}
		
		reader.close(); 
	}

}
