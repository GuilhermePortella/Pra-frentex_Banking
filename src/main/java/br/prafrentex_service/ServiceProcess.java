package br.prafrentex_service;

/**
 *
 * @author Guilherme
 */
public class ServiceProcess {
    
    public ServiceProcess() {
        
    }
    
    public void ServiceProcessPrint(){
        //AbrirContaPF usuario = new AbrirContaPF();
        AbrirContaPJ usuarioPJ = new AbrirContaPJ();
        usuarioPJ.solicitarCNPJValido();

    }
    
}
