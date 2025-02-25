import javax.swing.*;
import java.awt.*;

public class testBoard extends JFrame {
    private Image bgImage;

    public testBoard() {
        setTitle("Poke Board");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null); 

        // Load background image
        ImageIcon bgIcon = new ImageIcon("squirtle.png");
        bgImage = bgIcon.getImage();

        // Create layered panel
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(0, 0, getWidth(), getHeight());

        // Panel for drawing background
        JPanel gridPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;

                // Scale background image to fit the window size
                g2d.drawImage(bgImage, 0, 0, getWidth(), getHeight(), this); // Use full width and height of panel
            }
        };

        layeredPane.add(gridPanel, Integer.valueOf(10)); // Add to bottom layer

        add(layeredPane); // Add the layered pane to the frame
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            testBoard board = new testBoard();
            board.setVisible(true);
            System.out.println("test");
        });
    }
}
