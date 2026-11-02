package br.unig.denunciadigital.service;

import br.unig.denunciadigital.model.Denuncia;
import br.unig.denunciadigital.repository.DenunciaRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DenunciaService {

    private final DenunciaRepository denunciaRepository;

    public DenunciaService(DenunciaRepository denunciaRepository) {
        this.denunciaRepository = denunciaRepository;
    }

    // Salvar uma nova denúncia
    public Denuncia salvar(Denuncia denuncia) {
        return denunciaRepository.save(denuncia);
    }

    // Listar todas as denúncias
    public List<Denuncia> listarTodas() {
        return denunciaRepository.findAll();
    }

    // Total de denúncias
    public long totalDenuncias() {
        return denunciaRepository.count();
    }

    // Dados para o gráfico de tipos de violação
    public Map<String, Long> contarPorTipo() {
        List<Object[]> resultados = denunciaRepository.contarPorTipoViolacao();
        Map<String, Long> mapa = new HashMap<>();

        for (Object[] linha : resultados) {
            String tipo = (String) linha[0];
            Long total = (Long) linha[1];
            mapa.put(tipo != null ? tipo : "Não informado", total);
        }
        return mapa;
    }

    // Dados para o gráfico de faixa etária
    public Map<String, Long> contarPorFaixaEtaria() {
        List<Object[]> resultados = denunciaRepository.contarPorFaixaEtaria();
        Map<String, Long> mapa = new HashMap<>();

        for (Object[] linha : resultados) {
            String faixa = (String) linha[0];
            Long total = (Long) linha[1];
            mapa.put(faixa != null ? faixa : "Não informado", total);
        }
        return mapa;
    }

    // Dados para o gráfico de sensação de segurança
    public Map<String, Long> contarPorSensacaoSeguranca() {
        List<Object[]> resultados = denunciaRepository.contarPorSensacaoSeguranca();
        Map<String, Long> mapa = new HashMap<>();

        for (Object[] linha : resultados) {
            Integer nivel = (Integer) linha[0];
            Long total = (Long) linha[1];
            String chave = nivel != null ? nivel.toString() : "Não informado";
            mapa.put(chave, total);
        }
        return mapa;
    }
}