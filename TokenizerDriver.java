import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;

/**
 * @author brandonskane
 * a text processing module as follows:
		A tokenizer according to the following rules:
		Tokenize all abbreviations containing periods as strings without periods
		Treat the rest of the punctuation as word separators
		Lowercase all letters

	  	A stemmer implemented via the Porter Stemmer package: http://tartarus.org/~martin/PorterStemmer/
		Implement stopword removal using the following stopword list: http://bit.ly/1bqQWaV

		The word list is tokenized first, stopwords are removed, and finally the words are put through the stemmer
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

		String tokenizedWords = tokenizer.getProcessedWords();
		
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
