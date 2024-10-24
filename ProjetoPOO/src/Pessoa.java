public abstract class Pessoa {
    protected String cpf;
    protected String nome;

    public Pessoa(String cpf, String nome){
        this.cpf = cpf;
        this.nome = nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }
}
