package br.edu.ifpb.dac.atividade.saras2luzs2.controller;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.edu.ifpb.dac.atividade.saras2luzs2.entidades.Banda;
import br.edu.ifpb.dac.atividade.saras2luzs2.entidades.Integrante;
import br.edu.ifpb.dac.atividade.saras2luzs2.servico.BandaServico;

@Named
@SessionScoped
public class Controller implements Serializable {

   
    private static final long serialVersionUID = 1L;

    private Banda banda;
    private Integrante integrante;
    private BandaServico bandaServico;
    private String origem;
    private List<Banda> bandaSession = new ArrayList<>();

    public Controller() {
        this.setBanda(new Banda());
        this.setIntegrante(new Integrante());
        this.bandaServico = new BandaServico();
    }

    public String SalvarBanda() {
        bandaServico.Add(banda);
        this.banda = new Banda();
        return "list";
    }

    public String removeBanda(int id) {
        bandaServico.removeBanda(id);
        return "list";
    }
    public String redirect() {
      
        return "banda/edit";
    }

    public String editar(Banda banda) {
        this.banda = banda;
        return "edit";
    }

    public List<Banda> getBandas() {
        //return Collections.EMPTY_LIST;
       bandaSession = bandaServico.lista();
        if(bandaSession.isEmpty())
        return Collections.EMPTY_LIST;
        else return bandaSession;
    }
public String rediretOrigem(){
    bandaSession= Collections.EMPTY_LIST;
    return "banda/buscaOrigem";
}
    public List<Banda> buscarOrigem(){
        System.err.println("l origem"+origem);
        bandaSession= bandaServico.localizarLocalDeOrigem(origem);
        if(bandaSession.isEmpty()){
            System.err.println("if lista");
            return Collections.EMPTY_LIST;
        }
        System.err.println("ejdi"+bandaSession.get(0));
        return bandaSession;
    }

    public Integrante getIntegrante() {
        return integrante;
    }

    public void setIntegrante(Integrante integrante) {
        this.integrante = integrante;
    }

    public Banda getBanda() {
        return banda;
    }

    public void setBanda(Banda banda) {
        this.banda = banda;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public List<Banda> getBandaSession() {
        return bandaSession;
    }

    public void setBandaSession(List<Banda> bandaSession) {
        this.bandaSession = bandaSession;
    }

    public BandaServico getBandaServico() {
        return bandaServico;
    }

    public void setBandaServico(BandaServico bandaServico) {
        this.bandaServico = bandaServico;
    }
     

}
