package com.cryptoblack.smsc;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.AbstractHandler;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class VoIPSMSCService extends AbstractHandler {
    private Map<String, String> smscStore = new HashMap<>();

    public VoIPSMSCService() {
        smscStore.put("Sprint", "+17044100000");
    }

    @Override
    public void handle(String target, HttpServletRequest request, HttpServletResponse response, int dispatch) throws IOException {
        response.setContentType("application/json;charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);

        String carrier = request.getParameter("carrier");
        String smscNumber = smscStore.getOrDefault(carrier, "Unknown carrier");

        response.getWriter().println("{\"smsc\": \"" + smscNumber + "\"}");
    }

    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);
        server.setHandler(new VoIPSMSCService());
        server.start();
        server.join();
    }
}
