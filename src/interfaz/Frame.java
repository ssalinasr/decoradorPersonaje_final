/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import builder.*;
import decorador.*;
import javax.swing.JOptionPane;

/**
 *
 * @author estudiantes
 */
public class Frame extends javax.swing.JFrame {

    private Personaje personaje;
    private PrototypePersonaje pp;
    private Decorador dec;
    private Personaje pp1;
    private Personaje pp2;
    private Personaje pp3;
    private Thread h1;
    private Thread h2;
    private Thread h3;
    private Thread h4;
    private boolean est1;
    private boolean est2;
    private boolean est3;
    private boolean est4;

    /**
     * Creates new form Frame
     */
    public Frame() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        this.est1 = false;
        this.est2 = false;
        this.est3 = false;
        this.est4 = false;
        this.GroupDecorar.add(this.RadioBtnDecorar);   
    }

    public void instanciaPersonaje(String p) throws CloneNotSupportedException {
        Director director = new Director();
        BuilderPersonaje humano = new ConstructorPersonajeHumano();
        BuilderPersonaje enano = new ConstructorPersonajeEnano();
        BuilderPersonaje elfo = new ConstructorPersonajeElfo();

        if (p.equals("Humano")) {
            director.setBuilderPersonaje(humano);
            director.construirPersonaje();
            personaje = director.getPersonaje();
            pp = new PrototypePersonaje();
            pp1 = (Personaje) pp.prototipo("humano");
            pp2 = (Personaje) pp.prototipo("humano");
            pp3 = (Personaje) pp.prototipo("humano");
        } else {
            if (p.equals("Enano")) {
                director.setBuilderPersonaje(enano);
                director.construirPersonaje();
                personaje = director.getPersonaje();
                pp = new PrototypePersonaje();
                pp1 = (Personaje) pp.prototipo("enano");
                pp2 = (Personaje) pp.prototipo("enano");
                pp3 = (Personaje) pp.prototipo("enano");
            } else {
                if (p.equals("Elfo")) {
                    director.setBuilderPersonaje(elfo);
                    director.construirPersonaje();
                    personaje = director.getPersonaje();
                    pp = new PrototypePersonaje();
                    pp1 = (Personaje) pp.prototipo("elfo");
                    pp2 = (Personaje) pp.prototipo("elfo");
                    pp3 = (Personaje) pp.prototipo("elfo");
                }
            }
        }
    }

    public boolean isEst1() {
        return est1;
    }

    public void setEst1(boolean est1) {
        this.est1 = est1;
    }

    public boolean isEst2() {
        return est2;
    }

    public void setEst2(boolean est2) {
        this.est2 = est2;
    }

    public boolean isEst3() {
        return est3;
    }

    public void setEst3(boolean est3) {
        this.est3 = est3;
    }

    public boolean isEst4() {
        return est4;
    }

    public void setEst4(boolean est4) {
        this.est4 = est4;
    }

    /**
     * .start de los hilos
     */
    public void hilos() {
        this.h1 = new Thread(new Runnable() {
            @Override
            public void run() {
                if (isEst1()) {
                    try {
                        Anima1();
                    } catch (InterruptedException ex) {
                        JOptionPane.showMessageDialog(null, "Hilo Interrumpido", "Error", 0);
                    }
                }
            }
        });

        this.h2 = new Thread(new Runnable() {
            @Override
            public void run() {
                if (isEst2()) {
                    try {
                        Anima2();
                    } catch (InterruptedException ex) {
                        JOptionPane.showMessageDialog(null, "Hilo Interrumpido", "Error", 0);

                    }
                }
            }
        });

        this.h3 = new Thread(new Runnable() {
            @Override
            public void run() {
                if (isEst3()) {
                    try {
                        Anima3();
                    } catch (InterruptedException ex) {
                        JOptionPane.showMessageDialog(null, "Hilo Interrumpido", "Error", 0);

                    }
                }
            }
        });

        this.h4 = new Thread(new Runnable() {
            @Override
            public void run() {
                if (isEst4()) {
                    try {
                        Anima4();
                    } catch (InterruptedException ex) {
                        JOptionPane.showMessageDialog(null, "Hilo Interrumpido", "Error", 0);

                    }
                }
            }
        });

        this.h1.start();
        this.h2.start();
        this.h3.start();
        this.h4.start();
    }

    /**
     * Ciclo Animación 1 Animación Caminar
     *
     * @throws InterruptedException
     */
    public void Anima1() throws InterruptedException {

        if (isEst1()) {
            if(this.BoxAnima1.isSelected()){
            this.LblAnima1.setEnabled(true);
            }
            else{
               this.LblAnima1.setEnabled(false); 
            }
            if(this.BoxAnima5.isSelected()){
            this.LblAnima5.setEnabled(true);
            }
            else{
               this.LblAnima5.setEnabled(false);
            }
            if(this.BoxAnima6.isSelected()){
            this.LblAnima6.setEnabled(true);
            }
            else{
                this.LblAnima6.setEnabled(false);
            }
            if(this.BoxAnima7.isSelected()){
            this.LblAnima7.setEnabled(true);
            }
            else{
                this.LblAnima7.setEnabled(false);
            }
            
            int cont = 0;
            while (cont < 9 && isEst1()) {
                cont = (cont + 1) % 8;
                this.LblAnima1.setIcon(personaje.getWalk()[cont]);
                this.LblAnima5.setIcon(pp1.getWalk()[cont]);
                this.LblAnima6.setIcon(pp2.getWalk()[cont]);
                this.LblAnima7.setIcon(pp3.getWalk()[cont]);
                Thread.sleep(125);
            }
            this.LblAnima1.setEnabled(false);
            this.LblAnima5.setEnabled(false);
            this.LblAnima6.setEnabled(false);
            this.LblAnima7.setEnabled(false);
        }
    }

    /**
     * Ciclo Animación 2 Animación Morir
     *
     * @throws InterruptedException
     */
    public void Anima2() throws InterruptedException {
        if (isEst2()) {
            if(this.BoxAnima2.isSelected()){
            this.LblAnima2.setEnabled(true);
            }
            else{
               this.LblAnima2.setEnabled(false); 
            }
            if(this.BoxAnima5.isSelected()){
            this.LblAnima5.setEnabled(true);
            }
            else{
               this.LblAnima5.setEnabled(false);
            }
            if(this.BoxAnima6.isSelected()){
            this.LblAnima6.setEnabled(true);
            }
            else{
                this.LblAnima6.setEnabled(false);
            }
            if(this.BoxAnima7.isSelected()){
            this.LblAnima7.setEnabled(true);
            }
            else{
                this.LblAnima7.setEnabled(false);
            }
            int cont = 0;
            while (cont < 7 && isEst2()) {
                cont = (cont + 1) % 6;
                this.LblAnima2.setIcon(personaje.getDead()[cont]);
                this.LblAnima5.setIcon(pp1.getDead()[cont]);
                this.LblAnima6.setIcon(pp2.getDead()[cont]);
                this.LblAnima7.setIcon(pp3.getDead()[cont]);
                Thread.sleep(125);
            }
            this.LblAnima2.setEnabled(false);
            this.LblAnima5.setEnabled(false);
            this.LblAnima6.setEnabled(false);
            this.LblAnima7.setEnabled(false);
        }

    }

    /**
     * Ciclo Animación 3 Animación Ataque
     *
     * @throws InterruptedException
     */
    public void Anima3() throws InterruptedException {
        if (isEst3()) {
            if(this.BoxAnima3.isSelected()){
            this.LblAnima3.setEnabled(true);
            }
            else{
               this.LblAnima3.setEnabled(false); 
            }
            if(this.BoxAnima5.isSelected()){
            this.LblAnima5.setEnabled(true);
            }
            else{
               this.LblAnima5.setEnabled(false);
            }
            if(this.BoxAnima6.isSelected()){
            this.LblAnima6.setEnabled(true);
            }
            else{
                this.LblAnima6.setEnabled(false);
            }
            if(this.BoxAnima7.isSelected()){
            this.LblAnima7.setEnabled(true);
            }
            else{
                this.LblAnima7.setEnabled(false);
            }
            int cont = 0;
            while (cont < 14 && isEst3()) {
                cont = (cont + 1) % 13;
                this.LblAnima3.setIcon(personaje.getAttack()[cont]);
                this.LblAnima5.setIcon(pp1.getAttack()[cont]);
                this.LblAnima6.setIcon(pp2.getAttack()[cont]);
                this.LblAnima7.setIcon(pp3.getAttack()[cont]);
                Thread.sleep(125);
            }
            this.LblAnima3.setEnabled(false);
            this.LblAnima5.setEnabled(false);
            this.LblAnima6.setEnabled(false);
            this.LblAnima7.setEnabled(false);
        }
    }

    /**
     * Ciclo Animación 4 Animación Movimiento
     *
     * @throws InterruptedException
     */
    public void Anima4() throws InterruptedException {
        if (isEst4()) {
            if(this.BoxAnima4.isSelected()){
            this.LblAnima4.setEnabled(true);
            }
            else{
               this.LblAnima4.setEnabled(false); 
            }
            if(this.BoxAnima5.isSelected()){
            this.LblAnima5.setEnabled(true);
            }
            else{
               this.LblAnima5.setEnabled(false);
            }
            if(this.BoxAnima6.isSelected()){
            this.LblAnima6.setEnabled(true);
            }
            else{
                this.LblAnima6.setEnabled(false);
            }
            if(this.BoxAnima7.isSelected()){
            this.LblAnima7.setEnabled(true);
            }
            else{
                this.LblAnima7.setEnabled(false);
            }
            int cont = 0;
            while (cont < 7 && isEst4()) {
                cont = (cont + 1) % 6;
                this.LblAnima4.setIcon(personaje.getMove()[cont]);
                this.LblAnima5.setIcon(pp1.getMove()[cont]);
                this.LblAnima6.setIcon(pp2.getMove()[cont]);
                this.LblAnima7.setIcon(pp3.getMove()[cont]);
                Thread.sleep(125);
            }
            this.LblAnima4.setEnabled(false);
            this.LblAnima5.setEnabled(false);
            this.LblAnima6.setEnabled(false);
            this.LblAnima7.setEnabled(false);
        }
    }

    /**
     * Función cambio de estados
     */
    public void validarAccion() throws CloneNotSupportedException, InterruptedException {
        String valuePer = this.cbbPers.getSelectedItem().toString();
        String valueBox = this.BoxSelection.getSelectedItem().toString();
        switch (valuePer) {
            case "Humano":
                instanciaPersonaje("Humano");
                switch (valueBox) {
                    case "A1":
                        setEst1(true);
                        setEst2(false);
                        setEst3(false);
                        setEst4(false);
                        if(this.RadioBtnDecorar.isSelected()){
                            dec = new decoradorHumano(this.LblAnima1,
                                    this.LblAnima1.getX(),this.LblAnima1.getY());
                            dec.añadeLabel();
                            dec = new decoradorHumano(this.LblAnima5,
                                    this.LblAnima5.getX(),this.LblAnima5.getY());
                            dec.añadeLabel();
                            dec = new decoradorHumano(this.LblAnima6,
                                    this.LblAnima6.getX(),this.LblAnima6.getY());
                            dec.añadeLabel();
                            dec = new decoradorHumano(this.LblAnima7,
                                    this.LblAnima7.getX(),this.LblAnima7.getY());
                            dec.añadeLabel();
                        }
                        break;
                    case "A2":
                        setEst1(false);
                        setEst2(true);
                        setEst3(false);
                        setEst4(false);
                        if(this.RadioBtnDecorar.isSelected()){
                            dec = new decoradorHumano(this.LblAnima2,
                                    this.LblAnima2.getX(),this.LblAnima2.getY());
                            dec.añadeLabel();
                            dec = new decoradorHumano(this.LblAnima5,
                                    this.LblAnima5.getX(),this.LblAnima5.getY());
                            dec.añadeLabel();
                            dec = new decoradorHumano(this.LblAnima6,
                                    this.LblAnima6.getX(),this.LblAnima6.getY());
                            dec.añadeLabel();
                            dec = new decoradorHumano(this.LblAnima7,
                                    this.LblAnima7.getX(),this.LblAnima7.getY());
                            dec.añadeLabel();
                        }
                        break;
                    case "A3":
                        setEst1(false);
                        setEst2(false);
                        setEst3(true);
                        setEst4(false);
                        if(this.RadioBtnDecorar.isSelected()){
                            dec = new decoradorHumano(this.LblAnima3,
                                    this.LblAnima3.getX(),this.LblAnima3.getY());
                            dec.añadeLabel();
                            dec = new decoradorHumano(this.LblAnima5,
                                    this.LblAnima5.getX(),this.LblAnima5.getY());
                            dec.añadeLabel();
                            dec = new decoradorHumano(this.LblAnima6,
                                    this.LblAnima6.getX(),this.LblAnima6.getY());
                            dec.añadeLabel();
                            dec = new decoradorHumano(this.LblAnima7,
                                    this.LblAnima7.getX(),this.LblAnima7.getY());
                            dec.añadeLabel();
                        }
                        break;
                    case "A4":
                        setEst1(false);
                        setEst2(false);
                        setEst3(false);
                        setEst4(true);
                        if(this.RadioBtnDecorar.isSelected()){
                            dec = new decoradorHumano(this.LblAnima4,
                                    this.LblAnima4.getX(),this.LblAnima4.getY());
                            dec.añadeLabel();
                            dec = new decoradorHumano(this.LblAnima5,
                                    this.LblAnima5.getX(),this.LblAnima5.getY());
                            dec.añadeLabel();
                            dec = new decoradorHumano(this.LblAnima6,
                                    this.LblAnima6.getX(),this.LblAnima6.getY());
                            dec.añadeLabel();
                            dec = new decoradorHumano(this.LblAnima7,
                                    this.LblAnima7.getX(),this.LblAnima7.getY());
                            dec.añadeLabel();
                        }
                        break;
                }
                break;
            case "Enano":
                instanciaPersonaje("Enano");
                switch (valueBox) {
                    case "A1":
                        setEst1(true);
                        setEst2(false);
                        setEst3(false);
                        setEst4(false);
                        if(this.RadioBtnDecorar.isSelected()){
                            dec = new decoradorEnano(this.LblAnima1,
                            this.LblAnima1.getX(),this.LblAnima1.getY());
                            dec.añadeLabel();
                            dec = new decoradorEnano(this.LblAnima5,
                            this.LblAnima5.getX(),this.LblAnima5.getY());
                            dec.añadeLabel();
                            dec = new decoradorEnano(this.LblAnima6,
                            this.LblAnima6.getX(),this.LblAnima6.getY());
                            dec.añadeLabel();
                            dec = new decoradorEnano(this.LblAnima7,
                            this.LblAnima7.getX(),this.LblAnima7.getY());
                            dec.añadeLabel();
                        }
                        break;
                    case "A2":
                        setEst1(false);
                        setEst2(true);
                        setEst3(false);
                        setEst4(false);
                        if(this.RadioBtnDecorar.isSelected()){
                            dec = new decoradorEnano(this.LblAnima2,
                            this.LblAnima2.getX(),this.LblAnima2.getY());
                            dec.añadeLabel();
                            dec = new decoradorEnano(this.LblAnima5,
                            this.LblAnima5.getX(),this.LblAnima5.getY());
                            dec.añadeLabel();
                            dec = new decoradorEnano(this.LblAnima6,
                            this.LblAnima6.getX(),this.LblAnima6.getY());
                            dec.añadeLabel();
                            dec = new decoradorEnano(this.LblAnima7,
                            this.LblAnima7.getX(),this.LblAnima7.getY());
                            dec.añadeLabel();
                        }
                        break;
                    case "A3":
                        setEst1(false);
                        setEst2(false);
                        setEst3(true);
                        setEst4(false);
                        if(this.RadioBtnDecorar.isSelected()){
                            dec = new decoradorEnano(this.LblAnima3,
                            this.LblAnima3.getX(),this.LblAnima3.getY());
                            dec.añadeLabel();
                            dec = new decoradorEnano(this.LblAnima5,
                            this.LblAnima5.getX(),this.LblAnima5.getY());
                            dec.añadeLabel();
                            dec = new decoradorEnano(this.LblAnima6,
                            this.LblAnima6.getX(),this.LblAnima6.getY());
                            dec.añadeLabel();
                            dec = new decoradorEnano(this.LblAnima7,
                            this.LblAnima7.getX(),this.LblAnima7.getY());
                            dec.añadeLabel();
                        }
                        break;
                    case "A4":
                        setEst1(false);
                        setEst2(false);
                        setEst3(false);
                        setEst4(true);
                        if(this.RadioBtnDecorar.isSelected()){
                            dec = new decoradorEnano(this.LblAnima4,
                            this.LblAnima4.getX(),this.LblAnima4.getY());
                            dec.añadeLabel();
                            dec = new decoradorEnano(this.LblAnima5,
                            this.LblAnima5.getX(),this.LblAnima5.getY());
                            dec.añadeLabel();
                            dec = new decoradorEnano(this.LblAnima6,
                            this.LblAnima6.getX(),this.LblAnima6.getY());
                            dec.añadeLabel();
                            dec = new decoradorEnano(this.LblAnima7,
                            this.LblAnima7.getX(),this.LblAnima7.getY());
                            dec.añadeLabel();
                        }
                        break;
                }
                break;
            case "Elfo":
                instanciaPersonaje("Elfo");
                switch (valueBox) {
                    case "A1":
                        setEst1(true);
                        setEst2(false);
                        setEst3(false);
                        setEst4(false);
                        if(this.RadioBtnDecorar.isSelected()){
                            dec = new decoradorElfo(this.LblAnima1,
                            this.LblAnima1.getX(),this.LblAnima1.getY());
                            dec.añadeLabel();
                            dec = new decoradorElfo(this.LblAnima5,
                            this.LblAnima5.getX(),this.LblAnima5.getY());
                            dec.añadeLabel();
                            dec = new decoradorElfo(this.LblAnima6,
                            this.LblAnima6.getX(),this.LblAnima6.getY());
                            dec.añadeLabel();
                            dec = new decoradorElfo(this.LblAnima7,
                            this.LblAnima7.getX(),this.LblAnima7.getY());
                            dec.añadeLabel();
                        }
                        break;
                    case "A2":
                        setEst1(false);
                        setEst2(true);
                        setEst3(false);
                        setEst4(false);
                        if(this.RadioBtnDecorar.isSelected()){
                            dec = new decoradorElfo(this.LblAnima2,
                            this.LblAnima2.getX(),this.LblAnima2.getY());
                            dec.añadeLabel();
                            dec = new decoradorElfo(this.LblAnima5,
                            this.LblAnima5.getX(),this.LblAnima5.getY());
                            dec.añadeLabel();
                            dec = new decoradorElfo(this.LblAnima6,
                            this.LblAnima6.getX(),this.LblAnima6.getY());
                            dec.añadeLabel();
                            dec = new decoradorElfo(this.LblAnima7,
                            this.LblAnima7.getX(),this.LblAnima7.getY());
                            dec.añadeLabel();
                        }
                        break;
                    case "A3":
                        setEst1(false);
                        setEst2(false);
                        setEst3(true);
                        setEst4(false);
                        if(this.RadioBtnDecorar.isSelected()){
                            dec = new decoradorElfo(this.LblAnima3,
                            this.LblAnima3.getX(),this.LblAnima3.getY());
                            dec.añadeLabel();
                            dec = new decoradorElfo(this.LblAnima5,
                            this.LblAnima5.getX(),this.LblAnima5.getY());
                            dec.añadeLabel();
                            dec = new decoradorElfo(this.LblAnima6,
                            this.LblAnima6.getX(),this.LblAnima6.getY());
                            dec.añadeLabel();
                            dec = new decoradorElfo(this.LblAnima7,
                            this.LblAnima7.getX(),this.LblAnima7.getY());
                            dec.añadeLabel();
                        }
                        break;
                    case "A4":
                        setEst1(false);
                        setEst2(false);
                        setEst3(false);
                        setEst4(true);
                        if(this.RadioBtnDecorar.isSelected()){
                            dec = new decoradorElfo(this.LblAnima4,
                            this.LblAnima4.getX(),this.LblAnima4.getY());
                            dec.añadeLabel();
                            dec = new decoradorElfo(this.LblAnima5,
                            this.LblAnima5.getX(),this.LblAnima5.getY());
                            dec.añadeLabel();
                            dec = new decoradorElfo(this.LblAnima6,
                            this.LblAnima6.getX(),this.LblAnima6.getY());
                            dec.añadeLabel();
                            dec = new decoradorElfo(this.LblAnima7,
                            this.LblAnima7.getX(),this.LblAnima7.getY());
                            dec.añadeLabel();
                        }
                        break;
                }
                break;

        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GroupDecorar = new javax.swing.ButtonGroup();
        LblAnima1 = new javax.swing.JLabel();
        BtnRun = new javax.swing.JButton();
        LblAnima2 = new javax.swing.JLabel();
        LblAnima3 = new javax.swing.JLabel();
        LblAnima4 = new javax.swing.JLabel();
        BoxSelection = new javax.swing.JComboBox<>();
        cbbPers = new javax.swing.JComboBox<>();
        LblAnima5 = new javax.swing.JLabel();
        LblAnima6 = new javax.swing.JLabel();
        LblAnima7 = new javax.swing.JLabel();
        RadioBtnDecorar = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        BoxAnima1 = new javax.swing.JCheckBox();
        BoxAnima2 = new javax.swing.JCheckBox();
        BoxAnima3 = new javax.swing.JCheckBox();
        BoxAnima4 = new javax.swing.JCheckBox();
        BoxAnima5 = new javax.swing.JCheckBox();
        BoxAnima6 = new javax.swing.JCheckBox();
        BoxAnima7 = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        LblAnima1.setFont(new java.awt.Font("Tahoma", 0, 64)); // NOI18N

        BtnRun.setText("Run");
        BtnRun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnRunActionPerformed(evt);
            }
        });

        LblAnima2.setFont(new java.awt.Font("Tahoma", 0, 64)); // NOI18N

        LblAnima3.setFont(new java.awt.Font("Tahoma", 0, 64)); // NOI18N

        LblAnima4.setFont(new java.awt.Font("Tahoma", 0, 64)); // NOI18N

        BoxSelection.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A1", "A2", "A3", "A4" }));
        BoxSelection.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                BoxSelectionItemStateChanged(evt);
            }
        });
        BoxSelection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BoxSelectionActionPerformed(evt);
            }
        });

        cbbPers.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Humano", "Elfo", "Enano" }));

        LblAnima5.setFont(new java.awt.Font("Tahoma", 0, 64)); // NOI18N

        LblAnima6.setFont(new java.awt.Font("Tahoma", 0, 64)); // NOI18N

        LblAnima7.setFont(new java.awt.Font("Tahoma", 0, 64)); // NOI18N

        RadioBtnDecorar.setText("Decorar");

        jLabel1.setText("Labels Activados");

        BoxAnima1.setText("Anima 1");
        BoxAnima1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                BoxAnima1StateChanged(evt);
            }
        });

        BoxAnima2.setText("Anima 2");
        BoxAnima2.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                BoxAnima2StateChanged(evt);
            }
        });

        BoxAnima3.setText("Anima 3");
        BoxAnima3.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                BoxAnima3StateChanged(evt);
            }
        });

        BoxAnima4.setText("Anima 4");
        BoxAnima4.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                BoxAnima4StateChanged(evt);
            }
        });

        BoxAnima5.setText("Anima 5");
        BoxAnima5.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                BoxAnima5StateChanged(evt);
            }
        });

        BoxAnima6.setText("Anima 6");
        BoxAnima6.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                BoxAnima6StateChanged(evt);
            }
        });

        BoxAnima7.setText("Anima 7");
        BoxAnima7.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                BoxAnima7StateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BtnRun, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(LblAnima6, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(LblAnima7, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(LblAnima5, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LblAnima1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbPers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(LblAnima2, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(LblAnima3, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(RadioBtnDecorar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(LblAnima4, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(BoxSelection, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BoxAnima1)
                    .addComponent(BoxAnima2)
                    .addComponent(BoxAnima3)
                    .addComponent(BoxAnima4)
                    .addComponent(BoxAnima5)
                    .addComponent(BoxAnima6)
                    .addComponent(BoxAnima7))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BoxSelection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbPers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(RadioBtnDecorar))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(LblAnima1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(LblAnima2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(LblAnima4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(LblAnima3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LblAnima5, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                            .addComponent(LblAnima6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(LblAnima7, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(BtnRun)
                        .addGap(21, 21, 21))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BoxAnima1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BoxAnima2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BoxAnima3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BoxAnima4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BoxAnima5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BoxAnima6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BoxAnima7)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Acción Botón Run
     *
     * @param evt
     */
    private void BtnRunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnRunActionPerformed
        try {
            validarAccion();
        } catch (CloneNotSupportedException ex) {
            JOptionPane.showMessageDialog(null,"error en ejecución","error",0);
        } catch (InterruptedException ex) {
            JOptionPane.showMessageDialog(null,"error en ejecución","error",0);
        }
        hilos();
    }//GEN-LAST:event_BtnRunActionPerformed

    private void BoxSelectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BoxSelectionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BoxSelectionActionPerformed

    /**
     * Limpíar valores botones
     * @param evt 
     */
    private void BoxSelectionItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_BoxSelectionItemStateChanged
        this.GroupDecorar.clearSelection();
        this.BoxAnima1.setSelected(false);
        this.BoxAnima2.setSelected(false);
        this.BoxAnima3.setSelected(false);
        this.BoxAnima4.setSelected(false);
        this.BoxAnima5.setSelected(false);
        this.BoxAnima6.setSelected(false);
        this.BoxAnima7.setSelected(false);
    }//GEN-LAST:event_BoxSelectionItemStateChanged

    /**
     * Activar/desactivar boton 1
     * @param evt 
     */
    private void BoxAnima1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_BoxAnima1StateChanged
        if(this.BoxAnima1.isSelected()){
            this.LblAnima1.setEnabled(true);
        }
        else{
            this.LblAnima1.setEnabled(false);
        }
    }//GEN-LAST:event_BoxAnima1StateChanged
/**
 * Activar/desactivar boton 2
 * @param evt 
 */
    private void BoxAnima2StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_BoxAnima2StateChanged
        if(this.BoxAnima2.isSelected()){
            this.LblAnima2.setEnabled(true);
        }
        else{
            this.LblAnima2.setEnabled(false);
        }
    }//GEN-LAST:event_BoxAnima2StateChanged
/**
 * Activar/desactivar boton 3
 * @param evt 
 */
    private void BoxAnima3StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_BoxAnima3StateChanged
        if(this.BoxAnima3.isSelected()){
            this.LblAnima3.setEnabled(true);
        }
        else{
            this.LblAnima3.setEnabled(false);
        }
    }//GEN-LAST:event_BoxAnima3StateChanged

    /**
     * Activar/desactivar boton 4
     * @param evt 
     */
    private void BoxAnima4StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_BoxAnima4StateChanged
        if(this.BoxAnima4.isSelected()){
            this.LblAnima4.setEnabled(true);
        }
        else{
            this.LblAnima4.setEnabled(false);
        }
    }//GEN-LAST:event_BoxAnima4StateChanged

    /**
     * Activar/desactivar boton 5
     * @param evt 
     */
    private void BoxAnima5StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_BoxAnima5StateChanged
         if(this.BoxAnima5.isSelected()){
            this.LblAnima5.setEnabled(true);
        }
        else{
            this.LblAnima5.setEnabled(false);
        }
    }//GEN-LAST:event_BoxAnima5StateChanged
/**
 * Activar/desactivar boton 6
 * @param evt 
 */
    private void BoxAnima6StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_BoxAnima6StateChanged
        if(this.BoxAnima6.isSelected()){
            this.LblAnima6.setEnabled(true);
        }
        else{
            this.LblAnima6.setEnabled(false);
        }
    }//GEN-LAST:event_BoxAnima6StateChanged

    /**
     * Activar/desactivar boton 7
     * @param evt 
     */
    private void BoxAnima7StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_BoxAnima7StateChanged
        if(this.BoxAnima7.isSelected()){
            this.LblAnima7.setEnabled(true);
        }
        else{
            this.LblAnima7.setEnabled(false);
        }
    }//GEN-LAST:event_BoxAnima7StateChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox BoxAnima1;
    private javax.swing.JCheckBox BoxAnima2;
    private javax.swing.JCheckBox BoxAnima3;
    private javax.swing.JCheckBox BoxAnima4;
    private javax.swing.JCheckBox BoxAnima5;
    private javax.swing.JCheckBox BoxAnima6;
    private javax.swing.JCheckBox BoxAnima7;
    private javax.swing.JComboBox<String> BoxSelection;
    private javax.swing.JButton BtnRun;
    private javax.swing.ButtonGroup GroupDecorar;
    private javax.swing.JLabel LblAnima1;
    private javax.swing.JLabel LblAnima2;
    private javax.swing.JLabel LblAnima3;
    private javax.swing.JLabel LblAnima4;
    private javax.swing.JLabel LblAnima5;
    private javax.swing.JLabel LblAnima6;
    private javax.swing.JLabel LblAnima7;
    private javax.swing.JCheckBox RadioBtnDecorar;
    private javax.swing.JComboBox<String> cbbPers;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
