package br.domain.model.usuarios;

import java.time.LocalDate;
import java.time.Period;
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
public class Usuario extends ContaPF {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public LocalDate dataNascimento;

    @NotBlank(message = "Nome é obrigatório")
    public String nome;
    public String sobrenome;
    public String apelido;

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
    
    public Usuario(String nome, String email, String senhaHash, String cpf1) {
        this.nome = nome;
        this.email = email;
        this.senhaHash = senhaHash;
    }

    public Usuario(String nome, String sobrenome, LocalDate dataNascimento, String cpf, String email, String senhaHash) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.email = email;
        this.senhaHash = senhaHash;
    }

    private int calcularIdade() {
        return Period.between(dataNascimento, LocalDate.now()).getYears();
    }

    private String gerarUsername() {
        return (nome.toLowerCase() + sobrenome.toLowerCase()).replaceAll("\\s+", "");
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

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
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