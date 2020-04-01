package application;
	
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;


public class Main extends Application {
	
	public static void main(String[] args) {
		launch(args);
	}
	
	
	public void start(Stage primaryStage) {
		Stage window = primaryStage;
		window.setTitle("PhoneBook");
		Scene scene2;
		TableView<Contact> table = new TableView<>();
		table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		TableColumn<Contact, String> column1 = new TableColumn<>("Name");
		column1.setCellValueFactory(new PropertyValueFactory<>("name"));
		column1.setMinWidth(200);
		
		TableColumn<Contact, String> column2 = new TableColumn<>("Phone Number");
		column2.setMinWidth(300);
		column2.setCellValueFactory(new PropertyValueFactory<>("number"));
		
		TableColumn<Contact, String> column3 = new TableColumn<>("Group");
		column3.setCellValueFactory(new PropertyValueFactory<>("group"));
		column3.setMinWidth(100);
		
		
		
		table.getColumns().addAll(column1, column2, column3);
		
		
		TextField nameInput = new TextField();
		nameInput.setPromptText("Name");
		
		TextField numberInput = new TextField();
		numberInput.setPromptText("Phone Number");
		
		TextField groupInput = new TextField();
		groupInput.setPromptText("Group");
		
		Button button2 = new Button("Add");
		button2.setOnAction(e -> addContact(nameInput, numberInput, groupInput, table));
		
		Button deleteButton = new Button("Delete");
		deleteButton.setOnAction(e -> deleteContact(table));
		
		HBox layout3 = new HBox();
		layout3.setPadding(new Insets(10, 10, 10, 10));
		layout3.setSpacing(10);
		layout3.setAlignment(Pos.CENTER);
		layout3.getChildren().addAll(nameInput, numberInput, groupInput, button2, deleteButton);
		
		VBox layout2 = new VBox();
		layout2.setPadding(new Insets(10, 10, 10, 10));
		layout2.setSpacing(20);
		layout2.getChildren().addAll(table, layout3);
		
		
		scene2 = new Scene(layout2);
		
		
		
		
		
		
		
		
		Label label = new Label("Click to enter Phonebook");
		Button button = new Button("Enter");
		button.setOnAction( e -> window.setScene(scene2));
		VBox layout1 = new VBox();
		layout1.setPadding(new Insets(10, 10, 10, 10));
		layout1.setSpacing(30);
		layout1.setAlignment(Pos.CENTER);
		layout1.getChildren().addAll(label, button);
		Scene scene1 = new Scene(layout1, 500, 300);
		
		
		window.setScene(scene1);
		window.show();
		
		
	}
	
	public static void addContact(TextField name, TextField number, TextField group, TableView<Contact> table) {
		String a = name.getText();
		String b = number.getText();
		String c = group.getText();
		
		ObservableList<Contact> list = FXCollections.observableArrayList();
		list.addAll(table.getItems());
		list.add(new Contact(a, b, c));
		
		table.setItems(list);
		name.clear();
		number.clear();
		group.clear();
	}
	
	public static void deleteContact(TableView<Contact> table) {
		ObservableList<Contact> list = FXCollections.observableArrayList(table.getSelectionModel().getSelectedItems());
		table.getItems().removeAll(list);
		
	}
	
	
}
