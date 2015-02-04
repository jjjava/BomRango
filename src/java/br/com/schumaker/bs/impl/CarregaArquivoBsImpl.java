package br.com.schumaker.bs.impl;

import br.com.schumaker.gfx.GfxEngine;
import br.com.schumaker.hsfiles.HsFiles;
import br.com.schumaker.model.Produto;
import br.com.schumaker.util.HsCommons;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;
import org.primefaces.event.FileUploadEvent;

/**
 *
 * @author hudson schumaker HStudio - @BomRango 02/02/2015
 * @version 1.0.0
 * @since 1.0.0
 */
public class CarregaArquivoBsImpl {

    public void gerenciaCargaDeArquivo(FileUploadEvent event) {
        UUID uuid = UUID.randomUUID();
        String uuidStr = uuid.toString() + "." + HsFiles.getFileExtension(event.getFile().getFileName());
        System.out.println(uuidStr);
        try {
            InputStream in = new BufferedInputStream(event.getFile().getInputstream());
            File file = new File(HsCommons.TEMPPRODIMAGFOLDER + uuid.toString() + "." + HsFiles.getFileExtension(event.getFile().getFileName()));
            FileOutputStream fout = new FileOutputStream(file);
            while (in.available() != 0) {
                fout.write(in.read());
            }
            fout.close();
            GfxEngine gfxEngine = new GfxEngine(HsCommons.TEMPPRODIMAGFOLDER, HsCommons.IMAGEFOLDER, uuidStr);
            gfxEngine.start();
            Produto p = new ProdutoBsImpl().getCadProdutoSessao();
            p.setImagem(uuid.toString());//sem extensão
        } catch (IOException ex) {
            System.out.println(ex);
            LogBsImpl.getInstance().inserirLog(this.getClass().getSimpleName(), ex.getMessage());
        }
    }
}
