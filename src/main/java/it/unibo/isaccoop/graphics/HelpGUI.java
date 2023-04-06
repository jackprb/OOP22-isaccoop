package it.unibo.isaccoop.graphics;

import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
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
    private static final String CANNOT_FIND_HELPFILE = "Cannot find the help file \"help.txt\"";
    private static final String NEWLINE = System.lineSeparator();
    private static final int TEXTAREA_COLS = 60;
    private static final int TEXTAREA_ROWS = 10;

    /**
     * Constructor. No parameters required.
     * Creates a GUI to show the game help.
     */
    protected HelpGUI() {
        super();
        super.setTitle(TITLE);

        final JButton btnClose = new JButton("Close");
        final JTextArea textArea = new JTextArea(TEXTAREA_ROWS, TEXTAREA_COLS);

        // if exists, load the file "help.txt" from the resources folder as a stream<String> 
        // and put it in a textarea
        final InputStream in = ClassLoader.getSystemResourceAsStream(RES_PATH + "help.txt");
        if (in != null) {
            final BufferedReader br = new BufferedReader(new InputStreamReader(in));
            final Stream<String> linesStream = br.lines();

            final StringBuilder strBuilder = new StringBuilder();
            linesStream.forEach(s -> strBuilder.append(s + NEWLINE));
            textArea.setText(strBuilder.toString());
        } else {
            // if the file does not exist, put an alternate message in textarea
            textArea.setText(CANNOT_FIND_HELPFILE);
        }

        // get the main BorderLayout
        final JFrame frame = super.getJFrame();
        // add the textArea, where to display the help
        frame.add(new JScrollPane(textArea), BorderLayout.CENTER);

        btnClose.addActionListener(l -> {
            this.getJFrame().setVisible(false);
        });
        frame.add(btnClose, BorderLayout.SOUTH);
    }

    @Override
    public void updateView() {
    }
}
