import java.util.ArrayList;
import java.util.List;

public class Operadora {
    //TIPO classe Banco TP1

    private String nomeOp;
    private List<Celular> celulares;
    private List<Cliente> clientes;
    private List<Plano> planos;

    public Operadora (String nome)
    {
        nomeOp = nome;
        celulares = new ArrayList<Celular>();
        clientes = new ArrayList<Cliente>();
        planos = new ArrayList<Plano>();
    }

    public String getNomeOp() {
        return nomeOp;
    }

    public void setNomeOp(String nomeOp) {
        this.nomeOp = nomeOp;
    }

    public List<Celular> getCelulares() {
        return celulares;
    }

    public void setCelulares(List<Celular> celulares) {
        this.celulares = celulares;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public void addCliente(String nome, String id, String ender) throws CliException
    {
        Cliente c = new Cliente(nome, id, ender);
        for(Cliente aux: clientes)
        {
            if(c.compareC(aux))
            {
                throw new CliException(id);
                //System.out.println("Ja cadastrado");
            }
        }

        clientes.add(c);
        //System.out.println(clientes.get(0).getName());

    }


    public void addPlano(String name, double val) throws Exception
    {
        Plano p = new Plano(name, val);
        for(Plano aux: planos)
        {
            if(p.comparePlano(aux))
            {
                throw new Exception("Plano ja existe");
            }
        }

        planos.add(p);
    }

    public Celular find(long num)throws CelException
    {
        for(Celular aux: celulares)
        {
            if (aux.getNumero() == num)
            {
                return aux;
            }
        }
        throw new CelException(num);

    }

    public void liga (long origem, String data, float duracao, long destino) throws Exception
    {
        try
        {
            Celular ori = find(origem);
            find(destino);  //apenas para lancar excecao
            try
            {
                ori.ligacao(data, duracao, destino);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

        }
        catch (CelException c)
        {
            c.printStackTrace();
        }


    }

}
