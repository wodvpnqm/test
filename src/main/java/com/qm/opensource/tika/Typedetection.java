package com.qm.opensource.tika;

import java.io.File;

import org.apache.tika.Tika;

public class Typedetection {

	public static void main(String[] args) throws Exception {
		// System.out.println(Typedetection.class.getResource("/"));
		// System.out.println(Typedetection.class.getResource(""));
		// assume example.mp3 is in your current directory
		File file = new File(Typedetection.class.getResource("").getPath() + "chrome.adm");//
		// Instantiating tika facade class
		Tika tika = new Tika();

		// detecting the file type using detect method
		String filetype = tika.detect(file);
		System.out.println(filetype);
	}
}