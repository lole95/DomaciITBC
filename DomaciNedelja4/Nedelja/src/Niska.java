import java.util.Arrays;

/**
 * Project Nedelja, Package PACKAGE_NAME, Class Niska, Created by Milovan 21.8.2021.
 */
public class Niska {
    /*Private fields*/
    private char[] chars;

    /*Constructors*/
    public Niska(){
        this.chars = new char[0];
    }

    public Niska(char[] chars){
        this.chars = chars;
    }

    public char[] getChars() {
        return chars;
    }

    public void setChars(char[] chars) {
        this.chars = chars;
    }

    //*Methods*//
    public int length(){
        return chars.length;
    }

    public char charAt(int index){
        return chars[index];
    }

    public boolean equals(Niska n){
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != n.charAt(i)){
                return false;
            }
        }
        return true;
    }

    public boolean equalsIgnoreCase(Niska n){
        for (int i = 0; i < chars.length; i++) {
            if (Character.toLowerCase(chars[i]) != Character.toLowerCase(n.charAt(i))){
                return false;
            }
        }
        return true;
    }

    public Niska concat(Niska n){
        char[] novaNiska = new char[chars.length + n.length()];
        int index = 0;
        for (int i = 0; i < chars.length; i++) {
            novaNiska[i] = chars[i];
        }
        for (int i = chars.length; i < novaNiska.length; i++) {
            novaNiska[i] = n.charAt(index++);
        }
        return new Niska(novaNiska);
    }

    public Niska subNiska(int index){
        char[] novaNiska = new char[chars.length - index];
        int brojac = 0;
        for (int i = index; i < chars.length; i++) {
            novaNiska[brojac++] = chars[i];
        }
        return new Niska(novaNiska);
    }

    public Niska subNiska(int startIndex, int endIndex){
        char[] novaNiska = new char[chars.length - startIndex - (chars.length - endIndex)];
        int brojac = 0;
        for (int i = startIndex; i < chars.length - (chars.length - endIndex); i++) {
            novaNiska[brojac++] = chars[i];
        }
        return new Niska(novaNiska);
    }

    public boolean startsWith(Niska n){
        for (int i = 0; i < n.length(); i++) {
            if (chars[i] != n.charAt(i)){
                return false;
            }
        }
        return true;
    }

    public boolean endsWith(Niska n){
        int index = 0;
        for (int i = chars.length - n.length(); i < chars.length; i++) {
            if (chars[i] != n.charAt(index++)){
                return false;
            }
        }
        return true;
    }

    public Niska toLowerCase(){
        char[] novaNiska = new char[chars.length];
        for (int i = 0; i < chars.length; i++) {
            novaNiska[i] = Character.toLowerCase(chars[i]);
        }
        return new Niska(novaNiska);
    }

    public Niska toUpperCase(){
        char[] novaNiska = new char[chars.length];
        for (int i = 0; i < chars.length; i++) {
            novaNiska[i] = Character.toUpperCase(chars[i]);
        }
        return new Niska(novaNiska);
    }

    public int indexOf(char c){
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == c){
                return i;
            }
        }
        System.out.println("No character in ch[]");
        return -1;
    }

    public int lastIndexOf(char c){
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] == c){
                return i;
            }
        }
        System.out.println("No character in ch[]");
        return -1;
    }

    public Niska replace(Niska newNiska){
        // Menja sve oldNiska sa newNiska
        chars = newNiska.getChars();
        return new Niska(chars);
    }

    public boolean contains(char c){
        for (char x : chars){
            if (x == c){
                return true;
            }
        }
        return false;
    }

    public boolean contains(Niska n){
        for (int i = 0; i < chars.length - n.length(); i++) {
            boolean flag = true;
            int index = 0;
            for (int j = i; j < n.length() + i; j++) {
                if (chars[j] != n.charAt(index++)){
                    flag = false;
                    break;
                }
            }
            if (flag){
                return true;
            }
        }
        return false;
    }

    public boolean isEmpty(){
        for (char c : chars){
            if (c != ' '){
                return false;
            }
        }
        return true;
    }

    public boolean isBlank(){
        if (chars.length == 0){
            return true;
        }
        return false;
    }

    public Niska repeat(int n){
        char[] novaNisaka = new char[chars.length*n];
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < chars.length; j++) {
                novaNisaka[index++] = chars[j];
            }
        }
        return new Niska(novaNisaka);
    }

    public Niska trim(){
        int prednjiRazmaci = 0;
        int zadnjiRazmaci = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' '){
                prednjiRazmaci++;
            }
            else
            break;
        }
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] == ' '){
                zadnjiRazmaci++;
            }
            else
            break;
        }
        if (chars.length - prednjiRazmaci - zadnjiRazmaci <= 0){
            return new Niska();
        }
        char[] novaNiska = new char[chars.length - prednjiRazmaci - zadnjiRazmaci];
        int index = 0;

        for (int i = prednjiRazmaci; i < novaNiska.length + prednjiRazmaci; i++) {
            novaNiska[index++] = chars[i];
        }
        return new Niska(novaNiska);
    }

    @Override
    public String toString() {
        return Arrays.toString(chars);
    }
}

