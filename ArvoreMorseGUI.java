import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class ArvoreMorseGUI extends JPanel {
    private ArvoreMorse arvoreMorse;

    public ArvoreMorseGUI(ArvoreMorse arvoreMorse) {
        this.arvoreMorse = arvoreMorse;
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.desenharArvore(g, this.arvoreMorse.getRaiz(), this.getWidth() / 2, 50, this.getWidth() / 4, 60);
    }

    private void desenharArvore(Graphics g, No nodo, int x, int y, int offset, int nivelAltura) {
        if (nodo != null) {
            g.setColor(Color.LIGHT_GRAY);
            g.fillOval(x - 20, y - 20, 40, 40);
            g.setColor(Color.BLACK);
            g.drawOval(x - 20, y - 20, 40, 40);
            g.drawString(nodo.valor, x - 5, y + 5);
            if (nodo.esquerda != null) {
                g.drawLine(x, y, x - offset, y + nivelAltura);
                this.desenharArvore(g, nodo.esquerda, x - offset, y + nivelAltura, offset / 2, nivelAltura);
            }

            if (nodo.direita != null) {
                g.drawLine(x, y, x + offset, y + nivelAltura);
                this.desenharArvore(g, nodo.direita, x + offset, y + nivelAltura, offset / 2, nivelAltura);
            }

        }
    }
}
