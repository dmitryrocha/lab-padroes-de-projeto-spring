package one.digitalinnovation.labpadroesdeprojetospring.service.impl;

import one.digitalinnovation.labpadroesdeprojetospring.model.Cliente;
import one.digitalinnovation.labpadroesdeprojetospring.model.Endereco;
import one.digitalinnovation.labpadroesdeprojetospring.repository.ClienteRepository;
import one.digitalinnovation.labpadroesdeprojetospring.repository.EnderecoRepository;
import one.digitalinnovation.labpadroesdeprojetospring.service.ClienteService;
import one.digitalinnovation.labpadroesdeprojetospring.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository repository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private ViaCepService viaCepService;

    @Override
    public Iterable<Cliente> buscarTodos() {
        return repository.findAll();
    }

    @Override
    public Cliente buscarPorId(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public void inserir(Cliente cliente) {
        String cep = cliente.getEndereco().getCep();
        Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> viaCepService.consultarCep(cep));
        cliente.setEndereco(endereco);
        repository.save(cliente);
    }

    @Override
    public void atualizar(Long id, Cliente cliente) {
        Optional<Cliente> clienteBd = repository.findById(id);
        if(clienteBd.isPresent()){
            String cep = cliente.getEndereco().getCep();
            Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> viaCepService.consultarCep(cep));
            cliente.setEndereco(endereco);
            repository.save(cliente);
        }
    }

    @Override
    public void deletar(Long id) {
        Optional<Cliente> clienteBd = repository.findById(id);
        if(clienteBd.isPresent()){
            repository.deleteById(id);
        }
    }
}
