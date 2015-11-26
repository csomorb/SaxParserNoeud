package parserSAX;

public class Noeud<T> {

	private T valeur;
	private Noeud<?> filsG,filsD;
	
	public Noeud() {
		
	}
	public Noeud(T v, Noeud<?> g, Noeud<?> d) {	
		valeur=v;
		filsG=g;
		filsD=d;
	}
	
	public T getValeur() {
		return valeur;
	}

	public Noeud<?> getFilsG() {
		return filsG;
	}


	public Noeud<?> getFilsD() {
		return filsD;
	}

	public void setValeur(T valeur) {
		this.valeur = valeur;
	}

	public void setFilsG(Noeud<?> filsG) {
		this.filsG = filsG;
	}

	public void setFilsD(Noeud<?> filsD) {
		this.filsD = filsD;
	}
	
	
	public String toString() {
		return "("+valeur+" "+getFilsG()+" "+getFilsD()+")";
	}
}