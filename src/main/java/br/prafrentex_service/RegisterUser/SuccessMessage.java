package br.prafrentex_service.RegisterUser;

/**
 *
 * @author Guilherme
 */
public class SuccessMessage {

    private String mensagem;

    public SuccessMessage() {
    }

    public SuccessMessage(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
