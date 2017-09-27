package com.sk7software.openldbws;

import java.net.URL;
import com.thalesgroup.rtti._2013_11_28.token.types.AccessToken;
import com.thalesgroup.rtti._2017_02_02.ldb.GetBoardRequestParams;
import com.thalesgroup.rtti._2017_02_02.ldb.LDBServiceSoap;
import com.thalesgroup.rtti._2017_02_02.ldb.Ldb;
import com.thalesgroup.rtti._2017_02_02.ldb.StationBoardResponseType;

import javax.xml.namespace.QName;

public class ServiceCalls {

    private static final String ACCESS_TOKEN = "YOUR_ACCESS_TOKEN";

    public static void main(String[] args) {

        AccessToken token = new AccessToken();
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
            _getDepartureBoard_parameters.setCrs("DVN");
            _getDepartureBoard_parameters.setNumRows(20);
            StationBoardResponseType _getDepartureBoard__return = port.getDepartureBoard(_getDepartureBoard_parameters);
            System.out.println("getDepartureBoard.result=" + _getDepartureBoard__return);
        }

    }
}
