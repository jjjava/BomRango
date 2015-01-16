package br.com.schumaker.managedbean;

import br.com.schumaker.dao.DensidadeDao;
import br.com.schumaker.dao.impl.DensidadeDaoImpl;
import br.com.schumaker.dao.impl.MercadoDaoImpl;
import br.com.schumaker.model.Densidade;
import br.com.schumaker.model.Mercado;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

/**
 * @author hudson schumaker HStudio - @BomRango 12/01/2015
 * @version 1.0.0
 * @since 1.0.0
 *
 */
@ManagedBean
@ViewScoped
public class MercadoManegedBean implements Serializable {

    private final MenuModel model;

    public MercadoManegedBean() {
        model = new DefaultMenuModel();
    }

    @PostConstruct
    public void carregaMercados() {
        DensidadeDao densidadeDao = new DensidadeDaoImpl();
        MercadoDaoImpl mercadoDao = new MercadoDaoImpl();
        List<Densidade> listDensidade = densidadeDao.listar();
        for (Densidade d : listDensidade) {
            DefaultSubMenu dsm = new DefaultSubMenu(d.getNome());
            List<Mercado> mTmp = mercadoDao.listarPorDensidade(d.getId());
            for (Mercado m : mTmp) {
                DefaultMenuItem dmi = new DefaultMenuItem(m.getNome(), null, "/faces/mercadohome.xhtml?m="+m.getId());
                dsm.addElement(dmi);
            }
            model.addElement(dsm);
        }
    }

    public MenuModel getModel() {
        return model;
    }
}
