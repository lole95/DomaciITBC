package stek.zadaci;


import java.util.*;

public class Zadaci {
    /*
     * 1. Palacinke
     * Sara pravi palacinke sa dzemom, nutelom i sunkom za svoje drugare.
     * Funkciji se prosledjuje niska sa vrsom palacinke koju je Sara napravila, odovjene novim redom, redom;
     * kao i broj n koji oznacava koliko palacinaka ce pojesti Sarini prijatelji.
     * Ispisati kojim redom ce koje palacinke Sara pojesti posle svojih drugara, ako znamo da ce da pojede sve koje ostanu.
     *
     * NPR:
     * Nutela
     * Sunka
     * Nutela
     * Dzem
     * 2
     * ---------
     * Sunka
     * Nutela
     * */

    public static String palacinke(String s, int n){
        String[] array = s.split("\\R");
        Stack<String> stack = new Stack<>();
        for (String string : array){
            stack.push(string);
        }
        for (int i = 0; i < n; i++) {
            if (!stack.isEmpty())
                stack.pop();
        }
        String result = "";
        if (stack.isEmpty())
            return ":(";
        while (!stack.isEmpty())
            result = result.concat(stack.pop()).concat("\n");

        return result.strip();
    }

    /*
     * 2. Istorija web pregledaca
     * Прегледач веба памти историју посећених сајтова и корисник има могућност да се враћа унатраг
     *  на сајтове које је раније посетио.
     * Написати програм који симулира историју прегледача тако што се учитавају адресе
     *  посећених сајтова (свака у посебном реду),
     * а када се учита ред у коме пише back прегледач се враћа на последњу посећену страницу.
     * Ако се наредбом back вратимо на почетну страницу, исписати -.
     * Ако се на почетној страници изда наредба back, остаје се на почетној страници.
     * Програм треба да испише све сајтове које је корисник посетио.
     * Улаз: Са стандардног улаза се учитавају веб-адресе, свака у посебној линији,
     *  koje се даље уписују у String, свака у посебном реду.
     * Излаз: Вратити String са исписаним сајтовима редом посећиваним.
     * */

    public static String history(String search){
        String[] array = search.split("\\R");
        Stack<String> stack = new Stack<>();
        String allVisitedSites = "";
        for (String s : array){
            if (s.equals("back")){
                if (stack.isEmpty()){
                    allVisitedSites = allVisitedSites.concat("-").concat("\n");
                    continue;
                }
                else if (stack.size() == 1){
                    stack.pop();
                    allVisitedSites = allVisitedSites.concat("-").concat("\n");
                    continue;
                }
                else {
                    stack.pop();
                    allVisitedSites = allVisitedSites.concat(stack.peek()).concat("\n");
                    continue;
                }
            }
            stack.push(s);
            allVisitedSites = allVisitedSites.concat(stack.peek()).concat("\n");
        }
        return allVisitedSites.strip();
    }

    /*
     * 3. Uparenost zagrada:
     * У изразу учествују следеће врсте заграда (, ), {, }, [ и ].
     * Напиши програм који проверава да ли су у унетом изразу заграде исправно упарене.
     * Улаз: Са стандардног улаза се уноси израз (цео у једном реду, без размака), које се даље уписују у String.
     * Излаз: Boolean.
     * */

