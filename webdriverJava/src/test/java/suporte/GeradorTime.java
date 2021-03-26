package suporte;

import java.io.File;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class GeradorTime {

    public static String tempoArquivo(){
        Timestamp date = new Timestamp(System.currentTimeMillis());
        return new SimpleDateFormat("yyyyMMdd-HHmmss").format(date);
    }
}
