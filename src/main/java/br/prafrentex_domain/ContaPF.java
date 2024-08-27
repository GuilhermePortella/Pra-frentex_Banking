package br.prafrentex_domain;

/**
 *
 * @author Guilherme
 */
public class ContaPF {
    
    public String nome;
    public String sobrenome;
    
    public String apelido;
    
    public int idade;
    
    public String tipoDocumento;
    
    public String cpf;
    public static final String tipoDocRG = "RG";
    public String documentoRG;
    public static final String tipoDocHabilitacao = "CNH";
    public String documentoCNH;
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

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
