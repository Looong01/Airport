package util.gui;

import org.apache.batik.transcoder.TranscoderException;
import org.apache.batik.transcoder.TranscoderInput;
import org.apache.batik.transcoder.TranscoderOutput;
import org.apache.batik.transcoder.image.ImageTranscoder;
import org.apache.batik.transcoder.image.PNGTranscoder;

import java.awt.image.BufferedImage;

/**
 * The class encodes svg into BufferedImage
 *
 * @author Ziyao Wang
 * @version 1.1
 */
public class BufferedImageTranscoder extends ImageTranscoder {
	private BufferedImage image;

	/**
	 * constructor for BufferedImageTranscoder
	 * @param uri String
	 * @param width float
	 * @param height float
	 */
	public BufferedImageTranscoder(String uri, float width, float height) {
		addTranscodingHint(PNGTranscoder.KEY_WIDTH, width);
		addTranscodingHint(PNGTranscoder.KEY_HEIGHT, height);

		TranscoderInput input = new TranscoderInput(uri);
		try {
			transcode(input, null);
		} catch (TranscoderException e) {
			e.printStackTrace();
		}
	}

	/**
	 * get BufferedImage
	 * @return BufferedImage
	 */
	public BufferedImage getImage() {
		return image;
	}

	/**
	 * create image
	 * @param w int width
	 * @param h int height
	 * @return BufferedImage
	 */
	@Override
	public BufferedImage createImage(int w, int h) {
		return new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
	}

	/**
	 * write image
	 * @param bi BufferedImage
	 * @param output TranscoderOutput
	 */
	@Override
	public void writeImage(BufferedImage bi, TranscoderOutput output) {
		this.image = bi;
	}
}