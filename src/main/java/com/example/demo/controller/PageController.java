package com.example.demo.controller; //kumpulan dari class
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController { //seperti urls.py
	@RequestMapping ("/viral") //ngakses return suatu method
	public String index() {
		return "viral"; //merupakan return viral.html
	}

	/*@RequestMapping("/challenge") //?name=kiki&umur=
	public String challenge(@RequestParam(value="name",required =false,defaultValue="kiki") String name,Model model) { //ngambil dari question, search request param adalah parameter buat di cari
		model.addAttribute("name", name); //
		return "challenge";
	
	}*/
	@RequestMapping(value= {"/challenge","challenge/{name}"}) //perbedaannya adalah / langsung isi nama
	public String challengePath(@PathVariable Optional<String> name, Model model) {
		if(name.isPresent()) {
			model.addAttribute("name",name.get());
		}else {
			model.addAttribute("name","KB");
		}
		return "challenge";
		
	}
	
	@RequestMapping("/generator") //?name=kiki&umur=
	public String challenge(@RequestParam(value="a",required =false,defaultValue="0") String a,Model model, @RequestParam(value="b",required =false,defaultValue="0") String b) { //ngambil dari question, search request param adalah parameter buat di cari
		model.addAttribute("a", a);
		model.addAttribute("b", b);
		int a1 = 1;
		int b1 = 1;
		if (!a.equals("0")) {
			a1=Integer.parseInt(a);
		}if(!b.equals("0")) {
			b1=Integer.parseInt(b);
		}
		String kata ="";
		String hm = "h";
		for (int z=0;z<a1;z++) {
			hm+="m";
		}for(int y=0;y<b1;y++) {
			kata+=" "+hm;
		}
		model.addAttribute("hm",kata);
		return "generator";
	}
}