package GUI.Cwiczenia12.MVC;

/*

import javafx.scene.control.*;			// Button, Label
import javafx.scene.layout.*;			// Pane, GridPane
import javafx.scene.shape.*;			// Circle, Rectangle
import javafx.scene.paint.*;			// Color
import javafx.geometry.*;				// Pos

public class View {

    private final GridPane rootNode;
    private final TextField textField;
    private final Button sumButtton;
    private final Button clearButton;
    private final Label sumLabel;

    public GridPane getRootNode() {
        return rootNode;
    }

    public TextField getTextField() {
        return textField;
    }

    public Button getSumButtton() {
        return sumButtton;
    }

    public Button getClearButton() {
        return clearButton;
    }

    public Label getSumLabel() {
        return sumLabel;
    }

    public View() {

        // left component
        GridPane leftComponent = new GridPane();

        // controls
        textField = new TextField();
        textField.setAlignment(Pos.CENTER);

        sumButtton = new Button("Sum");
        clearButton = new Button("Clear");

        sumLabel = new Label("Label");

        sumLabel.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

        leftComponent.add(textField, 0, 0, 2, 1);
        leftComponent.add(sumButtton, 0, 1);
        leftComponent.add(clearButton, 1, 1);
        leftComponent.add(sumLabel, 0, 2);

        //leftComponent.setGridLinesVisible(true);

        // right component
        Pane rightComponent = new Pane();

        // shapes
        Circle circle1 = new Circle(100, 100, 50, Color.TRANSPARENT);
        circle1.setStroke(Color.RED);

        Rectangle rectangle = new Rectangle(0, 0, 100, 100);
        rectangle.setFill(Color.TRANSPARENT);
        rectangle.setStroke(Color.BLUE);

        Circle circle2 = new Circle(150, 150, 50, Color.TRANSPARENT);
        circle2.setStroke(Color.GREEN);

        rightComponent.getChildren().addAll(circle1, rectangle, circle2);

        // root node (panel)
        rootNode = new GridPane();
        rootNode.add(leftComponent, 0, 0);
        rootNode.add(rightComponent, 1, 0);
    }
}
 */
