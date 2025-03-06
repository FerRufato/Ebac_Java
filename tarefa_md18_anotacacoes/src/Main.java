
public class Main {
    public static void main(String[] args) {
        Class<Usuario> classe = Usuario.class;// Obtém a classe Usuario


        if (classe.isAnnotationPresent(Tabela.class)) {// Verifica se a classe tem a anotação @Tabela

            Tabela tabela = classe.getAnnotation(Tabela.class);// Obtém a anotação @Tabela
            System.out.println("Nome da tabela: " + tabela.valor());// Exibe o valor do atributo valor da anotação @Tabela
        } else {// Se a classe não tem a anotação @Tabela
            System.out.println("A classe não tem a anotação @Tabela.");// Exibe uma mensagem
        }
    }
}
