package question3;

import question1.*;
import java.util.*;
import org.jdom.*;

public class Memento {

    private Element state;

    public Memento(Cotisant c) {
        if(c != null){
            state = c.accepter(new VisiteurSauvegarde());
        }

    }

    public void setState(Cotisant c) {
        if(c != null){
            c.accepter(new VisiteurRestitution(state));
        }
    }

}