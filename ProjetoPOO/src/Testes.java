import java.util.Scanner;
public class Testes {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("1- Metodo Mudar Nome");
        System.out.println("Escolha oque testar");
        int escolha = sc.nextInt();

        if(escolha == 1){
            Usuario user = new Usuario("123", "Carlos", 1, 1111);
            Funcionario fun = new Funcionario("132", "Adilson", 2);
            Admin admin = new Admin("321", "adm", 3);

            // Para atender o Requisito 8,é necessario criar esta chamada Polimorfica
            Funcionario adm = new Admin("1", "administro", 4);
            adm.alterarCredenciais(user, "Andre");

            System.out.println("Nome original " + user.getNome());
            System.out.println("Nome original " + fun.getNome());

            // Funcionário alterando nome de um usuário
            fun.alterarCredenciais(user, "Carlos Modificado");
            // Admin alterando nome de um funcionário
            fun.alterarCredenciais(fun, "Adilson Modificado");

            // Requisito 8 Polimorfico
            adm.alterarCredenciais(user, "Andre");
            adm.alterarCredenciais(fun,"Teste Fun");
            // Exibindo mudanças
            System.out.println("Nome modificado " + user.getNome()); // Carlos Modificado
            System.out.println("Nome Modificado " + fun.getNome()); // Adilson Modificado
        }
        if(escolha ==2){
                System.out.println("teste");
        }
        else
            System.out.println("Valor Invalido");
    }
}
