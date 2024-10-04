import java.awt.image.BufferedImage;
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.util.Stack;

public class FloodFill {

    public static void floodFillPilha(BufferedImage image, int x, int y, Color newColor) throws IOException {
        int width = image.getWidth();
        int height = image.getHeight();
        int targetColor = image.getRGB(x, y);

        if (targetColor == newColor.getRGB()) return;

        Stack<int[]> stack = new Stack<>();
        // ponto inicial
        stack.push(new int[]{x, y});

        // enquanto tiver elemento, continua pintando
        int pixelsProcessed = 0;
        int saveInterval = 560; // Número de pixels após os quais a imagem será salva
        int step = 1; // Contador de passos para salvar imagens

        // onde vai baixar a imagem
        File outputDir = new File("resources");
        if (!outputDir.exists()) {
            outputDir.mkdirs();
        }

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
            pixelsProcessed++;

            // Empilha o pixel da direita
            stack.push(new int[]{px + 1, py});
            // Empilha o pixel da esquerda
            stack.push(new int[]{px - 1, py});
            // Empilha o pixel de baixo
            stack.push(new int[]{px, py + 1});
            // Empilha o pixel de cima
            stack.push(new int[]{px, py - 1});

            // Salva a imagem a cada `saveInterval` pixels
            if (pixelsProcessed % saveInterval == 0) {
                File output = new File(outputDir, "pilhaPasso" + step + ".png");

                // salvar a imagem colorida
                ImageIO.write(image, "png", output);
                System.out.println("Imagem salva como passo" + step + ".png");

                step++;
            }
        }

        // Salva a imagem final após o loop
        File finalOutput = new File(outputDir, "pilhaPasso" + step + ".png");
        ImageIO.write(image, "png", finalOutput);
        System.out.println("Imagem final salva como passo" + step + ".png");
    }

    public static void main(String[] args) {
        try {
            // caminho da imagem
            File input = new File("C:\\Users\\evely\\OneDrive - Grupo Marista\\BES\\4P\\ESTRUTURA DE DADOS\\FloodFill\\resources/cacto.png");
            // carregar
            BufferedImage image = ImageIO.read(input);

            // cor verde
            Color newColor = Color.GREEN;

            // pixel inicial
            int centerX = image.getWidth() / 2;
            int centerY = image.getHeight() / 2;

            // método Flood Fill com o pixel inicial e a cor
            floodFillPilha(image, centerX, centerY, newColor);

            System.out.println("Processo de pintura concluído!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
