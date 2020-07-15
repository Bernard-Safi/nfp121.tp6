package question2;

import question1.*;
import java.util.Set;
import java.util.TreeSet;
import java.util.Iterator;

public class SansDoublon implements Visiteur<Boolean>{
    private Set<String> nomsDesCotisants = new TreeSet<>();
  public Boolean visite(Contributeur c){
    return !contientNoms(c);
  }
  
  public Boolean visite(GroupeDeContributeurs g){
    boolean res = contientNoms(g);
  if(!res){
            Iterator<Cotisant> it = g.iterator();
            while(it.hasNext()){
                Cotisant cotisant = it.next();
                res = contientNoms(cotisant);
                if(res)
                    return !res;
            }
        }
        return !res ;
  }
  
    private boolean contientNoms(Cotisant cotisant){
        boolean contient = nomsDesCotisants.contains(cotisant.nom());
        if (!contient)
            nomsDesCotisants.add(cotisant.nom());
        return contient;
    }
  
}