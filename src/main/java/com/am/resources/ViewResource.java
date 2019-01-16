package com.am.resources;

import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.am.entity.Tview;
import com.am.entityfilter.MyFilter;
import com.am.entityfilter.OpCriteria;
import com.am.entityfilter.SearchCriteria;
import com.am.service.ViewService;
import com.am.util.ClassInfo;
import com.am.util.Param;

//http://localhost:8181/user/userList
@RestController
@RequestMapping("/view")
public class ViewResource {
	@Autowired
	private ViewService viewService;

	@RequestMapping(value = "/viewlist", method = RequestMethod.GET)
	@CrossOrigin
	public List<Tview> viewList() {
		return viewService.findAll();
	}

	//utilisation de la recherche par programmation à partir bu back (définir manuellement les conditions)
	@RequestMapping(value = "/viewtest", method = RequestMethod.GET)
	@CrossOrigin
	public List<Tview> viewTest() {
		MyFilter<Tview> myfilter = new MyFilter<>();
		myfilter.addCondition("enabledview",OpCriteria.equals, new Integer(1).toString());
		//myfilter.addCondition("progview", OpCriteria.like, "/prod%");
		myfilter.addCondition("nameview", OpCriteria.like, "%e%");
		

		// myfilter.addCondition(new SearchCriteria("enabledview", "and", 1));

		List<Tview> find;
		find = viewService.findAll(myfilter.getSpecification());
		return find;
	}
	
	//http://localhost:8181/view/viewtest2?search=nameview:Aaa,enabledview:0
	//utilisation de la recherche injectée dans l'url ?search=
	@RequestMapping(value = "/viewtest2", method = RequestMethod.GET)
	@CrossOrigin
	public List<Tview> viewTest2(@RequestParam(value = "search") String search) {

		MyFilter<Tview> myfilter = new MyFilter<>();
		// Pattern pattern = Pattern.compile("(\\w+?)(:|<|>)(\\w+?),");
		Pattern pattern = Pattern.compile("(\\w+?)(:|<|>)(\\w+?),", Pattern.UNICODE_CHARACTER_CLASS);
		Matcher matcher = pattern.matcher(search + ",");
		System.out.println("matcher="+matcher);
		while (matcher.find()) {
			// System.out.println("matcher.group(2)="+matcher.group(2));
			myfilter.addCondition(matcher.group(1), OpCriteria.fromString(matcher.group(2)), matcher.group(3));
			
		}

		List<Tview> find;
		find = viewService.findAll(myfilter.getSpecification());
		return find;
	}

	//utilisation de la recherche par injection d'une classe à partir du front (utiliser seulement les champs non vides)
	@RequestMapping(value = "/viewtest3", method = RequestMethod.POST)
	@ResponseBody
	@CrossOrigin
	public ResponseEntity<List<Tview>> viewTest3(@RequestBody(required=false) Tview tview,@RequestBody(required=false) List<Param> params) {
		MyFilter<Tview> myfilter = new MyFilter<>();
		
		System.out.println("Params="+params);
		List<Tview> find = viewService.findAll(myfilter.getSpecificationFromEntity(tview,OpCriteria.likeIgnoreCase));

		return new ResponseEntity<List<Tview>>(find, HttpStatus.OK);

	}

	//utilisation de la recherche par programmation à partir bu back (utiliser les condition à partir d'une classe)
	@RequestMapping(value = "/viewtest4", method = RequestMethod.GET)
	@ResponseBody
	@CrossOrigin
	public List<Tview> viewTest4() {
		MyFilter<Tview> myfilter = new MyFilter<>();
		Tview v = new Tview();
		v.setEnabledview(1);
		// v.setProgview("/product%");

		Map<String, Object> list = ClassInfo.getFieldValues(v, false);
		System.out.println("LISTLENGTH=" + list);
		if (list != null && !list.isEmpty()) {
			for (Map.Entry<String, Object> m : list.entrySet()) {
				myfilter.addCondition(m.getKey(), OpCriteria.equals, m.getValue().toString());
			}
		}
		System.out.println("ici");
		List<Tview> find;
		find = viewService.findAll(myfilter.getSpecification());
		return find;
	}

	//utilisation de la recherche par programmation à partir bu front : injection de searchCriteria
	@RequestMapping(value = "/viewtest5", method = RequestMethod.POST)
	@ResponseBody
	@CrossOrigin
	public ResponseEntity<List<Tview>> viewTest5(@RequestBody(required=false) SearchCriteria[] searchCriterias) {
		MyFilter<Tview> myfilter = new MyFilter<>();
		System.out.println("searchCriterias="+searchCriterias);
		for(SearchCriteria c:searchCriterias)
		{
			System.out.println("searchCriteria="+c.getKey()+"/"+c.getValue()+";"+c.getOperation());
		}
		if (searchCriterias != null) {
			for (SearchCriteria s:searchCriterias) {
				myfilter.addCondition(s.getKey(), s.getOperation(), s.getValue());
			}
		}

		List<Tview> find;
		
		find = viewService.findAll(myfilter.getSpecification());
		//find = viewService.findAll();

		return new ResponseEntity<List<Tview>>(find, HttpStatus.OK);

	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	@CrossOrigin
	public Tview getView(@PathVariable("id") long id) {
		return viewService.findByIdview(id);
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	@ResponseBody
	@CrossOrigin
	public Tview getView(@RequestParam("progview") String progView) {
		return viewService.findByProgview(progView);
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	@CrossOrigin
	public ResponseEntity<Tview> save(@RequestBody Tview tview) {
		Tview tviewsave = viewService.save(tview);
		return new ResponseEntity<Tview>(tviewsave, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	@CrossOrigin
	public void delete(@PathVariable("id") long id) {
		viewService.delete(id);
	}

}
