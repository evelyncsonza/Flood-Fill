import java.awt.image.BufferedImage;
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class FloodFill {

    public static void floodFillPilha(BufferedImage image, int x, int y, Color newColor) {
        int width = image.getWidth();
        int height = image.getHeight();
        int targetColor = image.getRGB(x, y);

        if (targetColor == newColor.getRGB()) return;

        Stack<int[]> stack = new Stack<>(width * height);
        // ponto inicial
        stack.push(new int[]{x, y});

        // enquanto tiver elemento, continua pintando
        while (!stack.isEmpty()) {
            int[] point = stack.pop();
            // x é horizontal e y é vertical
            int px = point[0];
            int py = point[1];

            // se o pixel não ta fora do tamanho da imagem
            if (px < 0 || px >= width || py < 0 || py >= height) continue;
            // se o pixel nao for da cor do pixel inicial ele nao pinta
            if (image.getRGB(px, py) != targetColor) continue;

            // se for da cor do inicial, pinta com a nova cor
            image.setRGB(px, py, newColor.getRGB());

            // direita
            stack.push(new int[]{px + 1, py});
            // esquerda
            stack.push(new int[]{px - 1, py});
            // pra baixo
            stack.push(new int[]{px, py + 1});
            // pra cima
            stack.push(new int[]{px, py - 1});
        }
    }

    public static void main(String[] args) {
        try {
            // caminho da imagem
            File input = new File("C:\\Users\\evely\\OneDrive - Grupo Marista\\BES\\4P\\ESTRUTURA DE DADOS\\FloodFill/imagem.png");
            // carregar
            BufferedImage image = ImageIO.read(input);

            // cor vermelha
            Color newColor = Color.RED;

            // pixel inicial
            int centerX = image.getWidth() / 2;
            int centerY = image.getHeight() / 2;

            // método Flood Fill com o pixel inicial e a cor
            floodFillPilha(image, centerX, centerY, newColor);

            // onde vai baixar a imagem
            File outputDir = new File("resources");
            if (!outputDir.exists()) {
                outputDir.mkdirs();
            }
            File output = new File(outputDir, "imagem_colorida.png");

            // salvar a imagem colorida
            ImageIO.write(image, "png", output);

            System.out.println("Imagem colorida e salva com sucesso!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
