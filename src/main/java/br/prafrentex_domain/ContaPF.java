package br.prafrentex_domain;

/**
 *
 * @author Guilherme
 */
public class ContaPF {

    public String tipoDocumento;

    public String cpf;
    public static final String tipoDocRG = "RG";
    public String documentoRG;
    public static final String tipoDocHabilitacao = "CNH";
    public String documentoCNH;



    public String gettipoDocumento() {
        return tipoDocumento;
    }

    public void settipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

}
