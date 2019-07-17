package com.triptogo.api;

import com.triptogo.domain.Rota;
import com.triptogo.domain.RotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/rotas")
public class RotasController {
    @Autowired
    private RotaService service;

    @GetMapping
    public Iterable<Rota> get() {
        return service.getRotas();
    }

    @GetMapping("/{id}")
    public Optional<Rota> get(@PathVariable("id") Long id) {
        return service.getRotaById(id);
    }

    @GetMapping("/estado/{estado}")
    public Iterable<Rota> getRotasByEstado(@PathVariable("estado") String estado) {
        return service.getRotaByEstado(estado);
    }

    @PostMapping
    public String post(@RequestBody Rota rota){
        Rota r = service.insert(rota);

        return "Rota salva com sucesso: " + r.getNome();
    }

    @PutMapping("/{id}")
    public String put(@PathVariable("id") Long id, @RequestBody Rota rota){
        Rota r = service.update(rota,id);

        return "Rota atualizada com sucesso: " + r.getNome();
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id){
        service.delete(id);

        return "Rota deletada com sucesso";
    }
}
