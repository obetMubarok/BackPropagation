/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package backpropagation;

import java.awt.Color;

/**
 *
 * @author fendi
 */
public class Button extends javax.swing.JButton{
    private final int AKTIF=1,TIDAK_AKTIF=0;
    private int status;
    public Button() {
        status=AKTIF;
        tekanButton();
    }
    public void tekanButton(){
        if(status==AKTIF){
            status=TIDAK_AKTIF;
            setBackground(Color.white);
            setForeground(Color.black);
            setText("0");
        }else{
            status=AKTIF;
            setBackground(Color.black);
            setForeground(Color.white);
            setText("1");
        }
    }
    public void reset(){
        status=TIDAK_AKTIF;
        setBackground(Color.white);
        setForeground(Color.black);
        setText("0");
    }
    public int getNilai(){
        return status;
    }
}
