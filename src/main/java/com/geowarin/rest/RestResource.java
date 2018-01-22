package com.geowarin.rest;

import com.geowarin.domain.Message;
import com.geowarin.domain.MyJaxbBean;
import com.geowarin.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/")
@Component
public class RestResource {

    @Autowired
    private MessageService messageService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/hello")
    public String hello() {
        return "Hello World";
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/messages")
    public List<Message> message() {
        return messageService.getMessages();
    }

    //try
    @GET
    @Produces(MediaType.APPLICATION_XML)
    @Path("/xml")
    public String xml() {
        return "this is xml";
    }

    @GET
    @Produces(MediaType.APPLICATION_ATOM_XML)
    @Path("/atom_xml")
    public String atom_xml() {
        return "this is atom_xml";
    }

    @GET
    @Produces(MediaType.APPLICATION_FORM_URLENCODED)
    @Path("/from_urlencoded")
    public String from_urlencoded() {


        return "this is from_urlencoded";
    }

    @GET
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    @Path("/octet_stream")
    public String octet_stream() {
        return "this is octet_stream";
    }

    @GET
    @Produces(MediaType.APPLICATION_SVG_XML)
    @Path("/svg_xml")
    public String svg_xml() {
        return "svg_xml";
    }

    @GET
    @Produces(MediaType.APPLICATION_XHTML_XML)
    @Path("/xhtml_xml")
    public String xhtml_xml() {
        return messageService.getMessages().toString();
    }

    @GET
    @Produces(MediaType.MULTIPART_FORM_DATA)
    @Path("/from_data")
    public String from_data() {
        return messageService.getMessages().toString();
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/text_plain")
    public String test_plain() {
        return messageService.getMessages().toString();
    }

    @GET
    @Produces(MediaType.TEXT_XML)
    @Path("/text_xml")
    public String test_xml() {
        return messageService.getMessages().toString();
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    @Path("/text_html")
    public String text_html() {
        return messageService.getMessages().toString();
    }


    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/text_post")
    public String text_post(@PathParam("x") String x, @PathParam("y") String y) {

        System.err.println(x + " : " + y);
        return x + " : " + y;
    }

    @POST
    @Produces(MediaType.TEXT_HTML)
    @Path("/text_post1")
    public String text_html1() {
        System.err.println("hello");
        return messageService.getMessages().toString();
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/text_delete")
    public String text_delete() {
        System.err.println("hello");
        return messageService.getMessages().toString();
    }

    @OPTIONS
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/text_option")
    public String text_option(){
        return messageService.getMessages().toString();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/mybean")
    public MyJaxbBean getBean(){
        return new MyJaxbBean("wade",34);
    }

}
