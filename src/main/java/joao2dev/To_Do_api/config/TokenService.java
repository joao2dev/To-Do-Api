package joao2dev.To_Do_api.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import joao2dev.To_Do_api.entinty.Users;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.Instant;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
@Component
public class TokenService {
    @Value("${jwt.secret}")
    private String secret;
//    TODO: 1 passo criar uma função para gerar o token
    public String generateToken(Users user){
        try {
//      TODO: escolher um algoritimo para gerar o token e inserir a secret
            Algorithm algorithm = Algorithm.HMAC256(secret);
//      TODO: criar o token
            String token = JWT.create()
                    .withIssuer("TodoApi")
                    .withSubject(user.getUsername())
                    .withExpiresAt(generateInstant())
                    .sign(algorithm);
            return token;
        }catch (JWTCreationException exception){
            throw new RuntimeException("erro while generate token",exception);
        }
    }
//    TODO: validar token
    public String validateToken(String token){
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
                    .withIssuer("todoapi")
                    .build()
                    .verify(token)
                    .getSubject();
        }catch (JWTCreationException jwtCreationException){
            return " " ;
        }
    }

//    TODO: criar um instante para a expiração do token
    private Instant generateInstant(){
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}
