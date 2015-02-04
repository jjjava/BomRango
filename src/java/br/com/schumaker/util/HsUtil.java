package br.com.schumaker.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author hudson schumaker HStudio - @BomRango 21/01/2015
 * @version 1.0.0
 * @since 1.0.0
 */
public class HsUtil {

    public static String timeStamp() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH:mm:SS");
        String timeStamp = sdf.format(Calendar.getInstance().getTime());
        return timeStamp;
    }
}
