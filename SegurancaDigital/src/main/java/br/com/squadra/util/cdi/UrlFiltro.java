package br.com.squadra.util.cdi;
 
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Renato Borges Cardoso
 * @version 1.00 23/06/2016
 */
@WebFilter("*.xhtml")
public class UrlFiltro implements Filter{
    
    private FilterConfig filterConfig;
    
    @Override
    public void init(FilterConfig config) throws ServletException{
        this.filterConfig = config;
    }
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)throws ServletException, IOException{
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpSession session = req.getSession(true);
        
        String requestUrl = req.getRequestURL().toString();
        
        if(session.getAttribute("usuario")== null && !requestUrl.contains("index.xhtml")){
            resp.sendRedirect(req.getContextPath() + "/faces/index.xhtml" );            
        }else{
            chain.doFilter(request, response);
        }
        
    }
    
    @Override
    public void destroy() {
        this.filterConfig =null;
    }
    
}
