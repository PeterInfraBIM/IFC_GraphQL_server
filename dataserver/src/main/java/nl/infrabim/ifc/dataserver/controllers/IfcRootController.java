package nl.infrabim.ifc.dataserver.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nl.infrabim.ifc.dataserver.models.IfcRoot;
import nl.infrabim.ifc.dataserver.services.IfcRootService;

@RestController
public class IfcRootController {

	@Autowired
	private IfcRootService rootService;

	@RequestMapping("/roots")
	public List<IfcRoot> getAllRoots() {
		return rootService.getAllRoots();
	}

//	@RequestMapping("/roots/{id}")
//	public IfcRoot getRoot(@PathVariable String id) {
//		return rootService.getRoot(id);
//	}

}
