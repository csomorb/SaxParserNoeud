package parserSAX;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;


public class MonParserSAX {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		
		 Path p = Paths.get("unarbre.xml");
		 SAXParserFactory spf = SAXParserFactory.newInstance();
		 spf.setNamespaceAware(true);
		 SAXParser saxParser = spf.newSAXParser();		 
		 XMLReader xmlReader = saxParser.getXMLReader();
		 xmlReader.setContentHandler(new MonHandler());
		 xmlReader.parse(p.toUri().toString());
		 
	}
}
