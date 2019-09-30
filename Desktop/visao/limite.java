/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author victor tesoura jr
 */
public class limite extends PlainDocument {

    int max = 0;

    public limite(int a) {
        this.max = a;
    }

    @Override
    public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
        int tamanho = (this.getLength() + str.length());
        if (tamanho <= max) {
            super.insertString(offs, str, a);
        } else {
            super.insertString(offs, str.replaceAll("[aA0-zZ9]", ""), a);
        }
    }
}
