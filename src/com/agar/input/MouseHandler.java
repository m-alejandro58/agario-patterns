package com.agar.input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

/*
 * Guarda la posición actual del mouse.
 */
public class MouseHandler implements MouseMotionListener {

    private static int mouseX;
    private static int mouseY;

    @Override
    public void mouseDragged(MouseEvent e) {

        mouseX = e.getX();
        mouseY = e.getY();
    }

    @Override
    public void mouseMoved(MouseEvent e) {

        mouseX = e.getX();
        mouseY = e.getY();
    }

    public static int getMouseX() {
        return mouseX;
    }

    public static int getMouseY() {
        return mouseY;
    }
}