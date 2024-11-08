package puzzle.test.ex02;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PuzzleFrame extends JFrame {
    private JLabel backgroundMap;
    private Player player;

    public PuzzleFrame() {
        initObject();
        initSetting();
        initListener();
        setVisible(true);
    }

    private void initObject() {
        backgroundMap = new JLabel(new ImageIcon("image/backgroundMap.png"));
        setContentPane(backgroundMap);

        player = new Player();
        add(player);
    }

    private void initSetting() {
        setSize(1024, 768);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initListener() {
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                //System.out.println(e.getKeyCode());

                switch (e.getKeyCode()) {
                    case KeyEvent.VK_LEFT:
                        player.left();
                        break;
                    case KeyEvent.VK_RIGHT:
                        player.right();
                        break;
                    //case KeyEvent.VK_UP:
                    //  player.up();
                    //  break;
                }
            }
        });
    }

    public static void main(String[] args) {
        new PuzzleFrame();
    }

}
