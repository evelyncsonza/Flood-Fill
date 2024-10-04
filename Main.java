
import java.util.Scanner;
import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        ArvoreMorse arvoreMorse = new ArvoreMorse();
        Scanner scanner = new Scanner(System.in);

        while(true) {
            while(true) {
                System.out.println("\nEscolha uma opção:");
                System.out.println("1. Decodificar frase em código Morse");
                System.out.println("2. Exibir árvore Morse");
                System.out.println("3. Sair");
                int opcao = scanner.nextInt();
                scanner.nextLine();
                switch (opcao) {
                    case 1:
                        System.out.print("Digite a frase em código Morse: ");
                        String fraseMorse = scanner.nextLine();
                        String resultado = arvoreMorse.decodificarFrase(fraseMorse);
                        System.out.println("Frase decodificada: " + resultado);
                        break;
                    case 2:
                        exibirArvoreMorse(arvoreMorse);
                        break;
                    case 3:
                        System.out.println("Encerrando o programa...");
                        System.exit(0);
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            }
        }
    }
    public static void exibirArvoreMorse(ArvoreMorse arvoreMorse) {
        JFrame frame = new JFrame("Árvore Morse");
        ArvoreMorseGUI arvoreMorseGUI = new ArvoreMorseGUI(arvoreMorse);
        frame.setDefaultCloseOperation(3);
        frame.add(arvoreMorseGUI);
        frame.setSize(1000, 800);
        frame.setVisible(true);
    }
}
