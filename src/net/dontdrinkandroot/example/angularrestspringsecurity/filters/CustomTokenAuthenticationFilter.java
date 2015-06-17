package net.dontdrinkandroot.example.angularrestspringsecurity.filters;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

public class CustomTokenAuthenticationFilter extends AbstractAuthenticationProcessingFilter {
	
	private static final Logger logger = LoggerFactory
			.getLogger(CustomTokenAuthenticationFilter.class);
	
	public static final String HEADER_TOKEN = "x-token";

	private List<String> whitelist;

	protected CustomTokenAuthenticationFilter(String defaultFilterProcessesUrl) {
		super(defaultFilterProcessesUrl);
		super.setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher(
				defaultFilterProcessesUrl));

		this.whitelist = new ArrayList<>();
	}

	public void setWhitelist(List<String> whitelist) {
		this.whitelist = whitelist;
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request,
			HttpServletResponse response) throws AuthenticationException,
			IOException, ServletException {
		
		if (whitelist.contains(request.getServletPath())) {
			logger.info("whitelisted path {}, authenticating as anonymous",
					request.getServletPath());
			return new CustomToken("anon");
		}

		Optional<String> token = Optional.ofNullable(request
				.getHeader(HEADER_TOKEN));

		if (!token.isPresent()) {
			throw new AuthenticationServiceException("missing token");
		}

		return getAuthenticationManager().authenticate(
				new CustomToken(token.get()));
	}
}
