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
		String stopWordsFileName = "stopwords.txt";

		String rawInput = captureText(fileName);
		String stopWordsString = processStopWords(stopWordsFileName);

		System.out.println(rawInput);
		
		String[] seperatedWords = rawInput.split(" ");
		String[] stopWords = stopWordsString.split("\n");

		Tokenizer tokenizer = new Tokenizer(seperatedWords, stopWords);

		String tokenizedWords = tokenizer.getProcessedWord();
		
		System.out.println();
		System.out.println("Text Processing Tokenizer");
		System.out.println("-------------------------");
		System.out.println(tokenizedWords);

	}

	static String captureText(String fileName) throws IOException {
		String textToProcess;
		FileInputStream inputStream = new FileInputStream(fileName);
		try {
			textToProcess = IOUtils.toString(inputStream);
		} finally {
			inputStream.close();
		}
		return textToProcess;
	}
	
	static String processStopWords(String fileName) throws IOException{
		String stopWords;
		FileInputStream inputStream = new FileInputStream(fileName);
		try {
			stopWords = IOUtils.toString(inputStream);
		} finally {
			inputStream.close();
		}
		return stopWords;
		
	}
}
