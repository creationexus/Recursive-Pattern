import java.util.*;

class LetraToNumero {
    String[] Letras = { "UN", "UNO", "DOS", "TRES", "CUATRO", "CINCO", "SEIS","SIETE", "OCHO", "NUEVE", "DIEZ", "ONCE", "DOCE", "TRECE","CATORCE", "QUINCE", "DIECISEIS", "DIECISIETE", "DIECIOCHO","DIECINUEVE", "VEINTE", "TREINTA", "CUARENTA", "CINCUENTA", "SESENTA", "SETENTA", "OCHENTA", "NOVENTA", "CIEN", "CIENTO","DOSCIENTOS", "TRESCIENTOS", "CUATROCIENTOS", "QUINIENTOS","SEISCIENTOS", "SETECIENTOS", "OCHOCIENTOS", "NOVECIENTOS" };
    Integer[] Valores = { 1, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 30, 40, 50, 60, 70, 80, 90, 100, 100, 200, 300, 400, 500, 600, 700, 800, 900 };
    String[] nNiveles = {"MIL", "MILLON", "MILLONES"};
    int[] nPesos = {1000, 1000000, 1000000};

    public static void main(String[] args) {
    	Scanner entrada=new Scanner (System.in);
    	System.out.println("Ingrese Numero");
    	String l=entrada.nextLine();
        new LetraToNumero().Letras(l);
    }
    public void Letras(String numeroString) {
        StringTokenizer st = new StringTokenizer(numeroString);
        int num = 0;
        int constante = 0;
        int nivel1 = 0;
        int nivel2 = 0;
        while (st.hasMoreTokens()) {
            String t = st.nextToken();
            t = t.toUpperCase();
            for(int i = 0; i < nNiveles.length; i++){
            	if(t.compareTo(nNiveles[i]) == 0){
            	if(i == 1 || i == 2){
            		constante += nivel1;
            		nivel1 = 0;
					nivel2 = constante * nPesos[1];
					constante = 0;
            	}else if(i == 0){
            		if(constante == 0) constante = 1;
            		nivel1 = constante * nPesos[0];
            		constante = 0;
            	}
            }
            }
            //Aqui se maneja el nivel constante Nivel 0.
            for(int i = 0; i < Letras.length; i++)
            	if(t.compareTo(Letras[i]) == 0)
            		constante += Valores[i];
        }
        num = nivel2 + nivel1 + constante;
        System.out.println("Resultado : " + num);
    }
}