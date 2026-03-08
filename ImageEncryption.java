import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class ImageEncryption {

    public static void main(String[] args) {
        try {
            // Load image
            File input = new File("input.jpg");
            BufferedImage image = ImageIO.read(input);

            int width = image.getWidth();
            int height = image.getHeight();

            int key = 123; // Encryption key

            // Encrypt pixels
            for (int x = 0; x < width; x++) {
                for (int y = 0; y < height; y++) {

                    int pixel = image.getRGB(x, y);

                    int r = (pixel >> 16) & 0xff;
                    int g = (pixel >> 8) & 0xff;
                    int b = pixel & 0xff;

                    // Simple encryption using XOR
                    r = r ^ key;
                    g = g ^ key;
                    b = b ^ key;

                    int encryptedPixel = (r << 16) | (g << 8) | b;

                    image.setRGB(x, y, encryptedPixel);
                }
            }

            // Save encrypted image
            File output = new File("encrypted.jpg");
            ImageIO.write(image, "jpg", output);

            System.out.println("Image encrypted successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}