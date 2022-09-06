package domb.app.security.filters;

import java.io.IOException;

import javax.security.sasl.AuthenticationException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import domb.app.security.JwtStore;
import domb.app.security.utils.TokenBasedAuthentication;
import domb.app.security.utils.TokenUtils;
import io.jsonwebtoken.ExpiredJwtException;

@Component
public class TokenAuthenticationFilter extends OncePerRequestFilter {

    private final TokenUtils tokenUtils;
    private final JwtStore jwtStore;

    private final UserDetailsService userDetailsService;

    protected final Log LOGGER = LogFactory.getLog(getClass());

    public TokenAuthenticationFilter(TokenUtils tokenHelper, JwtStore jwtStore, UserDetailsService userDetailsService) {
        this.tokenUtils = tokenHelper;
        this.jwtStore = jwtStore;
        this.userDetailsService = userDetailsService;
    }

    @Override
    public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws IOException, ServletException {


        String username;

        String authToken = tokenUtils.getToken(request);

        try {

            if (authToken != null) {
                jwtStore.setJwt(authToken);

                username = tokenUtils.getUsernameFromToken(authToken);
                jwtStore.setUsername(username);

                if (username != null) {
                    UserDetails userDetails = userDetailsService.loadUserByUsername(username);
                    if (tokenUtils.validateToken(authToken, userDetails)) {
                        TokenBasedAuthentication authentication = new TokenBasedAuthentication(userDetails);
                        authentication.setToken(authToken);
                        SecurityContextHolder.getContext().setAuthentication(authentication);
                    }
                }
            }

        } catch (ExpiredJwtException ex) {
            LOGGER.debug("Token expired!");
        }

        chain.doFilter(request, response);
    }

}
