package com.graphics;

import java.awt.*;
import javax.swing.*;

public class EstrellaFractal extends JFrame {

    public EstrellaFractal() {
        setTitle("Estrella Fractal");
        addWindowListener(new CerrarVentana());
    }

    @Override
    public void paint(Graphics g) {
        pintaFractal(g, 200, 200, 400);
    }
    private void pintaFractal(Graphics g, int xCentro, int yCentro, int cotaDim){
        int lado = cotaDim / 2;
        if(lado < 1)
            return;
        //Calculo de las esquinas
        int izq = xCentro - lado / 2;
        int sup = yCentro - lado / 2;
        int der = xCentro + lado / 2;
        int inf = yCentro + lado / 2;

        //Dibujo recursivo de las cuatro cuadrantes
        pintaFractal(g, izq, sup, cotaDim / 2);
        pintaFractal(g, izq, inf, cotaDim / 2);
        pintaFractal(g, der, sup, cotaDim / 2);
        pintaFractal(g, der, inf, cotaDim / 2);

        //Dibuja el cuadro central, que se solapa con los cuadrantes
        g.fillRect(izq, sup, der -izq, inf - sup);
    }
}
