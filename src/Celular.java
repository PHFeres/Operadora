import java.util.ArrayList;
import java.util.List;

public class Celular {
    //Armazenar número, cliente, plano, lista ligações
    //Tipo: PreP, PoP
    //Plano

    private String cpfCliente;
    private long numero;
    private static long proxNumero = 10000000; //INICIALIZAR COM MENOR VALOR, 8 DIGITOS?
    private Plano plano;
    private List<Ligacao> ligacoes;

    public Celular(String cpf){
        cpfCliente = cpf;
        ligacoes = new ArrayList<Ligacao>();
    }

    public String getCliente(){
        return cpfCliente;
    }

    public long getNumero(){
        return numero;
    }

    public long getProxNumero(){
        return proxNumero;
    }

    public void setPlano(Plano p){
        plano = p;
    }

    //Tratar erro de leitura de plano sem plano cadastrado
    public String getDadosPlano(){
        return plano.getPlano();
    }

    public double getPrecoPlano(){
        return  plano.getValorPlano();
    }

    public List<Ligacao> getLigacoes() {
        return ligacoes;
    }

    public void setLigacao(Ligacao l){
        ligacoes.add(l);
    };

    public void ligacao(String data, float duracao, long destino) throws Exception {
        //TODO tratar excecao, se pa melhor na operadora
        Ligacao l = new Ligacao(data, duracao, destino);
        setLigacao(l);
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////
    //                                  FUNÇÕES DECLARAÇÃO
    /////////////////////////////////////////////////////////////////////////////////////////////////

    public double getSaldo(){
        return -1;
    }

    public String getType (){
        return "";
    };


    public void addSaldo(int money){

    }

    public String getDadosCelular(){
        return "";
    };

    public String getVencimento() {
        return "";
    }
}
