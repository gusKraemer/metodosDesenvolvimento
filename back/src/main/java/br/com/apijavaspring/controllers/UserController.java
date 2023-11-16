package br.com.apijavaspring.controllers;

import br.com.apijavaspring.model.User;
import br.com.apijavaspring.service.UserService;
import jakarta.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/usuarios")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> listarUsuarios() {
        return ResponseEntity.status(200).body(userService.listarUsuarios());
    }

    @PostMapping
    public ResponseEntity<User> criarUsuario(@Valid @RequestBody User usuario) {
        return ResponseEntity.status(201).body(userService.salvarUsuario(usuario));
    }

    @PutMapping
    public ResponseEntity<User> editarUsuario(@Valid @RequestBody User usuario) {
        return ResponseEntity.status(201).body(userService.editarUsuario(usuario));
    }

    @PostMapping("/login")
    public ResponseEntity<User> validarSenha(@Valid @RequestBody User usuario) {
        boolean validacao = userService.validarSenha(usuario);
        if (!validacao) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        } else {
            return ResponseEntity.status(200).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluirUsuario(@PathVariable Integer id) {
        userService.excluirUsuario(id);
        return ResponseEntity.status(204).build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> lidarComExcecaoDeValidacao(MethodArgumentNotValidException excecao) {
        Map<String, String> erros = new HashMap<>();
        excecao.getBindingResult().getAllErrors().forEach((erro) -> {
            String nomeCampo = ((FieldError) erro).getField();
            String mensagemErro = erro.getDefaultMessage();
            erros.put(nomeCampo, mensagemErro);
        });
        return erros;
    }
}
