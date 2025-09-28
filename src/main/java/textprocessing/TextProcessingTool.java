package textprocessing;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextProcessingTool extends Application {

    @Override
    public void start(Stage stage) {
        // Labels and input fields
        Label textLabel = new Label("Enter text:");
        TextArea textArea = new TextArea();

        Label regexLabel = new Label("Enter regex pattern:");
        TextField regexField = new TextField();

        Label replaceLabel = new Label("Replacement text (optional):");
        TextField replaceField = new TextField();

        // Buttons
        Button findMatchesButton = new Button("Find Matches");
        Button replaceButton = new Button("Replace Matches");
        Button saveMatchButton = new Button("Save Matches in Set");

        // Result display
        TextArea resultArea = new TextArea();
        resultArea.setEditable(false);

        // Collections for storing matches
        ArrayList<String> matchList = new ArrayList<>();
        HashSet<String> matchSet = new HashSet<>();

        // Regex find matches
        findMatchesButton.setOnAction(e -> {
            matchList.clear();
            String inputText = textArea.getText();
            String patternText = regexField.getText();

            try {
                Pattern pattern = Pattern.compile(patternText);
                Matcher matcher = pattern.matcher(inputText);

                while (matcher.find()) {
                    matchList.add(matcher.group());
                }

                resultArea.setText("Matches found:\n" + matchList);
            } catch (Exception ex) {
                resultArea.setText("Invalid regex pattern.");
            }
        });

        // Regex replace
        replaceButton.setOnAction(e -> {
            String inputText = textArea.getText();
            String patternText = regexField.getText();
            String replacement = replaceField.getText();

            try {
                Pattern pattern = Pattern.compile(patternText);
                Matcher matcher = pattern.matcher(inputText);
                String replacedText = matcher.replaceAll(replacement);

                resultArea.setText("Replaced text:\n" + replacedText);
            } catch (Exception ex) {
                resultArea.setText("Invalid regex pattern.");
            }
        });

        // Save matches in a Set
        saveMatchButton.setOnAction(e -> {
            matchSet.clear();
            matchSet.addAll(matchList);
            resultArea.setText("Unique matches saved in Set:\n" + matchSet);
        });

        // Layout
        VBox layout = new VBox(10,
                textLabel, textArea,
                regexLabel, regexField,
                replaceLabel, replaceField,
                findMatchesButton, replaceButton, saveMatchButton,
                resultArea
        );
        layout.setPrefSize(500, 600);

        Scene scene = new Scene(layout);
        stage.setTitle("Text Processing Tool");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(TextProcessingTool.class, args);
    }
}
