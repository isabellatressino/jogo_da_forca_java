public class ControladorDeErros implements Cloneable {
    private int qtdMax, qtdErr = 0;

    public ControladorDeErros(int qtdMax) throws Exception {
        // verifica se qtdMax fornecida não é positiva, lançando
        // uma exceção.
        // armazena qtdMax fornecida em this.qtdMax.
        if (qtdMax < 0) throw new Exception("Quantidade invalida");

        this.qtdMax = qtdMax;
    }

    public void registreUmErro() throws Exception {
        // verifica se this.qtdErr ja é igual a this.qtdMax,
        // lançando excecao em caso positivo ou
        // incrementando this.qtdErr em caso negativo
        if (this.qtdErr == this.qtdMax) throw new Exception("Errou alem do maximo");

        this.qtdErr++;
    }

    public boolean isAtingidoMaximoDeErros() {
        // returna true se this.qtdErr for igual a this.qtdMax,
        // ou então false, caso contrario.
        /*
        if (this.qtdErr==this.qtdMax)
            return true;
        else
            return false;
        */

        return this.qtdErr == this.qtdMax;
    }

    public String toString() {
        return this.qtdErr + "/" + this.qtdMax;
    }

    public boolean equals(Object obj) {
        // verificar se this e obj possuem o mesmo conteúdo, retornando
        // true no caso afirmativo ou false no caso negativo
        if(this == obj) return true;
        if(obj == null) return false;
        if(getClass() != obj.getClass()) return false;

        ControladorDeErros n = (ControladorDeErros)obj;
        if(n.qtdErr != this.qtdErr) return false;
        if(n.qtdMax != this.qtdMax) return false;

        return true;
    }

    public int hashCode() {
        // calcular e retornar o hashcode de this
        int hash = 233;

        hash = 13 * hash + Integer.valueOf(this.qtdErr).hashCode();
        hash = 13 * hash +  Integer.valueOf(this.qtdMax).hashCode();
        if (hash < 0) hash = -hash;

        return hash;
    }

    public ControladorDeErros(ControladorDeErros c) throws Exception // construtor de cópia
    {
        // copiar c.qtdMax e c.qtdErr, respectivamente em, this.qtdMax e this.qtdErr
        if(c == null) throw new Exception("inválido");
        this.qtdErr = c.qtdErr;
        this.qtdMax = c.qtdMax;
    }

    public Object clone() {
        // returnar uma cópia de this
        ControladorDeErros obj = null;

        try{
            obj = new ControladorDeErros(this);
        }catch(Exception e){

        }

        return obj;
    }
}
