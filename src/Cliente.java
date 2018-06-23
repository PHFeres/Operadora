import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class Cliente {
    private String nome;
    private String cpf_cnpj;
    private String endereco;

    public Cliente(String nom, String cpf, String ads){
        nome = nom;
        cpf_cnpj = cpf;
        endereco = ads;
    }

    public String getName(){
        return nome;
    }

    public String getCpf_cnpj() {
        return cpf_cnpj;
    }

    public boolean compareC (Cliente c)
    {
        if(this.cpf_cnpj.equals(c.cpf_cnpj))
        {
            return TRUE;   //cpf ja cadastrado
        }
        else
        {
            return FALSE;
        }

    }

}
