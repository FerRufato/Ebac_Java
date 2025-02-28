package br.com.ferufato; // Define que esta classe pertence ao pacote 'br.com.ferufato'

import br.com.ferufato.dao.ClienteSetDAO; // Importa a implementação do DAO que lida com clientes
import br.com.ferufato.dao.IClienteDAO; // Importa a interface DAO para operações com clientes
import br.com.ferufato.domain.Cliente; // Importa a classe Cliente, que representa um cliente no sistema

import javax.swing.*; // Importa a biblioteca Swing para exibir caixas de diálogo

public class App {

    private static IClienteDAO iClienteDAO; // Declara uma variável estática para acessar o DAO de clientes

    public static void main(String args[]) {
        iClienteDAO = new ClienteSetDAO(); // Instancia a implementação do DAO

        // Exibe uma caixa de diálogo solicitando a opção do usuário
        String opcao = JOptionPane.showInputDialog(null,
                "Digite 1 para cadastro, 2 para consultar, 3 para exclusão, 4 para alteração ou 5 para sair",
                "Green dinner", JOptionPane.INFORMATION_MESSAGE);

        // Valida se a opção digitada é válida
        while (!isOpcaoValida(opcao)) {
            if ("".equals(opcao)) { // Se o usuário não digitou nada, encerra o programa
                sair();
            }
            opcao = JOptionPane.showInputDialog(null,
                    "Opção inválida digite 1 para cadastro, 2 para consulta, 3 para exclusão, 4 para alteração ou 5 para sair",
                    "Green dinner", JOptionPane.INFORMATION_MESSAGE);
        }

        // Enquanto a opção for válida, executa a ação correspondente
        while (isOpcaoValida(opcao)) {

            if (isOpcaoSair(opcao)) { // Se o usuário escolheu sair (opção 5)
                sair();
            } else if (isCadastro(opcao)) { // Se escolheu cadastrar um novo cliente (opção 1)
                String dados = JOptionPane.showInputDialog(null,
                        "Digite os dados do cliente separados por vírgula, conforme exemplo: Nome, CPF, Telefone, Endereço, Número, Cidade e Estado",
                        "Cadastro", JOptionPane.INFORMATION_MESSAGE);
                cadastrar(dados);
            } else if (isConsulta(opcao)) { // Se escolheu consultar um cliente (opção 2)
                String dados = JOptionPane.showInputDialog(null,
                        "Digite o CPF do cliente",
                        "Consulta cliente", JOptionPane.INFORMATION_MESSAGE);
                consultar(dados);
            } else if (isExclusao(opcao)) { // Se escolheu excluir um cliente (opção 3)
                String dados = JOptionPane.showInputDialog(null,
                        "Digite o CPF do cliente",
                        "Consulta cliente", JOptionPane.INFORMATION_MESSAGE);
                excluir(dados);
            } else { // Se escolheu atualizar um cliente (opção 4)
                String dados = JOptionPane.showInputDialog(null,
                        "Digite os dados do cliente separados por vírgula, conforme exemplo: Nome, CPF, Telefone, Endereço, Número, Cidade e Estado",
                        "Atualização", JOptionPane.INFORMATION_MESSAGE);
                atualizar(dados);
            }

            // Solicita novamente a opção do usuário após concluir a ação
            opcao = JOptionPane.showInputDialog(null,
                    "Digite 1 para cadastro, 2 para consulta, 3 para exclusão, 4 para alteração ou 5 para sair",
                    "Green dinner", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    // Método para atualizar os dados de um cliente
    private static void atualizar(String dados) {
        String[] dadosSeparados = dados.split(","); // Divide os dados do cliente por vírgula
        Cliente cliente = new Cliente(dadosSeparados[0], dadosSeparados[1], dadosSeparados[2],
                dadosSeparados[3], dadosSeparados[4], dadosSeparados[5], dadosSeparados[6]); // Cria um objeto Cliente
        iClienteDAO.alterar(cliente); // Chama o DAO para alterar o cliente no banco de dados
    }

    // Método para excluir um cliente pelo CPF
    private static void excluir(String dados) {
        iClienteDAO.excluir(Long.parseLong(dados)); // Converte o CPF para Long e solicita a exclusão
        JOptionPane.showMessageDialog(null, "Cliente excluído com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
    }

    // Método para consultar um cliente pelo CPF
    private static void consultar(String dados) {
        Cliente cliente = iClienteDAO.consultar(Long.parseLong(dados)); // Consulta o cliente no DAO
        if (cliente != null) {
            JOptionPane.showMessageDialog(null, "Cliente encontrado com sucesso: " + cliente.toString(), "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Cliente não encontrado", "ERRO", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    // Método para cadastrar um novo cliente
    private static void cadastrar(String dados) {
        String[] dadosSeparados = dados.split(","); // Divide os dados do cliente por vírgula
        Cliente cliente = new Cliente(dadosSeparados[0], dadosSeparados[1], dadosSeparados[2],
                dadosSeparados[3], dadosSeparados[4], dadosSeparados[5], dadosSeparados[6]); // Cria um objeto Cliente
        Boolean isCadastrado = iClienteDAO.cadastrar(cliente); // Chama o DAO para cadastrar o cliente
        if (isCadastrado) {
            JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Cliente já se encontra cadastrado", "Erro", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    // Método que verifica se a opção digitada é a de exclusão
    private static boolean isExclusao(String opcao) {
        return "3".equals(opcao);
    }

    // Método que verifica se a opção digitada é a de consulta
    private static boolean isConsulta(String opcao) {
        return "2".equals(opcao);
    }

    // Método que verifica se a opção digitada é a de cadastro
    private static boolean isCadastro(String opcao) {
        return "1".equals(opcao);
    }

    // Método para encerrar o programa e exibir os clientes cadastrados antes de sair
    private static void sair() {
        String clientesCadastrados = "";
        for (Cliente cliente : iClienteDAO.buscarTodos()) { // Percorre a lista de clientes cadastrados
            clientesCadastrados += cliente.toString() + "\n"; // Concatena as informações dos clientes
        }

        // Exibe os clientes cadastrados e encerra o programa
        JOptionPane.showMessageDialog(null, "Clientes cadastrados:\n" + clientesCadastrados, "Até logo", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0); // Finaliza o programa
    }

    // Método que verifica se a opção digitada é a de sair
    private static boolean isOpcaoSair(String opcao) {
        return "5".equals(opcao);
    }

    // Método que verifica se a opção digitada é válida (1 a 5)
    private static boolean isOpcaoValida(String opcao) {
        return "1".equals(opcao) || "2".equals(opcao) || "3".equals(opcao) || "4".equals(opcao) || "5".equals(opcao);
    }
}
