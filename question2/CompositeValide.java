package question2;

import question1.Contributeur;
import question1.GroupeDeContributeurs;
import question1.Visiteur;
import question1.Cotisant;

public class CompositeValide implements Visiteur<Boolean>{
  
  public Boolean visite(Contributeur c){
   return c.solde() >= 0;
  }
  
  public Boolean visite(GroupeDeContributeurs g){
     if(g == null){
            return false;
        }
    if(g.nombreDeCotisants() == 0){
            return false;
        }
    for(Cotisant cotisant : g.getChildren()){
         if(!cotisant.accepter(this)){
             return false;
            }
        }
        
    return true ;
  }
}