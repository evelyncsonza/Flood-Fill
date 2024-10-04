// adiciona no topo e remove no topo
public class Stack <T> {
    private int top = 0;
    private T[] data;

    public Stack(int size) {
        this.data = (T[]) new Object[size];
    }

    public void push(T s){
        if(isFull()){
            throw new RuntimeException("Pilha cheia");
        }
        this.data[top] = s;
        this.top++;
    }

    public T pop() {
        if (isEmpty()) {
            System.out.println("A pilha está vazia. Não é possível desempilhar elementos.");
            return null;
        } else {
            return data[--top];
        }
    }

    public void clear() {
        top = 0;
    }

    public boolean isFull() {
        return top == data.length;
    }

    public boolean isEmpty() {
        return top == 0;
    }

    public T[] getData() {
        return data;
    }

}
