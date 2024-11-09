public class ControladorDeLetrasJaDigitadas implements Cloneable {
    private String letrasJaDigitadas;

    public ControladorDeLetrasJaDigitadas() {
        // torna this.letrasJaDigitadas igual ao String vazio
        this.letrasJaDigitadas = " ";
    }

    public boolean isJaDigitada(char letra) {
        // percorrer o String this.letrasJaDigitadas e verificar se ele
        // possui a letra fornecida, retornando true em caso afirmativo
        // ou false em caso negativo

        for (int i = 0; i < this.letrasJaDigitadas.length(); i++) {
            if (this.letrasJaDigitadas.charAt(i) == letra) {
                return true;
            }
        }

        return false;
    }

    public void registre(char letra) throws Exception {
        // verifica se a letra fornecida ja foi digitada (pode usar
        // o método this.isJaDigitada, para isso), lancando uma exceção
        // em caso afirmativo.
        // concatena a letra fornecida a this.letrasJaDigitadas.

        if (isJaDigitada(letra)) {
            throw new Exception("Letra já digitada");
        }

        this.letrasJaDigitadas += letra;

    }

    public String toString() {
        // retorna um String com TODAS as letras presentes em
        // this.letrasJaDigitadas separadas por vírgula (,).

        String concat = "";
        for (int i = 0; i < this.letrasJaDigitadas.length(); i++) {
            concat += this.letrasJaDigitadas.charAt(i); //guarda em concat
            if (i != this.letrasJaDigitadas.length() - 1) { // virgula
                concat += ",";
            }
        }

        return concat;
    }

    public boolean equals(Object obj) {
        // verificar se this e obj são iguais
        if(this == obj) return true;
        if(obj == null) return false;
        if(getClass() != obj.getClass()) return false;

        ControladorDeLetrasJaDigitadas n = (ControladorDeLetrasJaDigitadas) obj;
        if(n.letrasJaDigitadas != this.letrasJaDigitadas) return false;

        return true;
    }

    public int hashCode() {
        // calcular e retornar o hashcode de this
        int hash = 233;

        hash = 13 * hash + new String(this.letrasJaDigitadas).hashCode();

        if(hash<0) hash = -hash;

        return hash;
    }

    public ControladorDeLetrasJaDigitadas(
            ControladorDeLetrasJaDigitadas controladorDeLetrasJaDigitadas)
            throws Exception // construtor de cópia
    {
        // copiar c.letrasJaDigitadas em this.letrasJaDigitadas
        this.letrasJaDigitadas = controladorDeLetrasJaDigitadas.letrasJaDigitadas;

    }

    public Object clone() {
        // criar uma cópia do this com o construtor de cópia e retornar
        ControladorDeLetrasJaDigitadas obj = null;

        try{
            obj = new ControladorDeLetrasJaDigitadas(this);
        }catch (Exception e) {
            //não trata, this nunca é null
        }

        return obj;
    }
}
