package com.graphics;

import javax.swing.*;

public class MainEF extends JFrame {

    public static void main(String[] args) {
        EstrellaFractal e = new EstrellaFractal();
        e.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        e.setSize(400, 400);
        e.setVisible(true);
    }
}
