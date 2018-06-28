import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Ligacao {

    private double valor;    //facilita trabalho da interface
    private Calendar dataL;
    private long nDestino;
    private float duracao;

    //TODO pegar hora da ligacao tbm
    public Ligacao(String date, float dur, long num, int hora, int minuto, double val)
    {
        duracao = dur;
        dataL = string2cal(date);
        nDestino = num;
        dataL.set(Calendar.HOUR_OF_DAY, hora);
        dataL.set(Calendar.MINUTE, minuto);
        valor = val;
    }

    public String getdataL() {
        return cal2string(dataL);
    }

    public Calendar get_data_calen(){ return dataL;}

    public void setdataL(String dataL) {
        this.dataL = string2cal(dataL);
    }

    public float getDuracao() {
        return duracao;
    }

    public void setDuracao(float duracao) {
        this.duracao = duracao;
    }


    public long getnDestino() {
        return nDestino;
    }

    public void setnDestino(long nDestino) {
        this.nDestino = nDestino;
    }

    public static String cal2string(Calendar c)
    {
        SimpleDateFormat formatter= new SimpleDateFormat("dd/MMM/yyyy"); //format it as per your requirement
        String dateNow = formatter.format(c.getTime());
        return dateNow;
    }

    public static Calendar string2cal(String s)
    {
        SimpleDateFormat formatter= new SimpleDateFormat("dd/MMM/yyyy"); //format it as per your requirement
        Calendar cal = Calendar.getInstance();
        try {
            cal.setTime(formatter.parse(s));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return cal;
    }
}
