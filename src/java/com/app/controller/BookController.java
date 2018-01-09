/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author ss
 */
@Controller
@RequestMapping("/book")
public class BookController {

    @RequestMapping(value = "/init", method = RequestMethod.GET)
    public String init(HttpServletRequest request, HttpServletResponse response, Model model) {

        model.addAttribute("bookdao", new BookDao());
        model.addAttribute("action", "add.htm");
        model.addAttribute("mode", "add");

        request.getSession().setAttribute("body", "/books/addbooks.jsp");
        return "common";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@ModelAttribute("bookdao") BookDao beanObj, HttpServletRequest request, HttpServletResponse response, Model model) {
        try {

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/book/init.htm";
    }

    @RequestMapping(value = "/initSearch", method = RequestMethod.GET)
    public String initSearch(HttpServletRequest request, HttpServletResponse response, Model model) {
        try {
            model.addAttribute("bookdao", new BookDao());

        } catch (Exception e) {
            e.printStackTrace();
        }
        request.getSession().setAttribute("body", "/books/searchbooks.jsp");
        return "common";
    }

    @RequestMapping(value = "/initUpdate", method = RequestMethod.GET)
    public String initUpdate(HttpServletRequest request, HttpServletResponse response, Model model) {

        try {
            String recid = (String) request.getParameter("recid");
            model.addAttribute("language", new BookDao());
            model.addAttribute("action", "update.htm");
            model.addAttribute("mode", "update");
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.getSession().setAttribute("body", "/books/addbooks.jsp");
        return "common";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("bookdao") BookDao beanObj, HttpServletRequest request, HttpServletResponse response, Model model) {

        String forward = "redirect:/book/initSearch.htm";
        try {

        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("bookdao", beanObj);
            model.addAttribute("action", "update.htm");
            model.addAttribute("mode", "update");
            request.getSession().setAttribute("body", "/books/addbooks.jsp");
            forward = "common";
        }

        return forward;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(HttpServletRequest request, HttpServletResponse response, Model model) {

        try {
            String recid = (String) request.getParameter("recid");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/book/initSearch.htm";
    }
}
