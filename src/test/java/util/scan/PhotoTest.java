package util.scan;

import org.bytedeco.javacv.*;
import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * The class tests photo-taking service via javacv and opencv-platform.
 * Upon window closing, photo is taken and written as PNG.
 *
 * @author Ziyao Wang
 * @version 1.5
 */
public class PhotoTest {
	@Test
	public void photo() throws Exception {
		OpenCVFrameGrabber grabber = new OpenCVFrameGrabber(0);
		grabber.start();

		CanvasFrame canvas = new CanvasFrame("Camera");
		canvas.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		canvas.toFront();
//		canvas.setAlwaysOnTop(true);

		Java2DFrameConverter converter = new Java2DFrameConverter();
		Frame frame = null;

		while (canvas.isDisplayable()) {
			frame = grabber.grab();
			canvas.showImage(frame);
		}
		grabber.close();

		BufferedImage image = converter.convert(frame);
		ImageIO.write(image,"png",new File("src/main/resources/jpg/photo-test.png"));
	}
}
