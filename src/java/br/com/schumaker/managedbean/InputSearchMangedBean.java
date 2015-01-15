package br.com.schumaker.managedbean;

import java.io.IOException;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author hudson schumaker HStudio - @BomRango 10/01/2015
 * @version 1.0.0
 * @since 1.0.0
 */
@ManagedBean
@ViewScoped
public class InputSearchMangedBean implements Serializable {

    private String valueStr;
    public InputSearchMangedBean() {
    }
    
    public void doSearch(){
         try {
            FacesContext fc = FacesContext.getCurrentInstance();
            HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
            session.setAttribute("CloudTag", valueStr);
            FacesContext.getCurrentInstance().getExternalContext().redirect("faces/produtos.xhtml");
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

    public String getValueStr() {
        return valueStr;
    }

    public void setValueStr(String valueStr) {
        this.valueStr = valueStr;
    }
}