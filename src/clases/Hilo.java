package clases;

import javax.swing.*;

class Hilo implements Runnable{
    Thread thread;

    String nombre;

    JLabel personaje;

    JLabel labelFinal;

    public static int lugar;

    public Hilo(String nombre, JLabel personaje, JLabel laberlFinal) {
        this.nombre = nombre;
        this.personaje = personaje;
        this.labelFinal = laberlFinal;
        thread = new Thread(this, nombre);
        thread.start();
    }

    @Override
    public void run() {
        int retardo;

        try{
            lugar = 1;
            retardo = (int)(Math.random()*15) + 1;
            labelFinal.setVisible(false);
            personaje.setVisible(true);

            for (int i = 50; i < 500; i++) {
                personaje.setLocation(i, personaje.getY());
                Thread.sleep(retardo);
            }
            personaje.setVisible(false);
            labelFinal.setVisible(true);
            labelFinal.setText("El personaje " + nombre + " Ha llegado en la posicion " + lugar);
            lugar++;
        }catch (Exception e){
            System.out.println(e);
        }
    }
}