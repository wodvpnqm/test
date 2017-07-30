package com.qm.opensource.tika;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.asm.ClassParser;
import org.apache.tika.sax.BodyContentHandler;

import org.xml.sax.SAXException;

public class JavaClassParse {

	public static void main(final String[] args) throws IOException, SAXException, TikaException {

		// detecting the file type
		BodyContentHandler handler = new BodyContentHandler();
		Metadata metadata = new Metadata();
		FileInputStream inputstream = new FileInputStream(new File(
				"G:/svn/dubbo/dubbo-rpc/dubbo-rpc-thrift/target/test-classes/com/alibaba/dubbo/rpc/gen/dubbo/$__DemoStub$echoByte_args.class"));
		ParseContext pcontext = new ParseContext();

		// Html parser
		ClassParser ClassParser = new ClassParser();
		ClassParser.parse(inputstream, handler, metadata, pcontext);
		System.out.println("Contents of the document:" + handler.toString());
		System.out.println("Metadata of the document:");
		String[] metadataNames = metadata.names();

		for (String name : metadataNames) {
			System.out.println(name + " :  " + metadata.get(name));
		}
	}
}