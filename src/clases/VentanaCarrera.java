package clases;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaCarrera extends JFrame {
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
