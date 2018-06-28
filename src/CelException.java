public class CelException extends Exception
{
    private long num;

    public CelException(long cel)
    {
        super("Celular "+ cel + " nao existe.");
        num = cel;
    }

    public CelException(long cel, int type)
    {
        super("Celular" + cel + "nao pode ser excluido.");
    }
}
