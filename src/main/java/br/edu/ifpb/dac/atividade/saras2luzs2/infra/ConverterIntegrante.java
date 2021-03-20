package br.edu.ifpb.dac.atividade.saras2luzs2.infra;

import br.edu.ifpb.dac.atividade.saras2luzs2.entidades.Integrante;
import br.edu.ifpb.dac.atividade.saras2luzs2.servico.BandaServico;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "converter.Integrante")
public class ConverterIntegrante implements Converter {


    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        return null;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        return null;
    }



}
