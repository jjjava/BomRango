package br.com.schumaker.bs.impl;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import org.primefaces.event.FileUploadEvent;

/**
 *
 * @author hudson schumaker HStudio - @BomRango 02/02/2015
 * @version 1.0.0
 * @since 1.0.0
 */
public class CarregaArquivoBsImpl {

    public void gerenciaCargaDeArquivo(FileUploadEvent event) {
        System.out.println(event.getFile().getFileName());
        System.out.println(event.getFile().getSize());
        
        String uuid;
        try {
            InputStream in = new BufferedInputStream(event.getFile().getInputstream());
            File file = new File("/Volumes/Data/HStudio/Temp/");
            FileOutputStream fout = new FileOutputStream(file);
            while (in.available() != 0) {
                fout.write(in.read());
            }
            fout.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
