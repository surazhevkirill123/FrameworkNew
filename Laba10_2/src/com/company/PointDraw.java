package com.company;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.border.LineBorder;

public class PointDraw extends JFrame {

    private List<ColorPoint> points;
    private Color pointColor;
    private JSlider pointSize;
    private DrawingPane pane;

    public PointDraw() {
        setTitle("PointDraw");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        points = new ArrayList<>();
        pointColor = Color.BLACK;
        pane = new DrawingPane();

        JPanel topPanel = new JPanel();
        final JButton colorButton = new JButton();
        colorButton.setBackground(pointColor);
        colorButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                pointColor = JColorChooser.showDialog(PointDraw.this,
                        "Choose color", pointColor);
                colorButton.setBackground(pointColor);
            }
        });
        colorButton.setPreferredSize(new Dimension(40, 40));

        pointSize = new JSlider(0, 30, 10);
        pointSize.setMajorTickSpacing(10);
        pointSize.setMinorTickSpacing(2);
        pointSize.setPaintTicks(true);
        pointSize.setPaintLabels(true);

        JButton clearButton = new JButton("Clear");
        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                points.clear();
                pane.repaint();
            }
        });

        topPanel.add(new JLabel("Color: "));
        topPanel.add(colorButton);
        topPanel.add(new JLabel("Size: "));
        topPanel.add(pointSize);
        topPanel.add(clearButton);

        add(pane);
        add(topPanel, BorderLayout.NORTH);
        pack();
    }

    public static void main(String[] args) {
        new PointDraw().setVisible(true);
    }

    class DrawingPane extends JComponent {
        public DrawingPane() {
            setPreferredSize(new Dimension(600, 400));
            setBorder(new LineBorder(Color.GRAY));
            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    ColorPoint point = new ColorPoint(e.getX(), e.getY(),
                            pointSize.getValue(), pointColor);
                    points.add(point);
                    repaint();
                }
            });
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            for (ColorPoint p : points) {
                g2.setColor(p.getColor());
                int x = p.getX();
                int y = p.getY();
                int size = p.getSize();
                g2.fillOval(x - size / 2, y - size / 2, size, size);
            }
        }
    }

    class ColorPoint {
        private int x;
        private int y;
        private int size;
        private Color color;

        public ColorPoint(int x, int y, int size, Color color) {
            this.x = x;
            this.y = y;
            this.size = size;
            this.color = color;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public Color getColor() {
            return color;
        }

        public int getSize() {
            return size;
        }

    }
}