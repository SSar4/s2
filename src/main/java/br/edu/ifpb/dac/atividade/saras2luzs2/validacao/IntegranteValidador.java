package br.edu.ifpb.dac.atividade.saras2luzs2.validacao;

import br.edu.ifpb.dac.atividade.saras2luzs2.entidades.Integrante;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator(value = "validador.Integrante")
public class IntegranteValidador implements Validator {


    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object value) throws ValidatorException {
        Integrante integrante = (Integrante) value;

        if(integrante == null){
            FacesMessage facesMessage = new FacesMessage("valor inválido para o integrante ");
            throw new ValidatorException(facesMessage);
        }


    }
}
