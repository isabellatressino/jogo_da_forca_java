public class Tracinhos implements Cloneable {
    private char texto[];

    public Tracinhos(int qtd) throws Exception {
        // verifica se qtd não é positiva, lançando uma exceção.
        if (qtd <= 0) throw new Exception("A quantidade deve ser positiva.");

        // instancia this.texto com um vetor com tamanho igual qtd.
        this.texto = new char[qtd];

        // preenche this.texto com underlines (_).
        for (int i = 0; i < qtd; i++) this.texto[i] = '_';
    }


    public void revele(int posicao, char letra) throws Exception {
        // verifica se posicao é negativa ou então igual ou maior
        // do que this.texto.length, lançando uma exceção.
        if (posicao < 0 || posicao >= this.texto.length) throw new Exception("Posição inválida.");
        // armazena a letra fornecida na posicao tambem fornecida
        // do vetor this.texto
        this.texto[posicao] = letra;
    }

    public boolean isAindaComTracinhos() {
        // percorre o vetor de char this.texto e verifica
        // se o mesmo ainda contem algum underline ou se ja
        // foram todos substituidos por letras; retornar true
        for (int i = 0; i < this.texto.length; i++) {
            if (this.texto[i] == '_') return true;
        }
        // caso ainda reste algum underline, ou false caso
        // contrario
        return false;
    }

    @Override
    public String toString() {
        // retorna um String com TODOS os caracteres que há
        // no vetor this.texto, intercalados com espaços em
        // branco
        String ret = "";
        for (int i = 0; i < this.texto.length; i++) {
            ret += this.texto[i] + " ";
        }

        return ret;
    }

    @Override
    public boolean equals(Object obj) {
        // verificar se this e obj possuem o mesmo conteúdo, retornando
        // true no caso afirmativo ou false no caso negativo
        if (obj == this) return true;
        if (obj == null) return false;
        if (obj.getClass() != this.getClass()) return false;

        Tracinhos t = (Tracinhos) obj;

        if (this.texto.length != t.texto.length) return false;

        for (int i = 0; i < this.texto.length; i++) {
            if (this.texto[i] != t.texto[i]) return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        // calcular e retornar o hashcode de this
        int ret = 1;

        for (int i = 0; i < this.texto.length; i++) {
            ret = 13 * ret + Character.valueOf(this.texto[i]).hashCode();
        }

        if (ret < 0) ret = -ret;

        return ret;
    }

    public Tracinhos(Tracinhos t) throws Exception // construtor de cópia
    {
        if (t == null) throw new Exception("Obejto ausente");

        // intanciar this.texto um vetor com o mesmo tamanho de t.texto
        this.texto = new char[t.texto.length];

        // e copilar o conteúdo de t.texto para this.texto
        for (int i = 0; i < this.texto.length; i++)
            this.texto[i] = t.texto[i];
    }

    @Override
    public Object clone() {
        // retornar uma copia de this
        Tracinhos ret = null;

        try {
            ret = new Tracinhos(this);
        } catch (Exception erro) {
        }

        return ret;
    }
}
