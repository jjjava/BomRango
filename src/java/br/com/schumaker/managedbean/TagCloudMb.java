package br.com.schumaker.managedbean;

import br.com.schumaker.bs.impl.LogBsImpl;
import br.com.schumaker.dao.impl.PesquisaDaoImpl;
import br.com.schumaker.model.Pesquisa;
import br.com.schumaker.util.HsCommons;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.tagcloud.DefaultTagCloudItem;
import org.primefaces.model.tagcloud.DefaultTagCloudModel;
import org.primefaces.model.tagcloud.TagCloudItem;
import org.primefaces.model.tagcloud.TagCloudModel;

/**
 *
 * @author hudson schumaker HStudio - @BomRango 07/01/2015
 * @version 1.0.0
 * @since 1.0.0
 */
@ManagedBean
@ViewScoped
public class TagCloudMb implements Serializable {
    
    private final PesquisaDaoImpl pesquisaDaoImpl;
    private List<Pesquisa> pesquisas;
    private final TagCloudModel model;
    
    public TagCloudMb() {
        pesquisaDaoImpl = new PesquisaDaoImpl();
        pesquisas = new ArrayList<Pesquisa>();
        model = new DefaultTagCloudModel();
    }
    
    @PostConstruct
    public void loadTags() {
        pesquisas = pesquisaDaoImpl.listarTopXX(HsCommons.DCTAGS);
        for (Pesquisa p : pesquisas) {
            model.addTag(new DefaultTagCloudItem(p.getNome(), p.getVezes()));
        }
    }
    
    public void onSelect(SelectEvent event) {
        TagCloudItem item = (TagCloudItem) event.getObject();
        try {
            FacesContext fc = FacesContext.getCurrentInstance();
            HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
            session.setAttribute("CloudTag", item.getLabel());
            FacesContext.getCurrentInstance().getExternalContext().redirect("faces/produtos.xhtml");
        } catch (IOException ex) {
            System.err.println(ex);
            LogBsImpl.getInstance().inserirLog(this.getClass().getSimpleName(), ex.getMessage());
        }
    }
    
    public TagCloudModel getModel() {
        return model;
    }
}
