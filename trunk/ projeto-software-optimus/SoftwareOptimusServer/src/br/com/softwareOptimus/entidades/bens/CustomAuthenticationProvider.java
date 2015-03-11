package br.com.softwareOptimus.entidades.bens;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.softwareOptimus.entidades.Usuario;
import br.com.softwareOptimus.entidades.dao.usuario.UsuarioDAOHibernate;

@Named
public class CustomAuthenticationProvider implements AuthenticationProvider {
	
	@Inject
	private UsuarioDAOHibernate userRepository;

	public CustomAuthenticationProvider() {
		super();
	}

	@SuppressWarnings("unused")
	@Override
	public Authentication authenticate(Authentication authentication)
			throws AuthenticationException {
		String username = authentication.getName();
		String password = authentication.getCredentials().toString();
		//acessar base para identificar se user e senha é valido 
		Usuario user = null; //= this.userRepository.findByUsernameAndPassword(username, password);
		if (user != null) {
			List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
			grantedAuthorities.add(new SimpleGrantedAuthority(user.getRole()));
			UserDetails userDetails = new User(username, password,
					grantedAuthorities);
			return new UsernamePasswordAuthenticationToken(userDetails,
					password, grantedAuthorities);
		} else {
			return null;
		}
	}

	@Override
	public boolean supports(final Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
}