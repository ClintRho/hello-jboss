package org.rhoden.hellojboss.freemarker;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Locale;

import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import freemarker.template.Configuration;
import freemarker.template.Version;
import freemarker.template.TemplateExceptionHandler;

@SuppressWarnings("serial")
@WebServlet("/freemarker/HelloFreemarker")
public class HelloServlet extends HttpServlet {

    private static final Logger LOG = Logger.getLogger(HelloServlet.class);

    Configuration cfg = null;

    @Inject
    HelloService helloService;

    @Override
    public void init() {
        LOG.info("HelloServlet Freemarker has started.");
        cfg = new Configuration();
        cfg.setClassForTemplateLoading(HelloServlet.class, "templates");
        cfg.setIncompatibleImprovements(new Version(2, 3, 20));
        cfg.setDefaultEncoding("UTF-8");
        cfg.setLocale(Locale.US);
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
    } 

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOG.info("HelloServlet Freemarker, in doGet().");

        resp.setContentType("text/html");

        PrintWriter writer = resp.getWriter();

        writer.println(helloService.createResponse(cfg));
        writer.close();
    }
}
