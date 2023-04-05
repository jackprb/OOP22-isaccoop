package it.unibo.isaccoop.graphics;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import it.unibo.isaccoop.core.GameEngine;
import it.unibo.isaccoop.core.GameEngineImpl;
import it.unibo.isaccoop.model.room.LevelController;
import it.unibo.isaccoop.model.room.LevelControllerImpl;
import it.unibo.isaccoop.model.room.Room;

/**
 * Creates a Gui to display the {@link Minimap}.
 * This GUI shows some information about the {@link Level} currently played.
 */
public class MinimapGUI extends AbstractGUIFrame{

    private static final int MAX_NUMBER_OF_LEVELS = 10;
    private static final int MIN_WIDTH_FRAME = 500;
    private static final int MIN_HEIGHT_FRAME = 300;
    private static final Font FONT = new Font("Verdana", Font.PLAIN, 12);
    private static final String TITLE = "Minimap";
    private static final Map<CellStatus, Color> COLOR_MAP = Map.of(
            CellStatus.PLAYER, new Color(255, 0, 0), //red
            CellStatus.NO_ROOM_HERE, new Color(120, 120, 120), //grey
            CellStatus.UNCOMPLETED_ROOM, new Color(243, 225, 75), //yellow
            CellStatus.COMPLETED_ROOM, new Color(139, 218, 83)); //green

    private final JFrame frame = new JFrame(TITLE);
    private final JLabel lblInfoLvl = new JLabel();
    private final JLabel lblInfoRoom = new JLabel();
    private final LevelController lvlController = new LevelControllerImpl(MAX_NUMBER_OF_LEVELS, new GameEngineImpl());
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
     */
    public MinimapGUI(final GameEngine gameEngine) {
        super.setTitle(TITLE);
        super.getJFrame().setMinimumSize(new Dimension(MIN_WIDTH_FRAME, MIN_HEIGHT_FRAME));

        // main layout
        final JPanel mainPanel = new JPanel(new BorderLayout());
        this.frame.getContentPane().add(mainPanel);
        // layout where to place the rooms
        final JPanel centerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        mainPanel.add(centerPanel, BorderLayout.CENTER);
        // flow layout where to place some information about the current level
        final JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        topPanel.add(lblInfoLvl);
        topPanel.add(lblInfoRoom);
        mainPanel.add(topPanel, BorderLayout.NORTH);

        /*final ActionListener al = e -> {
            var button = (JButton)e.getSource();
            var indexBtn = this.btns.indexOf(button); //indice di btn cliccato in lista di btn
        };*/
        for (int i = 0; i < lvlController.getNumberOfRoomsOfCurrentLevel(); i++) {
            final JButton jb = new JButton(Integer.toString(i));
            jb.setFont(FONT);
            centerPanel.add(jb);
            jb.setEnabled(false);
            this.btns.put(jb, lvlController.getRoomsOfCurrentLevel().get(i));
        }
    }

    @Override
    public void updateView() {
        lblInfoLvl.setText(getLevelStatusString());
        lblInfoRoom.setText(getRoomStatusString());
        this.btns.forEach((btn, r) -> {
            final var currRoom = this.lvlController.getCurrentLevel().getCurrentRoom();
            final var completeRooms = this.lvlController.getMinimap().getCompletedRooms();
            final var uncompleteRooms = this.lvlController.getMinimap().getUncompletedRooms();
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
        return "rooms completed: " + lvlController.getMinimap().getCompletedRooms().size() 
            + " of " + lvlController.getNumberOfRoomsOfCurrentLevel();
    }

    /**
     * Return a string to show information about the status of current level.
     * @return a string that contains information about status of current level
     */
    private String getLevelStatusString() {
        return "level: " + lvlController.getCurrentLevelIndex() + " of " + lvlController.getNumberOfLevels();
    }
}
