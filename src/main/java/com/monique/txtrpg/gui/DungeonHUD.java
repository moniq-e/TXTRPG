package com.monique.txtrpg.gui;

import java.awt.Graphics;
import java.awt.Color;

import com.monique.txtrpg.dungeons.Dungeon;
import com.monique.txtrpg.entities.Drawable;
import com.monique.txtrpg.items.Item;

public class DungeonHUD implements Drawable {
    private Dungeon dungeon;

    public DungeonHUD(Dungeon dungeon) {
        this.dungeon = dungeon;
    }

    @Override
    public void draw(Graphics g) {
        displayInventory(g);
    }

    private void displayInventory(Graphics g) {
        int x = 1;
        int y = dungeon.getHeight() - 23;
        for (Item item : dungeon.player.inventory) {

            Button b = new Button(dungeon, null, x, y, 22, 22, e -> {
                dungeon.player.setHeldItem(item);
            });

            b.setBackground(null);
            b.setBorder(null);
            b.setOpaque(false);

            g.setColor(Color.BLACK);
            g.drawRect(x, y, 21, 21);

            item.display(g, x + 1, y + 1);
            x += 21;
        }
    }
}