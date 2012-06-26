package sample;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class WebViewSample1 extends Application {
	@Override
	public void start(Stage stage) {
		// コンテナ
		Group container = new Group();

		// シーングラフのルート要素を生成し、コンテナを貼る
		Scene scene = new Scene(container, 100, 20);
		stage.setScene(scene);

		// ラベルを生成しコンテナに貼る
		Label label = new Label("Hello, World!");
		container.getChildren().add(label);

		// 表示
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
