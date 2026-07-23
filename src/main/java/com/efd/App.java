package com.efd;

import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;

public class App {
    public static String getGreeting() {
        return "Welcome to EFD Java with Gradle project!";
    }

    public static String getPage() {
        return "<!DOCTYPE html>"
                + "<html lang=\"en\">"
                + "<head><meta charset=\"utf-8\" /><meta name=\"viewport\" content=\"width=device-width, initial-scale=1\" /><title>EFD Java Gradle Welcome</title>"
                + "<style>:root{--bg:#180f2f;--panel:#ffffff;--accent:#8b5cf6;--text:#0f172a;--muted:#64748b;}*{box-sizing:border-box;}body{margin:0;font-family:'Segoe UI',Arial,sans-serif;background:linear-gradient(135deg,var(--bg),#2d1a4d);color:var(--text);min-height:100vh;display:grid;place-items:center;padding:24px;}"
                + ".card{background:var(--panel);border-radius:20px;padding:2.5rem 3rem;box-shadow:0 20px 50px rgba(0,0,0,0.25);text-align:center;max-width:560px;width:100%;}"
                + ".badge{display:inline-block;padding:0.4rem 0.8rem;border-radius:999px;background:rgba(139,92,246,0.12);color:var(--accent);font-weight:700;text-transform:uppercase;letter-spacing:0.08em;font-size:0.8rem;margin-bottom:1rem;}"
                + "h1{margin:0 0 0.75rem;font-size:2rem;color:var(--accent);}p{margin:0;color:var(--muted);line-height:1.6;}</style></head>"
                + "<body><div class=\"card\"><div class=\"badge\">EFD • Java Gradle</div><h1>" + getGreeting() + "</h1><p>This polished welcome page is served from the Java Gradle project and is ready to be viewed in a browser.</p></div></body></html>";
    }

    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        server.createContext("/", exchange -> {
            byte[] response = getPage().getBytes(StandardCharsets.UTF_8);
            exchange.getResponseHeaders().add("Content-Type", "text/html; charset=UTF-8");
            exchange.sendResponseHeaders(200, response.length);
            try (OutputStream os = exchange.getResponseBody()) {
                os.write(response);
            }
        });
        server.setExecutor(null);
        server.start();
        System.out.println("Server started at http://localhost:8080/");
    }
}
