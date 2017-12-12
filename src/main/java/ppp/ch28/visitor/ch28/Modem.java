package ppp.ch28.visitor.ch28;

public interface Modem {
    void dial(String pno);
    void hangup();
    void send(char c);
    char recv();
    void accept(ModemVisitor v);
}
