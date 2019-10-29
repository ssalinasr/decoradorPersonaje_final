/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decorador;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author sebas
 */
public class decoradorEnano extends Decorador{

    public decoradorEnano(JLabel expicon,int x,int y){
        super(expicon,x,y);
    }


    @Override
    public JLabel añadeLabel() throws InterruptedException{
        int equis = super.x;
        int ye = super.y;
        JLabel label_edit = super.decorated_icon;
        if(label_edit != null){
            boolean stat = super.status = true;
            hiloD(equis,ye,label_edit,stat);
        }
        else{
            JOptionPane.showMessageDialog(null,"Algo salió mal...","Error",0);
        }
        return label_edit;      
    }

    @Override
    public void hiloD(int equis, int ye, JLabel label_edit, boolean stat) throws InterruptedException {
        super.d = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    if(stat == true){
                    funcionD(equis,ye,label_edit,stat);
                    }
                else{
                    JOptionPane.showMessageDialog(null,"algo salió mal...","error",0); 
                    }
                } catch (InterruptedException ex) {
                    JOptionPane.showMessageDialog(null,"algo salió mal...","error",0);
                }
            }
        });
        d.start();
    }

    @Override
    public void funcionD(int equis, int ye, JLabel label_edit, boolean stat) throws InterruptedException{
        label_edit.setLocation(equis + 7, ye + 7);
        Thread.sleep(250);
        label_edit.setLocation(equis - 7, ye - 7);
        Thread.sleep(250);
        label_edit.setLocation(equis - 7, ye - 7);
        Thread.sleep(250);
        label_edit.setLocation(equis + 7, ye + 7);
        Thread.sleep(250);
        label_edit.setLocation(equis + 7, ye - 7);
        Thread.sleep(250);
        label_edit.setLocation(equis - 7, ye + 7);
        Thread.sleep(250);
        label_edit.setLocation(equis - 7, ye + 7);
        Thread.sleep(250);
        label_edit.setLocation(equis + 7, ye - 7);
        stat = false;
        super.status = stat;       
    }

   

}
