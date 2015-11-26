package parserSAX;

import java.util.Stack;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;

public class MonHandler implements ContentHandler {
	Noeud<Integer> arbre;
	Stack<Noeud<Integer>> s;
	
	@Override
	public void characters(char[] arg0, int arg1, int arg2) throws SAXException {
		String str = new String(arg0, arg1, arg2);
		if (str.matches("[0-9]*")){ //il s'agit bien d'un chiffre 
			System.out.println(str);
			Noeud<Integer> n = s.pop();
			n.setValeur(Integer.parseInt(str));
			s.push(n);
		}

	}

	@Override
	public void endDocument() throws SAXException {
		System.out.println("Fin du parser...");
		System.out.println(arbre.toString());

	}

	@Override
	public void endElement(String arg0, String arg1, String arg2) throws SAXException {
		if (arg1.contentEquals("fils")){
			System.out.println("On sort du fils... On récupère lle sommet de la pille");
			Noeud<Integer> sommet = s.pop();
			Noeud<Integer> base = s.pop();
			if (base.getFilsG()==null){
				base.setFilsG(sommet);
			}
			else{
				base.setFilsD(sommet);
			}
			s.push(base);
		}
	}

	@Override
	public void endPrefixMapping(String arg0) throws SAXException {
		// TODO Auto-generated method stub

	}

	@Override
	public void ignorableWhitespace(char[] arg0, int arg1, int arg2) throws SAXException {
		// TODO Auto-generated method stub

	}

	@Override
	public void processingInstruction(String arg0, String arg1) throws SAXException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setDocumentLocator(Locator arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void skippedEntity(String arg0) throws SAXException {
		// TODO Auto-generated method stub

	}

	public void startDocument() throws SAXException {
		System.out.println("Début du parser...\nCréation d'un noeud vide...");
		arbre = new Noeud<Integer>(0,null,null);
		s = new Stack<Noeud<Integer>>();
		s.push(arbre);
	}

	@Override
	public void startElement(String arg0, String arg1, String arg2, Attributes arg3) throws SAXException {
	//	System.out.println("Nouveau Element:"+arg1);
		if(arg1.contentEquals("fils")){
			System.out.println("Nouveau Element fils:"+arg1+"\nAjout du noeud à la pile");
			s.add(new Noeud<Integer>(0,null,null));
		}
		if(arg1.contentEquals("valeur")){
			System.out.print("Ajout au sommet de la pille de la valeur: ");
		}

	}

	@Override
	public void startPrefixMapping(String arg0, String arg1) throws SAXException {
		// TODO Auto-generated method stub

	}

}
