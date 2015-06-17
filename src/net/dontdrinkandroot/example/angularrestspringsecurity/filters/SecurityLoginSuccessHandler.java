package net.dontdrinkandroot.example.angularrestspringsecurity.filters;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Service;

@Service
public class SecurityLoginSuccessHandler extends
		SimpleUrlAuthenticationSuccessHandler {

	public SecurityLoginSuccessHandler() {
		super();
	}

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication auth)
			throws IOException, ServletException {
		// setDefaultTargetUrl(Constants.HOME);
		super.onAuthenticationSuccess(request, response, auth);
	}
}