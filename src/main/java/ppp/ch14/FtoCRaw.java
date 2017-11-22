package ppp.ch14;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 화씨 온도를 섭씨로 변환하는 프로그램. 패턴 적용 안 함.
 */
public class FtoCRaw {
    public static void main(String[] args) throws Exception {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        boolean done = false;

        while (!done) {
            String fahrString = br.readLine();
            if (fahrString == null || fahrString.length() == 0) {
                done = true;
            } else {
                double fahr = Double.parseDouble(fahrString);
                double celcius = 5.0 / 9.0 * (fahr - 32);
                System.out.println("F=" + fahr + ", C=" + celcius);
            }
        }
        System.out.println("ftoc exit");
    }
}
