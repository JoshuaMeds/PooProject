public class Usuario extends Pessoa{
    private int matricula;

    public Usuario(String cpf,String nome, int matricula){
        super(cpf,nome);
        this.matricula = matricula;
    }

    public int getMatricula() {
        return matricula;
    }
}
