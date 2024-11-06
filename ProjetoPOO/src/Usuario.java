import java.io.FileWriter;
import java.io.IOException;

public class Usuario extends Pessoa{
    private int matricula;
    private int userId;

    public Usuario(String cpf,String nome, int matricula, int userId){
        super(cpf,nome);
        this.matricula = matricula;
        this.userId = userId;
    }

    public int getMatricula() {
        return matricula;
    }

    @Override
    public void registrarPessoa(){
        try (FileWriter writer = new FileWriter("usuario.txt", true)) { // true para não sobrescrever
            writer.write("ID:" + this.userId + " / " + "Nome: " + this.nome + " / "+"CPF: " + this.cpf+ " / " +"Matricula: " + this.matricula + "\n");
            writer.write("---------------------------\n");
            System.out.println("Usuario Registrado com sucesso no arquivo!");
        } catch (IOException e) {
            System.out.println("Erro ao salvar o item no arquivo: " + e.getMessage());
        }
    }
}
