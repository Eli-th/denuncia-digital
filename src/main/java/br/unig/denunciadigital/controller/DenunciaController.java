package br.unig.denunciadigital.controller;

import br.unig.denunciadigital.model.Denuncia;
import br.unig.denunciadigital.service.DenunciaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class DenunciaController {

    private final DenunciaService denunciaService;

    public DenunciaController(DenunciaService denunciaService) {
        this.denunciaService = denunciaService;
    }

    // Mostra o formulário de denúncia
    @GetMapping("/denuncia")
    public String mostrarFormulario(Model model) {
        model.addAttribute("denuncia", new Denuncia());
        return "denuncia";
    }

    // Recebe o formulário e salva a denúncia
    @PostMapping("/denuncia")
    public String salvarDenuncia(@ModelAttribute Denuncia denuncia, RedirectAttributes redirectAttributes) {
        denunciaService.salvar(denuncia);
        redirectAttributes.addFlashAttribute("sucesso", "Denúncia registrada com sucesso! Obrigado por contribuir.");
        return "redirect:/denuncia";
    }
}