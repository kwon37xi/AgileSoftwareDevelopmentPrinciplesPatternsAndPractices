package ppp.ch28.visitor.ch28;

public interface ModemVisitor {
    void visit(HayesModem modem);
    void visit(ZoomModem modem);
    void visit(ErnieModem modem);
}
