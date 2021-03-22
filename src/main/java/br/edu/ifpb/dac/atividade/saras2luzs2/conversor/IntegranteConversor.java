package br.edu.ifpb.dac.atividade.saras2luzs2.conversor;

import br.edu.ifpb.dac.atividade.saras2luzs2.entidades.Integrante;
import br.edu.ifpb.dac.atividade.saras2luzs2.servico.IntegranteServico;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "converter.Integrante")
public class IntegranteConversor implements Converter {

    private IntegranteServico service = new IntegranteServico();

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
        if(value == null){
            return null;
        }

        Integrante integrante = this.service.buscarPorId(Integer.parseInt(value));
        return integrante;

    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
        if(value == null){
            return null;

        }

        Integrante integrante = (Integrante) value;
        return String.valueOf(integrante.getId());

    }
}
