package br.com.collections.model;

import java.math.BigDecimal;
import java.util.*;

public class Governo {

    private Map<String, List<Politico>> partidosPoliticos;

    public Governo() {
        this.partidosPoliticos = new HashMap<>();
    }

    public void adicionarPolitico(String partido, Politico politico){
        List<Politico> politicos = this.partidosPoliticos.get(partido);

        if(politicos == null){
            politicos = new ArrayList<>();
        }
        politicos.add(politico);

        this.partidosPoliticos.put(partido, politicos);
    }

    public BigDecimal calcularGastosComSlario(String partidoPolitio){

        BigDecimal total = BigDecimal.ZERO;
        List<Politico> politicos = this.partidosPoliticos.get(partidoPolitio);

        if(politicos != null) {
            for (Politico politico : politicos) {
                total = total.add(politico.getCargo().getSalario());
            }

//        BigDecimal total = politicos.stream()
//                            .map(p -> p.getCargo().getSalario())
//                            .reduce(BigDecimal.ZERO, BigDecimal::add);
        }
        return total;
    }

    public BigDecimal calcularGastosComSalarioParaCargo(Cargo cargo, String partido){

        BigDecimal total = BigDecimal.ZERO;
        List<Politico> politicos = this.partidosPoliticos.get(partido);

        if(politicos != null){
            for(Politico politico : politicos){
                if(politico.getCargo().equals(cargo)){
                    total = total.add(politico.getCargo().getSalario());
                }
            }
        }
        return total;
    }
}
