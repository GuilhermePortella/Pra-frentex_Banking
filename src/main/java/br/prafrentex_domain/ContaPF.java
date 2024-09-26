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
    public String conta;
    public String agencia;



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

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getDocumentoRG() {
        return documentoRG;
    }

    public void setDocumentoRG(String documentoRG) {
        this.documentoRG = documentoRG;
    }

    public String getDocumentoCNH() {
        return documentoCNH;
    }

    public void setDocumentoCNH(String documentoCNH) {
        this.documentoCNH = documentoCNH;
    }

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

}
