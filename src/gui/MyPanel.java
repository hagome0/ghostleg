package gui;

import logic.GhostLeg;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;

public class MyPanel extends JPanel {

    private static int PADDING = 100;
    private int num = 3;
    private GhostLeg ghostLeg;
    private Boolean isStarted = false;

    public void addMember() {
        this.num++;
        this.repaint();
    }

    public void subMember() {
        this.num--;
        this.repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {

        Graphics2D g2 = (Graphics2D) g;
        super.paintComponent(g);

        int col = 10;
        int row = num * 2 - 1;

        ghostLeg = new GhostLeg(num, col);
        int[][] map;
        map = ghostLeg.getMap();

        int mapW = (getWidth() - PADDING * 2) / (row - 1);
        int mapH = (getHeight() - PADDING * 2) / (col - 1);

        g.setColor(new Color(0x694B00));
        //draw map
        for (int j = 0; j < row; j += 2) {
            int pX = PADDING + j * mapW;

            g2.setStroke(new BasicStroke(10,BasicStroke.CAP_BUTT,0));
            g2.draw(new Line2D.Double(pX, PADDING, pX, getHeight() - PADDING));
//            g.drawLine(pX, PADDING, pX, getHeight() - PADDING);
        }

        if (isStarted) {
            // draw ghostLeg
            for (int i = 0; i < col; i++) {
                for (int j = 0; j < row; j++) {
                    if (map[i][j] == 1 && j % 2 == 1) {
                        int pX = PADDING + j * mapW;
                        int pY = PADDING + i * mapH;
                        g2.draw(new Line2D.Double(pX - mapW, pY, pX + mapW, pY));
//                        g.drawLine(pX - mapW, pY, pX + mapW, pY);
                    }
                }
            }
        }

    }


    public void doSadari() {
        isStarted = !isStarted;
        this.repaint();
    }
}
