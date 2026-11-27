package benakka.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component
@Aspect
@EnableAspectJAutoProxy
public class AuthorizationAspect {
    @Around(value="@annotation(securedByAsppect)", argNames = "pjp,securedByAsppect")
    public Object secure(ProceedingJoinPoint pjp, SecuredByAsppect securedByAsppect) throws Throwable { // si on declare l'annotation dans les parametre on remplece dans arount par le parametre
        String[] roles = securedByAsppect.roles();
        boolean authorized=false;
        for (String r:roles){
            if(SecurityContext.hasRole(r)){
                authorized=true;
                break;
            }
        }
        if (authorized==true){
            return pjp.proceed();
        }
        throw new RuntimeException("Unauthorized > 403");
    }
}