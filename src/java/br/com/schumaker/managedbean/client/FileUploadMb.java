package br.com.schumaker.managedbean.client;

import br.com.schumaker.hsfiles.HsFiles;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.event.FileUploadEvent;

/**
 *
 * @author hudson schumaker HStudio - @BomRango 27/01/2015
 * @version 1.0.0
 * @since 1.0.0
 */
@ManagedBean
@ViewScoped
public class FileUploadMb implements Serializable {

    public FileUploadMb() {
    }

    public void handleFileUpload(FileUploadEvent event) {
        System.out.println(event.getFile().getFileName());
        System.out.println(event.getFile().getSize());
        try {
            InputStream in = new BufferedInputStream(event.getFile().getInputstream());
            File file = new File("/Users/hudson/Pictures/teste.png");
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
