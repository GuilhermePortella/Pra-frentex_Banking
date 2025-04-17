package br.prafrentex_service.audit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.time.LocalDateTime;
import java.util.UUID;

public class AuditLogger {
    private static final Logger logger = LoggerFactory.getLogger(AuditLogger.class);

    public void logOperacao(String usuario, String operacao, String detalhes) {
        String transactionId = UUID.randomUUID().toString();
        LocalDateTime timestamp = LocalDateTime.now();
        
        logger.info("AUDIT_LOG|TransactionId:{}|Timestamp:{}|User:{}|Operation:{}|Details:{}", 
            transactionId, timestamp, usuario, operacao, detalhes);
    }

    public void logAcesso(String usuario, String recurso, boolean sucesso) {
        String transactionId = UUID.randomUUID().toString();
        LocalDateTime timestamp = LocalDateTime.now();
        
        logger.info("ACCESS_LOG|TransactionId:{}|Timestamp:{}|User:{}|Resource:{}|Success:{}", 
            transactionId, usuario, recurso, sucesso);
    }

    public void logErro(String usuario, String operacao, Exception erro) {
        String transactionId = UUID.randomUUID().toString();
        LocalDateTime timestamp = LocalDateTime.now();
        
        logger.error("ERROR_LOG|TransactionId:{}|Timestamp:{}|User:{}|Operation:{}|Error:{}", 
            transactionId, timestamp, usuario, operacao, erro.getMessage(), erro);
    }
}
