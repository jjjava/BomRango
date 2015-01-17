package br.com.schumaker.bs.impl;

import br.com.schumaker.dao.impl.PesquisaDaoImpl;

/**
 *
 * @author hudson schumaker HStudio - @BomRango 08/01/2015
 * @version 1.0.1
 * @since 1.0.0
 */
public class PesquisaBsImpl implements Runnable {

    private final String search;

    public PesquisaBsImpl(String search) {
        this.search = search;
    }

    private void verifyAndSave() {
        if (!FiltroPalavraoBsImpl.getInstance().checkWord(search)) {
            PesquisaDaoImpl pesquisaDaoImpl = new PesquisaDaoImpl();
            pesquisaDaoImpl.inserir(search);
        }
    }

    private void save() {
        PesquisaDaoImpl pesquisaDaoImpl = new PesquisaDaoImpl();
        pesquisaDaoImpl.inserir(search);
    }

    public void start() {
        Thread t = new Thread(this);
        t.setPriority(Thread.NORM_PRIORITY);
        t.start();
    }

    @Override
    public void run() {
        //verifyAndSave(); ñ eh mais necessario verificar a tabela de palavrao 
        save();
    }
}
