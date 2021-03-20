package br.edu.ifpb.dac.atividade.saras2luzs2.controller;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

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
        List<Banda> v = bandaServico.lista();
        System.err.println("ver " + v.get(0));
        return v;
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

}
