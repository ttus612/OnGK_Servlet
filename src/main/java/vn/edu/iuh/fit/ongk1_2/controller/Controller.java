package vn.edu.iuh.fit.ongk1_2.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.fit.ongk1_2.enums.Roles;
import vn.edu.iuh.fit.ongk1_2.models.Candidate;
import vn.edu.iuh.fit.ongk1_2.services.CandidateService;

import java.io.IOException;
import java.util.List;

@WebServlet("/controller")
public class Controller extends HttpServlet {
    private CandidateService candidateService = new CandidateService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        switch (action){
            case "listCandidate":
                viewCandidateList(req, resp);
                break;
            case "candidateDetails":
                viewCandidateDetail(req, resp);
                break;
            case "report1":
                viewGetReport1(req, resp);
                break;
            case "report2":
                viewReport2(req, resp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        switch (action){
            case "report1":
                viewPostReport1(req, resp);
                break;
        }
    }

    private void viewPostReport1(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String role = req.getParameter("selectedValue");
        System.out.println(role);
        List<Candidate> candidatesRole = candidateService.findByRole(Roles.valueOf(role));;
        req.setAttribute("candidatesRole", candidatesRole);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/report1.jsp");
        requestDispatcher.forward(req, resp);
    }

    private void viewReport2(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Candidate> candidatesHaveEmail = candidateService.findCandidateHaveEmail();
        req.setAttribute("candidatesHaveEmail", candidatesHaveEmail);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/report2.jsp");
        requestDispatcher.forward(req, resp);
    }

    private void viewGetReport1(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Candidate> candidatesRole = candidateService.findAll();
        req.setAttribute("candidatesRole", candidatesRole);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/report1.jsp");
        requestDispatcher.forward(req, resp);
    }

    private void viewCandidateDetail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Candidate candidate = candidateService.findID(id);
        req.setAttribute("candidate", candidate);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/candidate_detail.jsp");
        requestDispatcher.forward(req, resp);
    }

    private void viewCandidateList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Candidate> candidates = candidateService.findAll();
        req.setAttribute("candidates", candidates);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/candidate.jsp");
        requestDispatcher.forward(req, resp);

    }
}
