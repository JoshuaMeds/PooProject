public class Admin extends Funcionario {

    public Admin(String cpf, String nome, int registro){
        super(cpf, nome, registro);
    }

    public void alterarCredenciais(Pessoa p, String novoNome) {
        p.setNome(novoNome);
        System.out.println("Nome alterado para: " + novoNome);
    }

    public void modificarUsuario(Usuario usuario, String novoNome, int novaMatricula) {
        usuario.atualizarDados(novoNome, novaMatricula);
        System.out.println("Credenciais do usuário atualizadas com sucesso.");
    }
}
