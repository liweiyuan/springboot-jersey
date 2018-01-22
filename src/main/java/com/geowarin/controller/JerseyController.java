package com.geowarin.controller;

import com.geowarin.domain.MyJaxbBean;
import org.glassfish.jersey.client.JerseyClientBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.*;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by tingyun on 2018/1/16.
 */
@RestController
public class JerseyController {


    @RequestMapping("/hello")
    @ResponseBody
    public String hello() {
        String baseUri = "http://localhost:8080/rest/hello";
        Client client = JerseyClientBuilder.createClient();
        WebTarget target = client.target(baseUri);
        Response response = target.request(MediaType.APPLICATION_JSON).get(Response.class);
        if (response.getStatus() == 200) {
            return "success";
        } else {
            return "failue";
        }
    }

    @RequestMapping("/message")
    public String message() {
        String baseUri = "http://localhost:8080/rest/messages";
        Client client = JerseyClientBuilder.createClient();
        WebTarget target = client.target(baseUri);
        Response response = target.request(MediaType.APPLICATION_JSON).get(Response.class);
        System.err.println(response);
        return "message";
    }

    @RequestMapping("/xml")
    public String xml() {
        String baseUri = "http://localhost:8080/rest/xml";
        Client client = JerseyClientBuilder.createClient();
        WebTarget target = client.target(baseUri);
        Response response = target.request(MediaType.APPLICATION_XML).get(Response.class);
        Object result = response.getEntity();
        System.err.println(result);
        return "xml";
    }

    @RequestMapping("atom_xml")
    public String atom_xml() {
        String baseUri = "http://localhost:8080/rest/atom_xml";
        Client client = JerseyClientBuilder.createClient();
        WebTarget target = client.target(baseUri);
        Response response = target.request(MediaType.APPLICATION_ATOM_XML).get(Response.class);
        Object result = response.getEntity();
        System.err.println(result);
        return "atom_xml";
    }

    @RequestMapping("/from_urlencoded")
    public String from_urlencoded() {
        String baseUri = "http://localhost:8080/rest/from_urlencoded";
        Client client = JerseyClientBuilder.createClient();
        WebTarget target = client.target(baseUri);
        Response response = target.request(MediaType.APPLICATION_FORM_URLENCODED).get(Response.class);
        Object result = response.getEntity();
        System.err.println(result);
        return "from_urlencoded";
    }

    @RequestMapping("/octet_stream")
    public String octet_stream() {
        String baseUri = "http://localhost:8080/rest/octet_stream";
        Client client = JerseyClientBuilder.createClient();
        WebTarget target = client.target(baseUri);
        Response response = target.request(MediaType.APPLICATION_OCTET_STREAM).get(Response.class);
        Object result = response.getEntity();
        System.err.println(result);
        return "octet_stream";
    }

    @RequestMapping("/svg_xml")
    public String svg_xml() {
        String baseUri = "http://localhost:8080/rest/svg_xml";
        Client client = JerseyClientBuilder.createClient();
        WebTarget target = client.target(baseUri);
        Response response = target.request(MediaType.APPLICATION_SVG_XML).get(Response.class);
        Object result = response.getEntity();
        System.err.println(result);
        return "String baseUri=\"http://localhost:8080/rest/octet_stream\";\n" +
                "        Client client=JerseyClientBuilder.createClient();\n" +
                "        WebTarget target=client.target(baseUri);\n" +
                "        Response response=target.request(MediaType.APPLICATION_OCTET_STREAM).get(Response.class);\n" +
                "        Object result= response.getEntity();\n" +
                "        System.err.println(result);\n" +
                "        return \"octet_stream\";";
    }

    @RequestMapping("/xhtml_xml")
    public String xhtml_xml() {
        String baseUri = "http://localhost:8080/rest/xhtml_xml";
        Client client = JerseyClientBuilder.createClient();
        WebTarget target = client.target(baseUri);
        Response response = target.request(MediaType.APPLICATION_XHTML_XML).get(Response.class);
        Object result = response.getEntity();
        System.err.println(result);
        return "xhtml_xml";
    }

    @RequestMapping("/from_data")
    public String from_data() {
        String baseUri = "http://localhost:8080/rest/from_data";
        Client client = JerseyClientBuilder.createClient();
        WebTarget target = client.target(baseUri);
        Response response = target.request(MediaType.MULTIPART_FORM_DATA).get(Response.class);
        Object result = response.getEntity();
        System.err.println(result);
        return "from_data";
    }

    @RequestMapping("/text_plain")
    public String text_plain() {
        String baseUri = "http://localhost:8080/rest/text_plain";
        Client client = JerseyClientBuilder.createClient();
        WebTarget target = client.target(baseUri);
        Response response = target.request(MediaType.TEXT_PLAIN).get(Response.class);
        Object result = response.getEntity();
        System.err.println(result);
        return "text_plain";
    }

    @RequestMapping("/text_xml")
    public String text_xml() {
        String baseUri = "http://localhost:8080/rest/text_xml";
        Client client = JerseyClientBuilder.createClient();
        WebTarget target = client.target(baseUri);
        Response response = target.request(MediaType.TEXT_XML).get(Response.class);
        Object result = response.getEntity();
        System.err.println(result);
        return "text_xml";
    }

    @RequestMapping("text_html")
    public String text_html() {
        String baseUri = "http://localhost:8080/rest/text_html";
        Client client = JerseyClientBuilder.createClient();
        WebTarget target = client.target(baseUri);
        Response response = target.request(MediaType.TEXT_HTML).get(Response.class);
        Object result = response.getEntity();
        System.err.println(result);
        return "text_html";
    }


    @RequestMapping("/text_post")
    public String text_post() {
        //String baseUri="http://localhost:8080/rest/text_html";
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:8080").path("rest").path("text_post");
        Form form = new Form();
        form.param("x", "foo");
        form.param("y", "bar");
        String result = target.request(MediaType.APPLICATION_JSON_TYPE)
                .post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED_TYPE), String.class);
        return result;
    }

    @RequestMapping("/text_post1")
    public String text_post1() throws URISyntaxException {
        Client client = ClientBuilder.newClient();
        URI uri = new URI("http://localhost:8080/rest/test_post1");
        System.out.println(uri);
        WebTarget target = client.target(uri);
        Form form = new Form();
        form.param("x", "foo");
        form.param("y", "bar");
        String result = target.request(MediaType.TEXT_XML_TYPE)
                .post(Entity.entity(form,MediaType.APPLICATION_FORM_URLENCODED_TYPE), String.class);
        return result;
    }

    @RequestMapping("/text_delete")
    public String text_delete(){
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:8080").path("rest").path("text_delete");
        String result=target.request(MediaType.APPLICATION_JSON_TYPE).delete(String.class);
        return result;
    }

    @RequestMapping("/text_option")
    public String text_option(){
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:8080").path("rest").path("text_option");
        String result=target.request(MediaType.APPLICATION_JSON_TYPE).options(String.class);
        return result;
    }


    @RequestMapping("/mybean")
    public MyJaxbBean mybean(){
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:8080").path("rest").path("mybean");
        MyJaxbBean result=target.request(MediaType.APPLICATION_JSON_TYPE).get(MyJaxbBean.class);
        return result;
    }


}
