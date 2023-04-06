package it.unibo.isaccoop.graphics;

import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.stream.Stream;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * The GUI that shows the game help.
 */
public class HelpGUI extends AbstractGUIFrame {

    private static final String TITLE = "Isaccoop User Guide";
    private static final String RES_PATH = "it/unibo/isaccoop/help/";
    private static final int TEXTAREA_COLS = 50;
    private static final int TEXTAREA_ROWS = 10;
    private final JButton btnClose = new JButton("Close");
    private final JTextArea textArea = new JTextArea(TEXTAREA_ROWS, TEXTAREA_COLS);

    /**
     * Constructor. No parameters requiered.
     * Creates a GUI to show the game help.
     */
    protected HelpGUI() {
        super();
        super.setTitle(TITLE);

        Stream<String> linesStream = null;
        try {
            final InputStream in = Objects.requireNonNull(
                    ClassLoader.getSystemResourceAsStream(RES_PATH + "help.txt"));
            final BufferedReader br = new BufferedReader(new InputStreamReader(in));
            linesStream = br.lines();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        // get the main BorderLayout
        final JFrame frame = super.getJFrame();
        frame.add(new JScrollPane(textArea), BorderLayout.CENTER);

        if (linesStream != null) {
            final StringBuilder strBuilder = new StringBuilder();
            linesStream.forEach(s -> strBuilder.append(s));
            textArea.setText(strBuilder.toString());
        } else {
            textArea.setText("Cannot find the help file \"help.txt\"");
        }
        btnClose.addActionListener(l -> {
            this.getJFrame().setVisible(false);
        });
        frame.add(btnClose, BorderLayout.SOUTH);
    }

    @Override
    public void updateView() {

    }
}
