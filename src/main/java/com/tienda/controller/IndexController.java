package com.tienda.controller;

import com.tienda.domain.Cliente;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.tienda.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Controller
@Slf4j
public class IndexController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/")
    public String inicio(Model model) {
        log.info("Ahora utilizamos MVC");

        /* Cliente cliente = new Cliente("Andrés", "Díaz Garro", "iandrestgn@gmail.com", "8476-7856");
        Cliente cliente2 = new Cliente("Andrés", "Díaz Garro", "iandrestgn@gmail.com", "8476-7856");
        Cliente cliente3 = new Cliente("Andrés", "Díaz Garro", "iandrestgn@gmail.com", "8476-7856");

        var clientes = Arrays.asList(cliente, cliente2, cliente3);
        
        model.addAttribute("cliente",cliente);
        model.addAttribute("clientes",clientes);
         */
        var clientes = clienteService.getClientes();

        model.addAttribute("clientes", clientes);

        return "index";
    }

    @GetMapping("/nuevoCliente")
    public String nuevoCliente(Cliente cliente) {
        return "modificarCliente";
    }

    @PostMapping("/guardarCliente")
    public String guardarCliente(Cliente cliente) {
        clienteService.save(cliente);
        return "redirect:/";
    }

    @GetMapping("/modificarCliente/{idCliente}")
    public String modificarCliente(Cliente cliente, Model model) {
        cliente = clienteService.getCliente(cliente);
        model.addAttribute("cliente", cliente);
        return "modificarCliente";
    }

    @GetMapping("/eliminarCliente/{idCliente}")
    public String eliminarCliente(Cliente cliente) {
        clienteService.delete(cliente);
        return "redirect:/";
    }
}