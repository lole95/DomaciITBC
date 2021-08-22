/**
 * Project Nedelja, Package PACKAGE_NAME, Class delete2, Created by Milovan 21.8.2021.
 */
public class Poruka {
    private Niska poruka;
    private Niska posiljalac;
    private Niska primalac;
    private int id; // jedinstveni broj
    /*
     * Default vrednosti:
     * poruka = posiljalac = primalac = null
     * id = 0
     * */

    //Konstruktori

    public Poruka(Niska poruka, Niska posiljalac, Niska primalac, int id) {
        this.poruka = poruka;
        this.posiljalac = posiljalac;
        this.primalac = primalac;
        this.id = id;
    }

    public Poruka() {
        poruka = null;
        posiljalac = null;
        primalac = null;
        id = 0;
    }

    //Metode


    public Niska getPoruka() {
        return poruka;
    }

    public void setPoruka(Niska poruka) {
        this.poruka = poruka;
    }

    public Niska getPosiljalac() {
        return posiljalac;
    }

    public void setPosiljalac(Niska posiljalac) {
        this.posiljalac = posiljalac;
    }

    public Niska getPrimalac() {
        return primalac;
    }

    public void setPrimalac(Niska primalac) {
        this.primalac = primalac;
    }

    public int getId() {
        return id;
    }

    //Svako slovo iz poruke shiftuje za k pozicija u ASCII tabeli
    // k moze da bude negativno
    public void sifrujZaK(int k){
        char[] novaPoruka = new char[poruka.length()];
        for (int i = 0; i < poruka.length(); i++) {
            novaPoruka[i] = (char)((int)poruka.charAt(i) + k);
        }
        poruka.replace(new Niska(novaPoruka));
    }

    // Desifruje poruku shiftovamo za k
    // k je isto kao iza sifrujZaK
    public void desifruj(int k){
        char[] novaPoruka = new char[poruka.length()];
        for (int i = 0; i < poruka.length(); i++) {
            novaPoruka[i] = (char)((int)poruka.charAt(i) - k);
        }
        poruka.replace(new Niska(novaPoruka));
    }

    // Oblik:
    /*
     * {id}
     * {posiljalac} salje {primalac} poruku:
     * {poruka}
     * */
    @Override
    public String toString() {

        return id +"\n"
                + posiljalac + " salje " + primalac + " poruku:\n"
                + poruka;
    }
}

