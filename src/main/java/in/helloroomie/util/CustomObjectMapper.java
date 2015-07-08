package in.helloroomie.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.text.SimpleDateFormat;

/**
 * Created by Pradeep Arya on 7/8/2015.
 */
public class CustomObjectMapper extends ObjectMapper {
    public CustomObjectMapper() {
        super.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        super.setDateFormat(new SimpleDateFormat(HelloRoomieConstants.DEFAULT_DATE_FORMAT));
    }
}
