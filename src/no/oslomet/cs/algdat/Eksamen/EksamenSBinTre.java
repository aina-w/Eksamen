package no.oslomet.cs.algdat.Eksamen;


import java.sql.SQLOutput;
import java.util.*;

public class EksamenSBinTre<T> {


    private static final class Node<T>   // en indre nodeklasse
    {
        private T verdi;                   // nodens verdi
        private Node<T> venstre, høyre;    // venstre og høyre barn
        private Node<T> forelder;          // forelder

        // konstruktør
        private Node(T verdi, Node<T> v, Node<T> h, Node<T> forelder) {
            this.verdi = verdi;
            venstre = v;
            høyre = h;
            this.forelder = forelder;
        }

        private Node(T verdi, Node<T> forelder)  // konstruktør
        {
            this(verdi, null, null, forelder);
        }

        @Override
        public String toString() {
            return "" + verdi;
        }

    } // class Node



    private Node<T> rot;                            // peker til rotnoden
    private int antall;                             // antall noder
    private int endringer;                          // antall endringer

    private final Comparator<? super T> comp;       // komparator

    public EksamenSBinTre(Comparator<? super T> c)    // konstruktør
    {
        rot = null;
        antall = 0;
        comp = c;
    }





    public String toStringPostOrder() {
        if (tom()) return "[]";

        StringJoiner s = new StringJoiner(", ", "[", "]");

        Node<T> p = førstePostorden(rot); // går til den første i postorden
        while (p != null) {
            s.add(p.verdi.toString());
            p = nestePostorden(p);
        }

        return s.toString();
    }


    /////////////////////////// OPPGAVE 1 //////////////////////////////////////////////

    /*  Kopiert kode fra kompendiet 5.2.3a) */
    public boolean leggInn(T verdi) {
        Objects.requireNonNull(verdi, "Ikke love med null-verdier");


        Node<T> p = rot, q = null;  //p starter i roten
        int cmp = 0;    //hjelpevariabel

        while(p != null) {  //fortsetter til p er ute av treet
            q = p;  //forelder er forelder til p
            cmp = comp.compare(verdi, p.verdi); //bruker komparatoren
            p = cmp < 0 ? p.venstre : p.høyre;
        }

        //p er nå null, som betyr at den er ute av treet, forelder er den siste vi passerte

        p = new Node<>(verdi, q);  //oppretter en ny node

        if(q == null) rot = p;  //p blir rotnode
        else if(cmp < 0) q.venstre = p; //venstre barn til q
        else q.høyre = p;   //høyre barn til q

        antall++;   //en verdi mer i treet
        return true;    //vellykket innlegging

    }

    /////////////////////////// OPPGAVE 2 //////////////////////////////////////////////
    public boolean tom() {
        return antall == 0;
    }

    public boolean inneholder(T verdi) {
        if (verdi == null) return false;

        Node<T> p = rot;

        while (p != null) {
            int cmp = comp.compare(verdi, p.verdi);
            if (cmp < 0) p = p.venstre;
            else if (cmp > 0) p = p.høyre;
            else return true;
        }

        return false;
    }

    public int antall() {
        return antall;
    }


    public int antall(T verdi) {

        Node<T> p = rot;
        int antall = 0;     //Hjelpevariabel for å holde styr på antallet forekomster

        while (p != null) {     //Kjører når vi vet det finnes noder
            int cmp = comp.compare(verdi, p.verdi); //Bruker komparatoren på verdien i treeet og p
            if(cmp < 0) p = p.venstre;      //Hvis komparator er mindre enn 0, får p ny verdi til venstre
            else {
                if(cmp == 0) antall++;      //Hvis komparator er null, øker antall og p får verdi til høyre
                p = p.høyre;
            }
        }
        return antall;

    }

    /////////////////////////// OPPGAVE 3 //////////////////////////////////////////////

