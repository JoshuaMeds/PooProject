import java.io.FileWriter;
import java.io.IOException;

public class Funcionario extends Pessoa {
    protected int registro;

    Funcionario(String cpf, String nome, int registro){
        super(cpf, nome);
        this.registro = registro;
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

    public void adicionarEstoque(Estoque e, Item i){

    }

    public void retirarEstoque(Item i){

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

    public void retirarItemEstoque(Estoque estoque, Item i) {
        if (estoque.removerItem(i)) {
            registrarRetirada(i);
        }
    }
    public void registrarRetirada(Item i) {
        try (FileWriter writer = new FileWriter("retiradas.txt", true)) { // true para adicionar ao final do arquivo
            writer.write("Nome do Funcionário: " + this.nome + ", CPF: " + this.cpf + ", Item Retirado: " + i.getNomeItem() + "\n");
            writer.write("---------------------------\n");
            System.out.println("Retirada registrada com sucesso no arquivo!");
        } catch (IOException e) {
            System.out.println("Erro ao registrar a retirada: " + e.getMessage());
        }
    }

    @Override
    public void registrarPessoa(){
        try (FileWriter writer = new FileWriter("funcionarios.txt", true)) { // true para não sobrescrever
            writer.write("Nome: " + this.nome + " / "+"CPF: " + this.cpf+ " / " +"Registro: " + this.registro + "\n");
            writer.write("---------------------------\n");
            System.out.println("Pessoa Registrada com sucesso no arquivo!");
        } catch (IOException e) {
            System.out.println("Erro ao salvar o item no arquivo: " + e.getMessage());
        }
    }

}
