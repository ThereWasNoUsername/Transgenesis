package designType;

import designType.subElements.DataElements;
import designType.subElements.Event;
import designType.subElements.Events;
import designType.subElements.Language;
import designType.subElements.SubElementFactory;
import designType.subElements.SubElementFactory.AdventureDescElements;
import designType.subElements.SubElementFactory.DisplayAttributesElements;
import designType.subElements.SubElementFactory.DisplayElements;
import designType.subElements.SubElementFactory.DockScreensElements;
import designType.subElements.SubElementFactory.ItemGeneratorElements;
import designType.subElements.SubElementFactory.ShipGeneratorElements;
import designType.subElements.SubElementFactory.SovereignElements;
import designType.subElements.SubElementFactory.SystemCriteria;
import designType.subElements.SubElementFactory.SystemGroupElements;
import xml.DesignAttribute;
import xml.DesignAttribute.ValueType;
import xml.DesignElement;
import static xml.DesignAttribute.ValueType.*;
import static designType.AttributeFactory.addDeviceContent;
import static xml.DesignAttribute.*;
import static xml.DesignElement.*;
public final class TypeFactory {
	//\#define ([A-Z]*_*)*\s+CONSTLIT\(\"(.+)\"\)
	public static DesignElement createDesignType(Types t) {
		DesignElement e = new Type(t.name());
		e.addAttributes(AttributeFactory.createAttributesForType(t));
		e.addOptionalSingleSubElements(
				TypeFactory.createSubElementsForType(t)
				);
		switch(t) {
		case StationType:
			System.out.println("Replace ValueType for each attribute with the correct one.");
			//<Image>
			//new Attribute("shipwreckID", ValueType.STRING),
			//<Construction>
			//new Attribute("maxConstruction", ValueType.INTEGER),
			break;
		}
		
		e.addAttributes(
				att("UNID", ValueType.UNID),
				att("attributes", ValueType.STRING),
				att("inherit", ValueType.TYPE_INHERITED),
				att("extends", ValueType.STRING)
				);
		DesignElement communications = new DesignElement("Communications");
		communications.addOptionalMultipleSubElements(
				() -> {
					DesignElement message = new DesignElement("Message");
					message.addAttributes(
							att("id", STRING),
							att("name", STRING),
							att("key", CHARACTER)
							);
					message.addOptionalSingleSubElements(
							ele("OnShow"),
							ele("Invoke")
							);
					return message;
				}
				);
		DesignElement dockScreens = new DesignElement("DockScreens");
		dockScreens.addOptionalMultipleSubElements(DockScreensElements.DockScreen_Named);
		DesignElement displayAttributes = new DesignElement("DisplayAttributes");
		displayAttributes.addOptionalMultipleSubElements(DisplayAttributesElements.ItemAttribute);
		DesignElement attributeDesc = new DesignElement("AttributeDesc");
		attributeDesc.addOptionalMultipleSubElements(DisplayAttributesElements.ItemAttribute);
		e.addOptionalSingleSubElements(
				communications,
				DataElements.StaticData.get(),
				DataElements.GlobalData.get(),
				Language.createLanguage(t),
				Events.createEvents(t),
				dockScreens,
				displayAttributes,
				attributeDesc
				);
		
		return e;
	}

