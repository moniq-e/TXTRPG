package com.monique.txtrpg.entities;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JMenuItem;

import com.monique.txtrpg.*;
import com.monique.txtrpg.dungeons.*;
import com.monique.txtrpg.items.*;

public class Skeleton extends Mob {

    /**
     * Create a new Skeleton and adds it to the dungeon.board.entities
     * @param dungeon
     */
    public Skeleton(Dungeon dungeon) {
        super(dungeon, "skeleton", 10, 100, 35, 35);
        
        this.dungeon.entities.add(this);
        this.dungeon.drawables.add(this);
        inventory.add(new Sword());
        setPos(Util.random(0, dungeon.frame.WIDTH - WIDTH), Util.random(0, dungeon.frame.HEIGHT - HEIGHT));
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.yellow);
        g.fillOval(getPos().x, getPos().y - HEIGHT, WIDTH, HEIGHT);
    }

    @Override
    public void ai() {
        followPlayer();
        if (playerColliding()) {
            attack(dungeon.player, inventory.get(0));
        }
    }

    @Override
    protected void setPopupItems() {
        JMenuItem attack = new JMenuItem("Attack");
        attack.addActionListener(e -> {
            dungeon.player.attack(this, dungeon.player.inventory.get(0));
        });
        popup.add(attack);
    }
}