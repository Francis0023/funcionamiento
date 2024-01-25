import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("primera pantalla");
        frame.setContentPane(new forma1().menuprincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1250,850);
        frame.pack();
        frame.setVisible(true);

    }
}