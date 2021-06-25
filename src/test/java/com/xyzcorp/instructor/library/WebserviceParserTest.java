package com.xyzcorp.instructor.library;

import org.junit.jupiter.api.Test;

public class WebserviceParserTest {


    @Test
    void parseEmptyJSON() {

    }

    @Test
    void parseJsonWithTwoCountries() {
        String json = """
            {
                "AD": {
                    "currency": {
                        "primary": "EUR"
                    },
                    "iso": {
                        "code2": "AD",
                        "code3": "AND",
                        "num": "020"
                    },
                    "languages": [
                        "ca"
                    ],
                    "name": "Andorra",
                    "region": "Europe"
                },
                "AE": {
                    "currency": {
                        "primary": "AED"
                    },
                    "iso": {
                        "code2": "AE",
                        "code3": "ARE",
                        "num": "784"
                    },
                    "languages": [
                        "ar"
                    ],
                    "name": "United Arab Emirates",
                    "region": "Asia"
                }
            }
            """;
    }
}
