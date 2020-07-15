package question1;


public class Contributeur extends Cotisant{
  private int solde;
  
  public Contributeur(String nom, int somme) throws RuntimeException{
    super(nom);
    if(somme < 0){
            throw new RuntimeException ("La somme ne peut pas etre <0");
        }
        this.solde = somme;
  }
  
  public int solde(){
    return this.solde;
  }
  
  public int nombreDeCotisants(){
    return 1;
  }
	public void debit(int somme) throws RuntimeException,SoldeDebiteurException{
	  if(somme < 0){
            throw new RuntimeException("La somme d�bitee doit etre > 0");
        }
        if(somme > solde){
            throw new SoldeDebiteurException("La somme est > que solde");
        }
        solde -= somme;
	}
	
	/**
	 * throws RuntimeException new RuntimeException("nombre négatif !!!");
	 */
  public  void credit(int somme)throws RuntimeException{
	 if(somme < 0){
            throw new RuntimeException("La somme creditee est <0");
        }
        solde += somme;
	}
	
	/**
	 * throws RuntimeException new RuntimeException("nombre négatif !!!");
	 */
  public void affecterSolde(int somme){
   if(somme < 0) 
            throw new RuntimeException("La somme ne peut pas etre <0");
        try{
            debit(solde()); 
            credit(somme);
        }catch(SoldeDebiteurException ex){ 
            this.solde = somme;
        }
  }
  
  public <T> T accepter(Visiteur<T> visiteur){
    return visiteur.visite(this);
  }
  
  public String toString(){
    return "<Contributeur : " + nom + "," + solde + ">";
  }

}
