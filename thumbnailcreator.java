import javax.imageio.ImageIO;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String inputfile = "C:\\Users\\ruddh\\Documents\\잡다\\사진.jpg";
        String outfile = "C:\\Users\\ruddh\\Documents\\잡다\\증명사진.jpg";
        File f = new File(inputfile);
        BufferedImage original = ImageIO.read(f);


        BufferedImage image = new BufferedImage(150, 200, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics2D = image.createGraphics();
        graphics2D.drawImage(original, 0, 0, 150, 200, null);
        graphics2D.dispose();

        File out = new File(outfile);
        ImageIO.write(image, "jpg", out);
    }
}