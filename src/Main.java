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
			System.out.println("Write the name of the file (Must be inside the \"Test Files\" folder).");
			String filePath = reader.next();
			System.out.println(".\\src\\" + filePath);
			try (Stream<String> stream = Files.lines(Paths.get(".\\Test Files\\" + filePath), Charset.defaultCharset())) {
				String[] lines = stream.toArray(size -> new String[size]);
		        LinkedList<String> inputs = new LinkedList<>();
		        DataProcessor processor = new DataProcessor();
		        processor.ReadGridSize(lines[0]);
		        
		        for(int i=1; i< lines.length; i++) {
		        	inputs.add(lines[i]);
		        }

		        processor.LoadData(inputs, processor.GetGridX(), processor.GetGridY());
				processor.ProcessData();
			}catch (Exception e) {
				System.out.println("File not found!");
			}
		}

		//once finished
		reader.close(); 
	}

}
