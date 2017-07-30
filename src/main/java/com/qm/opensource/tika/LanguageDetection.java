package com.qm.opensource.tika;

import java.io.IOException;

import org.apache.tika.exception.TikaException;
import org.apache.tika.language.LanguageIdentifier;

import org.xml.sax.SAXException;

public class LanguageDetection {

	public static void main(String args[]) throws IOException, SAXException, TikaException {

		LanguageIdentifier identifier = new LanguageIdentifier("适当放松放松th水电费is is斯蒂芬森 english ");
		String language = identifier.getLanguage();
		System.out.println("Language of the given content is : " + language);
	}
}