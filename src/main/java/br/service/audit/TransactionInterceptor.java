package br.service.audit;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.time.LocalDateTime;
import java.time.Duration;

@Interceptor
@LoggedTransaction
public class TransactionInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(TransactionInterceptor.class);

    @AroundInvoke
    public Object logTransaction(InvocationContext context) throws Exception {
        LocalDateTime inicio = LocalDateTime.now();
        String metodo = context.getMethod().getName();
        String classe = context.getTarget().getClass().getSimpleName();

        try {
            logger.info("TRANSACTION_START|Method:{}|Class:{}|Time:{}", metodo, classe, inicio);
            Object resultado = context.proceed();
            LocalDateTime fim = LocalDateTime.now();
            Duration duracao = Duration.between(inicio, fim);
            
            logger.info("TRANSACTION_END|Method:{}|Class:{}|Duration:{}ms|Success:true", 
                metodo, classe, duracao.toMillis());
            
            return resultado;
        } catch (Exception e) {
            logger.error("TRANSACTION_ERROR|Method:{}|Class:{}|Error:{}", 
                metodo, classe, e.getMessage(), e);
            throw e;
        }
    }
}
