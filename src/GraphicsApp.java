package PACKAGE_NAME;

import java.awt.*;
import java.util.Random;
import javax.swing.*;

public class GraphicsApp extends JFrame {
    public static void main(String[] args) {
        JFrame frame = new GraphicsApp();
        frame.setSize(700, 700);
        frame.setTitle("GraphicsApp");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); // Center the frame
        frame.setVisible(true);
    }

    public GraphicsApp() {
        add(new DrawPanel());
    }

    class DrawPanel extends JPanel {
        Random gen = new Random();
        int count = 0;

        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            int origin = 50;

            //Draw Y-Axis
            g.drawLine(origin, origin, origin, 650);

            //Draw X-Axis
            g.drawLine(origin, origin, 650, origin);

            int drawAmount = 10;
            int spacing = 60;

            drawNumberedHorizontalLines(drawAmount, spacing, g, origin);
            drawNumberedVerticalLines(drawAmount, spacing, g, origin);


        } // class DrawPanel

        private void drawNumberedVerticalLines(int drawAmount, int spacing, Graphics g, int origin){
            int newOrigin = origin;

            for (int i = drawAmount; i >= 0; i--) {
                g.drawLine(origin - 20, newOrigin, origin, newOrigin);

                g.drawString("" + i, origin - 40, newOrigin);

                newOrigin = newOrigin + spacing;
            }
        }

        private void drawNumberedHorizontalLines(int drawAmount, int spacing, Graphics g, int origin){
            int newOrigin = origin;

            for (int i = drawAmount; i >= 0; i--) {
                g.drawLine(newOrigin, origin - 20, newOrigin, origin);
                g.drawString("" + i, newOrigin, origin - 40);
                newOrigin = newOrigin + spacing;
            }

        }

        
    }

    }