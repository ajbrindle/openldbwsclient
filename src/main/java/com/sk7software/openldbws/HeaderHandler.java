package com.sk7software.openldbws;


import com.thalesgroup.rtti._2013_11_28.token.types.AccessToken;

import javax.xml.namespace.QName;
import javax.xml.soap.*;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;
import java.util.Set;

public class HeaderHandler implements SOAPHandler<SOAPMessageContext> {

    private AccessToken token;

    public HeaderHandler(AccessToken token) {
        this.token = token;
    }

    public boolean handleMessage(SOAPMessageContext context) {

        Boolean outboundProperty = (Boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);

        if (outboundProperty.booleanValue()) {

            SOAPMessage message = context.getMessage();

            try {
                SOAPHeader header = message.getSOAPHeader();
                SOAPEnvelope envelope = context.getMessage().getSOAPPart().getEnvelope();
                if (header == null) {
                    header = envelope.addHeader();
                }

                SOAPHeaderElement accessToken =
                        header.addHeaderElement(new QName("http://thalesgroup.com/RTTI/2013-11-28/Token/types", "AccessToken"));

                SOAPHeaderElement tokenValue =
                        header.addHeaderElement(new QName("http://thalesgroup.com/RTTI/2013-11-28/Token/types", "TokenValue"));
                tokenValue.addTextNode(token.getTokenValue());

                accessToken.addChildElement(tokenValue);
                message.saveChanges();

                //Print out the outbound SOAP message to System.out
                message.writeTo(System.out);
                System.out.println("");

            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }

        } else {
            try {

                SOAPMessage message = context.getMessage();
                message.writeTo(System.out);
                System.out.println("");

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }


        return outboundProperty;

    }

    public Set getHeaders() {
        //throw new UnsupportedOperationException("Not supported yet.");
        return null;
    }

    public boolean handleFault(SOAPMessageContext context) {
        //throw new UnsupportedOperationException("Not supported yet.");
        return true;
    }

    public void close(MessageContext context) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }
}
