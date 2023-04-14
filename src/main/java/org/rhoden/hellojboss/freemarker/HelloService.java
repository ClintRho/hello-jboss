package org.rhoden.hellojboss.freemarker;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jboss.logging.Logger;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class HelloService {

    private static final Logger LOG = Logger.getLogger(HelloService.class);

    String createResponse(Configuration cfg) {
        LOG.info("HelloService, in createResponse().");

        String sOut = "";

        Map<String, Object> input = new HashMap<String, Object>();

        input.put("title", "Hello Freemarker");

        input.put("person", new Person("Clint"));

        List<Todo> todos = new ArrayList<Todo>();
        todos.add(new Todo(1,"Todo Item number 1"));
        todos.add(new Todo(1,"Todo Item number 2"));
        todos.add(new Todo(2,"Todo Item number 3"));
        todos.add(new Todo(2,"Todo Item number 4"));
        input.put("todos", todos);

        try {
            Template template = cfg.getTemplate("hello.ftl");

            StringWriter freemarkerString = new StringWriter();
            template.process(input, freemarkerString);
            sOut = freemarkerString.toString();
            //LOG.info(sOut);
        }
        catch (Exception e) {
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            LOG.info(errors.toString());
        }

        return sOut;
    }
}
