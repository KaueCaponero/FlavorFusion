package br.com.fiap.hubhotels.hotel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.hubhotels.usuario.Usuario;

@Service
public class HotelService {

    @Autowired
    HotelRepository repository;

    public void manage(Long id, Usuario myUser) {
        var hotel = repository.findById(id).orElseThrow(
            () -> new IllegalArgumentException("Hotel não encontrado.")
        );

        if(hotel.getUsuario() != null) {
            throw new IllegalArgumentException("Hotel já atribuído a outro usuário");
        }

        hotel.setUsuario(myUser);
        repository.save(hotel);
    }

    public void drop(Long id, Usuario myUser) {
        var hotel = repository.findById(id).orElseThrow(
            () -> new IllegalArgumentException("Hotel não encontrado.")
        );

        if(hotel.getUsuario() != myUser) {
            throw new IllegalArgumentException("Hotel já atribuído a outro usuário");
        }

        hotel.setUsuario(null);
        repository.save(hotel);
    }
}