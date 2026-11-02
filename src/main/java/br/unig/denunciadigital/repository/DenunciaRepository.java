package br.unig.denunciadigital.repository;

import br.unig.denunciadigital.model.Denuncia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface DenunciaRepository extends JpaRepository<Denuncia, Long> {

    // Conta quantas denúncias existem por tipo de violação
    @Query("SELECT d.tipoViolacao as tipo, COUNT(d) as total FROM Denuncia d GROUP BY d.tipoViolacao")
    List<Object[]> contarPorTipoViolacao();

    // Conta por faixa etária
    @Query("SELECT d.faixaEtaria as faixa, COUNT(d) as total FROM Denuncia d GROUP BY d.faixaEtaria")
    List<Object[]> contarPorFaixaEtaria();

    // Conta por sensação de segurança
    @Query("SELECT d.sensacaoSeguranca as nivel, COUNT(d) as total FROM Denuncia d GROUP BY d.sensacaoSeguranca")
    List<Object[]> contarPorSensacaoSeguranca();
}