    private static <T> Node<T> førstePostorden(Node<T> p) {
        /*Kopiert kode fra kompendiet 5.1.7h) */
        Objects.requireNonNull(p, "Null-verdier er ikke tillatt");

        while(true) {
            if(p.venstre != null) p = p.venstre;
            else if(p.høyre != null) p = p.høyre;
            else return p;
        }
    }

    private static <T> Node<T> nestePostorden(Node<T> p) {
        if(p.forelder == null) {        //Sjekker om p er rot-noden
            return null;
        }
        else if(p.forelder != null && p == p.forelder.høyre) {  //Hvis p er et høyre barn vil p sin forelder være neste i postorden
            p = p.forelder;
        }
        else if(p.forelder != null && p == p.forelder.venstre) {    //Hvis p er et venstre barn, og p sin forelder ikke har et høyre barn
            if(p.forelder.høyre == null) {                              //^ er p sin forelder neste i postorden
                p = p.forelder;
            }
            else {
                p = p.forelder.høyre;               //Den neste i postorden vil alltid være den lengst til venstre sitt høyre barn
                while(p.venstre != null) {              //^dersom den eksisterer
                    p = p.venstre;
                }
            }
        }
        return p;
    }

    /////////////////////////// OPPGAVE 4 //////////////////////////////////////////////


    public void postorden(Oppgave<? super T> oppgave) {

        Node<T> p = førstePostorden(rot);
        while (p != null) {
            oppgave.utførOppgave(p.verdi);
            p = nestePostorden(p);
        }
    }


    private void postordenRecursive(Node<T> p, Oppgave<? super T> oppgave) {
        if(p.venstre != null) {
            postordenRecursive(p.venstre, oppgave);
        }
        if(p.høyre != null) {
            postordenRecursive(p.høyre, oppgave);
        }
        oppgave.utførOppgave(p.verdi);
    }
    public void postordenRecursive(Oppgave<? super T> oppgave) {
        postordenRecursive(rot, oppgave);
    }


    /////////////////////////// OPPGAVE 5 //////////////////////////////////////////////

    public ArrayList<T> serialize() {
        throw new UnsupportedOperationException("Ikke kodet ennå!");
    }

    static <K> EksamenSBinTre<K> deserialize(ArrayList<K> data, Comparator<? super K> c) {
        throw new UnsupportedOperationException("Ikke kodet ennå!");
    }

    /////////////////////////// OPPGAVE 6 //////////////////////////////////////////////

    /*Kopiert kode fra kompendiet 5.2.8d) */
    public boolean fjern(T verdi) {
        if(verdi == null) {
            return false;
        }

        Node<T> p = rot, q = null;

        while(p != null) {
            int cmp = comp.compare(verdi, p.verdi);
            if(cmp < 0) {
                q = p;
                p = p.venstre;
            }
            else if(cmp > 0) {
                q = p;
                p = p.høyre;
            }
            else {
                break;
            }

        }
        if(p == null) {
            return false;
        }
        if(p.venstre == null || p.høyre == null) {
            Node<T> b = p.venstre != null ? p.venstre : p.høyre;
            if(p == rot) {
                rot = b;
            }
            else if(p == q.venstre) {
                q.venstre = b;
            }
            else {
                q.høyre = b;
            }
        }
        else {
            Node<T> s = p, r = p.høyre;
            while(r.venstre != null) {
                s = r;
                r = r.venstre;
            }
            p.verdi = r.verdi;
            if(s != p) {
                s.venstre = r.høyre;
            }
            else {
                s.høyre = r.høyre;
            }
        }
        antall--;
        return true;
    }

    public int fjernAlle(T verdi) {
        if(verdi == null) {
            return 0;
        }
        int antall = 0;
        while(fjern(verdi)) {
            antall++;
        }
        return antall;
    }



    public void nullstill() {
        Node<T> p = rot;
        if(p.venstre != null) {
            nullstill();
            p.venstre = null;
            antall--;
        }
        if(p.høyre != null) {
            nullstill();
            p.høyre = null;
            antall--;
        }
        p.verdi = null;
    }










} // ObligSBinTre
