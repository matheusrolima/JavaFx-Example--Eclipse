/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Pagination;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author matheus
 */
public class TelaHomeController implements Initializable {

	@FXML
	private AnchorPane pagina;

	@FXML
	private VBox conteudoPagina;

	@FXML
	private Button btBuscar;

	@FXML
	private void btEntrar(ActionEvent event) {

		try {

			VBox login = (VBox) FXMLLoader.load(getClass().getResource("/view/login.fxml"));

			conteudoPagina.getChildren().setAll(login);

		} catch (Exception ex) {
			Logger.getLogger(TelaHomeController.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	@FXML
	private void btHome(ActionEvent event) {

		try {

			VBox conteudoHome = (VBox) FXMLLoader.load(getClass().getResource("/view/conteudoHome.fxml"));

			conteudoHome.getChildren().setAll(montarSlide());

			conteudoPagina.getChildren().setAll(conteudoHome);

		} catch (Exception ex) {
			Logger.getLogger(TelaHomeController.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	@FXML
	private void btPedido(ActionEvent event) {
		try {

			VBox pedido = (VBox) FXMLLoader.load(getClass().getResource("/view/pedido.fxml"));
			conteudoPagina.getChildren().setAll(pedido);

		} catch (Exception ex) {
			Logger.getLogger(TelaHomeController.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	ArrayList<String> images = new ArrayList<>();

	@Override
	public void initialize(URL url, ResourceBundle rb) {

		images.add("/imagens/Imagem1.jpeg");
		images.add("/imagens/Imagem2.jpeg");
		images.add("/imagens/Imagem3.jpeg");

		try {

			VBox conteudoHome = (VBox) FXMLLoader.load(getClass().getResource("/view/conteudoHome.fxml"));

			conteudoHome.getChildren().setAll(montarSlide());

			conteudoPagina.getChildren().add(conteudoHome);

		} catch (Exception ex) {
			Logger.getLogger(TelaHomeController.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

	public Pagination montarSlide() {
		Pagination p = new Pagination(images.size());
		p.setPageFactory(n -> new ImageView(images.get(n)));

		Timeline fiveSecondsWonder = new Timeline(new KeyFrame(Duration.seconds(5), event -> {
			int pos = (p.getCurrentPageIndex() + 1) % p.getPageCount();
			p.setCurrentPageIndex(pos);
		}));
		fiveSecondsWonder.setCycleCount(Timeline.INDEFINITE);
		fiveSecondsWonder.play();

		return p;
	}

}
