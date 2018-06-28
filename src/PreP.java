import java.util.Calendar;

public class PreP extends Celular{

    private double saldo;
    private String vencimento;

    public PreP(String cpf){
        super(cpf);
        saldo = 0.0;

        //vencimento = HOJE;
        Calendar cal_venc = Calendar.getInstance();
        vencimento = Ligacao.cal2string(cal_venc);

    }

    public double getSaldo(){
        return saldo;
    }

    public void addSaldo(int money){
        saldo = saldo + money;

        //validade = HOJE + 180 dias;
        Calendar aux =Calendar.getInstance();
        aux.add(Calendar.DAY_OF_MONTH, +180);
        //Seta para inicio do dia
        aux.set(Calendar.HOUR_OF_DAY, 0);
        aux.set(Calendar.MINUTE, 0);
        aux.set(Calendar.SECOND, 0);
        vencimento = Ligacao.cal2string(aux);
    }

    public String getDadosCelular(){
        String p = "Saldo: " + saldo + "\nValidade: " + vencimento;
        return p;
    }

    public String getVencimento() {
        return vencimento;
    }

    public String getType (){
        return "Celular Pré-Pago";
    }


    public int getType_int (){
        return 2;
    }


    //TODO adicionar hora
    public void ligacao(String data, float duracao, long destino, int hora, int minuto) throws Exception
    {
        double preco = this.getPrecoPlano()*duracao;
        Calendar val = Ligacao.string2cal(vencimento);
        Calendar dateCal = Ligacao.string2cal(data);

        //excecao nao testada
        if(preco>saldo)
        { //Verificar vencimento
            throw new Exception("Saldo insuficiente");
        }
        else if (val.compareTo(dateCal)>0)
        {
            throw new Exception("Creditos vencidos");
        }
        else {
            saldo = saldo - preco;
            Ligacao l = new Ligacao(data, duracao, destino, hora, minuto, preco);//Passar data e duração como parametros
            setLigacao(l);
        }
    }

    public void verifica_venc()
    {
        Calendar aux = Calendar.getInstance();
        Calendar cal_vencimento = Ligacao.string2cal(vencimento);

        if (aux.compareTo(cal_vencimento) > 0)      //ja passou da data de vencimento
        {
            System.out.println("Celular" + this.getNumero() + "com creditos vencido");
        }

    }
}
