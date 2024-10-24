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

    public void alterarCredenciais(Pessoa p){

    }
}
