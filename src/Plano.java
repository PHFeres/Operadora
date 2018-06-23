import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;


public class Plano {

    private String Nome;    //chave
    private double valorMinuto;

    public Plano(String name, double val){
        Nome = name;
        valorMinuto = val;
    }

    public String getNome() {
        return Nome;
    }

    public String getPlano(){
        String p = "Plano: " + Nome + "\nValor por minuto: " + valorMinuto;
        return p;
    }

    public double getValorPlano(){
        return valorMinuto;
    }


    public boolean comparePlano(Plano p)
    {
        if (Nome.equals(p.getNome()))
        {
            return TRUE;
        }
        else
        {
            return FALSE;
        }
    }
}
