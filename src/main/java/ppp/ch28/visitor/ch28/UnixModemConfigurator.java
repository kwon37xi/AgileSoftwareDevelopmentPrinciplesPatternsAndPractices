package ppp.ch28.visitor.ch28;

public class UnixModemConfigurator implements ModemVisitor {
    @Override
    public void visit(HayesModem modem) {
        modem.configurationString = "&s1=4&D=3";
    }

    @Override
    public void visit(ZoomModem modem) {
        modem.configurationValue = 42;
    }

    @Override
    public void visit(ErnieModem modem) {
        modem.internalPattern = "C is too slow";
    }
}
