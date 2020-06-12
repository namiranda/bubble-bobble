package View;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VistaMenu extends JFrame {
    private JPanel menuPanel;
    private JButton newGameButton;
    private JButton exitButton;


    public VistaMenu() {
        setTitle("Menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(menuPanel);

        setResizable(false);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // If the calculateButton is clicked execute a method
    // in the Controller named actionPerformed

    /**
     * If new game button is clicked, executes method in controller
     */
    public void addNewGameListener(ActionListener listenForNewGame) {
        newGameButton.addActionListener(listenForNewGame);
    }

    /**
     * If Exit button is clicked, Closes application
     */
    public void addExitListener(ActionListener listenForExitButton) {
        exitButton.addActionListener(listenForExitButton);
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        menuPanel = new JPanel();
        menuPanel.setLayout(new GridLayoutManager(3, 1, new Insets(0, 0, 0, 0), -1, -1));
        exitButton = new JButton();
        exitButton.setText("Exit");
        menuPanel.add(exitButton, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        newGameButton = new JButton();
        newGameButton.setText("New Game");
        menuPanel.add(newGameButton, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label1 = new JLabel();
        label1.setIcon(new ImageIcon(getClass().getResource("/logo.png")));
        label1.setText("");
        menuPanel.add(label1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return menuPanel;
    }

}