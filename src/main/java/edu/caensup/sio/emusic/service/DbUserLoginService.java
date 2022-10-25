package edu.caensup.sio.emusic.service;

import edu.caensup.sio.emusic.models.Responsable;
import edu.caensup.sio.emusic.repositories.IRepoResponsable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public class DbUserLoginService implements UserDetailsService {

    @Autowired
    private IRepoResponsable repoResponsable;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Responsable> opt = Optional.ofNullable(repoResponsable.findByUsername(username));
        if (opt.isPresent()) {
            return opt.get();
        }
        throw new UsernameNotFoundException(username + " n'existe pas !");
    }




}
