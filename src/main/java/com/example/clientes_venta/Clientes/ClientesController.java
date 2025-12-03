package com.example.clientes_venta.Clientes;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.clientes_venta.Usuario.Usuario;
import com.example.clientes_venta.Usuario.UsuarioService;

@Controller
public class ClientesController {

    private final UsuarioService usuarioService;

    public ClientesController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }
    
    @GetMapping("/clientes")
    public String clientes(Model model){
        List<Usuario> clientesL = usuarioService.getUsuarios();
        model.addAttribute("clientes", clientesL);
        return "clientes";
    }

}
