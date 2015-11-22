package test.spring.boot.rest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.*;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.StreamUtils;
import org.springframework.web.client.RestTemplate;
import spring.boot.rest.common.model.DataResult;
import spring.boot.rest.demo.main.DemoRestApplication;

import java.io.ByteArrayInputStream;
import java.nio.charset.Charset;
import java.util.zip.GZIPInputStream;

import static org.junit.Assert.assertEquals;

/**
 * test
 *
 * @since: 15/11/21.
 * @author: yangjunming
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(DemoRestApplication.class)
@WebIntegrationTest(randomPort = false)
@DirtiesContext
public class DemoRestTests {


    String url = "http://localhost:8080/ping";

    @Test
    public void testPing() throws Exception {
        ResponseEntity<DataResult> entity = new TestRestTemplate()
                .getForEntity(url, DataResult.class);
        assertEquals(HttpStatus.OK, entity.getStatusCode());
        assertEquals("running", entity.getBody().getData());
    }

    @Test
    public void testCompression() throws Exception {
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.set("Accept-Encoding", "gzip");
        HttpEntity<?> requestEntity = new HttpEntity<Object>(requestHeaders);
        RestTemplate restTemplate = new TestRestTemplate();
        ResponseEntity<byte[]> entity = restTemplate.exchange(url, HttpMethod.GET, requestEntity,
                byte[].class);
        assertEquals(HttpStatus.OK, entity.getStatusCode());
        GZIPInputStream inflater = new GZIPInputStream(
                new ByteArrayInputStream(entity.getBody()));
        try {
            assertEquals("{\"data\":\"running\",\"errorCode\":null,\"errorDesc\":null,\"elapsedMilliseconds\":0,\"success\":true}",
                    StreamUtils.copyToString(inflater, Charset.forName("UTF-8")));
        } finally {
            inflater.close();
        }
    }
}
