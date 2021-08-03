package com.api.util;

import com.api.entities.booking.response.BookingId;
import com.api.entities.booking.response.GetBookingResponse;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.type.CollectionType;
import org.codehaus.jackson.map.type.TypeFactory;
import org.codehaus.jackson.type.TypeReference;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.io.StringReader;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @author in-vinaykumar.gupta on 01/08/21
 * @project IntelliJ IDEA
 */
public class ResponseHelper {
    public static Object getResponseObject(String responseString, Class responseClass) throws IOException {
        if (System.getProperty("Content-Type") != null) {
            try {
                final JAXBContext context = JAXBContext.newInstance(responseClass);
                final Unmarshaller unmarshaller = context.createUnmarshaller();

                return unmarshaller.unmarshal(new StringReader(responseString));
            } catch (JAXBException e) {
                e.printStackTrace();
            }
        } else {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(responseString, responseClass);
        }
        return null;
    }
    public static Object getResponseObjectForStarArray(String responseString, Class responseClass) throws IOException {
        if (System.getProperty("Content-Type") != null) {
            try {
                final JAXBContext context = JAXBContext.newInstance(responseClass);
                final Unmarshaller unmarshaller = context.createUnmarshaller();

                return unmarshaller.unmarshal(new StringReader(responseString));
            } catch (JAXBException e) {
                e.printStackTrace();
            }
        } else {
            ObjectMapper mapper = new ObjectMapper();
           return mapper.readValue(
                   responseString, new TypeReference<List<BookingId>>() { });
        }
        return null;
    }

}
