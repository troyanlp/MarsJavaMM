import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.stream.Stream;

public class FileReader implements IReader {

	public FileReader() {
	}
	
	@Override
	public void read() {
		Scanner reader = new Scanner(System.in);
		System.out.println("Write the name of the file (Must be inside the \"Test Files\" folder).");
		String filePath = reader.next();
		try (Stream<String> stream = Files.lines(Paths.get(".\\Test Files\\" + filePath), Charset.defaultCharset())) {
			readFile(stream);
		} catch (Exception e) {
			System.out.println("File not found!");
		}
		reader.close();
	}
	
	private void readFile(Stream<String> stream) {
		String[] lines = stream.toArray(size -> new String[size]);
        LinkedList<String> inputs = new LinkedList<>();
        DataProcessor processor = new DataProcessor();
        boolean gridOK = processor.readGridSize(lines[0]);
        
        if (gridOK) {
	        for (int i=1; i< lines.length; i++) {
	        	inputs.add(lines[i]);
	        }
	        processFile(processor, inputs);
        } else {
        	System.out.println("No valid grid size values.");
        }
	}
	
	private void processFile(DataProcessor processor, LinkedList<String> inputs) {
		processor.loadData(inputs, processor.getGridX(), processor.getGridY());
        boolean fileOK = processor.processData();
        if (!fileOK) {
        	System.out.println("No valid file values.");
        }
	}

}
