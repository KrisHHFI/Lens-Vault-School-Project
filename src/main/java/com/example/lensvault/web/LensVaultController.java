package com.example.lensvault.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.lensvault.model.Lens;
import com.example.lensvault.model.LensRepository;
import com.example.lensvault.model.MountRepository;
import com.example.lensvault.model.PrimeOrZoomRepository;

@Controller
public class LensVaultController {
	
	@Autowired
	private LensRepository lensRepository; 
	
	@Autowired
	private PrimeOrZoomRepository primeOrZoomRepository;
	
	@Autowired
	private MountRepository mountRepository;
	
	@RequestMapping(value = "/home")
    public String home(Model model, Long lensId){
		model.addAttribute("lenses", lensRepository.findAll());
		model.addAttribute("lensCount", lensRepository.count());
		// Finds the largest aperture
		Double largestAperture = 100.00;
		String stringLargestAperture = "";
		for (Lens lens : lensRepository.findAll()) {
			if (lens.getLargestAperture() < largestAperture) {
				largestAperture = lens.getLargestAperture();
			}
			stringLargestAperture = largestAperture + "";
		}
		if (largestAperture == 100.00) {
			stringLargestAperture = "N/A";
		}
		model.addAttribute("largestAperture", stringLargestAperture);
		// Finds the widest focal length
		Double widestFocalLength = 100000.00;
		for (Lens lens : lensRepository.findAll()) {
			if (lens.getFocalLength() < widestFocalLength) {
				widestFocalLength = lens.getFocalLength();
			}
		}
		String stringWidestFocalLength = widestFocalLength + "";
		String[] textParts = stringWidestFocalLength.split("\\.");
		if (textParts[0].equals("100000")) {
			textParts[0] = "N/A ";
		}
		model.addAttribute("widestFocalLength", textParts[0]);
		// Finds the most narrow focal length
		Double mostNarrowFocalLength = 0.00;
		for (Lens lens : lensRepository.findAll()) {
			if (lens.getFocalLength() > mostNarrowFocalLength) {
				mostNarrowFocalLength = lens.getFocalLength();
			}
		}
		String stringMostNarrowFocalLength = mostNarrowFocalLength + "";
		String[] textParts2 = stringMostNarrowFocalLength.split("\\.");
		if (textParts2[0].equals("0")) {
			textParts2[0] = "N/A ";
		}
		model.addAttribute("mostNarrowFocalLength", textParts2[0]);
        return "home";
    }     
	
	// Returns all the lenses to the HTML page
	@RequestMapping(value= {"/", "/inventory"})
	public String detailedLensList(Model model) {
		model.addAttribute("lenses", lensRepository.findAll());
		model.addAttribute("lensCount", lensRepository.count());
		return "inventory";
	}
	
	// Deletes specific lenses, which are selected from table row
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteLens(@PathVariable("id") Long lensId, Model model) {
		lensRepository.deleteById(lensId);
        return "redirect:../inventory";
    }    
	
	// Add Lens (Part 1)
	@RequestMapping(value = "/add")
    public String addLens(Model model, Model model2){
    	model.addAttribute("newLens", new Lens());
    	model.addAttribute("primeOrZoomRepositoryCategories", primeOrZoomRepository.findAll());
    	model2.addAttribute("mountCategories", mountRepository.findAll());
        return "addlens";
    }     
	
	// Add Lens (Part 2, inputs from addlens.html, then redirects back to home.html)
	@RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Lens lens){
		lensRepository.save(lens);
        return "redirect:/inventory";
    }    
	
	//Currently crashes if no number values inputted
	// Edit Lens
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editLens(@PathVariable("id") Long lensId, Model model1, Model model2) {
    	Optional<Lens> optional1 = lensRepository.findById(lensId);
        model1.addAttribute("primeOrZoomRepositoryCategories", primeOrZoomRepository.findAll());
        model2.addAttribute("mountCategories", mountRepository.findAll());
    	model1.addAttribute("editedLens", optional1);
        return "editlens";
    } 
}
// URL views ---------------------------------------------------------------
//Browser url: localhost:8080/home

// For H2 console
// Url: localhost:8080/h2-console
// JDBC url field= jdbc:h2:mem:testdb