	public static DesignElement[] createSubElementsForType(Types t) {
		switch(t) {
		case AdventureDesc:
			DesignElement encounterOverrides = new DesignElement("EncounterOverrides");
			encounterOverrides.addOptionalMultipleSubElements(AdventureDescElements.EncounterOverrides);
			DesignElement constants = new DesignElement("Constants");
			constants.addOptionalMultipleSubElements(
					AdventureDescElements.ArmorDamageAdj,
					AdventureDescElements.ShieldDamageAdj
					);
			return new DesignElement[] {
					encounterOverrides, constants
			}
			;
		case DockScreen:
			DesignElement listOptions = new DesignElement("ListOptions");
			DesignElement list = new DesignElement("List");
			for(DesignElement e : new DesignElement[] {listOptions, list}) {
				e.addAttributes(
						att("dataFrom", ValueType.DOCKSCREEN_DATA_FROM),
						att("criteria", STRING),
						att("list", STRING),
						att("initialItem", STRING),
						att("rowHeight", WHOLE),
						att("noArmorSpeedDisplay", BOOLEAN),
						att("slotName", STRING),
						att("noEmptySlots", BOOLEAN),
						att("posX", INTEGER),
						att("posY", INTEGER),
						att("width", WHOLE),
						att("height", WHOLE)
						);
			}
			Event onScreenInit = new Event("OnScreenInit");
			Event onInit = new Event("OnInit");
			Event initialPane = new Event("InitialPane");
			Event onScreenUpdate = new Event("OnScreenUpdate");
			DesignElement display = new DesignElement("Display");
			display.addAttributes(
					att("display", STRING),
					att("animate", STRING),
					att("type", DOCKSCREEN_TYPE),
					att("dataFrom", DOCKSCREEN_DATA_FROM)
					);
			display.addOptionalSingleSubElements(
					new Event("OnDisplayInit")
					);
			display.addOptionalMultipleSubElements(
					DisplayElements.values()
					);
			DesignElement canvas = new DesignElement("Canvas");
			canvas.addAttributes(
					att("left", INTEGER),
					att("right", INTEGER),
					att("top", INTEGER),
					att("bottom", INTEGER)
					);
			//WIP
			DesignElement panes = new DesignElement("Panes");
			panes.addOptionalMultipleSubElements(DockScreensElements.Pane_Named);
			return new DesignElement[] {
				listOptions, list, onScreenInit, onInit, initialPane, onScreenUpdate, display, canvas, panes
			};
		case EconomyType:			break;
		case EffectType:			break;
		case Image:					break;
		case ItemTable:				break;
		case ItemType:
			DesignElement
			armor = new DesignElement("Armor"),
			autoDefenseDevice = new DesignElement("AutoDefenseDevice"),
			cargoHoldDevice = new DesignElement("CargoHoldDevice"),
			components = new DesignElement("Components"),
			cyberDeckDevice = new DesignElement("CyberDeckDevice"),
			driveDevice = new DesignElement("DriveDevice"),
			enhancerDevice = new DesignElement("EnhancerDevice"),
			image = new DesignElement("Image"),
			initialData = DataElements.InitialData.get(),
			invoke = new DesignElement("Invoke"),
			miscellaneousDevice = new DesignElement("MiscellaneousDevice"),
			missile = new DesignElement("Missile"),
			names = new DesignElement("Names"),
			reactorDevice = new DesignElement("ReactorDevice"),
			repairerDevice = new DesignElement("RepairerDevice"),
			shields = new DesignElement("Shields"),
			solarDevice = new DesignElement("SolarDevice"),
			weapon = new DesignElement("Weapon");
			armor.addAttributes(
					att("blindingDamageAdj", WHOLE),
					att("blindingImmune", BOOLEAN),
					att("chargeDecay", WHOLE),
					att("chargeRegen", WHOLE),
					att("completeBonus", WHOLE),
					att("damageAdjLevel", INTEGER_SEQUENCE),
					att("decay", WHOLE),
					att("decayRate", WHOLE),
					att("deviceCriteria", STRING),
					att("deviceDamageAdj", WHOLE),
					att("deviceDamageImmune", BOOLEAN),
					att("deviceHPBonus", WHOLE),
					att("distribute", WHOLE),
					att("disintegrationImmune", BOOLEAN),
					att("enhancementType", HEX_NUMBER),
					att("EMPDamageAdj", WHOLE),
					att("EMPImmune", BOOLEAN),
					att("idlePowerUse", WHOLE),
					att("installCost", WHOLE),
					att("installCostAdj", WHOLE),
					att("maxHPBonus", WHOLE),
					att("maxSpeedBonus", WHOLE),
					att("photoRecharge", BOOLEAN),
					att("photoRepair", BOOLEAN),
					att("powerUse", WHOLE),
					att("radiationImmune", BOOLEAN),
					att("reflect", STRING),
					att("regen", WHOLE),
					att("repairCost", WHOLE),
					att("repairCostAdj", WHOLE),
					att("repairRate", WHOLE),
					att("repairTech", WHOLE),
					att("shatterImmune", BOOLEAN),
					att("shieldInterference", BOOLEAN),
					att("stealth", WHOLE),
					//att("unid", ),
					att("useHealerToRegen", BOOLEAN)
					);
			autoDefenseDevice.addAttributes(
					att("fireRate", WHOLE),
					att("weapon", TYPE_WEAPON),
					att("interceptRange", WHOLE),
					att("targetCriteria", STRING),
					att("target", STRING, "missiles")
					);
			cargoHoldDevice.addAttributes(
					att("cargoSpace", INTEGER)
					);
			components.addOptionalMultipleSubElements(
					ItemGeneratorElements.values()
					);
			cyberDeckDevice.addAttributes(
					att("range", WHOLE),
					att("attackChance", WHOLE),
					att("aiLevel", WHOLE),
					att("program", PROGRAM),
					att("programName", STRING)
					);
			driveDevice.addAttributes(
					att("maxSpeed", WHOLE),
					att("maxSpeedInc", WHOLE),
					att("powerUse", WHOLE),
					att("thrust", DECIMAL),
					att("inertialessDrive", BOOLEAN),
					att("rotationAccel", DECIMAL),
					att("rotationStopAccel", DECIMAL),
					att("maxRotationRate", DECIMAL)
					);
			enhancerDevice.addAttributes(
					att("activateAdj", WHOLE),
					att("criteria", STRING),
					att("hpBonus", WHOLE),
					att("minActivateDelay", INTEGER),
					att("maxActivateDelay", INTEGER),
					att("damageAdj", INTEGER_SEQUENCE),
					att("powerUse", WHOLE)
					);
			image.addAttributes(SubElementFactory.createImageDescAttributes());
			
			invoke.addAttributes(
					att("key", CHARACTER),
					att("installedOnly", BOOLEAN),
					att("uninstalledOnly", BOOLEAN),
					att("enabledOnly", BOOLEAN),
					att("completeArmorOnly", BOOLEAN),
					att("asArmorSet", BOOLEAN)
					);
			miscellaneousDevice.addAttributes(
					att("powerUse", WHOLE),
					att("powerToActivate", WHOLE),
					att("capacitorPowerUse", WHOLE),
					att("powerRating", WHOLE)
					);
			missile.addAttributes(att("W.I.P.", STRING));
			reactorDevice.addAttributes(
					att("fuelCapacity", WHOLE),
					att("fuelCriteria", STRING),
					att("maxFuel", WHOLE),
					att("maxFuelTech", WHOLE),
					att("minFuelTech", WHOLE),
					att("maxPower", WHOLE),
					att("maxPowerBonusPerCharge", WHOLE),
					att("noFuel", BOOLEAN),
					att("reactorEfficiency", WHOLE),
					att("reactorPower", WHOLE)
					);
			shields.addAttributes(
					att("absorbAdj", WHOLE),
					att("armorShield", WHOLE),
					att("damageAdj", STRING),
					att("damageAdjLevel", STRING),
					att("depletionDelay", WHOLE),
					att("hitEffect", TYPE_EFFECT),
					att("hitPoints", WHOLE),
					att("idlePowerUse", WHOLE),
					att("hasNonRegenHP", BOOLEAN),
					att("hpBonus", WHOLE),
					att("HPBonusPerCharge", WHOLE),
					att("maxCharges", WHOLE),
					att("powerBonusPerCharge", WHOLE),
					att("powerUse", WHOLE),
					att("reflect", STRING),
					att("regen", WHOLE),
					att("regenHP", WHOLE),
					att("regenHPBonusPerCharge", WHOLE),
					att("regenTime", WHOLE),
					att("weaponSuppress", STRING),
					att("maxHPBonus", WHOLE)
					);
			solarDevice.addAttributes(
					att("refuel", WHOLE),
					att("powerGen", WHOLE)
					);
			weapon.addAttributes();
			//WIP: Add device-specific events
			components.addOptionalMultipleSubElements(ItemGeneratorElements.values());
			//WIP
			
			
			for(DesignElement e : new DesignElement[] {
					autoDefenseDevice,
					cargoHoldDevice,
					cyberDeckDevice,
					driveDevice,
					enhancerDevice,
					miscellaneousDevice,
					reactorDevice,
					repairerDevice,
					shields,
					solarDevice,
					weapon
			}) {
				addDeviceContent(e);
			}
			
			//Add Armor, Devices, etc
			return new DesignElement[] {
					armor,
					autoDefenseDevice,
					cargoHoldDevice,
					components,
					cyberDeckDevice,
					driveDevice,
					enhancerDevice,
					image,
					initialData,
					invoke,
					miscellaneousDevice,
					missile,
					names,
					reactorDevice,
					repairerDevice,
					shields,
					solarDevice,
					weapon
			};
		case MissionType:			break;
		case NameGenerator:			break;
		case OverlayType:
			DesignElement effect = new DesignElement(SubElementFactory.createEffects(), "Effect");
			DesignElement hitEffect = new DesignElement(SubElementFactory.createEffects(), "HitEffect");
			DesignElement effectWhenHit = new DesignElement(SubElementFactory.createEffects(), "EffectWhenHit");
			effectWhenHit.addAttributes(att("altEffect", BOOLEAN));
			DesignElement counter = new DesignElement("Counter");
			counter.addAttributes(
					att("style", ValueType.OVERLAY_COUNTER_STTYLE),
					att("label", STRING),
					att("max", WHOLE),
					att("color", HEX_COLOR),
					att("showOnMap", BOOLEAN)
					);
			return new DesignElement[] {
				effect, hitEffect, effectWhenHit, counter
			};
		case Power:
			return new DesignElement[] {
					new DesignElement("OnShow"),
					new DesignElement("OnInvokedByPlayer"),
					new DesignElement("OnInvoke"),
					new DesignElement("OnDestroyCheck")	
			};
		case ShipClass:				break;
		case ShipTable:				break;
		case Sound:					break;
		case Sovereign:
			DesignElement relationships = new DesignElement("Relationships");
				relationships.addOptionalMultipleSubElements(SovereignElements.Relationship);
			return new DesignElement[] {
					relationships
			};
		case SpaceEnvironmentType:
			image = ele("Image");
			DesignElement edgeMask = ele("EdgeMask");
			image.addAttributes(SubElementFactory.createImageDescAttributes());
			edgeMask.addAttributes(SubElementFactory.createImageDescAttributes());
			return new DesignElement[] {
					image, edgeMask
			};
		case StationType:
			DesignElement animations = ele("Animations");
				animations.addOptionalMultipleSubElements(() -> {
					DesignElement animation = new DesignElement("Animation");
					animation.addAttributes(att("x", INTEGER), att("y", INTEGER));
					animation.addAttributes(SubElementFactory.createImageDescAttributes());
					return animation;
				});
			
			DesignElement construction = ele("Construction");
				construction.addAttributes(
						att("constructionRate", WHOLE),
						att("maxConstruction", WHOLE)
						);
				construction.addOptionalMultipleSubElements(ShipGeneratorElements.values());
			
			//WIP
			DesignElement encounterGroup = ele("EncounterGroup");
			DesignElement encounterType = ele("EncounterType");
			
			DesignElement encounter = ele("Encounter");
				encounter.addAttributes(
						att("enemyExclusionRadius", WHOLE),
						att("exclusionRadius", WHOLE),
						att("levelFrequency", LEVEL_FREQUENCY),
						att("locationCriteria", STRING),
						att("maxAppearing", WHOLE),
						att("minAppearing", WHOLE),
						att("systemCriteria", STRING),
						att("unique", UNIQUE)
						);
				DesignElement criteria = new DesignElement("Criteria");
				criteria.addOptionalMultipleSubElements(
						SystemCriteria.values()
						);
				encounter.addOptionalSingleSubElements(
						criteria
						);
			DesignElement encounters = ele("Encounters");
				encounters.addAttributes(att("frequency", FREQUENCY));
				encounters.addOptionalMultipleSubElements(ShipGeneratorElements.values());
				
			//Image
				//shipwreckid
			//WIP
			DesignElement imageComposite = ele("ImageComposite");
			DesignElement imageEffect = ele("ImageEffect");
			DesignElement imageLookup = ele("ImageLookup");
			DesignElement imageVariants = ele("ImageVariants");
			
			DesignElement reinforcements = ele("Reinforcements");
				reinforcements.addAttributes(
						att("minShips", DICE_RANGE),
						att("buildReinforcements", BOOLEAN)
						);
				reinforcements.addOptionalMultipleSubElements(ShipGeneratorElements.values());
			
			DesignElement satellites = ele("Satellites");
				satellites.addAttributes(
						att("overlapCheck", SATELLITE_OVERLAP_CHECK)
						);
				satellites.addOptionalMultipleSubElements(SystemGroupElements.values());
			
			DesignElement ships = ele("Ships");
				ships.addAttributes(
						att("challenge", DICE_RANGE),
						att("standingCount", DICE_RANGE),
						att("minShips", DICE_RANGE),
						att("buildReinforcements", BOOLEAN)
						);
			return new DesignElement[] {
					animations,
					construction,
					encounterGroup,
					encounterType,
					encounter,
					encounters,
					imageComposite,
					imageEffect,
					imageLookup,
					imageVariants,
					reinforcements,
					satellites,
					ships
			};
		case SystemMap:				break;
		case SystemTable:			break;
		case SystemType:			break;
		case TemplateType:			break;
		case Type:					break;
		default:					break;
		}
		return new DesignElement[] {
		};
	}
}
