package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebEvent;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class WebViewSample2 extends Application {
	@Override
	public void start(Stage stage) {
		Group root = new Group();

		Scene scene = new Scene(root);
		stage.setScene(scene);

		// 円
		Circle circle = new Circle(200.0, 200.0, 300.0, Color.PINK);
		root.getChildren().add(circle);

		// ボーダーレイアウト
		BorderPane borderPane = new BorderPane();
		root.getChildren().add(borderPane);

		// ブラウザ

		WebView view = new WebView();
		final WebEngine engine = view.getEngine();
		engine.setJavaScriptEnabled(true);
		engine.setOnStatusChanged(new EventHandler<WebEvent<String>>() {
			@Override
			public void handle(WebEvent<String> event) {
				System.out.println(" event " + event);
			}
		});

		borderPane.setCenter(view);

		// 水平ボックス
		HBox hbox = new HBox(10);
		borderPane.setTop(hbox);

		// ラベル
		Label label = new Label("URL:");
		hbox.getChildren().add(label);

		// テキスト入力
		final TextField textBox = new TextField();
		textBox.setMinWidth(300);
		hbox.getChildren().add(textBox);

		// ボタン
		Button button = new Button("Open");
		hbox.getChildren().add(button);
		button.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				engine.load(textBox.getText());
			}
		});

		// 表示
		stage.show();

		engine.load("http://www.google.co.jp/");
	}

	public static void main(String[] args) {
		launch(args);
	}
}
