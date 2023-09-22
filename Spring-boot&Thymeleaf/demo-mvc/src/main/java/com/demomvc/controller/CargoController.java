package com.demomvc.controller;

import com.demomvc.domain.Cargo;
import com.demomvc.domain.Departamento;
import com.demomvc.service.CargoService;
import com.demomvc.service.DepartamentoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.demomvc.util.Paginacao;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/cargos")
public class CargoController {


    private CargoService cargoService;
    private DepartamentoService departamentoService;

    @Autowired
    public CargoController(CargoService cargoService, DepartamentoService departamentoService) {
        this.cargoService = cargoService;
        this.departamentoService = departamentoService;
    }

    @GetMapping("/cadastrar")
    public String cadastrar(Cargo cargo){
        return "/cargo/cadastro";
    }

    @GetMapping("/listar")
    public String listar(ModelMap model, @RequestParam("page")Optional<Integer> page){

        int paginaAtual = page.orElse(1);

        Paginacao<Cargo> pageCargo = cargoService.buscaPagina(paginaAtual);
        model.addAttribute("pageCargo", pageCargo);
        //model.addAttribute("cargos", cargoService.buscarTodos());
        return "cargo/lista";
    }

    @PostMapping("/salvar")
    public String salvar(@Valid Cargo cargo, BindingResult result, RedirectAttributes attr){

        if(result.hasErrors()){
            return "/cargo/cadastro";
        }

        cargoService.salvar(cargo);
        attr.addFlashAttribute("success", "Cargo inserido com sucesso.");
        return "redirect:/cargos/cadastrar";
    }

    @GetMapping("/editar/{id}")
    public String preEditar(@PathVariable("id") Long id, ModelMap model){
        model.addAttribute("cargo", cargoService.buscaPorId(id));
        return "cargo/cadastro";
    }

    @PostMapping("/editar")
    public String editar(@Valid Cargo cargo,BindingResult result, RedirectAttributes attr){

        if(result.hasErrors()){
            return "/cargo/cadastro";
        }

        cargoService.editar(cargo);
        attr.addFlashAttribute("success", "Registro atualizado com sucesso.");
        return "redirect:/cargos/cadastrar";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Long id, RedirectAttributes attr){
        if(cargoService.cargoTemFuncionarios(id)){
            attr.addFlashAttribute("fail", "Cargo não excluido. Tem funcionários vinculados");
        }else{
            cargoService.excluir(id);
            attr.addFlashAttribute("success", "Cargo excluido com sucesso");
        }
        return "redirect:/cargos/listar";
    }

    @ModelAttribute("departamentos")
    public List<Departamento> listaDeDepartamento(){
        return departamentoService.buscarTodos();
    }
}
