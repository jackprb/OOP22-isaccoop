package it.unibo.isaccoop.graphics;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import it.unibo.isaccoop.model.room.Level;
import it.unibo.isaccoop.model.room.Minimap;
import it.unibo.isaccoop.model.room.Room;

/**
 * Creates a Gui to display the {@link Minimap}.
 * This GUI shows some information about the {@link Level} currently played.
 */
public class MinimapGUI extends JPanel {

    private static final int PANEL_WIDTH = 1300;
    private static final int PANEL_HEIGHT = 100;
    private static final Font FONT = new Font("Verdana", Font.PLAIN, 12);
    private static final String TITLE = "Minimap";
    private static final Map<CellStatus, Color> COLOR_MAP = Map.of(
            CellStatus.PLAYER, new Color(255, 0, 0), //red
            CellStatus.NO_ROOM_HERE, new Color(120, 120, 120), //grey
            CellStatus.UNCOMPLETED_ROOM, new Color(243, 225, 75), //yellow
            CellStatus.COMPLETED_ROOM, new Color(139, 218, 83)); //green

    private final JLabel lblInfoRoom = new JLabel();
    private final Level lvl;
    private final Map<JButton, Room> btns = new HashMap<>();

    private enum CellStatus {
        /**
         * Where the player is.
         */
        PLAYER,
        /**
         * Where there is not a playable room.
         */
        NO_ROOM_HERE,
        /**
         * Uncompleted room (there are still enemies to defeat).
         */
        UNCOMPLETED_ROOM,
        /**
         * Completed room (there are no more enemies to defeat).
         */
        COMPLETED_ROOM;
    }

    /**
     * Create a new GUI for {@link Minimap}.
     * @param minimapHeight
     * @param roomWidth
     */
    public MinimapGUI(final Level level, final int roomWidth, final int minimapHeight) {
        this.lvl = level;

        // main layout
        this.setSize(roomWidth, minimapHeight);
        this.setLayout(new BorderLayout());
        // layout where to place the rooms
        final JPanel centerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        this.add(centerPanel, BorderLayout.CENTER);
        // flow layout where to place some information about the current level
        final JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        topPanel.add(lblInfoRoom);
        this.add(topPanel, BorderLayout.NORTH);

        /*final ActionListener al = e -> {
            var button = (JButton)e.getSource();
            var indexBtn = this.btns.indexOf(button); //indice di btn cliccato in lista di btn
        };*/
        for (int i = 0; i < lvl.getRooms().size(); i++) {
            final JButton jb = new JButton(Integer.toString(i));
            jb.setFont(FONT);
            centerPanel.add(jb);
            jb.setEnabled(false);
            this.btns.put(jb, lvl.getRooms().get(i));
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        lblInfoRoom.setText(getRoomStatusString());
        this.btns.forEach((btn, r) -> {
            final var currRoom = this.lvl.getCurrentRoom();
            final var completeRooms = this.lvl.getMinimap().getCompletedRooms();
            final var uncompleteRooms = this.lvl.getMinimap().getUncompletedRooms();
            if (currRoom.equals(r)) {
                btn.setBackground(COLOR_MAP.get(CellStatus.PLAYER));
            } else if (completeRooms.contains(r)) {
                btn.setBackground(COLOR_MAP.get(CellStatus.COMPLETED_ROOM));
            } else if (uncompleteRooms.contains(r)) {
                btn.setBackground(COLOR_MAP.get(CellStatus.UNCOMPLETED_ROOM));
            } else {
                btn.setBackground(COLOR_MAP.get(CellStatus.NO_ROOM_HERE));
            }
        });
    }

    /**
     * Return a string to show information about the status of current room.
     * @return a string that contains information about status of current room
     */
    private String getRoomStatusString() {
        return "Rooms Completed: " + lvl.getMinimap().getCompletedRooms().size()
            + " of " + lvl.getRooms().size();
    }

}
