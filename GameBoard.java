import javax.swing.*;
import java.awt.*;

public class GameBoard extends JFrame {
    public int SIZE = 8;
    private JPanel[][] squares = new JPanel[SIZE][SIZE]; // 2D array for grid
    private String[][] piecesArray;

    public GameBoard() {
        setTitle("Poke Board");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(SIZE, SIZE)); // Use GridLayout for the board layout

        // Initialize the 2D array of panels
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                squares[row][col] = new JPanel();
                if ((row + col) % 2 == 0) {
                    squares[row][col].setBackground(Color.BLACK); // Color black for even squares
                } else {
                    squares[row][col].setBackground(Color.DARK_GRAY); // Color dark gray for odd squares
                }
                add(squares[row][col]); // Add each square to the board
            }
        }

        // Initialize Pokémon pieces array
        piecesArray = new String[32][2];
        loadPieces();
        for (int i = 0; i < piecesArray.length; i++) {
            for (int j = 0; j < piecesArray[i].length; j++) {
                System.out.println("piecesArray[" + i + "][" + j + "] = " + piecesArray[i][j]);
            }
        }

        // Initially populate the board with pieces
        populateBoard();
    }

    private void populateBoard() {
        int pieceIndex = 0;

        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (pieceIndex < piecesArray.length) {
                    String imagePath = piecesArray[pieceIndex][0];
                    String hpText = piecesArray[pieceIndex][1];

                    ImageIcon icon = new ImageIcon(imagePath);
                    Image scaledImage = icon.getImage().getScaledInstance(45, 45, Image.SCALE_SMOOTH);

                    JLabel pieceLabel = new JLabel(new ImageIcon(scaledImage));
                    JLabel textLabel = new JLabel(hpText, SwingConstants.CENTER);
                    textLabel.setForeground(Color.BLACK); // Make text readable

                    JPanel piecePanel = new JPanel(new BorderLayout());
                    piecePanel.setOpaque(false); // Make sure the background of the piece panel is transparent
                    piecePanel.add(pieceLabel, BorderLayout.CENTER);
                    piecePanel.add(textLabel, BorderLayout.SOUTH);

                    squares[row][col].setLayout(new BorderLayout());
                    squares[row][col].add(piecePanel, BorderLayout.CENTER);

                    pieceIndex++;
                }
            }
        }

        revalidate(); // Ensure layout updates
        repaint(); // Refresh view
    }

    private void loadPieces() {
        piecesArray[0][0] = "squirtle.png"; piecesArray[0][1] = "HP:200";
        piecesArray[1][0] = "squirtle.png"; piecesArray[1][1] = "HP:201";
        piecesArray[2][0] = "squirtle.png"; piecesArray[2][1] = "HP:202";
        piecesArray[3][0] = "squirtle.png"; piecesArray[3][1] = "HP:203";
        piecesArray[4][0] = "squirtle.png"; piecesArray[4][1] = "HP:32";
        piecesArray[5][0] = "squirtle.png"; piecesArray[5][1] = "HP:31";
        piecesArray[6][0] = "eevee.png"; piecesArray[6][1] = "HP:172";
        piecesArray[7][0] = "vaporeon.png"; piecesArray[7][1] = "HP:100";
        piecesArray[8][0] = "espeon.png"; piecesArray[8][1] = "HP:104";
        piecesArray[9][0] = "umbreon.png"; piecesArray[9][1] = "HP:123";
        piecesArray[10][0] = "jolteon.png"; piecesArray[10][1] = "HP:134";
        piecesArray[11][0] = "flareon.png"; piecesArray[11][1] = "HP:155";
        piecesArray[12][0] = "leafeon.png"; piecesArray[12][1] = "HP:182";
        piecesArray[13][0] = "sylveon.png"; piecesArray[13][1] = "HP:111";
        piecesArray[14][0] = "glaceon.png"; piecesArray[14][1] = "HP:300";
        piecesArray[15][0] = "ice-stone.png"; piecesArray[15][1] = "HP:1";
        piecesArray[16][0] = "water-stone.png"; piecesArray[16][1] = "HP:2";
        piecesArray[17][0] = "fire-stone.png"; piecesArray[17][1] = "HP:3";
        piecesArray[18][0] = "thunder-stone.png"; piecesArray[18][1] = "HP:4";
        piecesArray[19][0] = "shiny-stone.png"; piecesArray[19][1] = "HP:5";
        piecesArray[20][0] = "dawn-stone.png"; piecesArray[20][1] = "HP:6";
        piecesArray[21][0] = "dusk-stone.png"; piecesArray[21][1] = "HP:7";
        piecesArray[22][0] = "leaf-stone.png"; piecesArray[22][1] = "HP:8";
        piecesArray[23][0] = "cool.png"; piecesArray[23][1] = "HP:9";
        piecesArray[24][0] = "wartortle.png"; piecesArray[24][1] = "HP:215";
        piecesArray[25][0] = "wartortle.png"; piecesArray[25][1] = "HP:189";
        piecesArray[26][0] = "wartortle.png"; piecesArray[26][1] = "HP:202";
        piecesArray[27][0] = "wartortle.png"; piecesArray[27][1] = "HP:178";
        piecesArray[28][0] = "wartortle.png"; piecesArray[28][1] = "HP:220";
        piecesArray[29][0] = "wartortle.png"; piecesArray[29][1] = "HP:195";
        piecesArray[30][0] = "wartortle.png"; piecesArray[30][1] = "HP:205";
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GameBoard board = new GameBoard();
            board.setVisible(true);
        });
    }
}
