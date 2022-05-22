package util.scan;

import org.bytedeco.javacv.*;
import org.opencv.osgi.OpenCVInterface;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * 用法：运行弹窗，关闭窗口时拍照并保存
 */
public class PhotoTest {
	public static void main(String[] args) throws Exception {
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

			Thread.sleep(50);
		}
		grabber.close();

		BufferedImage image = converter.convert(frame);
		ImageIO.write(image,"png",new File("src/main/resources/PNG/1.png"));

	}
}
