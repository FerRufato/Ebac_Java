package br.com.ferufato.dao;

import br.com.ferufato.domain.Cliente;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//implementação da interface

public class ClienteMapDao implements IClienteDAO {

//criando um map para armazenar os clientes

    private Map<Long, Cliente> map;

//instanciando o map

    public ClienteMapDao() {
        this.map = new HashMap<>();


    }
//metodos da interface

    @Override
    public boolean cadastrar(Cliente cliente) {
        if (this.map.containsKey(cliente.getCpf())) {
            return false;

        }

        this.map.put(cliente.getCpf(), cliente);
        return true;

    }

    @Override
    public void excluir(Long cpf) { //retorna true se excluiu e false se não excluiu
       Cliente clienteCadastrado = this.map.get(cpf); //busca o cliente pelo cpf
        if (clienteCadastrado != null) { //se encontrou o cliente
            this.map.remove(cpf); //remove o cliente

        }

    }

    @Override
    public void alterar(Cliente cliente) {
            Cliente clienteCadastrado = this.map.get(cliente.getCpf()); //busca o cliente pelo cpf
            if (clienteCadastrado != null) { //se encontrou o cliente
                clienteCadastrado.setNome(cliente.getNome());//altera os dados do cliente
                clienteCadastrado.setTel(cliente.getTel()); //altera os dados do cliente
                clienteCadastrado.setEnd(cliente.getEnd());//altera os dados do cliente
                clienteCadastrado.setNumero(cliente.getNumero());//altera os dados do cliente
                clienteCadastrado.setCidade(cliente.getCidade());//altera os dados do cliente
                clienteCadastrado.setEstado(cliente.getEstado());//altera os dados do cliente

        }

    }

    @Override
    public Cliente consultar(Long cpf) {
        return this.map.get(cpf); //retorna o cliente se encontrou e null se não encontrou


    }

    @Override
    public Collection<Cliente> buscarTodos() {
        return this.map.values(); //retorna todos os clientes cadastrados

    }


}
