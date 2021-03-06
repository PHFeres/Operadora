import java.util.ArrayList;
import java.util.Calendar;
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

    public List<Plano> getPlanos() {
        return planos;
    }

    public double getSaldo(long num) throws Exception {
        Celular c = find(num);

        if(c.getType_int() == 1)
        {
            throw new Exception("Não se pode olhar saldo de um celular pós pago.");
        }
        else
        {
            return c.getSaldo();
        }

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

    public Cliente find(String cpf) throws Exception {
        Cliente c = new Cliente("", cpf, "");
        for(Cliente aux: clientes)
        {
            if(c.compareC(aux))
            {
                return aux;
            }
        }

        throw new Exception("Cliente não existe");
    }

    public void addPreP(String cpf) throws Exception {
        Cliente c = find(cpf);
        PreP cel = new PreP(c);

        celulares.add(cel);
    }

    public void addPoP(String cpf, Calendar data_venc) throws Exception {
        Cliente c = find(cpf);
        PoP cel = new PoP(c, data_venc);

        celulares.add(cel);
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

    public Plano find_plano(String nome) throws Exception {
        Plano p = new Plano(nome, 0);
        for(Plano aux: planos)
        {
            if(aux.comparePlano(p))
            {
                return p;
            }
        }

        throw new Exception("Plano não existe");
    }

    public void assina_plano(long num, String nome_p) throws Exception {
        Celular c = find(num);
        Plano p = find_plano(nome_p);
        c.setPlano(p);
    }

    public void liga (long origem, String data, float duracao, long destino, int hora, int minuto) throws Exception
    {
        try
        {
            Celular ori = find(origem);
            find(destino);  //apenas para lancar excecao
            try
            {
                ori.ligacao(data, duracao, destino, hora, minuto);
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

    public void addSaldo(long num, int money) throws Exception
    {
        try
        {
            Celular c = find(num);
            if(c.getType_int() == 2)
            {
                c.addSaldo(money);
            }
            else
            {
                throw new Exception("Nao é possivel adicionar creditos num celular pos pago");
            }
        }
        catch (CliException c_ex)
        {
            c_ex.printStackTrace();
        }



    }

    public void del_celular(long num) throws CelException
    {
        try
        {
            Celular c = find(num);
            if(c.getType_int() == 1) //pos pago
            {
                List l = c.fatura_mes();
                double val = c.total_fatura(l);
                if (val == 0)   //pode excluir
                {
                    celulares.remove(c);
                }
                else
                {
                    throw new CelException(num, 0);
                }
            }
            else //pre pago
            {
                double saldo = c.getSaldo();
                if(saldo == 0)
                {
                    celulares.remove(c);
                }
                else
                {
                    throw new CelException(num, 0);
                }

            }
        }
        catch (CelException c_ex)
        {
            c_ex.printStackTrace();
        }
    }



    //TODO comparar data atual com data de vencimento creditos e fatura

}
