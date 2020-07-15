package question2;

import java.util.*;
import question1.*;

public class TestsDesVisiteurs extends junit.framework.TestCase{

    public void testACompleter(){
        GroupeDeContributeurs grp1 = new GroupeDeContributeurs("G1");
        GroupeDeContributeurs grp2 = new GroupeDeContributeurs("G2");
        GroupeDeContributeurs grp3 = new GroupeDeContributeurs("G3");

        Contributeur cont1 = new Contributeur("bernard", 20000);
        Contributeur cont2 = new Contributeur("fadi", 3000);
        Contributeur cont3 = new Contributeur("chadi", 5000);
        Contributeur cont4 = new Contributeur("fadi", 10000);
        Contributeur cont5 = new Contributeur("toni", 4000);

  
        grp1.ajouter(cont1);
        grp1.ajouter(cont2);
        assertTrue(grp1.accepter(new CompositeValide()));
        assertFalse(grp2.accepter(new CompositeValide()));
        assertFalse(grp3.accepter(new CompositeValide()));

        grp2.ajouter(cont3);
        grp2.ajouter(cont4);
        grp2.ajouter(grp1);
        assertTrue( grp1.accepter(new SansDoublon()));
        assertFalse(grp2.accepter(new SansDoublon()));
        assertTrue(grp3.accepter(new SansDoublon()));
        
      
        grp3.ajouter(cont5);
        grp3.ajouter(grp2);
        assertEquals(new Integer(3000), grp1.accepter(new DebitMaximal()));
        assertEquals( new Integer(3000), grp2.accepter(new DebitMaximal()));
        assertEquals( new Integer(3000), grp3.accepter(new DebitMaximal()));

    }

    public void testCompositeValide(){
        try{
            GroupeDeContributeurs g = new GroupeDeContributeurs("g");
            assertFalse(" Ce composite n'est pas valide, revoyez CompositeValide !!!", g.accepter(new CompositeValide()));

            GroupeDeContributeurs g1 = new GroupeDeContributeurs("g1");
            g.ajouter(g1);
            assertFalse(" Ce composite n'est pas valide, revoyez CompositeValide !!!", g.accepter(new CompositeValide()));

            g1.ajouter(new Contributeur("c",100));
            assertTrue(" Ce composite est valide, revoyez CompositeValide !!!", g.accepter(new CompositeValide()));

        }catch(Exception e){
            fail("exception inattendue !!! " + e.getMessage());
        }
    }

    public void testTroisContributeursUnGroupe(){
        try{
            GroupeDeContributeurs g = new GroupeDeContributeurs("g");
            g.ajouter(new Contributeur("g_a",100));
            g.ajouter(new Contributeur("g_b",200));
            g.ajouter(new Contributeur("g_c",300));
            assertTrue(" Ce composite est valide, revoyez CompositeValide !!!", g.accepter(new CompositeValide()));
            assertEquals(" Revoyez DébitMaximal !!!", new Integer(100), g.accepter(new DebitMaximal()));
            GroupeDeContributeurs g1 = new GroupeDeContributeurs("g1");
            g.ajouter(g1);
            assertFalse(" Ce composite n'est pas valide, revoyez CompositeValide !!!", g1.accepter(new CompositeValide()));
        }catch(Exception e){
            fail("exception inattendue !!! " + e.getMessage());
        }
    }

    public void testUnContributeurUnGroupeAvecLeMemeNom(){
        try{
            GroupeDeContributeurs g = new GroupeDeContributeurs("g_a");
            g.ajouter(new Contributeur("g_a",100));
            g.ajouter(new Contributeur("g_b",200));
            g.ajouter(new Contributeur("g_c",300));
            g.ajouter(new Contributeur("g_d",80));
            assertTrue(" Ce composite est valide, revoyez CompositeValide !!!", g.accepter(new CompositeValide()));
            assertFalse(" Ce composite a au moins un doublon, revoyez SansDoublon !!!", g.accepter(new SansDoublon()));
        }catch(Exception e){
            fail("exception inattendue !!! " + e.getMessage());
        }
    }
}