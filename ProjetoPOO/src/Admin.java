public class Admin extends Funcionario {

    public Admin(String cpf,String nome,int registro){
        super(cpf,nome,registro);
    }

    public void alterarCredenciais(Pessoa p, String novoNome) {
        p.setNome(novoNome);
        System.out.println("Nome alterado para: " + novoNome);
    }
}
