
@Tabela(valor = "usuarios")// Adiciona a anotação @Tabela com o valor "usuarios"
public class Usuario {
    private String nome;
    private int idade;

    public Usuario(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }
}
