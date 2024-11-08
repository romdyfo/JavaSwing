package puzzle.test.ex02;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;

import javax.imageio.ImageIO;

public class BackgroundPlayerService implements Runnable {
    private BufferedImage image;
    private Player player;

    public BackgroundPlayerService(Player player) {
        this.player = player;
        try {
            image = ImageIO.read(new File("image/background_red.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        int windowHeight = 768; // 창의 높이 설정

        while (true) {
            try {
                // player의 위치가 이미지 범위 내에 있는지 확인
                if (player.getX() + 10 < image.getWidth() && player.getY() + 50 + 5 < image.getHeight()
                        && player.getX() + 50 - 10 < image.getWidth()) {

                    int bottomColor = image.getRGB(player.getX() + 10, player.getY() + 50 + 2)
                            + image.getRGB(player.getX() + 50 - 10, player.getY() + 50 + 2);
                    System.out.println("바텀 컬러: " + bottomColor);

                    if (bottomColor != -2) {
                        player.setDown(false);
                    } else {
                        // player가 창의 하단에 닿지 않았을 때만 down()을 호출
                        if (player.getY() + player.getHeight() < windowHeight) {
                            player.down();
                        }
                    }
                }

                Thread.sleep(10);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.err.println("Warning: Player coordinates are out of image bounds.");
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}