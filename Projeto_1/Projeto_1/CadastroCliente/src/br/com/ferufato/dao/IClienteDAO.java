package br.com.ferufato.dao;

import br.com.ferufato.domain.Cliente;

import java.util.Collection;

public interface IClienteDAO {
    // TODO: Implementar a interface IClienteDAO

    public boolean cadastrar(Cliente cliente);//retorna true se cadastrou e false se não cadastrou

    public void excluir(Long cpf); //retorna true se excluiu e false se não excluiu

    public void alterar(Cliente cliente); //retorna true se alterou e false se não alterou

    public Cliente consultar(Long cpf); //retorna o cliente se encontrou e null se não encontrou

    public Collection<Cliente> buscarTodos(); //retorna todos os clientes cadastrados

}
