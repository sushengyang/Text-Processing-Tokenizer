import java.util.ArrayList;


public class Tokenizer {
	
	ArrayList<String> allWords;
	
	public Tokenizer(String[] seperatedWords){
		allWords = new ArrayList<String>();
		
		for (String word : seperatedWords) {
			word = word.replace("\r", "");
			word = word.replace("\n", "");
			if(word.length() != 0 && !word.isEmpty() && !word.equals(" ") && !word.equals("")){
				allWords.add(word.trim());
			}	
		}
		
	}
	

	
	public void tokenize(){
		
	}
	
	void stringToArrayList(){
		
	}
	
	
	void removePunctuation(){
		
	}

}
