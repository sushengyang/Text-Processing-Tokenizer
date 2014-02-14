import java.util.ArrayList;

public class Tokenizer {

	
	ArrayList<String> allWords;
	ArrayList<String> stopWords;
	ArrayList<String> stemWords;

	public Tokenizer(String[] seperatedWords, String[] stopWords) {
		this.allWords = new ArrayList<String>();
		this.stopWords = new ArrayList<String>();
		this.stemWords = new ArrayList<String>();

		tokenizer(seperatedWords);
		removeEmptyWords();
		removeStopWords(stopWords);
		stemWords();
		

	}
	
	void stemWords(){
		
		char[] wordCharArray;
		Stemmer s = new Stemmer();
		
		
		for (String word : allWords) {
			wordCharArray = word.toCharArray();
			
			for (int i = 0; i < word.length(); i++){
				 s.add(wordCharArray[i]);
			}
			s.stem();
			stemWords.add(s.toString());
		}	
	}
	
	void tokenizer(String[] seperatedWords){
		for (String word : seperatedWords) {
			word = word.replace("\r", "");
			word = word.replace("\n", "");
			if (word.length() != 0 && !word.isEmpty() && !word.equals(" ")
					&& !word.equals("")) {

				if (word.contains("http://")) {
					continue;
				} else {
					if (word.contains("-")) {
						String[] splitWords = splitHyphenWord(word);
						for (String string : splitWords) {
							allWords.add(cleanString(string));
						}
					} else {
						allWords.add(cleanString(word));
					}
				}
			}
		}
	}
	
	void removeStopWords(String[] stopWords){
		
		for (String string : stopWords) {
			this.stopWords.add(string);
		}
		
		for (int j = 0; j < stopWords.length; j++) {
			for (int i = 0; i < allWords.size(); i++) {
				if(allWords.get(i).equals(this.stopWords.get(j))){
				}
			}
		}
		
	}

	String[] splitHyphenWord(String word) {
		String[] splitWords = null;
		if (word.contains("-")) {
			splitWords = word.split("-");

		}
		return splitWords;
	}

	String cleanString(String word) {
		word = word.replaceAll("[0-9]", "");
		word = word.replaceAll("\\W", "");
		return word.toLowerCase().trim();
	}
	
	void removeEmptyWords(){
		for (int i = 0; i < allWords.size(); i++) {
			if(allWords.get(i).length() == 0){
				allWords.remove(i);
			}
		}
	}

	public String getProcessedWord() {
		StringBuilder stringBuilder = new StringBuilder();
		
		for (String word : stemWords) {
			stringBuilder.append(word + " ");
		}
		
		return stringBuilder.toString();
	}

	
	void print(){
		for (String word : stemWords) {
			System.out.println(word);
		}
	}

}
