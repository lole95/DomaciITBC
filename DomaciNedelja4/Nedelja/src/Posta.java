import java.util.LinkedList;

/**
 * Project Nedelja, Package PACKAGE_NAME, Class delete3, Created by Milovan 21.8.2021.
 */
public class Posta {
    private LinkedList<Poruka> mail;
    //Konstruktori

    public Posta(LinkedList<Poruka> mail) {
        this.mail = mail;
    }

    public Posta() {
        this.mail = new LinkedList<>();
    }
    //Metode

    //Dodaje poruku p ako ne postoji
    public void add(Poruka p){
        for (Poruka poruka : mail){
            if (poruka.equals(p)){
                return;
            }
        }
        mail.add(p);
    }

    public void add(Poruka p, int index){
        for (Poruka poruka : mail){
            if (poruka.getId() == index){
                return;
            }
        }
        mail.add(p);
    }

    //Bride poruku p ako postoji
    public void remove(Poruka p){
        for (Poruka poruka : mail){
            if (poruka.equals(p)){
                mail.remove(p);
            }
        }
    }

    public void remove(int index){
        for (Poruka poruka : mail){
            if (poruka.getId() == index){
                mail.remove(poruka);
            }
        }
    }

    // Sifruje poruku p u listi ako ona postoji
    public void sifruj(Poruka p, int k){
        p.sifrujZaK(k);
    }

    public void sifruj(int index, int k){
        mail.get(index).sifrujZaK(k);
    }

    // Desifruje poruku p u listi ako ona postoji
    public void desifruj(Poruka p, int k){
        p.desifruj(k);
    }

    public void desifruj(int index, int k){
        mail.get(index).desifruj(k);
    }

    // Sifruje sve poruke za k
    public void sifrujSveZaK(int k){
        for (Poruka p : mail){
            p.sifrujZaK(k);
        }
    }

    public void desifrujSveZaK(int k){
        for (Poruka p : mail){
            p.desifruj(k);
        }
    }

    // Ispisuje u konzoli poruku p i brise je iz liste
    public void send(Poruka p){
        System.out.println(p);
        mail.remove(p);
    }

    /*Oblik:
     * {id}: {poruka}  // svaka u novom redu
     * */
    @Override
    public String toString() {
        String s = "";
        for (Poruka p : mail){
            s = s.concat(p.getId() + ": " + p.getPoruka() + "\n");
        }
        return s;
    }
}

