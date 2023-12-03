package com.estacionamento.demo.web;

import com.estacionamento.demo.entity.Usuario;
import com.estacionamento.demo.service.UsuarioService;
import com.estacionamento.demo.web.dto.UsuarioCreateDto;
import com.estacionamento.demo.web.dto.UsuarioResponseDto;
import com.estacionamento.demo.web.dto.UsuarioSenhaDto;
import com.estacionamento.demo.web.mapper.UsuarioMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService2;

    @PostMapping
    public ResponseEntity<UsuarioResponseDto> create(@Valid @RequestBody UsuarioCreateDto createDto) {
        Usuario user = usuarioService2.salvar(UsuarioMapper.toUsuario(createDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(UsuarioMapper.toDto(user));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponseDto> getById(@PathVariable Long id) {
        Usuario user = usuarioService2.buscarPorId(id);
        return ResponseEntity.ok(UsuarioMapper.toDto(user));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> updatePassword(@PathVariable Long id, @Valid @RequestBody UsuarioSenhaDto dto) {
        Usuario user = usuarioService2.editarSenha(id, dto.getSenhaAtual(), dto.getNovaSenha(), dto.getConfirmaSenha());
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<UsuarioResponseDto>> getAll() {
        List<Usuario> users = usuarioService2.buscarPorTodos();
        return ResponseEntity.ok(UsuarioMapper.toListDto(users));
    }
}