    public static boolean uparenost(String s){

        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char trenutni = chars[i];
            if (trenutni == '(' || trenutni == '[' || trenutni == '{'){
                stack.push(trenutni);
            }
            else if(trenutni == ')' || trenutni == ']' || trenutni == '}'){
                if(stack.isEmpty())
                    return false;
                else{
                    char otvorena = stack.pop();
                    switch (trenutni){
                        case ')':
                            if (otvorena != '(')
                                return false;
                            break;
                        case ']':
                            if (otvorena != '[')
                                return false;
                            break;
                        default: //'}'
                            if (otvorena != '{')
                                return false;
                            break;
                    }
                }
            }
        }
        return stack.isEmpty();
    }

    /*
     * 4. Uzastopni brojevi
     * Низ се трансформише тако што се сваких 2 узастопних појављивања неког елемента бришу.
     * Напиши програм који одређује садржај низа након исцрпне примене ове трансформације.
     * Улаз:Са стандардног улаза се учитава елементи низа.
     * Излаз: На стандардни излаз исписати елементе резултујућег низа, раздвојене размаком.
     * NPR:
     * 1 1 2 2 2 2 1 3 4 4 5 5 4 4 3 2 1 1 1
     * "1 3 3 2 1"
     * */

    public static String uzastopni(int[] arr){
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (stack.isEmpty()){
                stack.push(arr[i]);
                continue;
            }
            if (stack.peek() == arr[i]){
                stack.pop();
                continue;
            }
            sb.append(stack.pop()).append(" ");
            stack.push(arr[i]);
        }

        if (!stack.isEmpty())
            sb.append(stack.pop());

        return sb.toString().trim();
    }

    /*
     * 5. Linijski editor
     * Sa standardnog ulaza se unose niske karaktera koje opisuju neku akciju. Akcije su sledece:
     * iX - korisnike je otkucao karakter X
     * < - korisnik je pritisnuo taster levo
     * > - korisnik je pritisnuo taster desno
     * b - korisnik je pritisnuo taster backspace za brisanje karaktera iza kursora
     * d - korisnik je pritisnuo taster delete za brisanje karaktera ispred kursora
     *
     * Vratiti String dobijen izvrsavanjem svih ackija
     *
     * NPR:
     * iaib<bic>>
     * cb
     *
     * Objasnjenje:
     * Tekst     Naredba
     * |         ia
     * a|        ib
     * ab|       <
     * a|b       b
     * |b        ic
     * c|b       >
     * cb|       >
     * cb|
     *
     * */

    public static String console(String input){
//      iX - korisnike je otkucao karakter X
//      < - korisnik je pritisnuo taster levo
//      > - korisnik je pritisnuo taster desno
//      b - korisnik je pritisnuo taster backspace za brisanje karaktera iza kursora
//      d - korisnik je pritisnuo taster delete za brisanje karaktera ispred kursora
        Stack<Character> stackLeft = new Stack<>();
        Stack<Character> stackRight = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            switch (input.charAt(i)){
                case 'i':
                    stackLeft.push(input.charAt(i + 1));
                    i++;
                    break;
                case '<': // 123456
                    if (!stackLeft.isEmpty())
                        stackRight.push(stackLeft.pop());
                    break;
                case '>':
                    if (!stackRight.isEmpty())
                        stackLeft.push(stackRight.pop());
                    break;
                case 'b':
                    if (!stackLeft.isEmpty())
                       stackLeft.pop();
                    break;
                case 'd':
                    if (!stackRight.isEmpty())
                        stackRight.pop();
                    break;
            }
        }
        while (!stackLeft.empty())
            stackRight.push(stackLeft.pop());

        while (!stackRight.empty())
            sb.append(stackRight.pop());

        return sb.toString();
    }

    /*
     * 6. Vrednost postfiksnog izraza
     * Са стандардног улаза се учитава постфиксно записан израз
     * који садржи једноцифрене бројеве и операторе +, -, * и / (без размака).
     * Ispisati vrednost izraza
     *
     * NPR:
     * 12+3*
     * 9
     *
     * Objasnjenje:
     * 12+3* -> (1+2)*3 = 3*3 = 9
     * */

    public static int eval(String s){
        Stack<Integer> stack = new Stack<>();
        for (Character c : s.toCharArray()){
            if (Character.isDigit(c))
                stack.push(Character.getNumericValue(c));
            else {
                if (c == '+'){
                    stack.push(stack.pop() + stack.pop());
                }
                else if (c == '*'){
                    stack.push(stack.pop() * stack.pop());
                }
                else if (c == '-'){
                    int x = stack.pop();
                    int y = stack.pop();
                    stack.push(y - x);
                }
                else if (c == '/'){
                    int x = stack.pop();
                    int y = stack.pop();
                    stack.push(y / x);
                }
            }

            }

        return stack.pop();
    }


    /*
    * 7. Berza
    * Duzina Si cene neke hartije ne berzi je definisana kao najveci broj uzastopnih dana,
    * pre datog dana, za koje je cena hartije manja ili jednaka trenutnoj ceni.
    * Za dat niz cena jedne hartije, vratiti niz duzina Si za svaki od tih dana
    *
    * NPR:
    * Cene po danima:      [100, 80, 60, 70, 60, 75, 85]
    * Si duzine po danima: [  1,  1,  1,  2,  1,  4,  6]
    * */

    public static int[] hartije(int... hartija){

        int[] siLenght = new int[hartija.length];

        for (int i = hartija.length - 1; i >= 0; i--) {
            Stack<Integer> stack = new Stack<>();
            stack.push(hartija[i]);
            for (int j = i - 1; j >= 0 ; j--) {
                if (hartija[j] <= hartija[i]){
                    stack.push(hartija[j]);
                    if (j == 0){
                        siLenght[i] = stack.size();
                        break;
                    }
                }
                else {
                    siLenght[i] = stack.size();
                    break;
                }
            }
        }
        if (siLenght.length > 0)
            siLenght[0] = 1;
        System.out.println(Arrays.toString(siLenght));
        if (siLenght.length == 0)
            return null;
        return siLenght;
    }
}
