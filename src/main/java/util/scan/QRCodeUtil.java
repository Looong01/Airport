package util.scan;

import com.google.zxing.*;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Hashtable;

public class QRCodeUtil {
    private static final String CHARSET = "utf-8";
    private static final String FORMAT_NAME = "jpg";
    // 二维码尺寸
    private static final int QRCODE_SIZE = 300;
    // LOGO宽度
    private static final int WIDTH = 60;
    // LOGO高度
    private static final int HEIGHT = 60;

    private static BufferedImage createImage(String content, String imgPath, boolean needCompress) {
        Hashtable hints = new Hashtable();
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
        hints.put(EncodeHintType.CHARACTER_SET, CHARSET);
        hints.put(EncodeHintType.MARGIN, 1);
        BitMatrix bitMatrix = null;
        try {
            bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, QRCODE_SIZE, QRCODE_SIZE, hints);
        } catch (WriterException e) {
            e.printStackTrace();
        }
        assert bitMatrix != null;
        int width = bitMatrix.getWidth();
        int height = bitMatrix.getHeight();
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                image.setRGB(x, y, bitMatrix.get(x, y) ? 0xFF000000 : 0xFFFFFFFF);
            }
        }
        return image;
    }

    public static void encode(String content, String imgPath, String destPath, boolean needCompress) {
        BufferedImage image;
        try {
            image = QRCodeUtil.createImage(content, imgPath, needCompress);
            mkdirs(destPath);
            ImageIO.write(image, FORMAT_NAME, new File(destPath));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void mkdirs(String destPath) {
        File file = new File(destPath);
        // 当文件夹不存在时，mkdirs会自动创建多层目录，区别于mkdir．(mkdir如果父目录不存在则会抛出异常)
        if (!file.exists() && !file.isDirectory())
            file.mkdirs();
    }

    public static String decode(BufferedImage image) {
        BufferedImageLuminanceSource source = new BufferedImageLuminanceSource(image);
        BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
        Result result = null;
        Hashtable hints = new Hashtable();
        hints.put(DecodeHintType.CHARACTER_SET, CHARSET);
        try {
            result = new MultiFormatReader().decode(bitmap, hints);
        } catch (NotFoundException e) {
//            System.out.println("Recognizing QR code ...");
        }
        return result == null? null : result.getText();
    }

    /**
     * The Image decoder
     * @param file file
     */
    public static String decode(File file) {
        BufferedImage image = null;
        try {
            image = ImageIO.read(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (image == null) {
            return null;
        }
        BufferedImageLuminanceSource source = new BufferedImageLuminanceSource(image);
        BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
        Result result = null;
        Hashtable hints = new Hashtable();
        hints.put(DecodeHintType.CHARACTER_SET, CHARSET);
        try {
            result = new MultiFormatReader().decode(bitmap, hints);
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
        return result == null? null : result.getText();
    }

    /**
     * The Image decoder
     * @param path path
     */
    public static String decode(String path) {
        return QRCodeUtil.decode(new File(path));
    }

}