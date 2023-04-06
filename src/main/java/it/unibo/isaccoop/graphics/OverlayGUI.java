package it.unibo.isaccoop.graphics;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import it.unibo.isaccoop.model.player.PlayerStat;
import it.unibo.isaccoop.model.room.Level;
import it.unibo.isaccoop.model.room.Room;

/**
 * Creates a GUI to display the {@link Minimap}, the {@link PlayerStat}s and a legend explaining
 * the meaning of colors of {@link Minimap}.
 * This GUI shows: <br> the room the player is, <br> the completed rooms, <br> the uncompleted rooms
 * <br>a legend to explain the minimap colors, <br>the player statistics.
 */
public class OverlayGUI extends JPanel {

    private static final long serialVersionUID = -4109905993803098411L;
    private static final Font FONT = new Font("Verdana", Font.PLAIN, 12);
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
        PLAYER("You are here"),
        /**
         * Where there is not a playable room.
         */
        NO_ROOM_HERE("Inaccessible room"),
        /**
         * Uncompleted room (there are still enemies to defeat).
         */
        UNCOMPLETED_ROOM("Uncompleted room"),
        /**
         * Completed room (there are no more enemies to defeat).
         */
        COMPLETED_ROOM("Completed room");

        private final String descr;
        private CellStatus(final String descr) {
            this.descr = descr;
        }

        private String getDescr() {
            return this.descr;
        }
    }

    /**
     * Create a new GUI for {@link Minimap}.
     * @param level the level of which to show the layout
     * @param roomWidth the width of the minimap
     * @param minimapHeight the height of the minimap
     */
    public OverlayGUI(final Level level, final int roomWidth, final int minimapHeight) {
        this.lvl = level;

        final int horizontalGap = roomWidth / 16;
        final int verticalGap = 10;

        // main layout
        this.setSize(roomWidth, minimapHeight);
        this.setLayout(new FlowLayout(FlowLayout.CENTER, horizontalGap, verticalGap));

        // minimap container
        final JPanel minimapPanel = new JPanel(new BorderLayout());
        // panel where to place the rooms
        final JPanel centerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        minimapPanel.add(centerPanel, BorderLayout.CENTER);
        // panel where to place some information about the current level
        final JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        topPanel.add(lblInfoRoom);
        minimapPanel.add(topPanel, BorderLayout.NORTH);
        
        // legend to explain the meaning of minimap
        final JPanel legendPanel = new JPanel();
        legendPanel.setLayout(new BoxLayout(legendPanel, BoxLayout.X_AXIS));
        final JLabel lblInfo = new JLabel("Legend: ");
        legendPanel.add(lblInfo);
        COLOR_MAP.forEach((cellStatus, color) -> {
            final JButton btn = new JButton(cellStatus.getDescr());
            btn.setBackground(color);
            legendPanel.add(btn);
        });

        // stats container part 1
        final JPanel statsPanel1 = new JPanel();
        statsPanel1.setLayout(new BoxLayout(statsPanel1, BoxLayout.Y_AXIS));
        getStatsStringsPart1().forEach(str -> {
            final JLabel lblStat = new JLabel(str);
            statsPanel1.add(lblStat);
        });
        // stats container part 2
        final JPanel statsPanel2 = new JPanel();
        statsPanel2.setLayout(new BoxLayout(statsPanel2, BoxLayout.Y_AXIS));
        getStatsStringsPart2().forEach(str -> {
            final JLabel lblStat = new JLabel(str);
            statsPanel2.add(lblStat);
        });

        this.add(minimapPanel);
        this.add(statsPanel1);
        this.add(statsPanel2);
        this.add(legendPanel);

        for (int i = 0; i < lvl.getRooms().size(); i++) {
            final JButton jb = new JButton(Integer.toString(i+1));
            jb.setFont(FONT);
            centerPanel.add(jb);
            jb.setEnabled(false);
            this.btns.put(jb, lvl.getRooms().get(i));
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void paint(final Graphics g) {
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

    private List<String> getStatsStringsPart1() {
        return List.of("Player statistics:", 
                "Coins: " + this.lvl.getPlayer().getCoin(),
                "Damage: " + this.lvl.getPlayer().getDamage());
    }

    private List<String> getStatsStringsPart2() {
        return List.of(
                "Hearts: " + this.lvl.getPlayer().getHeart() + " / " + this.lvl.getPlayer().getMaxHeart(),
                "Speed: " + this.lvl.getPlayer().getSpeed(),
                "Tears: " + this.lvl.getPlayer().getTears());   
    }
}
