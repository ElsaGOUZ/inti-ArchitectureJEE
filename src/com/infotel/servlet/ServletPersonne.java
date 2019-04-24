package com.infotel.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.infotel.metier.Personne;
import com.infotel.service.Iservice;
import com.infotel.service.ServiceImpl;

/**
 * Servlet implementation class ServletPersonne
 */
@WebServlet("/ServletPersonne")
public class ServletPersonne extends HttpServlet {
	private Iservice service= new ServiceImpl();
	private static final long serialVersionUID = 1L;
	
	//on declare un attribut Iservice qui nous permet d'appeler la couche service,comme la ligne ci dessus afin de l'utiliser.
    /**
     * Default constructor. 
     */
    public ServletPersonne() {
        // TODO Auto-generated constructor stub
    	super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//1-recuperation des données
		int id= Integer.parseInt(request.getParameter("id"));
		String nom= request.getParameter("nom");
		String prenom= request.getParameter("prenom");
		int age= Integer.parseInt(request.getParameter("age"));
		
		//2-ENVOYER LES INFOS A LA COUCHE SERVICE
		//On cree une instance personne et on recupere les donnees avec les setters
		Personne p= new Personne();
		p.setId(id);
		p.setAge(age);
		p.setNom(nom);
		p.setPrenom(prenom);
		
		//on appelle la methode de la couche service avec un parametre afin de l'inserer dans la couche dao
		String message =service.creerPersonne(p);
	
       //3- preparation à l'envoi
	    request.setAttribute("message", message);
	
	    //4- appel de la jsp
	    request.getRequestDispatcher("resultatPersonne.jsp").forward(request,response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
