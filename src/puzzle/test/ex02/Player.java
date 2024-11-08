package puzzle.test.ex02;

import javax.swing.*;

public class Player extends JLabel implements Moveable{
    //위치 상태
    private int x;
    private int y;

    //움직임 상태
    private boolean left;
    private boolean right;
    //private boolean up;
    private boolean down;

    private final int JUMPSPEED = 2; //up, dowm

    private ImageIcon playerR, playerL;
    public Player() {
        initObject();
        initSetting();
        initBackgroundPlayerService();
    }

    private void initObject() {
        playerR = new ImageIcon("image/IdleCatttt_R.png");
        playerL = new ImageIcon("image/IdleCatttt_L.png");
    }

    private void initSetting() {
        x = 0;
        y = 0;

        left = false;
        right = false;
        //up = false;
        down = false;

        setIcon(playerR);
        setSize(50, 50);
        setLocation(x, y);
    }

    private void initBackgroundPlayerService() {
        new Thread(new BackgroundPlayerService(this)).start();
    }

    @Override
    public void left() {
        setIcon(playerL);
        x = x - 10;
        setLocation(x, y);
    }

    @Override
    public void right() {
        setIcon(playerR);
        x = x + 10;
        setLocation(x, y);
    }

    @Override
    public void down() {
        System.out.println("down");
        down = true;
        new Thread(()->{
            while(down) {
                y = y + JUMPSPEED;
                setLocation(x, y);
                try {
                    Thread.sleep(3);
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            down = false;
        }).start();
    }

    public void setDown(boolean b) {
        down = b;
    }
}
