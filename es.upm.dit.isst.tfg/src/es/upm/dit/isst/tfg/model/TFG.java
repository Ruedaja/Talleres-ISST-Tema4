package es.upm.dit.isst.tfg.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class TFG implements Serializable {
		private static final long serialVersionUID = 01L;
		@Id
		private String autor;
		private String titulo;
		private String resumen;
		private String tutor;
		private String secretario;
		private String fichero;
		private int estado;
		private String memoria;

		
public TFG (String autor, String titulo, String resumen, String tutor, String secretario, String fichero, int estado) {
		
		this.autor = autor;
		this.titulo = titulo;
		this.resumen = resumen;
		this.tutor = tutor;
		this.secretario = secretario;
		this.fichero = fichero;
		this.estado = estado;
		this.memoria = null;
		}


public String getAutor() {
	return autor;
}


public void setAutor(String autor) {
	this.autor = autor;
}


public String getTitulo() {
	return titulo;
}


public void setTitulo(String titulo) {
	this.titulo = titulo;
}


public String getResumen() {
	return resumen;
}


public void setResumen(String resumen) {
	this.resumen = resumen;
}


public String getTutor() {
	return tutor;
}


public void setTutor(String tutor) {
	this.tutor = tutor;
}


public String getSecretario() {
	return secretario;
}


public void setSecretario(String secretario) {
	this.secretario = secretario;
}


public String getFichero() {
	return fichero;
}


public void setFichero(String fichero) {
	this.fichero = fichero;
}


public int getEstado() {
	return estado;
}


public void setEstado(int estado) {
	this.estado = estado;
}


public String getMemoria() {
	return memoria;
}


public void setMemoria(String memoria) {
	this.memoria = memoria;
}


/*public void setAutor(String autor){
	this.autor=autor;
}
public String getAutor(){
	return autor;
}
public void setTitulo (String titulo){
	this.titulo=titulo;
}
public String getTitulo(){
	return titulo;
}
public void setResumen (String resumen){
	this.resumen = resumen;
}
public String getResumen(){
	return resumen;
}

public void SetTutor (String tutor){
	this.tutor=tutor;
}

public String getTutor(){
	return tutor;
}

public void setSecretario(String secretario){
	this.secretario=secretario;
}
public String getSecretario(){
	return secretario;
}
public void setFichero(String fichero){
	this.fichero=fichero;
}
public String getFichero(){
	return fichero;
}
public int getEstado(){
	return estado;
}


public String getMemoria() {
	return memoria;
}


public void setMemoria(String memoria) {
	this.memoria = memoria;
}*/
}

