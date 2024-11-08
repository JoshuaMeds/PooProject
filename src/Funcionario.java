import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Funcionario extends Pessoa {
    protected int registro;

    Funcionario(){

    }

    public int getRegistro() {
        return registro;
    }

    public void setRegistro(int registro) {
        this.registro = registro;
    }

    public void registrarPerda(Pessoa p){

    }

    public void registrarRetirada(Pessoa p){

    }

    public void visualizarRetiradas(){

    }

    public void alterarCredenciais(Pessoa p, String novoNome) {
        if (p instanceof Usuario) {
            p.setNome(novoNome);
            System.out.println("Nome do usuário alterado para: " + novoNome);
        } else {
            System.out.println("Funcionário só pode alterar credenciais de usuários.");
        }
    }

    @Override
    public void registrarPessoa() {
        Scanner sc = new Scanner(System.in);

        System.out.println("\nÁrea de Cadastro de Funcionario!\n");
        System.out.println("Preencha todos os campos para cadastrar um Funcionario:\n");

        System.out.println("Informe o nome do Funcionario: ");
        String nome = sc.nextLine();

        System.out.println("\nInforme o CPF do Funcionario: ");
        String cpf = sc.nextLine();

        System.out.println("\nInforme o registro do Funcionario: ");
        int registro = sc.nextInt();

        this.nome = nome;
        this.cpf = cpf;
        this.registro = registro;



        System.out.println("Funcionario Registro#" + this.getRegistro() + " " + this.getNome() + " cadastrado e armazenado com sucesso!");
    }

}
