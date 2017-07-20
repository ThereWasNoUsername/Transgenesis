package designType;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import xml.DesignAttribute;
import xml.DesignAttribute.ValueType;
import xml.DesignElementOld;
import static xml.DesignAttribute.ValueType.*;
import static xml.DesignAttribute.*;

public class AttributeFactory {
	public static DesignAttribute[] createAttributesForType(Types t) {
		DesignAttribute[] result = null;
		switch(t) {
		case AdventureDesc:
			return new DesignAttribute[] {
					att("adventureUNID", UNID),
					att("backgroundID", TYPE_IMAGE),
					att("desc", STRING),
					att("include10StartingShips", BOOLEAN),
					att("name", STRING),
					att("startingMap", TYPE_SYSTEM_MAP),
					att("startingPos", STRING),
					att("startingShipCriteria", STRING),
					att("startingSystem", STRING),
					att("welcomeMessage", STRING)
			};
		case DockScreen:
			return new DesignAttribute[] {
				att("name", STRING),
				att("desc", STRING),
				att("type", DOCKSCREEN_TYPE),
				att("backgroundID", ValueType.DOCKSCREEN_BACKGROUND_ID),
				att("nestedScreen", BOOLEAN),
			};
		case EconomyType:
			return new DesignAttribute[] {
					att("id", STRING),
					att("currency", STRING),
					att("conversion", INTEGER)	
			};
		case EffectType:
			break;
		case Image:
			return new DesignAttribute[] {
					att("backColor", HEX_COLOR),
					att("bitmap", FILENAME),
					att("bitmask", FILENAME),
					att("hitMask", FILENAME),
					att("loadOnUse", BOOLEAN),
					att("noPM", BOOLEAN),
					att("shadowMask", FILENAME),
					att("sprite", BOOLEAN)
			};
		case ItemTable:
			break;
		case ItemType:
			return new DesignAttribute[] {
					att("ammoCharges", BOOLEAN),
					att("charges", WHOLE),
					att("data", STRING),
					att("enhancement", STRING),
					att("frequency", FREQUENCY),
					att("level", WHOLE),
					att("massBonusPerCharge", WHOLE),
					att("name", STRING),
					att("noSaleIfUsed", BOOLEAN),
					att("numberAppearing", WHOLE),
					att("pluralName", STRING),
					att("randomDamaged", BOOLEAN),
					att("reverseArticle", BOOLEAN),
					att("secondPlural", BOOLEAN),
					att("showReference", BOOLEAN),
					att("sortName", STRING),
					att("unknownType", TYPE_ITEM),
					att("useAsArmorSet", BOOLEAN),
					att("useCompleteArmorOnly", BOOLEAN),
					att("useEnabledOnly", BOOLEAN),
					att("useInstalledOnly", BOOLEAN),
					att("useKey", CHARACTER),
					att("useScreen", ValueType.TYPE_DOCKSCREEN),
					att("useUninstalledOnly", BOOLEAN),
					att("value", WHOLE),
					att("valueBonusPerCharge", WHOLE),
					att("valueCharges", BOOLEAN),
					att("virtual", BOOLEAN),
			};
		case MissionType:
			return new DesignAttribute[] {
					att("allowPlayerDelete", BOOLEAN, "false"),
					att("debriefAfterOutOfSystem", BOOLEAN, "false"),
					att("expireTime", INTEGER),
					att("failureAfterOutOfSystem", BOOLEAN, "false"),
					att("forceUndockAfterDebrief", BOOLEAN, "false"),
					att("level", WHOLE),
					att("maxAppearing", WHOLE),
					att("name", STRING),
					att("noDebrief", BOOLEAN, "false"),
					att("noDecline", BOOLEAN, "false"),
					att("noFailureOnOwnerDestroyed", BOOLEAN, "false"),
					att("noStats", BOOLEAN, "false"),
					att("priority", WHOLE, "1")
			};
		case NameGenerator:
			break;
		case OverlayType:
			return new DesignAttribute[] {
					att("ignoreSourceRotation", BOOLEAN),
					att("absorbAdj", INTEGER_SEQUENCE),
					att("weaponBonusAdj", INTEGER_SEQUENCE),
					att("weaponSuppress", STRING),
					att("shieldOverlay", BOOLEAN),
					att("disarm", BOOLEAN),
					att("paralyze", BOOLEAN),
					att("disableShipScreen", BOOLEAN),
					att("spin", BOOLEAN),
					att("drag", WHOLE)
			};
		case Power:
			return new DesignAttribute[] {
					att("name", STRING, ""),
					att("key", CHARACTER, "")	
			};
		case ShipClass:
			break;
		case ShipTable:
			break;
		case Sound:
			return new DesignAttribute[] {
					att("filename", FILENAME)	
			};
		case Sovereign:
			return new DesignAttribute[] {
					att("name", STRING),
					att("shortName", STRING),
					att("adjective", STRING),
					att("demonym", STRING),
					att("plural", STRING),
					att("alignment", ALIGNMENT)
			};
		case SpaceEnvironmentType:
			return new DesignAttribute[] {
					att("autoEdges", BOOLEAN),
					att("dragFactor", WHOLE),
					att("lrsJammer", BOOLEAN, "false"),
					att("mapColor", HEX_COLOR),
					att("opacity", WHOLE),
					att("shieldJammer", BOOLEAN, "false"),
					att("srsJammer", BOOLEAN, "false")
			};
		case StationType:
			return new DesignAttribute[] {
					att("abandonedScreen", DOCKSCREEN_LOCAL_OR_TYPE),
					att("alertWhenAttacked", BOOLEAN),
					att("alertWhenDestroyed", BOOLEAN),
					att("allowEnemyDocking", BOOLEAN),
					att("armorID", TYPE_ARMOR),
					att("backgroundPlane", STRING),
					att("barrierEffect", STRING),
					att("beacon", STRING),
					
					att("canAttack", BOOLEAN),
					att("chance", STRING),
					att("constructionRate", WHOLE),
					att("controllingSovereign", TYPE_SOVEREIGN),
					att("count", WHOLE),
					att("defaultBackgroundID", STRING),
					att("destEntryPoint	", STRING),
					att("destNodeID", STRING),
					att("destroyWhenEmpty", BOOLEAN),
					att("dockScreen", DOCKSCREEN_LOCAL_OR_TYPE),
					att("dockingPorts", WHOLE),
					att("enemyExclusionRadius", WHOLE),
					att("ejectaAdj", INTEGER),
					att("ejectaType", TYPE_WEAPON),
					att("explosionType", TYPE_WEAPON),
					att("fireRateAdj", INTEGER),
					att("frequency", FREQUENCY),
					att("gateEffect", TYPE_EFFECT),
					att("gravityRadius", WHOLE),
					att("hitPoints", WHOLE),
					att("immutable", BOOLEAN),
					att("inactive", BOOLEAN),
					att("level", WHOLE),
					att("levelFrequency", LEVEL_FREQUENCY),
					att("locationCriteria", STRING),
					att("mass", WHOLE),
					
					att("maxHitPoints", WHOLE),
					att("maxLightRadius", WHOLE),
					att("maxStructuralHitPoints", WHOLE),
					att("minShips", WHOLE),
					att("mobile", BOOLEAN),
					att("multiHull", BOOLEAN),
					att("name", STRING),
					att("noBlacklist", BOOLEAN),
					att("noFriendlyFire", BOOLEAN),
					att("noFriendlyTarget", BOOLEAN),
					att("noMapDetails", BOOLEAN),
					att("noMapIcon", BOOLEAN),
					att("noMapLabel", BOOLEAN),
					att("paintLayer", STRING),
					att("radioactive", BOOLEAN),
					att("randomEncounters", FREQUENCY),
					att("regen", WHOLE),
					att("repairRate", WHOLE),
					att("reverseArticle", BOOLEAN),
					att("scale", SCALE_SIZE),
					att("shipEncounter", BOOLEAN),
					att("shipRegen", WHOLE),
					att("shipRepairRate", WHOLE),
					att("sign", BOOLEAN),
					att("size", WHOLE),
					att("sovereign", TYPE_SOVEREIGN),
					att("spaceColor", STRING),
					att("stealth", WHOLE),
					att("structuralHitPoints", STRING),
					att("timeStopImmune", BOOLEAN),
					att("UNID", UNID),
					att("unique", UNIQUE),
					att("virtual", BOOLEAN),
					att("barrier", BOOLEAN),
					att("x", INTEGER),
					att("y", INTEGER),

					att("largeDamageImageID", TYPE_IMAGE),
					att("largeDamageWidth", INTEGER),
					att("largeDamageHeight", INTEGER),
					att("largeDamageCount", INTEGER),
					att("mediumDamageImageID", TYPE_IMAGE),
					att("mediumDamageWidth", INTEGER),
					att("mediumDamageHeight", INTEGER),
					att("mediumDamageCount", INTEGER)	
			};
		case SystemMap:
			break;
		case SystemTable:
			break;
		case SystemType:
			return new DesignAttribute[] {
					att("backgroundID", TYPE_IMAGE),
					att("noExtraEncounters", BOOLEAN),
					att("noRandomEncounters", BOOLEAN),
					att("spaceScale", INTEGER),
					att("spaceEnvironmentTileSize", TILE_SIZE),
					att("timeScale", INTEGER)
			};
		case TemplateType:
			break;
		case Type:
			break;
		default:
		
		}
		return new DesignAttribute[] {};
	}
	public static void addDeviceContent(DesignElementOld e) {
		e.addAttributes(
				att("deviceSlots", WHOLE),
				att("category", CATEGORY_DEVICE),
				att("deviceSlotCategory", CATEGORY_DEVICE),
				att("overlayType", TYPE_OVERLAY),
				att("maxHPBonus", WHOLE),
				att("external", BOOLEAN)
		);
		e.addOptionalMultipleSubElements(
				() -> {
					DesignElementOld enhanceAbilities = new DesignElementOld("EnhanceAbilities");
					enhanceAbilities.addAttributes(
							att("criteria", STRING),
							att("type", STRING),
							att("enhancement", STRING)
							);
					return enhanceAbilities;
				}
		);
	}
}
