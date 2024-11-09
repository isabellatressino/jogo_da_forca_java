public class Palavra implements Comparable<Palavra>
{
    private String texto;

    public Palavra (String texto) throws Exception
    {
        // verifica se o texto recebido é nulo ou então vazio,
        // ou seja, sem nenhum caractere, lançando exceção.
        if (texto == null || texto.isEmpty())
            throw new Exception ("Palavra ausente.");

        // armazena o texto recebido em this.texto.
        this.texto = texto;
    }

    public int getQuantidade (char letra)
    {
        // percorre o String this.texto, conta e retorna
        // quantas letras existem nele iguais a letra fornecida
        int ret = 0;
        for (int i = 0; i < this.texto.length(); i++)
            if (this.texto.charAt(i) == letra) ret++;

        return ret;
    }

    public int getPosicaoDaIezimaOcorrencia (int i, char letra) throws Exception
    {
        // se i==0, retorna a posicao em que ocorre a primeira
        // aparicao de letra fornecida em this.texto;

        // se i==1, retorna a posicao em que ocorre a segunda
        // aparicao de letra fornecida em this.texto;

        // se i==2, retorna a posicao em que ocorre a terceira
        // aparicao de letra fornecida em this.texto;
        // e assim por diante.


        // lançar excecao caso nao encontre em this.texto
        // a Iézima aparição da letra fornecida.
    }

//    public int getPosicaoDaIezimaOcorrencia(int i, char letra) throws Exception
//    {
//        int ocorrencia = 0;
//        for (int pos = 0; pos < this.texto.length(); pos++)
//        {
//            if (this.texto.charAt(pos) == letra)
//            {
//                if (ocorrencia == i)
//                    return pos;
//                ocorrencia++;
//            }
//        }
//        throw new Exception("A Iézima aparição da letra não foi encontrada.");
//    }

    public int getTamanho ()
    {
        return this.texto.length();
    }

    public String toString ()
    {
        return this.texto;
    }


    @Override
    public boolean equals (Object obj)
    {
        // verificar se this e obj possuem o mesmo conteúdo, retornando
        // true no caso afirmativo ou false no caso negativo
        if (obj==this) return true;
        if (obj==null) return false;
        if (obj.getClass()!=this.getClass()) return false;

        Palavra t = (Palavra)obj;
        if(this.texto != t.texto) return false;

        return true;
    }

    @Override
    public int hashCode ()
    {
        // calcular e retornar o hashcode de this
        int ret = 1;
        ret = ret * 2 + String.valueOf(this.texto).hashCode();

        if(ret < 0) ret = -ret;

        return ret;
    }

    @Override
    public int compareTo (Palavra palavra)
    {
        return this.texto.compareTo(palavra.texto);
    }
}
