package org.mp.java.java8.example.base64;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.Optional;

public class Base64Example {

    private static final String CHAR_SET_TYPE = "utf-8";

    public static void main(String[] args) {
        basicEncodingDecoding();
        System.out.println();
        urlEncodingDecoding();
    }

    public static void basicEncodingDecoding() {
        String stringToEncode1 = "Manoj Pawar";
        String base64DecodedString = null;
        String base64EncodedString = null;
        try {
            base64EncodedString = Base64.getEncoder().encodeToString(stringToEncode1.getBytes(CHAR_SET_TYPE));
            System.out.println("Base64 basic encoded String of <" + stringToEncode1 + "> is " + base64EncodedString);

            base64DecodedString = new String(Base64.getDecoder().decode(base64EncodedString.getBytes(CHAR_SET_TYPE)));
            System.out
                    .println("Base64 basic decoded String of <" + base64EncodedString + "> is " + base64DecodedString);

        } catch (UnsupportedEncodingException e) {
            System.out.println(e);
        }

        Optional<String> decodedOptional = Optional.ofNullable(base64DecodedString);
        decodedOptional.ifPresent(value -> {
            if (value.equals(stringToEncode1)) {
                System.out.println("Base64 basic decoded value matched with source value.");
            } else {
                System.out.println("Base64 basic decoded value didn't matched with source value.");
            }
        });
    }

    public static void urlEncodingDecoding() {
        String urlToEncodeString = "http://www.mp.org?message=23";
        String encodedUrlString = null;
        String decodedUrlString = null;

        try {
            encodedUrlString = Base64.getUrlEncoder().encodeToString(urlToEncodeString.getBytes(CHAR_SET_TYPE));
            System.out.println("Base64 encoding of url " + urlToEncodeString + " is " + encodedUrlString);
            decodedUrlString = new String(Base64.getUrlDecoder().decode(encodedUrlString.getBytes(CHAR_SET_TYPE)));
            System.out.println("Base64 decoding of url " + encodedUrlString + " is " + decodedUrlString);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}

/**
--------------------------------------------------------------------
 * Output: 
--------------------------------------------------------------------
Base64 basic encoded String of <Manoj Pawar> is TWFub2ogUGF3YXI=
Base64 basic decoded String of <TWFub2ogUGF3YXI=> is Manoj Pawar
Base64 basic decoded value matched with source value.

Base64 encoding of url http://www.mp.org?message=23 is aHR0cDovL3d3dy5tcC5vcmc_bWVzc2FnZT0yMw==
Base64 decoding of url aHR0cDovL3d3dy5tcC5vcmc_bWVzc2FnZT0yMw== is http://www.mp.org?message=23 
-------------------------------------------------------------------- 
*/