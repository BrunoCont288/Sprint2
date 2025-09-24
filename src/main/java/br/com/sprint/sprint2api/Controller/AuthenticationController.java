package br.com.sprint.sprint2api.Controller;

import br.com.sprint.sprint2api.dto.LoginRequestDTO;
import br.com.sprint.sprint2api.dto.LoginResponseDTO;
import br.com.sprint.sprint2api.dto.UsuarioRequestDTO;
import br.com.sprint.sprint2api.model.Usuario;
import br.com.sprint.sprint2api.security.TokenService;
import br.com.sprint.sprint2api.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired private AuthenticationManager authenticationManager;
    @Autowired private TokenService tokenService;
    @Autowired private UsuarioService usuarioService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid LoginRequestDTO data) {
        var userAuth = new UsernamePasswordAuthenticationToken(data.getEmail(), data.getSenha());
        var auth = this.authenticationManager.authenticate(userAuth);
        var token = tokenService.generateToken((Usuario) auth.getPrincipal());
        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody @Valid UsuarioRequestDTO data) {
        Usuario novoUsuario = new Usuario();
        novoUsuario.setNome(data.getNome());
        novoUsuario.setEmail(data.getEmail());
        novoUsuario.setSenha(data.getSenha());
        usuarioService.salvar(novoUsuario);
        return ResponseEntity.ok().build();
    }
}