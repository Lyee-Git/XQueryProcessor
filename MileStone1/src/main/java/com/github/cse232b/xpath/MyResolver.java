package com.github.cse232b.xpath;

import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import java.io.IOException;
import java.io.InputStream;

// parsing custom XML entities.
public class MyResolver implements EntityResolver {
    private static final String DTD_FILE_NAME = "play.dtd";

    @Override
    public InputSource resolveEntity(String publicId, String systemId) throws SAXException, IOException {
        // Check if the systemId of the XML entity contains the DTD file name.
        if (systemId.contains(DTD_FILE_NAME)) {
            // Load the DTD file as a stream from the classpath.
            InputStream dtdStream = getClass().getClassLoader().getResourceAsStream(DTD_FILE_NAME);
            if (dtdStream == null) {
                throw new IOException("DTD file not found in resources.");
            }
            return new InputSource(dtdStream);
        }
        return null;
    }
}
