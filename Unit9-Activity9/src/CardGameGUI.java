import java.awt.Point;
import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.net.URL;
import java.util.List;
import java.util.ArrayList;

/**
 * This class provides a GUI for solitaire games related to Elevens.
 */
public class CardGameGUI extends JFrame implements ActionListener {

	/** Height of the game frame. */
	private static final int DEFAULT_HEIGHT = 302;
	/** Width of the game frame. */
	private static final int DEFAULT_WIDTH = 800;
	/** Width of a card. */
	private static final int CARD_WIDTH = 73;
	/** Height of a card. */
	private static final int CARD_HEIGHT = 97;
	/** Row (y coord) of the upper left corner of the first card. */
	private static final int LAYOUT_TOP = 30;
	/** Column (x coord) of the upper left corner of the first card. */
	private static final int LAYOUT_LEFT = 30;
	/** Distance between the upper left x coords of
	 *  two horizonally adjacent cards. */
	private static final int LAYOUT_WIDTH_INC = 100;
	/** Distance between the upper left y coords of
	 *  two vertically adjacent cards. */
	private static final int LAYOUT_HEIGHT_INC = 125;
	/** y coord of the "Replace" button. */
	private static final int BUTTON_TOP = 30;
	/** x coord of the "Replace" button. */
	private static final int BUTTON_LEFT = 570;
	/** Distance between the tops of the "Replace" and "Restart" buttons. */
	private static final int BUTTON_HEIGHT_INC = 50;
	/** y coord of the "n undealt cards remain" label. */
	private static final int LABEL_TOP = 160;
	/** x coord of the "n undealt cards remain" label. */
	private static final int LABEL_LEFT = 540;
	/** Distance between the tops of the "n undealt cards" and
	 *  the "You lose/win" labels. */
	private static final int LABEL_HEIGHT_INC = 35;

	/** The board (Board subclass). */
	private Board board;

	/** The main panel containing the game components. */
	private JPanel panel;
	/** The Replace button. */
	private JButton replaceButton;
	/** The Restart button. */
	private JButton restartButton;
	/** The "number of undealt cards remain" message. */
	private JLabel statusMsg;
	/** The "you've won n out of m games" message. */
	private JLabel totalsMsg;
	/** The card displays. */
	private JLabel[] displayCards;
	/** The win message. */
	private JLabel winMsg;
	/** The loss message. */
	private JLabel lossMsg;
	/** The coordinates of the card displays. */
	private Point[] cardCoords;

	/** kth element is true iff the user has selected card #k. */
	private boolean[] selections;
	/** The number of games won. */
	private int totalWins;
	/** The number of games played. */
	private int totalGames;


	public CardGameGUI(final Board gameBoard) {
        this.board = gameBoard;
        this.totalWins = 0;
        this.totalGames = 0;


        this.cardCoords = new Point[this.board.size()];
        int x = CardGameGUI.LAYOUT_LEFT;
        int y = CardGameGUI.LAYOUT_TOP;
        for (int i = 0; i < this.cardCoords.length; i++) {
            this.cardCoords[i] = new Point(x, y);
            if (i % 5 == 4) {
                x = CardGameGUI.LAYOUT_LEFT;
                y += CardGameGUI.LAYOUT_HEIGHT_INC;
            } else {
                x += CardGameGUI.LAYOUT_WIDTH_INC;
            }
        }

        this.selections = new boolean[this.board.size()];
        this.initDisplay();
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.repaint();
    }


