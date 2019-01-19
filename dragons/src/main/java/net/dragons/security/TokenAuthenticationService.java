package net.dragons.security;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import io.jsonwebtoken.*;
import java.util.Date;    
public class TokenAuthenticationService {
	private static String SECRET_KEY ="Pgkw660bPasdgk#5Bpaj$sdfp^bms@!jwgGpwm$b6709zPw4jabLq5D;3agP";
	public static String createJWTSecurity(String id, String email, String role, long ttlMillis) {
		  
	    //The JWT signature algorithm we will be using to sign the token
	    SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

	    long nowMillis = System.currentTimeMillis();
	    Date now = new Date(nowMillis);

	    //We will sign our JWT with our ApiKey secret
	    byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(SECRET_KEY);
	    Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

	    //Let's set the JWT Claims
//	    JwtBuilder builder = Jwts.builder().setId(id)
//	            .setIssuedAt(now)
//	            .setSubject(role)
//	            .setIssuer(email)
//	            .signWith(signatureAlgorithm, signingKey);
	    
	    JwtBuilder builder = Jwts.builder().claim("id", id).claim("email", email).claim("role", role).claim("time", ttlMillis).signWith(signatureAlgorithm, signingKey);
	  
	    //if it has been specified, let's add the expiration
	    if (ttlMillis > 0) {
	        long expMillis = nowMillis + ttlMillis;
	        Date exp = new Date(expMillis);
	        builder.setExpiration(exp);
	    }  
	  
	    //Builds the JWT and serializes it to a compact, URL-safe string
	    return builder.compact();
	}
	public static String getEmailFromToken(String token) {
		Claims claims = Jwts.parser()
	            .setSigningKey(DatatypeConverter.parseBase64Binary(SECRET_KEY))
	            .parseClaimsJws(token).getBody();
	    return String.valueOf(claims);
		
	}

}
