package br.com.casadascoxinhas.coxinhas.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.com.casadascoxinhas.coxinhas.dao.PedidoDao;
import br.com.casadascoxinhas.coxinhas.model.Pedido;

/**
 * Created by Gabrioti on 12/08/2018.
 */
@Controller
public class PedidoController {


    @Autowired
    private PedidoDao PedidoDao;


    @GetMapping({"/admin/pedido", "/admin/pedido/{id}"})
    public ModelAndView form(@PathVariable("id") Optional<Integer> id, Pedido pedido){

        ModelAndView modelAndView = new ModelAndView("pedido/pedido");

        if (id.isPresent()){
            pedido = PedidoDao.findOne(id.get());
        }

        modelAndView.addObject("pedido", pedido);

        return modelAndView;
    }


    @PostMapping("/admin/pedido")
    @Transactional
    public ModelAndView salva(@Valid Pedido pedido, BindingResult result){

        if (result.hasErrors()) {
            return form(Optional.ofNullable(pedido.getId()), pedido);
        }

        PedidoDao.save(pedido);

        ModelAndView view = new ModelAndView("redirect:/admin/pedido");

        return view;
    }


    @GetMapping(value="/admin/pedido")
    public ModelAndView lista(){

        ModelAndView modelAndView = new ModelAndView("pedido/lista");

        modelAndView.addObject("pedido", PedidoDao.findAll());

        return modelAndView;
    }


    @DeleteMapping("/admin/pedido/{id}")
    @ResponseBody
    @Transactional
    public void delete(@PathVariable("id") Integer id){
        PedidoDao.delete(id);
    }

}
