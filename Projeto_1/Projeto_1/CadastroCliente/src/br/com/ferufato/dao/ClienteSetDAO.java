package br.com.ferufato.dao;

import br.com.ferufato.domain.Cliente;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ClienteSetDAO implements IClienteDAO{

    private Set<Cliente> set;

    public ClienteSetDAO() {
        this.set = new HashSet<>();
    }


    @Override
    public boolean cadastrar(Cliente cliente) { //retorna true se cadastrou e false se não cadastrou
        return this.set.add(cliente); // adiciona o cliente no set
    }

    @Override
    public void excluir(Long cpf) {
        Cliente clienteEncontrado = null; //cria uma variavel para armazenar o cliente encontrado
        for (Cliente cliente : this.set) {//percorre o set
            if (cliente.getCpf().equals(cpf)) {//se encontrar o cliente
                clienteEncontrado = cliente; //armazena o cliente
                break;//sai do laço
            }
        }

        if (clienteEncontrado != null) { //se encontrou o cliente
            this.set.remove(clienteEncontrado);//remove o cliente
        }
    }

    @Override
    public void alterar(Cliente cliente) { //retorna true se alterou e false se não alterou
        if (this.set.contains(cliente)) { //se o cliente está cadastrado
            for (Cliente clienteCadastrado : this.set) { //percorre o set
                if (clienteCadastrado.equals(cliente)) { //se encontrar o cliente
                    clienteCadastrado.setNome(cliente.getNome()); //altera os dados do cliente
                    clienteCadastrado.setTel(cliente.getTel());
                    clienteCadastrado.setEnd(cliente.getEnd());
                    clienteCadastrado.setNumero(cliente.getNumero());
                    clienteCadastrado.setCidade(cliente.getCidade());
                    clienteCadastrado.setEstado(cliente.getEstado());
                    break;
                }
            }
        }

    }

    @Override
    public Cliente consultar(Long cpf) {
        for (Cliente clienteCadastrado : this.set) {
            if (clienteCadastrado.getCpf().equals(cpf)) {
                return clienteCadastrado;
            }
            return null;
        }
        return null;
    }

    @Override
    public Collection<Cliente> buscarTodos() { //retorna todos os clientes cadastrados
        return this.set;//retorna o set
    }
}
