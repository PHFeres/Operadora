import java.util.Scanner;

public class Interface
{
    private Operadora op;
    private Scanner in;

    public void limpaTela()
    {
        for(int i = 0; i <= 20; i++){
            System.out.println();
        }
    }

    public void add_cliente()
    {
        System.out.print("Digite o seu Nome: ");
        String nome_c = in.next();

        System.out.print("Digite o seu CPF ou CNPJ: ");
        String cpf = in.next();

        System.out.print("Digite o seu endereço: ");
        String ender = in.next();

        try {
            op.addCliente(nome_c, cpf, ender);
        }
        catch (CliException e)
        {
            e.printStackTrace();
        }


    }

    public void add_celular()
    {
        System.out.print("Digite o seu CPF ou CNPJ: ");
        String cpf = in.next();

        System.out.print("Gostaria de um celular: [1]pós-pago ou [2]pré-pago: ");
        int tipo = in.nextInt();

        if (tipo == 1)
        {
            System.out.print("Qual dia do mês deseja pagar a fatura: ");
            int dia = in.nextInt();
        }
        else if(tipo == 2)
        {
            op.addPreP(cpf);
        }
        else
        {
            System.out.println("Opção inválida!");
        }


    }

    public void opcoes()
    {
        limpaTela();

        System.out.println("____________" + op.getNomeOp() + "____________\n");

        System.out.println("[1] Adicionar cliente");
        System.out.println("[2] Adicionar celular");
        System.out.println("[3] Criar plano");
        System.out.println("[4] Aderir a um plano");
        System.out.println("[5] Listar clientes");
        System.out.println("[6] Listar celulares");
        System.out.println("[7] Listar planos");
        System.out.println("[8] Conferir saldo");
        System.out.println("[9] Excluir celular");

        System.out.print("Digite a opção desejada: ");
        int opcao = in.nextInt();

        limpaTela();

        switch (opcao)
        {
            case 1:
                add_cliente();

                break;
            case 2:
                add_celular();

                break;
            default:
                System.out.println("Opção invalida");

        }

    }

    public Interface()
    {
        System.out.print("Digite o nome da operadora: ");
        in = new Scanner(System.in);

        String nome_op = in.next();

        op = new Operadora(nome_op);

        opcoes();




    }

}
