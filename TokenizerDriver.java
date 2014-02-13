import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;

/**
 * @author Brandon S. Kane
 * 
 */
public class TokenizerDriver {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		
		System.out.println("Text Processing Tokenizer");
		System.out.println("-------------------------");
		
		String fileName = "input.txt";
		
		String rawInput = captureText(fileName);
		
		System.out.println("Raw Input");
		System.out.println("---------");
		System.out.println(rawInput);
		
		String[] seperatedWords = rawInput.split(" ");
				
		Tokenizer tokenizer = new Tokenizer(seperatedWords);
		
		tokenizer.tokenize();

	}

	static String captureText(String fileName) throws IOException{
		String textToProcess;
		FileInputStream inputStream = new FileInputStream(fileName);
	    try {
	    	textToProcess = IOUtils.toString(inputStream);
	    } finally {
	        inputStream.close();
	    }
	    return textToProcess;
	}
}
