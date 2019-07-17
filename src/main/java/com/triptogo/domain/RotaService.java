package com.triptogo.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RotaService {

    @Autowired
    private RotaRepository rep;

    public Iterable<Rota> getRotas(){
        return rep.findAll();
    }

    public Optional<Rota> getRotaById(Long id) {
        return rep.findById(id);
    }

    public Iterable<Rota> getRotaByEstado(String estado) {
        return rep.findByEstado(estado);
    }

    public Rota insert(Rota rota) {
        return rep.save(rota);
    }

    public Rota update(Rota rota, Long id) {
        Assert.notNull(id,"Não foi possível atualizar o registro");

        //Busca a rota no banco
        Optional<Rota> optional = getRotaById(id);
        if(optional.isPresent()) {
            Rota db = optional.get();
            //Copiar as propriedades
            db.setNome(rota.getNome());
            db.setEstado(rota.getEstado());
            System.out.println("Rota id: " + db.getId());

            //Atualiza o carro
            rep.save(db);

            return db;
        }else {
            throw new RuntimeException("Não foi possível atualizar o registro");
        }
    }

    public void delete(Long id) {
        Optional<Rota> rota = getRotaById(id);
        if(rota.isPresent()) {
            rep.deleteById(id);
        }
    }
}
