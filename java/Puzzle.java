import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Puzzle extends JFrame implements ActionListener {
    private Button b1, b2, b3, b4, b5, b6, b7, b8, b9;
    private Label clickLabel, timeLabel;
    private int totalClicks;
    private int clicksUntilWin;
    private long startTime;
    private Timer timer;
    private Button shuffleButton;

    Puzzle() {
        super("Puzzle - JavaTpoint");
        totalClicks = 0;
        clicksUntilWin = 0;

        JOptionPane.showMessageDialog(this, "Selamat datang di Puzzle PBO!\nKlik OK untuk memulai game.");

        JPanel puzzlePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {

                Graphics2D g2d = (Graphics2D) g;
                GradientPaint gradient = new GradientPaint(0, 0, Color.RED, getWidth(), getHeight(), Color.BLUE);
                g2d.setPaint(gradient);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        puzzlePanel.setLayout(null);

        b1 = new Button("1");
        b1.setBounds(50, 100, 40, 40);
        b2 = new Button("");
        b2.setBounds(100, 100, 40, 40);
        b3 = new Button("2");
        b3.setBounds(150, 100, 40, 40);
        b4 = new Button("4");
        b4.setBounds(50, 150, 40, 40);
        b5 = new Button("5");
        b5.setBounds(100, 150, 40, 40);
        b6 = new Button("3");
        b6.setBounds(150, 150, 40, 40);
        b7 = new Button("7");
        b7.setBounds(50, 200, 40, 40);
        b8 = new Button("8");
        b8.setBounds(100, 200, 40, 40);
        b9 = new Button("6");
        b9.setBounds(150, 200, 40, 40);

        shuffleButton = new Button("acak jika kesulitan");
        shuffleButton.setBounds(250, 150, 130, 40);
        shuffleButton.addActionListener(this);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
        b9.addActionListener(this);

        clickLabel = new Label("Total Clicks: " + totalClicks);
        clickLabel.setBounds(250, 100, 130, 20);

        timeLabel = new Label("Total Time: ");
        timeLabel.setBounds(250, 120, 130, 20);

        puzzlePanel.add(b1);
        puzzlePanel.add(b2);
        puzzlePanel.add(b3);
        puzzlePanel.add(b4);
        puzzlePanel.add(b5);
        puzzlePanel.add(b6);
        puzzlePanel.add(b7);
        puzzlePanel.add(b8);
        puzzlePanel.add(b9);
        puzzlePanel.add(shuffleButton);
        puzzlePanel.add(clickLabel);
        puzzlePanel.add(timeLabel);

        add(puzzlePanel);

        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void startTimer() {
        if (timer != null) {
            timer.stop(); 
        }
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateElapsedTime();
            }
        });
        timer.start();
        startTime = System.currentTimeMillis();
    }

    private void updateElapsedTime() {
        long currentTime = System.currentTimeMillis();
        long elapsedTime = (currentTime - startTime) / 1000; // Convert ke detikkk
        timeLabel.setText("Total Time: " + elapsedTime + " seconds");
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == shuffleButton) {
            shufflePuzzle();
        } else {
            totalClicks++;
            clicksUntilWin++;

            if (clicksUntilWin == 1) {
                
                startTimer();
            }

            if (e.getSource() == b1) {
                String label = b1.getLabel();
                if (b2.getLabel().equals("")) {
                    b2.setLabel(label);
                    b1.setLabel("");
                }
                if (b4.getLabel().equals("")) {
                    b4.setLabel(label);
                    b1.setLabel("");
                }
            }

            if (e.getSource() == b2) {
                String label = b2.getLabel();
                if (b1.getLabel().equals("")) {
                    b1.setLabel(label);
                    b2.setLabel("");
                }
                if (b3.getLabel().equals("")) {
                    b3.setLabel(label);
                    b2.setLabel("");
                }
                if (b5.getLabel().equals("")) {
                    b5.setLabel(label);
                    b2.setLabel("");
                }
            }

            if (e.getSource() == b3) {
                String label = b3.getLabel();
                if (b2.getLabel().equals("")) {
                    b2.setLabel(label);
                    b3.setLabel("");
                }
                if (b6.getLabel().equals("")) {
                    b6.setLabel(label);
                    b3.setLabel("");
                }
            }

            if (e.getSource() == b4) {
                String label = b4.getLabel();
                if (b1.getLabel().equals("")) {
                    b1.setLabel(label);
                    b4.setLabel("");
                }
                if (b7.getLabel().equals("")) {
                    b7.setLabel(label);
                    b4.setLabel("");
                }
                if (b5.getLabel().equals("")) {
                    b5.setLabel(label);
                    b4.setLabel("");
                }
            }

            if (e.getSource() == b5) {
                String label = b5.getLabel();
                if (b2.getLabel().equals("")) {
                    b2.setLabel(label);
                    b5.setLabel("");
                }
                if (b6.getLabel().equals("")) {
                    b6.setLabel(label);
                    b5.setLabel("");
                }
                if (b4.getLabel().equals("")) {
                    b4.setLabel(label);
                    b5.setLabel("");
                }
                if (b8.getLabel().equals("")) {
                    b8.setLabel(label);
                    b5.setLabel("");
                }
            }

            if (e.getSource() == b6) {
                String label = b6.getLabel();
                if (b9.getLabel().equals("")) {
                    b9.setLabel(label);
                    b6.setLabel("");
                }
                if (b3.getLabel().equals("")) {
                    b3.setLabel(label);
                    b6.setLabel("");
                }
                if (b5.getLabel().equals("")) {
                    b5.setLabel(label);
                    b6.setLabel("");
                }
            }

            if (e.getSource() == b7) {
                String label = b7.getLabel();
                if (b4.getLabel().equals("")) {
                    b4.setLabel(label);
                    b7.setLabel("");
                }
                if (b8.getLabel().equals("")) {
                    b8.setLabel(label);
                    b7.setLabel("");
                }
            }

            if (e.getSource() == b8) {
                String label = b8.getLabel();
                if (b9.getLabel().equals("")) {
                    b9.setLabel(label);
                    b8.setLabel("");
                }
                if (b7.getLabel().equals("")) {
                    b7.setLabel(label);
                    b8.setLabel("");
                }
                if (b5.getLabel().equals("")) {
                    b5.setLabel(label);
                    b8.setLabel("");
                }
            }

            if (e.getSource() == b9) {
                String label = b9.getLabel();
                if (b6.getLabel().equals("")) {
                    b6.setLabel(label);
                    b9.setLabel("");
                }
                if (b8.getLabel().equals("")) {
                    b8.setLabel(label);
                    b9.setLabel("");
                }
            }

            
            clickLabel.setText("Total Clicks: " + totalClicks);

            // Congrats code
            if (b1.getLabel().equals("1") && b2.getLabel().equals("2") && b3.getLabel().equals("3") &&
                b4.getLabel().equals("4") && b5.getLabel().equals("5") && b6.getLabel().equals("6") &&
                b7.getLabel().equals("7") && b8.getLabel().equals("8") && b9.getLabel().equals("")) {
                if (timer != null) {
                    timer.stop(); 
                }
                long endTime = System.currentTimeMillis();
                long elapsedTime = (endTime - startTime) / 1000; // Convert to seconds

                JOptionPane.showMessageDialog(this, "Selamat jagoan, kamu menang!!\n Total Clicks: " + totalClicks +
                        "  Total Waktu: " + elapsedTime + " seconds");

                        clicksUntilWin = 0;
            }
        }
    }
    private void shufflePuzzle() {
        if (timer != null) {
            timer.stop();
        }
    
        String[] buttonLabels = {b1.getLabel(), b2.getLabel(), b3.getLabel(),
                b4.getLabel(), b5.getLabel(), b6.getLabel(),
                b7.getLabel(), b8.getLabel(), b9.getLabel()};
    
        java.util.List<String> labelList = java.util.Arrays.asList(buttonLabels);
        java.util.Collections.shuffle(labelList);
    
        b1.setLabel(labelList.get(0));
        b2.setLabel(labelList.get(1));
        b3.setLabel(labelList.get(2));
        b4.setLabel(labelList.get(3));
        b5.setLabel(labelList.get(4));
        b6.setLabel(labelList.get(5));
        b7.setLabel(labelList.get(6));
        b8.setLabel(labelList.get(7));
        b9.setLabel(labelList.get(8));
    
        totalClicks = 0;
        clicksUntilWin = 0;
        clickLabel.setText("Total Clicks: " + totalClicks);
    
        startTimer();
    
        // Show "Makin Sulit" popup
        JOptionPane.showMessageDialog(this, "tapi boong, ini makin sulit🤭🤣");
    }
    

    public static void main(String[] args) {
        new Puzzle();
    }
}
