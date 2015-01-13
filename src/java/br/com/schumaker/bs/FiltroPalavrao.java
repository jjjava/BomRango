package br.com.schumaker.bs;

import br.com.schumaker.dao.impl.PalavraoDaoImpl;
import br.com.schumaker.model.Palavrao;
import java.util.ArrayList;

/**
 *
 * @author hudson schumaker HStudio - @BomRango 08/01/2015
 * @version 1.0.0
 * @since 1.0.0
 */
public class FiltroPalavrao {

    private static final FiltroPalavrao INSTANCE = new FiltroPalavrao();
    private ArrayList<Palavrao> listPalavrao;
    private final PalavraoDaoImpl palavraoDAO;

    private FiltroPalavrao() {
        palavraoDAO = new PalavraoDaoImpl();
        listPalavrao = new ArrayList<Palavrao>();
        listPalavrao = (ArrayList<Palavrao>) palavraoDAO.listar();
    }

    public static FiltroPalavrao getInstance() {
        return INSTANCE;
    }

    public ArrayList<Palavrao> getListPalavrao() {
        return listPalavrao;
    }

    public boolean checkWord(String word) {
        for(Palavrao dirtWord : listPalavrao){
            if(word.contains(dirtWord.getNome())){
                return true;
            }
        }
        return false;
    }
}
