package com.labs.lab1
import java.io.PrintWriter
import java.nio.file.Files
import java.nio.file.Paths
import java.nio.file.StandardOpenOption
import java.time.Instant
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet(name = "Servlet", value = ["/servlet"])
class Servlet : HttpServlet() {
    private val databasePath = Paths.get("database.txt")

    override fun doGet(req: HttpServletRequest, res: HttpServletResponse) {
        val key = req.getParameter("key")
        val value = req.getParameter("value")?.toIntOrNull() ?: 0
        val test = req.getParameter("test")?.toBoolean() ?: false

        servletContext.log("HTTP method: ${req.method}")
        servletContext.log("Client IP address: ${req.remoteAddr}")
        servletContext.log("User agent: ${req.getHeader("User-Agent")}")
        servletContext.log("Request parameters: key=$key, value=$value, test=$test")

        if (test) {
            res.writer.println("Confirmation message")
        } else {
            val line = "$key ".repeat(value) + Instant.now()
            Files.write(databasePath, listOf(line), StandardOpenOption.CREATE, StandardOpenOption.APPEND)

            res.contentType = "text/html;charset=UTF-8"
            val out: PrintWriter = res.writer
            out.println("<html><body>")
            Files.readAllLines(databasePath).forEach { out.println("<p>$it</p>") }
            out.println("</body></html>")
        }
    }
}
