import java.util.Calendar;

public class PreP extends Celular{

    private double saldo;
    private String vencimento;

    public PreP(String cpf){
        super(cpf);
        saldo = 0.0;
        //vencimento = HOJE;
    }

    public double getSaldo(){
        return saldo;
    }

    public void addSaldo(int money){
        saldo = saldo + money;
        Calendar aux =Calendar.getInstance();
        aux.add(Calendar.DAY_OF_MONTH, +180);
        //Seta para inicio do dia
        aux.set(Calendar.HOUR_OF_DAY, 0);
        aux.set(Calendar.MINUTE, 0);
        aux.set(Calendar.SECOND, 0);
        vencimento = Ligacao.cal2string(aux);
        //validade = HOJE + 180 dias;
    }

    public String getDadosCelular(){
        String p = "Saldo: " + saldo + "\nValidade: " + vencimento;
        return p;
    };

    public String getVencimento() {
        return vencimento;
    }

    public String getType (){
        return "Celular Pré-Pago";
    }

    public void ligacao(String data, float duracao, long destino) throws Exception
    {
        double preco = this.getPrecoPlano()*duracao;
        Calendar val = Ligacao.string2cal(vencimento);
        Calendar dateCal = Ligacao.string2cal(data);
        if(preco>saldo){ //Verificar vencimento
            throw new Exception("Saldo insuficiente");
        }
        else if (val.compareTo(dateCal)>0)
        {
            throw new Exception("Creditos vencidos");
        }
        else {
            saldo = saldo - preco;
            Ligacao l = new Ligacao(data, duracao, destino);//Passar data e duração como parametros
            setLigacao(l);
        }
    }
}
