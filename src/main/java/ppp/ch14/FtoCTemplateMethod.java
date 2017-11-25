package ppp.ch14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Template Method 패턴을 적용한 화씨 to 섭씨
 */
public class FtoCTemplateMethod extends Application {
    private InputStreamReader isr;
    private BufferedReader br;

    @Override
    protected void init() {
        isr = new InputStreamReader(System.in);
        br = new BufferedReader(isr);
    }

    @Override
    protected void idle() {
        String fahrString = readLineAndReturnNullIfError();

        if (fahrString == null || fahrString.length() == 0)
            setDone();
        else {
            double fahr = Double.parseDouble(fahrString);
            double celcius = 5.0 / 9.0 * (fahr - 32);
            System.out.println("F=" + fahr + ", C=" + celcius);
        }
    }

    @Override
    protected void cleanup() {
        System.out.println("ftoc exit");
    }

    private String readLineAndReturnNullIfError() {
        String s;
        try {
            s = br.readLine();
        } catch (IOException e) {
            s = null;
        }
        return s;
    }

    public static void main(String[] args) {
        (new FtoCTemplateMethod()).run();
    }
}
