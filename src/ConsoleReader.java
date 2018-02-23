import java.awt.List;
import java.util.LinkedList;
import java.util.Scanner;

public class ConsoleReader implements IReader {

	public ConsoleReader() {
	}

	@Override
	public void read() {
		
		System.out.println("Enter the size of the grid: ");
		Scanner reader = new Scanner(System.in);
		int width = -1;
		int height = -1;
		if (reader.hasNextInt()) {
			width = reader.nextInt();
		}
		if (reader.hasNextInt()) {
			height = reader.nextInt();
		}
		
		if (width > 0 && height > 0) {
			//System.out.println(width + " " + height);
			LinkedList<String> inputs = new LinkedList<String>();
			System.out.println("Write Mars Rovers data and when you're done write 'stop'");
			while (reader.hasNextLine()) {
				inputs.add(reader.nextLine());
				if (inputs.getLast().compareToIgnoreCase("stop") == 0) {
					inputs.poll();
					inputs.pollLast();
					break;
				}
			}
			processInput(inputs, width, height);
		} else {
			System.out.println("No valid grid size values.");
		}
		
		reader.close(); 
	}
	
	private void processInput(LinkedList<String> inputs, int width, int height) {
		DataProcessor processor = new DataProcessor();
		processor.loadData(inputs, width, height);
		boolean dataOK = processor.processData();
		if (!dataOK) {
			System.out.println("No valid input values.");
		}
	}
	
}
