package br.prafrentex_domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

/**
 *
 * @author Guilherme
 */
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome é obrigatório")
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

    @Email(message = "Email deve ser válido")
    @NotBlank(message = "Email é obrigatório")
    public String email;
    
    
    

    @NotBlank(message = "Senha é obrigatória")
    private String senhaHash;

    @ManyToOne
    private ContaPF contaPF;

    @ManyToOne
    private ContaPJ contaPJ;

    public Usuario(String nome, String email, String senhaHash) {
        this.nome = nome;
        this.email = email;
        this.senhaHash = senhaHash;
    }

    public Usuario(String nome, String sobrenome, int idade, String cpf, String email) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.idade = idade;
        this.cpf = cpf;
        this.email = email;
    }
    
    
    

    public Usuario() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenhaHash() {
        return senhaHash;
    }

    public void setSenhaHash(String senhaHash) {
        this.senhaHash = senhaHash;
    }

    public ContaPF getContaPF() {
        return contaPF;
    }

    public void setContaPF(ContaPF contaPF) {
        this.contaPF = contaPF;
    }

    public ContaPJ getContaPJ() {
        return contaPJ;
    }

    public void setContaPJ(ContaPJ contaPJ) {
        this.contaPJ = contaPJ;
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

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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


}
