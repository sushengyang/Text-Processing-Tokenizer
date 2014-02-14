Text-Processing-Tokenizer
=========================

Process words via a tokenizer, stop word list and stemming
 * a text processing tokenizer module according to the following rules:
		Tokenize all abbreviations containing periods as strings without periods
		Treat the rest of the punctuation as word separators
		Lowercase all letters
    stopword removal
	  Word stemming (implemented via the Porter Stemmer package: http://tartarus.org/~martin/PorterStemmer/)
	
		The word list is tokenized first, stopwords are removed, and finally the words are put through the stemmer
