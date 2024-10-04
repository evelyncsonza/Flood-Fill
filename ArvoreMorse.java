public class ArvoreMorse {
    private No raiz = new No("");

    public ArvoreMorse() {
        this.construirArvore();
    }

    public void adicionar(String valor, String codigoMorse) {
        No atual = this.raiz;
        char[] var4 = codigoMorse.toCharArray();
        int var5 = var4.length;

        for(int var6 = 0; var6 < var5; ++var6) {
            char c = var4[var6];
            if (c == '.') {
                if (atual.esquerda == null) {
                    atual.esquerda = new No("");
                }

                atual = atual.esquerda;
            } else if (c == '-') {
                if (atual.direita == null) {
                    atual.direita = new No("");
                }

                atual = atual.direita;
            }
        }

        atual.valor = valor;
    }

    private void construirArvore() {
        this.adicionar("A", ".-");
        this.adicionar("B", "-...");
        this.adicionar("C", "-.-.");
        this.adicionar("D", "-..");
        this.adicionar("E", ".");
        this.adicionar("F", "..-.");
        this.adicionar("G", "--.");
        this.adicionar("H", "....");
        this.adicionar("I", "..");
        this.adicionar("J", ".---");
        this.adicionar("K", "-.-");
        this.adicionar("L", ".-..");
        this.adicionar("M", "--");
        this.adicionar("N", "-.");
        this.adicionar("O", "---");
        this.adicionar("P", ".--.");
        this.adicionar("Q", "--.-");
        this.adicionar("R", ".-.");
        this.adicionar("S", "...");
        this.adicionar("T", "-");
        this.adicionar("U", "..-");
        this.adicionar("V", "...-");
        this.adicionar("W", ".--");
        this.adicionar("X", "-..-");
        this.adicionar("Y", "-.--");
        this.adicionar("Z", "--..");
        this.adicionar("1", ".----");
        this.adicionar("2", "..---");
        this.adicionar("3", "...--");
        this.adicionar("4", "....-");
        this.adicionar("5", ".....");
        this.adicionar("6", "-....");
        this.adicionar("7", "--...");
        this.adicionar("8", "---..");
        this.adicionar("9", "----.");
        this.adicionar("0", "-----");
    }

    public No getRaiz() {
        return this.raiz;
    }

    public boolean validarCodigoMorse(String codigo) {
        char[] var2 = codigo.toCharArray();
        int var3 = var2.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            char c = var2[var4];
            if (c != '.' && c != '-' && c != '/') {
                return false;
            }
        }

        return true;
    }

    public String decodificarLetra(String codigoMorse) {
        if (!this.validarCodigoMorse(codigoMorse)) {
            return "Código Morse inválido!";
        } else {
            No atual = this.raiz;
            char[] var3 = codigoMorse.toCharArray();
            int var4 = var3.length;

            for(int var5 = 0; var5 < var4; ++var5) {
                char c = var3[var5];
                if (c == '.') {
                    atual = atual.esquerda;
                } else if (c == '-') {
                    atual = atual.direita;
                }

                if (atual == null) {
                    return "Código Morse inválido!";
                }
            }

            return !atual.valor.isEmpty() ? atual.valor : "Código Morse inválido!";
        }
    }

    public String decodificarFrase(String codigoMorse) {
        StringBuilder fraseDecodificada = new StringBuilder();
        String[] palavras = codigoMorse.split(" / ");
        String[] var4 = palavras;
        int var5 = palavras.length;

        for(int var6 = 0; var6 < var5; ++var6) {
            String palavra = var4[var6];
            String[] letras = palavra.split(" ");
            String[] var9 = letras;
            int var10 = letras.length;

            for(int var11 = 0; var11 < var10; ++var11) {
                String letra = var9[var11];
                fraseDecodificada.append(this.decodificarLetra(letra));
            }

            fraseDecodificada.append(" ");
        }

        return fraseDecodificada.toString().trim();
    }
}
