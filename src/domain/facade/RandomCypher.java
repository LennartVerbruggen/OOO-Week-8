//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package domain.facade;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class RandomCypher implements EncodingInterface{
    private Map<Character, Character> codes = new HashMap();

    public RandomCypher() {
        this.codes.put('a', 'f');
        this.codes.put('b', 'n');
        this.codes.put('c', 'd');
        this.codes.put('d', 'v');
        this.codes.put('e', 'g');
        this.codes.put('f', 'x');
        this.codes.put('g', 'z');
        this.codes.put('h', 'o');
        this.codes.put('i', 'l');
        this.codes.put('j', 'r');
        this.codes.put('k', 'u');
        this.codes.put('l', 'a');
        this.codes.put('m', 'k');
        this.codes.put('n', 'i');
        this.codes.put('o', 's');
        this.codes.put('p', 'e');
        this.codes.put('q', 'x');
        this.codes.put('r', 'p');
        this.codes.put('s', 'b');
        this.codes.put('t', 'y');
        this.codes.put('u', 'm');
        this.codes.put('v', 'h');
        this.codes.put('w', 'w');
        this.codes.put('x', 't');
        this.codes.put('y', 'q');
        this.codes.put('z', 'j');
    }

    public char[] encypher(char[] message) {
        char[] result = new char[message.length];

        for(int i = 0; i < message.length; ++i) {
            result[i] = (Character)this.codes.get(message[i]);
        }

        return result;
    }

    public char[] decypher(char[] message) {
        char[] result = new char[message.length];

        for(int i = 0; i < message.length; ++i) {
            result[i] = this.getChar(message[i]);
        }

        return result;
    }

    private Character getChar(char cypher) {
        Iterator var3 = this.codes.entrySet().iterator();

        while(var3.hasNext()) {
            Map.Entry<Character, Character> e = (Map.Entry)var3.next();
            if ((Character)e.getValue() == cypher) {
                return (Character)e.getKey();
            }
        }

        return cypher;
    }

    public String crypt(String tekst){
        return new String(this.encypher(tekst.toCharArray()));
    }

    public String decrypt(String tekst){
        return new String(this.decypher(tekst.toCharArray()));
    }
}
