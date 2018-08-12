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

import br.com.casadascoxinhas.coxinhas.dao.ProdutoDao;
import br.com.casadascoxinhas.coxinhas.model.Produto;

/**
 * Created by Gabrioti on 12/08/2018.
 */
@Controller
public class ProdutoController {

    @Autowired
    private ProdutoDao produtoDao;


    @GetMapping({"/admin/produto", "/admin/produto/{id}"})
    public ModelAndView form(@PathVariable("id")Optional<Integer> id, Produto produto){
        ModelAndView modelAndView = new ModelAndView("produto/produto");

        if (id.isPresent()){
            produto = produtoDao.findOne(id.get());
        }

        modelAndView.addObject("produto", produto);

        return modelAndView;
    }




    @PostMapping("/admin/produto")
    @Transactional
    public ModelAndView salva(@Valid Produto produto, BindingResult result){

        if (result.hasErrors()){
            return form(Optional.ofNullable(produto.getId()) ,produto);
        }

        produtoDao.save(produto);
        return new ModelAndView("redirect:/admin/produtos");
    }

    @GetMapping("/admin/produtos")
    public ModelAndView lista(){
        ModelAndView modelAndView = new ModelAndView("produto/lista");

        modelAndView.addObject("produtos", produtoDao.findAll());

        return modelAndView;
    }


    @GetMapping("/admin/produtos/{id}/sabores")
    public ModelAndView listaSabores(@PathVariable("id") Integer id) {

        Produto produto = produtoDao.findOne(id);

        ModelAndView view = new ModelAndView("sabores/lista");
        view.addObject("produto", produto);

        return view;
    }


    @DeleteMapping("/admin/produto/{id}")
    @ResponseBody
    @Transactional
    public void delete(@PathVariable("id") Integer id){
        produtoDao.delete(id);
    }
}
