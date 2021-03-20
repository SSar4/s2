/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.dac.atividade.saras2luzs2.controller;

import br.edu.ifpb.dac.atividade.saras2luzs2.entidades.CPF;
import br.edu.ifpb.dac.atividade.saras2luzs2.entidades.Integrante;
import br.edu.ifpb.dac.atividade.saras2luzs2.servico.IntegranteServico;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;


@Named
@SessionScoped
public class ControlerIntegrante implements Serializable {

    private Integrante integrante;
    private IntegranteServico is;
    private String datanasc;
    private String CPF;
    

    public ControlerIntegrante() {
        integrante = new Integrante();
        is = new IntegranteServico();
    }
     public String redirect() {
      
        return "integrante/edit";
    }

    public String salvar() {
        integrante.setCpf(new CPF(CPF));
        integrante.setDataDeNascimento(LocalDate.parse(datanasc));
        is.add(integrante);
        return "list";
    }

    public Integrante getIntegrante() {
        return integrante;
    }

    public void setIntegrante(Integrante integrante) {
        this.integrante = integrante;
    }

    public String getDatanasc() {
        return datanasc;
    }

    public void setDatanasc(String datanasc) {
        this.datanasc = datanasc;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }
             
    public List<Integrante> getIntegrantes() {
        List<Integrante> r = is.todas();
        System.err.println("lis in "+r.get(0));
        return r;
    }

    public String remove(int id) {
        is.removeIntegrante(id);
        return null;
    }

    public String edite(Integrante integrante) {
        this.integrante = integrante;
        return "edit";
    }
}
