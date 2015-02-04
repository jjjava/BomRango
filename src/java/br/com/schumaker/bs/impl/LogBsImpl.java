package br.com.schumaker.bs.impl;

import br.com.schumaker.bs.LogBs;
import br.com.schumaker.dao.impl.LogDaoImpl;
import br.com.schumaker.model.Log;
import br.com.schumaker.util.HsUtil;

/**
 *
 * @author hudson schumaker HStudio - @BomRango 04/02/2015
 * @version 1.0.0
 * @since 1.0.0
 */
public class LogBsImpl implements LogBs{

    private static final LogBsImpl INSTANCE = new LogBsImpl();
    
    private LogBsImpl(){
    }
    
    public static LogBsImpl getInstance(){
        return INSTANCE;
    }
    
    @Override
    public void inserirLog(String clazz, String error) {
        Log log = new Log();
        log.setClazz(clazz);
        log.setError(error);
        log.setDate(HsUtil.timeStamp());
        new LogDaoImpl().cadastarLog(log);
    }
}
