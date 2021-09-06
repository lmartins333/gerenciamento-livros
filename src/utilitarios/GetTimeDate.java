/*
 * Classe com objetivo de capturar a Data e Hora atuais,
 */
package utilitarios;

import java.util.Calendar;
import java.util.TimeZone;

/**
 *
 * @author lucas
 */
public class GetTimeDate {
    public static final String AAAA = "AAAA";
    public static final String MM = "MM";
    public static final String DD = "DD";
    public static final String DMAA = "DMAA";
    public static final String DDMMAA = "DDMMAA";
    public static final String DMAAAA = "DMAAAA";
    public static final String DDMMAAAA = "DDMMAAAA";
    public static final String HMS = "HMS";
    public static final String HHMMSS = "HHMMSS";

    /**
    * Retorna a hora atual de acordo com o formato HHMMSS que será dividido de
    * acordo com o Delimitador, que caso seja indiacado individualmente (HMS), irá
    * desconsiderar os zeros à esquerda.
    * EX: DMAA = 1/1/17 DDMMAAAA = 01/01/2017
     * @param delimiter
     * @param format
     * @return 
    */
    public static String getData(String delimiter, String format){
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("Brazil/East"));
        int dia = calendar.get(Calendar.DAY_OF_MONTH);
        int mes = calendar.get(Calendar.MONTH) + 1;
        int ano = calendar.get(Calendar.YEAR);
        String data = "";
                
        /*
        * Como as variáveis são do tipo inteiro, o zero antes dos números são
        * desconsiderados. Então é verificado se os números obtidos são menores
        * ou iguais a 9 para poder inserir o zero (somente por questões visuais).
        */
        
        if(format.contains("DD")) {
            if(dia <= 9)
                data = "0" + String.valueOf(dia);
            else
                data = String.valueOf(dia);
        } else
            if(format.contains("D"))
                data = String.valueOf(dia);

        if((format.contains("D") && format.contains("M")) || 
                (format.contains("D") && format.contains("AA")))
            data += delimiter;

        if(format.contains("MM")) {
            if(mes <= 9)
                data += "0" + String.valueOf(mes);
            else
                data += String.valueOf(mes);
        } else 
            if(format.contains("M"))
                data += String.valueOf(mes);

        if(format.contains("M") && format.contains("AA"))
            data += delimiter;

        if(format.contains("AAAA")) {
            data += String.valueOf(ano);
        } else {
            if (format.contains("AA"))
                data += String.valueOf(ano).substring(2);
        }

        return data;
    }
    

    /**
    * Retorna a data atual de acordo com o formato DDMMAAAA que será dividido de
    * acordo com o Delimitador e o formato, que caso seja indicado individualmente,
    * irá desconsiderar os zeros à esquerda.
    * EX: HMS = 1:10:3 HHMMSS 01:10:03
     * @param delimiter
     * @param format
     * @return 
    */
    public static String getHora(String delimiter, String format){
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("Brazil/East"));
        int hora = calendar.get(Calendar.HOUR_OF_DAY);
        int minuto = calendar.get(Calendar.MINUTE);
        int segundo = calendar.get(Calendar.SECOND);
        String horario = "";
                
        /*
        * Como as variáveis são do tipo inteiro, o zero antes dos números são
        * desconsiderados. Então é verificado se os números obtidos são menores
        * ou iguais a 9 para poder inserir o zero.
        */
        if(format.contains("HH")){
            if(hora <= 9)
                horario = "0" + String.valueOf(hora);
            else
                horario = String.valueOf(hora);
        } else
            if(format.contains("H"))
                horario = String.valueOf(hora);
        
        if ((format.contains("H") && format.contains("M")) ||
                (format.contains("H") && format.contains("S")))
            horario += delimiter;

        if(format.contains("MM")) {
            if(minuto <= 9)
                horario += "0" + String.valueOf(minuto);
            else
                horario += String.valueOf(minuto);
        } else
            if (format.contains("M"))
                horario += String.valueOf(minuto);

        if (format.contains("M") && format.contains("S"))
            horario += delimiter;

        if(format.contains("SS")) {
            if(segundo <= 9)
                horario += "0" + String.valueOf(segundo);
            else
                horario += String.valueOf(segundo);
        } else
            if (format.contains("S"))
                horario += String.valueOf(segundo);

        return horario;
    }

    public static boolean diferencaHoraAtual(String data, String hora, int diferenca) {
        boolean retorno = false;

        String dataAtual = GetTimeDate.getData("/", "DDMMAAAA");

        if (data.equals(dataAtual))
            retorno = (diferencaSegundos(hora) >= diferenca);
        else
            return diferencaDias(data);

        return retorno;
    }

    public static int diferencaSegundos(String hora) {
        int horaAtual = Integer.valueOf(GetTimeDate.getHora("", "HH"));
        int minutoAtual = Integer.valueOf(GetTimeDate.getHora("", "MM"));
        int segundoAtual = Integer.valueOf(GetTimeDate.getHora("", "SS"));

        int horaRec = Integer.valueOf(hora.substring(0, 2));
        int minutoRec = Integer.valueOf(hora.substring(3, 5));
        int segundoRec = Integer.valueOf(hora.substring(6, 8));

        int nSegundosTotalAtual = (horaAtual * 60 * 60) + (minutoAtual * 60) + segundoAtual;
        int nSegundosTotalRec = (horaRec * 60 * 60) + (minutoRec * 60) + segundoRec;

        return (nSegundosTotalAtual - nSegundosTotalRec);
    }

    public static boolean diferencaDias(String data) {
        int diaAtual = Integer.valueOf(GetTimeDate.getData("", "DD"));
        int diaRec = Integer.valueOf(data.substring(0,2));
        boolean retorno = false;

        if (diaAtual > diaRec) 
            return true;
        else {
            int mesAtual = Integer.valueOf(GetTimeDate.getData("", "MM"));
            int mesRec = Integer.valueOf(data.substring(3,5));

            if (mesAtual > mesRec)
                return true;
            else {
                int anoAtual = Integer.valueOf(GetTimeDate.getData("", "AAAA"));
                int anoRec = Integer.valueOf(data.substring(6,10));

                if (anoAtual > anoRec)
                    retorno = true;
            }
        }

        return retorno;
    }
    
    public static String getDateSQL() {
        return getData(null, AAAA) + "-"
                + getData(null, MM) + "-"
                + getData(null, DD);
    }
}