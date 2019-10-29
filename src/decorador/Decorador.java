/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decorador;

import javax.swing.JLabel;


/**
 *
 * @author sebas
 */
public abstract class Decorador {
    
    protected JLabel decorated_icon;
    protected int x;
    protected int y;
    protected Thread d;
    protected boolean status;

    
    public Decorador(JLabel expicon, int x, int y){
        this.decorated_icon = expicon; 
        this.x = x;
        this.y = y;
        this.status = true;
    }
    
    public abstract JLabel añadeLabel() throws InterruptedException;
    public abstract void hiloD(int equis, int ye, JLabel label_edit, boolean stat) 
            throws InterruptedException;
    public abstract void funcionD(int equis, int ye,
            JLabel label_edit, boolean stat) throws InterruptedException;
    
}
