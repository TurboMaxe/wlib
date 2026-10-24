package xyz.webmc.wlib.api.misc.iface;

public class SerializerParseException extends RuntimeException {

    public SerializerParseException(String msg) {
        super(msg);
    }

    public SerializerParseException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public SerializerParseException(Throwable cause) {
        super(cause);
    }

}
