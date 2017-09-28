package com.sk7software.openldbws;

import com.thalesgroup.rtti._2013_11_28.token.types.AccessToken;
import com.thalesgroup.rtti._2017_02_02.ldb.GetBoardRequestParams;
import com.thalesgroup.rtti._2017_02_02.ldb.LDBServiceSoap;
import com.thalesgroup.rtti._2017_02_02.ldb.Ldb;
import com.thalesgroup.rtti._2017_02_02.ldb.StationBoardResponseType;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Properties;

public class ServiceCalls {

    private static final String ACCESS_TOKEN = "YOUR_ACCESS_TOKEN";

    public static void main(String[] args) throws Exception {

        AccessToken token = new AccessToken();
        String crs = "MAN";
        int numRows = 20;

        if (args.length == 1) {
            // Use arg 0 as token value
            token.setTokenValue(args[0]);
        } else {
            token.setTokenValue(ACCESS_TOKEN);
        }

        Ldb ss = new Ldb();
        HeaderHandlerResolver handlerResolver = new HeaderHandlerResolver(token);
        ss.setHandlerResolver(handlerResolver);
        LDBServiceSoap port = ss.getLDBServiceSoap();

        {
            System.out.println("Invoking getDepartureBoard...");
            GetBoardRequestParams _getDepartureBoard_parameters = new GetBoardRequestParams();
            _getDepartureBoard_parameters.setCrs(crs);
            _getDepartureBoard_parameters.setNumRows(numRows);
            StationBoardResponseType _getDepartureBoard__return = port.getDepartureBoard(_getDepartureBoard_parameters);
        }
    }
}
