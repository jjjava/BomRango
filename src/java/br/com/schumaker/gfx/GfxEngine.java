package br.com.schumaker.gfx;

import br.com.schumaker.hsfiles.HsFiles;
import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;

/**
 *
 * @author hudson schumaker HStudio - @BomRango 29/01/2015
 * @version 1.0.0
 * @since 1.0.0
 */
public class GfxEngine implements Runnable {

    private ArrayList<Integer> aSize;
    private ArrayList<String> aNames;
    private String pathOut;
    private String name;

    public GfxEngine(String pathOut, String name) {
        this.pathOut = pathOut;
        this.name = name;
        setUp();
    }

    private void setUp() {
        aSize = new ArrayList<Integer>();
        aSize.add(64);
        aSize.add(128);
        aNames = new ArrayList<String>();
        aNames.add(HsFiles.getClearName(name) + "@1." + HsFiles.getFileExtension(name));
        aNames.add(HsFiles.getClearName(name) + "@2." + HsFiles.getFileExtension(name));
    }

    private void createImages(String path) {
        BufferedImage originalImage = readImageFromDisk(path);
        int type = originalImage.getType() == 0 ? BufferedImage.TYPE_INT_ARGB : originalImage.getType();
        for (int k = 0; k < aNames.size(); k++) {
            BufferedImage resizeImageHintPng = resizeImageWithHint(originalImage, type, aSize.get(k), aSize.get(k));
            writeImageOnDisk(resizeImageHintPng, "png", pathOut, aNames.get(k));
        }
        File file = new File(path);
        file.delete();
    }

    private BufferedImage resizeImageWithHint(BufferedImage originalImage, int type, int w, int h) {
        BufferedImage resizedImage = new BufferedImage(w, h, type);
        Graphics2D g = resizedImage.createGraphics();
        g.drawImage(originalImage, 0, 0, w, h, null);
        g.dispose();
        g.setComposite(AlphaComposite.Src);
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        return resizedImage;
    }

    private BufferedImage readImageFromDisk(String path) {
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File(path));
        } catch (IOException ex) {
            System.err.println(ex);
        }
        return image;
    }

    private void writeImageOnDisk(BufferedImage img, String type, String path, String name) {
        try {
            ImageIO.write(img, type, new File(path + "/" + name));
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

    @Override
    public void run() {
        createImages(pathOut + "/" + name);
    }

    public void start() {
        Thread thread = new Thread(this);
        thread.start();
    }
}
