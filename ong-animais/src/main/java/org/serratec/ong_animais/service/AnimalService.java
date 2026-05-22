package org.serratec.ong_animais.service;

import java.util.List;

import org.serratec.ong_animais.domain.Animal;
import org.serratec.ong_animais.domain.Caracteristica;
import org.serratec.ong_animais.domain.Pessoa;
import org.serratec.ong_animais.dto.AnimalDTORequest;
import org.serratec.ong_animais.dto.AnimalDTOResponse;
import org.serratec.ong_animais.dto.CaracteristicaDTORequest;
import org.serratec.ong_animais.exceptions.ResourceNotFoundException;
import org.serratec.ong_animais.repository.AnimalRepository;
import org.serratec.ong_animais.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnimalService {

    @Autowired
    private AnimalRepository animalRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    public AnimalDTOResponse inserir(AnimalDTORequest animalDto) {

        Pessoa responsavel = pessoaRepository.findById(animalDto.getResponsavelId())
                .orElseThrow(() ->  new ResourceNotFoundException("Responsável não encontrado"));

        Animal animal = new Animal();
        animal.setNome(animalDto.getNome());
        animal.setDescricao(animalDto.getDescricao());
        animal.setEspecie(animalDto.getEspecie());

        CaracteristicaDTORequest caracteristicaDto = animalDto.getCaracteristica();
        Caracteristica caracteristica = new Caracteristica(
            caracteristicaDto.getCor(),
            caracteristicaDto.getPeso(),
            caracteristicaDto.getPorte(),
            caracteristicaDto.getRaca()
        );
        animal.setCaracteristica(caracteristica);

        animal.setResponsavel(responsavel);
        animal.setDataNascimento(animalDto.getDataNascimento());

        Animal salvo = animalRepository.save(animal);

        return new AnimalDTOResponse(salvo);
    }

    public List<AnimalDTOResponse> listar() {
        return animalRepository.findAll()
                .stream()
                .map(AnimalDTOResponse::new)
                .toList();
    }

    public AnimalDTOResponse buscarPorId(Long id) {
        return animalRepository.findById(id)
                .map(AnimalDTOResponse::new)
                .orElseThrow(() -> new ResourceNotFoundException("Responsável não encontrado"));
    }

    public AnimalDTOResponse atualizar(Long id, AnimalDTORequest animalDto) {

        return animalRepository.findById(id)
                .map(animal -> {

                    Pessoa responsavel = pessoaRepository.findById(animalDto.getResponsavelId())
                            .orElseThrow(() -> 
                            new ResourceNotFoundException("Responsável não encontrado"));

                    animal.setNome(animalDto.getNome());
                    animal.setDescricao(animalDto.getDescricao());
                    animal.setEspecie(animalDto.getEspecie());

                    CaracteristicaDTORequest caracteristicaDto = animalDto.getCaracteristica();
                    Caracteristica caracteristica = new Caracteristica(
                        caracteristicaDto.getCor(),
                        caracteristicaDto.getPeso(),
                        caracteristicaDto.getPorte(),
                        caracteristicaDto.getRaca()
                    );
                    animal.setCaracteristica(caracteristica);

                    animal.setResponsavel(responsavel);
                    animal.setDataNascimento(animalDto.getDataNascimento());

                    return new AnimalDTOResponse(animalRepository.save(animal));
                })
                .orElse(null);
    }

    public boolean deletar(Long id) {

        if (!animalRepository.existsById(id)) {
            return false;
        }

        animalRepository.deleteById(id);
        return true;
    }
}