    public void displayGame() {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CardGameGUI.this.setVisible(true);
            }
        });
    }


    public void repaint() {
        for (int k = 0; k < this.board.size(); k++) {
            final String cardImageFileName =
                    this.imageFileName(this.board.cardAt(k), this.selections[k]);
            final URL imageURL = this.getClass().getResource(cardImageFileName);
            if (imageURL != null) {
                final ImageIcon icon = new ImageIcon(imageURL);
                this.displayCards[k].setIcon(icon);
                this.displayCards[k].setVisible(true);
            } else {
                throw new RuntimeException(
                        "Card image not found: \"" + cardImageFileName + "\"");
            }
        }
        this.statusMsg.setText(this.board.deckSize()
                + " undealt cards remain.");
        this.statusMsg.setVisible(true);
        this.totalsMsg.setText("You've won " + this.totalWins
                + " out of " + this.totalGames + " games.");
        this.totalsMsg.setVisible(true);
        this.pack();
        this.panel.repaint();
    }


    private void initDisplay() {
        this.panel = new JPanel() {
            public void paintComponent(final Graphics g) {
                super.paintComponent(g);
            }
        };


        final String className = this.board.getClass().getSimpleName();
        final int classNameLen = className.length();
        final int boardLen = "Board".length();
        final String boardStr = className.substring(classNameLen - boardLen);
        if (boardStr.equals("Board") || boardStr.equals("board")) {
            final int titleLength = classNameLen - boardLen;
            this.setTitle(className.substring(0, titleLength));
        }


        final int numCardRows = (this.board.size() + 4) / 5;
        int height = CardGameGUI.DEFAULT_HEIGHT;
        if (numCardRows > 2) {
            height += (numCardRows - 2) * CardGameGUI.LAYOUT_HEIGHT_INC;
        }

        setSize(new Dimension(CardGameGUI.DEFAULT_WIDTH, height));
        this.panel.setLayout(null);
        this.panel.setPreferredSize(
                new Dimension(CardGameGUI.DEFAULT_WIDTH - 20, height - 20));
        this.displayCards = new JLabel[this.board.size()];
        for (int k = 0; k < this.board.size(); k++) {
            this.displayCards[k] = new JLabel();
            this.panel.add(this.displayCards[k]);
            this.displayCards[k].setBounds(this.cardCoords[k].x, this.cardCoords[k].y,
                    CardGameGUI.CARD_WIDTH, CardGameGUI.CARD_HEIGHT);
            this.displayCards[k].addMouseListener(new MyMouseListener());
            this.selections[k] = false;
        }
        this.replaceButton = new JButton();
        this.replaceButton.setText("Replace");
        this.panel.add(this.replaceButton);
        this.replaceButton.setBounds(CardGameGUI.BUTTON_LEFT, CardGameGUI.BUTTON_TOP, 100, 30);
        this.replaceButton.addActionListener(this);

        this.restartButton = new JButton();
        this.restartButton.setText("Restart");
        this.panel.add(this.restartButton);
        this.restartButton.setBounds(CardGameGUI.BUTTON_LEFT, CardGameGUI.BUTTON_TOP + CardGameGUI.BUTTON_HEIGHT_INC,
                100, 30);
        this.restartButton.addActionListener(this);

        this.statusMsg = new JLabel(
                this.board.deckSize() + " undealt cards remain.");
        this.panel.add(this.statusMsg);
        this.statusMsg.setBounds(CardGameGUI.LABEL_LEFT, CardGameGUI.LABEL_TOP, 250, 30);

        this.winMsg = new JLabel();
        this.winMsg.setBounds(CardGameGUI.LABEL_LEFT, CardGameGUI.LABEL_TOP + CardGameGUI.LABEL_HEIGHT_INC, 200, 30);
        this.winMsg.setFont(new Font("SansSerif", Font.BOLD, 25));
        this.winMsg.setForeground(Color.GREEN);
        this.winMsg.setText("You win!");
        this.panel.add(this.winMsg);
        this.winMsg.setVisible(false);

        this.lossMsg = new JLabel();
        this.lossMsg.setBounds(CardGameGUI.LABEL_LEFT, CardGameGUI.LABEL_TOP + CardGameGUI.LABEL_HEIGHT_INC, 200, 30);
        this.lossMsg.setFont(new Font("SanSerif", Font.BOLD, 25));
        this.lossMsg.setForeground(Color.RED);
        this.lossMsg.setText("Sorry, you lose.");
        this.panel.add(this.lossMsg);
        this.lossMsg.setVisible(false);

        this.totalsMsg = new JLabel("You've won " + this.totalWins
                + " out of " + this.totalGames + " games.");
        this.totalsMsg.setBounds(CardGameGUI.LABEL_LEFT, CardGameGUI.LABEL_TOP + 2 * CardGameGUI.LABEL_HEIGHT_INC,
                250, 30);
        this.panel.add(this.totalsMsg);

        if (!this.board.anotherPlayIsPossible()) {
            this.signalLoss();
        }

        this.pack();
        this.getContentPane().add(this.panel);
        this.getRootPane().setDefaultButton(this.replaceButton);
        this.panel.setVisible(true);
    }


    private void signalError() {
        final Toolkit t = this.panel.getToolkit();
        t.beep();
    }


    private String imageFileName(final Card c, final boolean isSelected) {
        String str = "cards/";
        if (c == null) {
            return "cards/back1.GIF";
        }
        str += c.rank() + c.suit();
        if (isSelected) {
            str += "S";
        }
        str += ".GIF";
        return str;
    }


    public void actionPerformed(final ActionEvent e) {
        if (e.getSource().equals(this.replaceButton)) {

            final List<Integer> selection = new ArrayList<Integer>();
            for (int k = 0; k < this.board.size(); k++) {
                if (this.selections[k]) {
                    selection.add(new Integer(k));
                }
            }

            if (!this.board.isLegal(selection)) {
                this.signalError();
                return;
            }
            for (int k = 0; k < this.board.size(); k++) {
                this.selections[k] = false;
            }

            this.board.replaceSelectedCards(selection);
            if (this.board.isEmpty()) {
                this.signalWin();
            } else if (!this.board.anotherPlayIsPossible()) {
                this.signalLoss();
            }
            this.repaint();
        } else if (e.getSource().equals(this.restartButton)) {
            this.board.newGame();
            this.getRootPane().setDefaultButton(this.replaceButton);
            this.winMsg.setVisible(false);
            this.lossMsg.setVisible(false);
            if (!this.board.anotherPlayIsPossible()) {
                this.signalLoss();
                this.lossMsg.setVisible(true);
            }
            for (int i = 0; i < this.selections.length; i++) {
                this.selections[i] = false;
            }
            this.repaint();
        } else {
            this.signalError();
            return;
        }
    }


    private void signalWin() {
        this.getRootPane().setDefaultButton(this.restartButton);
        this.winMsg.setVisible(true);
        this.totalWins++;
        this.totalGames++;
    }


    private void signalLoss() {
        this.getRootPane().setDefaultButton(this.restartButton);
        this.lossMsg.setVisible(true);
        this.totalGames++;
    }


    private class MyMouseListener implements MouseListener {


        public void mouseClicked(final MouseEvent e) {
            for (int k = 0; k < CardGameGUI.this.board.size(); k++) {
                if (e.getSource().equals(CardGameGUI.this.displayCards[k])
                        && CardGameGUI.this.board.cardAt(k) != null) {
                    CardGameGUI.this.selections[k] = !CardGameGUI.this.selections[k];
                    CardGameGUI.this.repaint();
                    return;
                }
            }
            CardGameGUI.this.signalError();
        }

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
    }
}