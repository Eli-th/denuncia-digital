package br.unig.denunciadigital.controller;

import br.unig.denunciadigital.service.DenunciaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    private final DenunciaService denunciaService;

    public DashboardController(DenunciaService denunciaService) {
        this.denunciaService = denunciaService;
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("total", denunciaService.totalDenuncias());
        model.addAttribute("porTipo", denunciaService.contarPorTipo());
        model.addAttribute("porFaixa", denunciaService.contarPorFaixaEtaria());
        model.addAttribute("porSeguranca", denunciaService.contarPorSensacaoSeguranca());
        return "dashboard";
    }
}
