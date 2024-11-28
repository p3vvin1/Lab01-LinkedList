package estruturaDeDados;

class No {
    int dado;
    No proximo;

    public No(int dado) {
        this.dado = dado;
        this.proximo = null;
    }
}

public class Lista {
    private No cabeca;

    public Lista() {
        this.cabeca = null;
    }

    // Insere no início da lista
    public void insereInicio(int i) {
        No novoNo = new No(i);
        novoNo.proximo = cabeca;
        cabeca = novoNo;
    }

    // Insere no final da lista
    public void insereFim(int i) {
        No novoNo = new No(i);
        if (cabeca == null) {
            cabeca = novoNo;
        } else {
            No atual = cabeca;
            while (atual.proximo != null) {
                atual = atual.proximo;
            }
            atual.proximo = novoNo;
        }
    }

    // Busca um elemento na lista (retorna true se encontrado)
    public boolean buscaElemento(int i) {
        No atual = cabeca;
        while (atual != null) {
            if (atual.dado == i) {
                return true;
            }
            atual = atual.proximo;
        }
        return false;
    }

    // Retorna o elemento do índice especificado (0-based)
    public int buscaIndice(int i) {
        No atual = cabeca;
        int contador = 0;

        while (atual != null) {
            if (contador == i) {
                return atual.dado;
            }
            atual = atual.proximo;
            contador++;
        }

        throw new IndexOutOfBoundsException("Índice fora dos limites da lista");
    }

    // Remove o primeiro elemento da lista
    public void removeInicio() {
        if (cabeca != null) {
            cabeca = cabeca.proximo;
        }
    }

    public void removeFim() {
        if (cabeca == null) return;  
    
       
        if (cabeca.proximo == null) {
            cabeca = null;
            return;
        }
    
        
        No atual = cabeca;
        while (atual.proximo != null && atual.proximo.proximo != null) {
            atual = atual.proximo;  
        }
    
        atual.proximo = null;  
    }
    
    
    public void removeIndice(int i) {
        if (i == 0) {
            removeInicio();
            return;
        }

        No atual = cabeca;
        int contador = 0;

        while (atual != null && atual.proximo != null) {
            if (contador == i - 1) {
                atual.proximo = atual.proximo.proximo;
                return;
            }
            atual = atual.proximo;
            contador++;
        }

        throw new IndexOutOfBoundsException("Índice fora dos limites da lista");
    }

    // Insere um elemento na posição especificada
    public void insereElementoPosicao(int i, int posicao) {
        if (posicao == 0) {
            insereInicio(i);
            return;
        }

        No novoNo = new No(i);
        No atual = cabeca;
        int contador = 0;

        while (atual != null) {
            if (contador == posicao - 1) {
                novoNo.proximo = atual.proximo;
                atual.proximo = novoNo;
                return;
            }
            atual = atual.proximo;
            contador++;
        }

        throw new IndexOutOfBoundsException("Índice fora dos limites da lista");
    }
}
