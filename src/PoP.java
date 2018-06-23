import java.util.Calendar;
import java.util.List;

public class PoP extends Celular
{
    //pos pago
    private Calendar vencimento;  //fatura


    //ao criar passar dataF com o ano certo, o proximo mes, e o dia escolhido
    public PoP(String cpf, String dataF)
    {
        super(cpf);

        Calendar aux = Ligacao.string2cal(dataF);

    }

    //retorna a lista com todas as ligacoes depois do ultimo vencimento
    public List<Ligacao> fatura_mes()
    {
        Calendar aux = (Calendar) vencimento.clone();
        aux.add(Calendar.MONTH, -1);
        List fatura = super.getLigacoes(Ligacao.cal2string(aux));

        return fatura;
    }

    //parametro eh a lista retornada pela funcao anterior, na interface as duas serao chamadas juntas
    public double total_fatura (List<Ligacao> lista)
    {
        double total = 0;
        double val_pm = super.getPrecoPlano();  //valor por minuto
        for (Ligacao aux: lista)
        {
            total = total + val_pm*aux.getDuracao();
        }

        return total;
    }

    @Override
    public String getType() {
        return "Celular Pos-pago";
    }

    @Override
    public void ligacao(String data, float duracao, long destino)
    {
        Ligacao l = new Ligacao(data, duracao, destino);
        super.setLigacao(l);
    }
}
