package it.unibo.isaccoop.graphics;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import it.unibo.isaccoop.core.GameEngineImpl;

/**
 * The menu of the game.
 * */
public class GameMenu {

    private final JFrame frame = new JFrame("Game menu - Isaccoop");
    private final JButton play = new JButton("Play");
    private final JButton help = new JButton("Help");
    private final JButton quit = new JButton("Quit");

    /**
     * 
     */
    public GameMenu() {
        this.frame.getContentPane().setLayout(new BoxLayout(this.frame.getContentPane(), BoxLayout.Y_AXIS));
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final JPanel canvas = new JPanel();
        final JPanel buttons = new JPanel();
        final JLabel title = new JLabel("Isaccopp");
        title.setFont(new Font("Arial", Font.PLAIN, 40));

        canvas.add(title);
        buttons.add(play);
        buttons.add(help);
        buttons.add(quit);

        canvas.setAlignmentX(Component.CENTER_ALIGNMENT);
        canvas.setPreferredSize(new Dimension(300, 500));
        canvas.setMaximumSize(new Dimension(300, 500));

        buttons.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttons.setAlignmentY(Component.CENTER_ALIGNMENT);
        buttons.setPreferredSize(new Dimension(100, 1000));
        buttons.setMaximumSize(new Dimension(100, 500));

        frame.getContentPane().add(canvas);
        frame.getContentPane().add(buttons);

        play.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                try {
                    Thread thread = new Thread(){
                        public void run(){
                            new GameEngineImpl().run();
                        }
                     };
                    thread.start();
                    hide();
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(frame, e1, "Error", JOptionPane.ERROR_MESSAGE);
                    e1.printStackTrace();
                }
            }
        });

        quit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                try {
                    System.exit(0);
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(frame, e1, "Error", JOptionPane.ERROR_MESSAGE);
                    e1.printStackTrace();
                }
            }
        });

        help.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                try {

                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(frame, e1, "Error", JOptionPane.ERROR_MESSAGE);
                    e1.printStackTrace();
                }
            }
        });

    }

    /***/
    public void display() {
        this.frame.setLocationByPlatform(true);
        this.frame.setSize(800, 400);
        this.frame.setVisible(true);
    }

    /***/
    public void hide() {
        this.frame.setVisible(false);
    }
}
