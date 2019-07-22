package main

import (
	"fmt"
	"log"
	"net/http"
)

func main() {
	http.Handle("/common/css/", http.StripPrefix("/common/css/", http.FileServer(http.Dir("/css"))))
	http.HandleFunc("/common/header-1.0", Header)
	http.HandleFunc("/common/titlepacs-1.0", TitlePacs)
	http.HandleFunc("/common/navbar-1.0", Navbar)
	http.HandleFunc("/common/footer-1.0", Footer)
	fmt.Println("Starting up on 8180")
	log.Fatal(http.ListenAndServe(":8180", nil))
}

func Header(w http.ResponseWriter, req *http.Request) {
	fmt.Fprintln(w, `
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
	  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
	 	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
        `)
}

func TitlePacs(w http.ResponseWriter, req *http.Request) {
	fmt.Fprintln(w, `
			<div class="jumbotron text-center">
				<h2>Park and Charge System  - User Management</h2>
				<h3>Included with ESI</h3>
			</div>`)
}

func Navbar(w http.ResponseWriter, req *http.Request) {
	fmt.Fprintln(w, `
			<nav class="navbar navbar-default">
			  <div class="container-fluid">
				<div class="navbar-header">
				  <a class="navbar-brand" href="#">PACS - ESI</a>
				</div>
				<ul class="nav navbar-nav">
				  <li class="active"><a href="#">UserManagement</a></li>
				  <li><a href="http://localhost:8081/" class="opener">ChargingPoint</a></li>
				  <li><a href="http://localhost:8082/" class="opener">Environment</a></li>
				</ul>
			  </div>
			</nav>`)
}

func Footer(w http.ResponseWriter, req *http.Request) {
	fmt.Fprintln(w, `
				<p>© 2019 Copyright: Gökhan Kahriman - ESI</p>`)
}
