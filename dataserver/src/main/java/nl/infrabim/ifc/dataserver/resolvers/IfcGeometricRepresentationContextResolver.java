package nl.infrabim.ifc.dataserver.resolvers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLResolver;

import nl.infrabim.ifc.dataserver.models.IfcArbitraryClosedProfileDef;
import nl.infrabim.ifc.dataserver.models.IfcExtrudedAreaSolid;
import nl.infrabim.ifc.dataserver.models.IfcGeometricRepresentationContext;
import nl.infrabim.ifc.dataserver.models.IfcPolyline;
import nl.infrabim.ifc.dataserver.models.IfcProfileDef;
import nl.infrabim.ifc.dataserver.models.IfcRepresentationItem;
import nl.infrabim.ifc.dataserver.models.IfcShapeRepresentation;
import nl.infrabim.ifc.dataserver.models.Ref;
import nl.infrabim.ifc.dataserver.services.IfcShapeRepresentationService;

@Component
public class IfcGeometricRepresentationContextResolver implements GraphQLResolver<IfcGeometricRepresentationContext> {
	@Autowired
	private IfcShapeRepresentationService shapeRepresentationService;

	public List<IfcShapeRepresentation> getRepresentationsInContext(
			IfcGeometricRepresentationContext geometricRepresentationContext) {
		List<IfcShapeRepresentation> representations = null;
		List<Ref> representationsRef = geometricRepresentationContext.getRepresentationsInContextRef();
		for (Ref ref : representationsRef) {
			if (representations == null) {
				representations = new ArrayList<>();
			}
			IfcShapeRepresentation shapeRepresentation = shapeRepresentationService
					.getOneShapeRepresentation(ref.getRef());
			List<IfcRepresentationItem> returnedItems = new ArrayList<>();
			for (IfcRepresentationItem item : shapeRepresentation.getItems()) {
				switch (item.getType()) {
				case "IfcPolyline":
					IfcPolyline polyline = new IfcPolyline("IfcPolyline");
					polyline.setPoints(item.getPoints());
					returnedItems.add(polyline);
					break;
				case "IfcExtrudedAreaSolid":
					IfcExtrudedAreaSolid extrudedAreaSolid = new IfcExtrudedAreaSolid("IfcExtrudedAreaSolid");
					extrudedAreaSolid.setExtrudedDirection(item.getExtrudedDirection());
					extrudedAreaSolid.setDepth(item.getDepth());
					extrudedAreaSolid.setPosition(item.getPosition());
					IfcProfileDef sweptArea = item.getSweptArea();
					if (sweptArea.getType().equals("IfcArbitraryClosedProfileDef")) {
						IfcArbitraryClosedProfileDef arbitraryClosedProfileDef = new IfcArbitraryClosedProfileDef();
						arbitraryClosedProfileDef.setType("IfcArbitraryClosedProfileDef");
						arbitraryClosedProfileDef.setProfileType(sweptArea.getProfileType());
						arbitraryClosedProfileDef.setOuterCurve(sweptArea.getOuterCurve());
						extrudedAreaSolid.setSweptArea(arbitraryClosedProfileDef);
					} else {
						extrudedAreaSolid.setSweptArea(item.getSweptArea());
					}
					returnedItems.add(extrudedAreaSolid);
					break;
				}
			}
			shapeRepresentation.setItems(returnedItems);
			representations.add(shapeRepresentation);
		}
		return representations;
	}

}
