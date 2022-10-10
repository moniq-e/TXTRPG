package com.monique.txtrpg;

import java.awt.event.MouseEvent;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;

import com.monique.txtrpg.entities.*;

/*
    main class, onde o jogo vai rodar
*/
public abstract class Board extends JPanel {
    public Frame frame;
    public final Player player;

    public Board(Frame frame) {
        this.frame = frame;
        this.player = new Player(this, "default");
    }

    //called by frame.listener events:
    public void mouseClicked(MouseEvent e) {
        player.lastClick.setLocation(e.getPoint());
    }

    /**
     * This method is called by the timer every DELAY ms. Use this space to update the state of your game or animation before the graphics are redrawn.
     * @param e
     */
    public abstract void actionPerformed(ActionEvent e);
    
    public abstract void keyPressed(KeyEvent e);
}