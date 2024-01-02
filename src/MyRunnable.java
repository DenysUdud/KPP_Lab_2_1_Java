import javax.swing.*;

public class MyRunnable implements Runnable {
    public double x;
    public double eps;
    public JLabel lbl;
    public boolean stop;

    @Override
    public void run() {
        double sum = 0;


        for (int n = 1; ; n++) {
            double term = 1.0 / ((3 * n - 2) * (3 * n + 1));
            if (Math.abs(term) < eps || stop) {
                double finalSum = sum;
                SwingUtilities.invokeLater(() -> lbl.setText("Result: " + finalSum));
                return;
            }
            sum += term;
        }
    }
}
