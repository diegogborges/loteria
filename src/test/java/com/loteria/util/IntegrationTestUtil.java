package com.loteria.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class IntegrationTestUtil {

    public static String fromJsonPath(final String jsonPath) throws IOException {
        return IOUtils.resourceToString(jsonPath, StandardCharsets.UTF_8);
    }
}
