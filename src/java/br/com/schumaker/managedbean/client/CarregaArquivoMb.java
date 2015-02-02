package br.com.schumaker.managedbean.client;

import br.com.schumaker.bs.impl.CarregaArquivoBsImpl;
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
public class CarregaArquivoMb implements Serializable {

    public CarregaArquivoMb() {
    }

    public void carregaArquivo(FileUploadEvent event) {
        new CarregaArquivoBsImpl().gerenciaCargaDeArquivo(event);
    }
}
