package br.com.apijavaspring.service;

import br.com.apijavaspring.model.User;
import br.com.apijavaspring.repository.IUser;
import java.util.List;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/*
 @author gustavo
*/

@Service
public class UserService {
    private IUser repositorio;
    private PasswordEncoder codificadorSenha;

    public UserService(IUser repositorio) {
        this.repositorio = repositorio;
        this.codificadorSenha = new BCryptPasswordEncoder();
    }

    public List<User> listarUsuarios() {
        return repositorio.findAll();
    }

    public User salvarUsuario(User usuario) {
        String senhaCodificada = codificadorSenha.encode(usuario.getPassword());
        usuario.setPassword(senhaCodificada);
        User novoUsuario = repositorio.save(usuario);
        return novoUsuario;
    }

    public User editarUsuario(User usuario) {
        String senhaCodificada = codificadorSenha.encode(usuario.getPassword());
        usuario.setPassword(senhaCodificada);
        User usuarioEditado = repositorio.save(usuario);
        return usuarioEditado;
    }

    public Boolean excluirUsuario(Integer id) {
        repositorio.deleteById(id);
        return true;
    }

    public Boolean validarSenha(User usuario) {
        String senhaArmazenada = repositorio.getById(usuario.getId()).getPassword();
        Boolean validacao = codificadorSenha.matches(usuario.getPassword(), senhaArmazenada);
        return validacao;
    }
}