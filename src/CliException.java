public class CliException extends Exception
{
    private String cpf;

    public CliException(String id)
    {
        super("CPF "+id+ " ja cadastrado: ");
        cpf = id;
    }

    public String getCpf() {
        return cpf;
    }
}
