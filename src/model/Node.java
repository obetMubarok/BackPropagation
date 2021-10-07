/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

/**
 *
 * @author fendi
 */
public abstract class Node {
    protected  double nilai;

    public Node(double nilai) {
        this.nilai = nilai;
    }

    public double getNilai() {
        return nilai;
    }

    public void setNilai(double nilai) {
        this.nilai = nilai;
    }
    public int getNilaiBulat(){
        if(nilai>=0.5){
            return 1;
        }else return 0;
    }
    abstract public double getBias();
    abstract public double getError();
}
