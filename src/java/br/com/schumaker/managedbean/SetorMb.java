package br.com.schumaker.managedbean;

import br.com.schumaker.dao.impl.SetorDaoImpl;
import br.com.schumaker.dao.impl.ProdutoDaoImpl;
import br.com.schumaker.model.Setor;
import br.com.schumaker.model.Produto;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

/**
 *
 * @author hudson schumaker HStudio - @BomRango 12/01/2015
 * @version 1.0.0
 * @since 1.0.0
 */
@ManagedBean
@ViewScoped
public class SetorMb implements Serializable {

    private List<Setor> listaCategorias;
    private final MenuModel model;
    private final SetorDaoImpl categoriaDaoImpl;
    private final ProdutoDaoImpl produtoDaoImpl;

    public SetorMb() {
        model = new DefaultMenuModel();
        categoriaDaoImpl = new SetorDaoImpl();
        produtoDaoImpl = new ProdutoDaoImpl();
        listaCategorias = new ArrayList<Setor>();
    }

    @PostConstruct
    public void loadCategorias() {
        listaCategorias = categoriaDaoImpl.listar();
        for (Setor c : listaCategorias) {
            DefaultSubMenu dsm = new DefaultSubMenu(c.getNome());
            List<Produto> tmp = produtoDaoImpl.listarPorCategoria(c.getId(), 10);
            for (Produto pTmp : tmp) {
                dsm.addElement(new DefaultMenuItem(pTmp.getNome(), null, pTmp.getPrecoStr()));
            }
            model.addElement(dsm);
        }
    }

    public MenuModel getModel() {
        return model;
    }
}
