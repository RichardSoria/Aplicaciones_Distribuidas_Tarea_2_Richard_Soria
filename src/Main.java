import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new VentanaCarrera();
            }
        });
    }
}

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

class VentanaCarrera extends JFrame {
    public VentanaCarrera() {
        super("Carrera de Leyendas del Dragon Ball Z");
        JLabel goku, vegeta, gohan, goku_pos, vegeta_pos, gohan_pos;
        JButton botonIniciarCarrera;

        setSize(500,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        Image imagen_goku = new ImageIcon("src/img/goku.gif").getImage();
        ImageIcon icon_goku = new ImageIcon(imagen_goku.getScaledInstance(50,50,Image.SCALE_DEFAULT));
        goku = new JLabel();
        goku.setIcon(icon_goku);
        goku.setBounds(50,50,50,50);

        Image imagen_vegeta = new ImageIcon("src/img/vegeta.gif").getImage();
        ImageIcon icon_vegeta = new ImageIcon(imagen_vegeta.getScaledInstance(50,50,Image.SCALE_DEFAULT));
        vegeta = new JLabel();
        vegeta.setIcon(icon_vegeta);
        vegeta.setBounds(50,100,50,50);

        Image imagen_gohan = new ImageIcon("src/img/gohan.gif").getImage();
        ImageIcon icon_gohan = new ImageIcon(imagen_gohan.getScaledInstance(50,50,Image.SCALE_DEFAULT));
        gohan = new JLabel();
        gohan.setIcon(icon_gohan);
        gohan.setBounds(50,150,50,50);

        goku_pos = new JLabel();
        goku_pos.setBounds(50,50,350,50);

        vegeta_pos = new JLabel();
        vegeta_pos.setBounds(50,100,350,50);

        gohan_pos = new JLabel();
        gohan_pos.setBounds(50,150,350,50);

        botonIniciarCarrera = new JButton("Iniciar Carrera");
        botonIniciarCarrera.setBounds(150,200,150,50);

        botonIniciarCarrera.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Hilo threadGoku = new Hilo("Goku", goku, goku_pos);
                Hilo treadVegeta = new Hilo("Vegeta", vegeta, vegeta_pos);
                Hilo threadGohan = new Hilo("Gohan", gohan, gohan_pos);
            }
        });

        panel.add(goku);
        panel.add(goku_pos);
        panel.add(vegeta);
        panel.add(vegeta_pos);
        panel.add(gohan);
        panel.add(gohan_pos);
        panel.add(botonIniciarCarrera);
        panel.setBackground(Color.WHITE);

        add(panel);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}