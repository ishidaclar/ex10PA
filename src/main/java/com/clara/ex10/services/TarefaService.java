package com.clara.ex10.services;

import com.clara.ex10.models.TarefaModel;
import com.clara.ex10.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository tarefaRepository;
    public List<TarefaModel> findAll(){
        return tarefaRepository.findAll();
    }

    public TarefaModel criarTarefa (TarefaModel tarefaModel){
        return tarefaRepository.save(tarefaModel);
    }

    public Optional<TarefaModel> findById(Long id){
        return tarefaRepository.findById(id);
    }

    public TarefaModel atualizar (Long id, TarefaModel tarefaModel){
        TarefaModel model = tarefaRepository.findById(id).get();
        model.setDescricao(tarefaModel.getDescricao());
        return tarefaRepository.save(model);
    }

    public void remover(Long id){
        tarefaRepository.deleteById(id);
    }

}
