package it.unibo.isaccoop.graphics;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
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
        final JPanel canvas = new JPanel();

        canvas.setLayout(new BorderLayout());
        canvas.add(play, BorderLayout.PAGE_START);
        canvas.add(help, BorderLayout.CENTER);
        canvas.add(quit, BorderLayout.PAGE_END);
        this.frame.setContentPane(canvas);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        play.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                try {
                    new GameEngineImpl().run();
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
        this.frame.pack();
        this.frame.setVisible(true);
    }

    /***/
    public void hide() {
        this.frame.setVisible(false);
    }
}
