package br.prafrentex_service;

/**
 *
 * @author Guilherme
 */
public class ServiceProcess {
    
    public ServiceProcess() {
        
    }
    
    public void ServiceProcessPrint(){
        AbrirContaPF usuarioPF = new AbrirContaPF();
        usuarioPF.exibirInformacoesPessoa();
        AbrirContaPJ usuarioPJ = new AbrirContaPJ();
        usuarioPJ.apresentarDadosEmLista();

    }
    
}
