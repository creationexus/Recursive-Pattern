package com.graphics;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class CerrarVentana extends WindowAdapter {

    @Override
    public void windowClosing(WindowEvent we) {
        System.exit(0);
    }
}
