package designType.subElements;
import designType.TypeFactory;
import designType.Types;
import designType.subElements.SubElementFactory.SystemGroupElements;
import xml.DesignAttribute;
import xml.DesignElement;
import xml.RenameableElement;
import xml.DesignAttribute.ValueType;
import static xml.DesignAttribute.ValueType.*;
import static xml.DesignAttribute.*;
public class SubElementFactory {
	public enum SystemGroupElements implements ElementType {
		AddAttribute,
		AddTerritory,
		AntiTrojan,
		ArcDistribution,
		Code,
		FillLocations,
		FillRandomLocation,
		Group,
		Label,
		LevelTable,
		LocationCriteriaTable,
		Lookup,
		Marker,
		Null,
		Offset,
		Orbitals,
		Particles,
		PlaceRandomStation,
		Primary,
		RandomLocation,
		RandomStation,
		Ship,
		SpaceEnvironment,
		Stargate,
		Station,
		Table,
		Variant,
		Variants,
		VariantTable;

		@Override
		public DesignElement get() {
			// TODO Auto-generated method stub
			DesignElement e = new DesignElement(name());
			if(this != Lookup && this != Null) {
				e.addAttributes(att("debugOnly", BOOLEAN), att("probability", WHOLE));
			}
			DesignAttribute[] att = {};
			switch(this) {
			case AddAttribute:
				e.addAttributes(
						att("attributes", STRING)
				);
				e.addAttributes();
				break;
			case AddTerritory:
				e.addAttributes(
						att("id", STRING),
						att("minRadius", WHOLE),
						att("maxRadius", WHOLE),
						att("criteria", STRING),
						att("attributes", STRING)
				);
				break;
			case AntiTrojan:
				e.addAttributes(
						att("offset", DICE_RANGE)
				);
				break;
			case ArcDistribution:
				e.addAttributes(
						att("count", DICE_RANGE),
						att("radialWidth", WHOLE),
						att("radialEdgeWidth", WHOLE),
						att("scale", SCALE_DISTANCE)
				);
				break;
			case Code:
				break;
			case FillLocations:
			case FillRandomLocation:
				e.addAttributes(
						att("percentFull", WHOLE),
						att("count", WHOLE),
						att("percentEnemies", WHOLE),
						att("stationCriteria", STRING)
				);
				break;
			case Group:
				break;
			case Label:
				e.addAttributes(
						att("attributes", STRING)
				);
				break;
			case LevelTable:
				e.addOptionalMultipleSubElements(SystemLevelTableElements.values());
				break;
			case LocationCriteriaTable:
				e.addOptionalMultipleSubElements(SystemLocationTableElements.values());
				break;
			case Lookup:
				e.addAttributes(
						att("table", STRING)
				);
				break;
			case Marker:
				e.addAttributes(
						att("objName", STRING),
						att("showOrbit", BOOLEAN)
				);
				break;
			case Null:
				break;
			case Offset:
				e.addAttributes(
						att("count", DICE_RANGE),
						att("scale", SCALE_DISTANCE),
						att("radius", DICE_RANGE),
						att("angle", DICE_RANGE),
						att("x", DICE_RANGE),
						att("y", DICE_RANGE)
				);
				break;
			case Orbitals:
				e.addAttributes(
						att("count", DICE_RANGE),
						att("distance", DICE_RANGE),
						att("bodeDistanceStart", DICE_RANGE),
						att("bodeDistanceEnd", DICE_RANGE),
						att("angle", DICE_RANGE),
						att("eccentricity", DICE_RANGE),
						att("rotation", DICE_RANGE),
						att("noOverlay", BOOLEAN),
						att("exclusionRadius", WHOLE),
						att("scale", SCALE_DISTANCE)
				);
				break;
			case Particles:
				e.addAttributes(
						att("name", STRING),
						att("noWake", BOOLEAN),
						att("radius", WHOLE),
						att("minRadius", WHOLE),
						att("dampening", WHOLE),
						att("damage", STRING),
						att("count", DICE_RANGE)
				);
				e.addOptionalSingleSubElements(new DesignElement("ImageDesc") {{
					addAttributes(createImageDescAttributes());
				}});
				break;
			case PlaceRandomStation:
				e.addAttributes(
						att("count", DICE_RANGE),
						att("stationCriteria", STRING),
						att("separateEnemies", BOOLEAN)
				);
				break;
			case Primary:
				break;
			case RandomLocation:
				e.addAttributes(
					att("locationCriteria", STRING),
					att("minDist", WHOLE),
					att("maxDist", WHOLE),
					att("percentFull", WHOLE),
					att("count", DICE_RANGE)
				);
				break;
			case RandomStation:
				e.addAttributes(
					att("stationCriteria", STRING),
					att("locationAttribs", STRING),
					att("includeAll", BOOLEAN),
					att("noSatellites", BOOLEAN),
					att("showOrbit", BOOLEAN),
					att("imageVariant", WHOLE),
					att("paintLayer", PAINT_LAYER),
					att("objName", STRING),
					att("noMapLabel", BOOLEAN),
					att("noConstruction", BOOLEAN),
					att("noReinforcements", BOOLEAN)
				);
				e.addOptionalSingleSubElements(
						DataElements.InitialData.get(),
						new DesignElement("Satellites") {{
							addAttributes(
									att("overlapCheck", OVERLAP_CHECK)
									);
							addOptionalMultipleSubElements(SystemGroupElements.values());
						}},
						new DesignElement("Ships") {{
							addOptionalMultipleSubElements(ShipGeneratorElements.values());
						}},
						new Event("OnCreate")
						);
				break;
			case Ship:
				e.addAttributes(
					att("count", DICE_RANGE)
				);
				break;
			case SpaceEnvironment:
				e.addAttributes(
					att("type", TYPE_SPACE_ENVIRONMENT),
					att("shape", SHAPE_SPACE_ENVIRONMENT),
					att("patches", WHOLE),
					att("patchFrequency", WHOLE),
					att("encountersCount", DICE_RANGE)
				);
				e.addOptionalMultipleSubElements(SystemGroupElements.values());
				break;
			case Stargate:
				e.addAttributes(
					att("objName", STRING)
				);
				break;
			case Station:
				e.addAttributes(
					att("type", TYPE_STATION),
					att("xOffset", INTEGER),
					att("yOffset", INTEGER),
					att("noSatellites", BOOLEAN),
					att("segment", BOOLEAN),
					att("rotation", INTEGER),
					att("backgroundPlane", WHOLE),
					att("sovereign", TYPE_SOVEREIGN)
				);
				e.addOptionalSingleSubElements(DataElements.InitialData.get());
				break;
			case Table:
				e.addOptionalMultipleSubElements(SystemElementTableElements.values());
				break;
			case Variant:
				e.addAttributes(
					att("variant", STRING)
				);
				break;
			case VariantTable:
				break;
			case Variants:
				break;
			default:
				break;
			
			}
			e.addAttributes(att);
			return e;
		}
		enum SystemLevelTableElements implements ElementType {
			AddAttribute,
			AddTerritory,
			AntiTrojan,
			ArcDistribution,
			Code,
			FillLocations,
			FillRandomLocation,
			Group,
			Label,
			LevelTable,
			LocationCriteriaTable,
			Lookup,
			Marker,
			Null,
			Offset,
			Orbitals,
			Particles,
			PlaceRandomStation,
			Primary,
			RandomLocation,
			RandomStation,
			Ship,
			SpaceEnvironment,
			Stargate,
			Station,
			Table,
			Variant,
			Variants,
			VariantTable;

			@Override
			public DesignElement get() {
				DesignElement e = SystemGroupElements.valueOf(name()).get();
				e.addAttributes(att("levelFrequency", LEVEL_FREQUENCY));
				return e;
			}
		}
		enum SystemLocationTableElements implements ElementType {
			AddAttribute,
			AddTerritory,
			AntiTrojan,
			ArcDistribution,
			Code,
			FillLocations,
			FillRandomLocation,
			Group,
			Label,
			LevelTable,
			LocationCriteriaTable,
			Lookup,
			Marker,
			Null,
			Offset,
			Orbitals,
			Particles,
			PlaceRandomStation,
			Primary,
			RandomLocation,
			RandomStation,
			Ship,
			SpaceEnvironment,
			Stargate,
			Station,
			Table,
			Variant,
			Variants,
			VariantTable;

			@Override
			public DesignElement get() {
				DesignElement e = SystemGroupElements.valueOf(name()).get();
				e.addAttributes(att("criteria", STRING));
				return e;
			}
		}
		enum SystemElementTableElements implements ElementType {
			AddAttribute,
			AddTerritory,
			AntiTrojan,
			ArcDistribution,
			Code,
			FillLocations,
			FillRandomLocation,
			Group,
			Label,
			LevelTable,
			LocationCriteriaTable,
			Lookup,
			Marker,
			Null,
			Offset,
			Orbitals,
			Particles,
			PlaceRandomStation,
			Primary,
			RandomLocation,
			RandomStation,
			Ship,
			SpaceEnvironment,
			Stargate,
			Station,
			Table,
			Variant,
			Variants,
			VariantTable;

			@Override
			public DesignElement get() {
				DesignElement e = SystemGroupElements.valueOf(name()).get();
				e.addAttributes(att("chance", WHOLE));
				return e;
			}
		}
	}
	public enum DockScreensElements implements ElementType {
		DockScreen_Named, Pane_Named, Action;
		
		@Override
		public DesignElement get() {
			DesignElement e = null;
			switch(this) {
			case DockScreen_Named:
				e = new RenameableElement("DockScreen");
				e.addOptionalSingleSubElements(TypeFactory.createSingleSubElementsForType(Types.DockScreen));
				break;
			case Pane_Named:
				e = new RenameableElement("Pane");
				e.addAttributes(
						att("layout", LAYOUT),
						att("desc", STRING),
						att("noListNavigation", BOOLEAN),
						att("showCounter", BOOLEAN),
						att("showTextInput", BOOLEAN)
						);
				DesignElement controls = new DesignElement("Controls");
				for(String name : new String[] {"Counter", "ItemDisplay", "ItemListDisplay", "Text", "TextInput"}) {
					DesignElement subelement = new DesignElement(name);
					subelement.addAttributes(
							att("id", STRING),
							att("style", STYLE_CONTROLS)
							);
					controls.addOptionalSingleSubElements(subelement);
				}
				DesignElement actions = new DesignElement("Actions");
				actions.addOptionalMultipleSubElements(DockScreensElements.Action);
				e.addOptionalSingleSubElements(
						new DesignElement("OnPaneInit"),
						new DesignElement("Initialize"),
						controls,
						actions
						);
				break;
			case Action:
				e = new DesignElement("Action");
				e.addAttributes(
						att("name", STRING),
						att("id", STRING),
						att("descID", STRING),
						att("prevKey", BOOLEAN),
						att("nextKey", BOOLEAN),
						att("default", BOOLEAN),
						att("cancel", BOOLEAN),
						att("key", CHARACTER),
						att("minor", BOOLEAN)
						
						);
				DesignElement navigate = new DesignElement("Navigate");
				navigate.addAttributes(att("screen", STRING));
				DesignElement showPane = new DesignElement("ShowPane");
				showPane.addAttributes(att("pane", STRING));
				e.addOptionalSingleSubElements(
						navigate,
						showPane,
						new DesignElement("Exit")
						);
				break;
			}
			return e;
		}
	}
	public static enum DisplayElements implements ElementType {
		Group,
		Text,
		Image;
		@Override
		public DesignElement get() {
			DesignElement e = new DesignElement(name());
			switch(this) {
			case Group:
				e.addAttributes(
						att("left", INTEGER),
						att("top", INTEGER),
						att("width", INTEGER),
						att("height", INTEGER),
						att("center", INTEGER),
						att("vcenter", INTEGER)
						);
				break;
			case Text:
				e.addAttributes(
						att("id", STRING),
						att("left", INTEGER),
						att("right", INTEGER),
						att("top", INTEGER),
						att("bottom", INTEGER),
						att("font", FONT),
						att("color", HEX_COLOR),
						att("align", ALIGN_HORIZONTAL)
						);
				break;
			case Image:
				e.addAttributes(
						att("left", INTEGER),
						att("right", INTEGER),
						att("top", INTEGER),
						att("bottom", INTEGER),
						att("align", ALIGN_HORIZONTAL),
						att("valign", ALIGN_VERTICAL),
						att("transparent", BOOLEAN)
						);
				break;
			}
			return e;
		}
	}
	public enum DisplayAttributesElements implements ElementType {
		ItemAttribute;

		@Override
		public DesignElement get() {
			DesignElement e = new DesignElement(name());
			switch(this) {
			case ItemAttribute:
				e.addAttributes(
						att("label", STRING),
						att("criteria", STRING),
						att("labelType", LABEL_TYPE)
						);
				break;
			};
			return e;
		}
		
	}
	public static enum EffectElements implements ElementType {
		Beam,
		Bolt,
		Damage,
		Ellipse,
		Flare,
		Group,
		Image,
		ImageAndTail,
		ImageFracture,
		LightningStorm,
		MoltenBolt,
		Null,
		Orb,
		Particle,
		ParticleCloud,
		ParticleExplosion,
		ParticlePattern, ParticleComet,
		ParticleSystem, ParticleJet,
		PlasmaSphere,
		Polyflash,
		Ray,
		Sequencer,
		Shape,
		Shockwave,
		SmokeTrail,
		Starburst,
		Text,
		Variants;
		@Override
		public DesignElement get() {
			DesignElement e = new DesignElement(name());
			switch(this) {
			case Beam:
				e.addAttributes(
						att("beamType", BEAM_TYPE),
				        att("intensity", WHOLE),
				        att("primaryColor", HEX_COLOR),
				        att("secondaryColor", HEX_COLOR)
				);
				break;
			case Bolt:
				e.addAttributes(
				        att("length", WHOLE),
				        att("width", WHOLE),
				        att("primaryColor", HEX_COLOR),
				        att("secondaryColor", HEX_COLOR)
				);
				break;
			case Damage:
				e = createWeaponDescElement("Damage");
				break;
			case Ellipse:
				e.addAttributes(
						att("eccentricity", WHOLE),
				        att("lineColor", HEX_COLOR),
				        att("lineStyle", STYLE_LINE),
				        att("lineWidth", WHOLE),
				        att("radius", WHOLE),
				        att("rotation", WHOLE)
				);
				break;
			case Flare:
				e.addAttributes(
						att("lifetime", WHOLE),
				        att("radius", WHOLE),
				        att("primaryColor", HEX_COLOR),
				        att("secondaryColor", HEX_COLOR),
				        att("style", STYLE_FLARE)
				);
				break;
			case Group:
				e.addOptionalMultipleSubElements(EffectElements.values());
				break;
			case Image:
				e.addAttributes(createImageDescAttributes());
				e.addAttributes(
						att("lifetime", WHOLE),
				        att("randomStartFrame", BOOLEAN),
				        att("rotateImage", BOOLEAN),
				        att("rotationCount", WHOLE),
				        att("imageVariants", WHOLE)
						);
				break;
			case ImageAndTail:
				e.addAttributes(createImageDescAttributes());
				e.addAttributes(
						att("imageVariants", WHOLE),
				        att("randomStartFrame", BOOLEAN),
				        att("length", WHOLE),
				        att("width", WHOLE),
				        att("primaryColor", HEX_COLOR),
				        att("secondaryColor", HEX_COLOR)
				        );
				break;
			case ImageFracture:
				System.out.println("ImageFracture Image 1");
				e.addSubElements(new DesignElement("Image") {{
					addAttributes(createImageDescAttributes());
				}});
				System.out.println("ImageFracture Image 2");
				break;
			case LightningStorm:
				e.addAttributes(
						att("intensity", DICE_RANGE),
				        att("lifetime", DICE_RANGE),
				        att("primaryColor", HEX_COLOR),
				        att("secondaryColor", HEX_COLOR),
				        att("style", STYLE_LIGHTNING_STORM));
				break;
			case MoltenBolt:
				e.addAttributes(
						att("length", WHOLE),
				        att("width", WHOLE),
				        att("growth", WHOLE),
				        att("primaryColor", HEX_COLOR),
				        att("secondaryColor", HEX_COLOR));
				break;
			case Null:
				break;
			case Orb:
				e.addAttributes(
						att("animate", ANIMATE_ORB),
						att("blendMode", BLEND_MODE),
						att("detail", DICE_RANGE),
						att("distortion", DICE_RANGE),
						att("lifetime", DICE_RANGE),
						att("intensity", DICE_RANGE),
						att("primaryColor", HEX_COLOR),
						att("radius", DICE_RANGE),
						att("secondaryColor", HEX_COLOR),
						att("spikeCount", DICE_RANGE)
						);
				break;
			case Particle:
				e.addAttributes(
						att("style", STYLE_PARTICLE),
						att("minWidth", WHOLE),
				        att("maxWidth", WHOLE),
				        att("primaryColor", HEX_COLOR),
				        att("secondaryColor", HEX_COLOR)
						);
				break;
			case ParticleCloud:
				e.addAttributes(
						att("drag", INTEGER),
				        att("cohesion", WHOLE_100),
				        att("emitDuration", WHOLE),
				        att("emitRate", DICE_RANGE),
				        att("emitRotation", INTEGER),
				        att("emitSpeed", DICE_RANGE),
				        att("lifetime", DICE_RANGE),
				        att("particleCount", DICE_RANGE),
				        att("particleLifetime", DICE_RANGE),
				        att("radius", WHOLE),
				        att("ringWidth", WHOLE),
				        att("slowMotion", WHOLE),
				        att("spreadAngle", DICE_RANGE),
				        att("style", STYLE_PARTICLE_CLOUD),
				        att("viscosity", WHOLE_100),
				        att("wakePotential", WHOLE_100)
				        );
				e.addSubElements(new DesignElement("ParticleEffect") {{
					addOptionalMultipleSubElements(EffectElements.values());
				}});
				break;
			case ParticleExplosion:
				e.addAttributes(
						att("particleCount", DICE_RANGE),
				        att("particleSpeed", DICE_RANGE),
				        att("particleLifetime", DICE_RANGE),
				        att("lifetime", DICE_RANGE)
						);
				e.addSubElements(new DesignElement("Image") {{
					addAttributes(createImageDescAttributes());
				}});
				break;
			case ParticlePattern:
			case ParticleComet:
				e.addAttributes(
						att("length", DICE_RANGE),
				        att("lifetime", DICE_RANGE),
				        att("particleCount", DICE_RANGE),
				        att("particleSpeed", DICE_RANGE),
				        att("primaryColor", HEX_COLOR),
				        att("secondaryColor", HEX_COLOR),
				        att("spreadAngle", DICE_RANGE),
				        att("style", STYLE_PARTICLE_PATTERN),
				        att("width", DICE_RANGE)
				        );
				break;
			case ParticleSystem:
			case ParticleJet:
				e.addAttributes(
						att("cohesion", DICE_RANGE),
				        att("emitChance", DICE_RANGE),
				        att("emitRate", DICE_RANGE),
				        att("emitSpeed", DICE_RANGE),
				        att("emitLifetime", DICE_RANGE),
				        att("fixedPos", BOOLEAN),
				        att("particleLifetime", DICE_RANGE),
				        att("radius", DICE_RANGE),
				        att("spreadAngle", DICE_RANGE),
				        att("lifetime", DICE_RANGE),
				        att("style", STYLE_PARTICLE_SYSTEM),
				        att("tangentSpeed", DICE_RANGE),
				        att("wakePotential", DICE_RANGE),
				        att("xformRotation", DICE_RANGE),
				        att("xformTime", DICE_RANGE)
						);
				break;
			case PlasmaSphere:
				e.addAttributes(
						att("spikeCount", DICE_RANGE),
				        att("spikeLength", DICE_RANGE),
				        att("primaryColor", HEX_COLOR),
				        att("radius", DICE_RANGE),
				        att("secondaryColor", HEX_COLOR)
						);
				break;
			case Polyflash:
				e.addAttributes();
				break;
			case Ray:
				e.addAttributes(
						att("animate", ANIMATE_RAY),
				        att("animateOpacity", ANIMATE_RAY),
				        att("blendMode", BLEND_MODE),
				        att("intensity", DICE_RANGE),
				        att("length", DICE_RANGE),
				        att("lifetime", DICE_RANGE),
				        att("primaryColor", HEX_COLOR),
				        att("secondaryColor", HEX_COLOR),
				        att("shape", SHAPE_RAY),
				        att("style", STYLE_RAY),
				        att("width", DICE_RANGE),
				        att("xformRotation", DICE_RANGE)
						);
				break;
			case Sequencer:
				e.addOptionalMultipleSubElements(EffectElements.values());
				break;
			case Shape:
				e.addAttributes(
						att("blendMode", BLEND_MODE),
						att("scaleWidth", INTEGER),
				        att("scaleLength", INTEGER),
				        att("color", HEX_COLOR),
				        att("opacity", WHOLE),
				        att("directional", BOOLEAN),
				        att("scaleWidthInc", INTEGER),
				        att("scaleLengthInc", INTEGER)
						);
				e.addSubElements(new DesignElement("Point") {{
					addAttributes(
							att("x", INTEGER),
					        att("y", INTEGER)
					);
				}});
				break;
			case Shockwave:
				e.addAttributes(
						att("blendMode", BLEND_MODE),
				        att("fadeStart", DICE_RANGE),
				        att("glowSize", DICE_RANGE),
				        att("intensity", DICE_RANGE),
				        att("lifetime", DICE_RANGE),
				        att("primaryColor", HEX_COLOR),
				        att("secondaryColor", HEX_COLOR),
				        att("speed", DICE_RANGE),
				        att("style", STYLE_SHOCKWAVE),
				        att("width", DICE_RANGE)
						);
				e.addSubElements(new DesignElement("Image") {{
					addAttributes(createImageDescAttributes());
				}});
				break;
			case SmokeTrail:
				e.addAttributes(
						att("lifetime", DICE_RANGE),
				        att("spread", DICE_RANGE),
				        att("emitDuration", DICE_RANGE),
				        att("particleLifetime", DICE_RANGE),
				        att("emitRate", DICE_RANGE),
				        att("emitSpeed", DICE_RANGE),
				        att("rotation", DICE_RANGE)
				        );
				e.addOptionalSingleSubElements(new DesignElement("ParticleEffect") {{
					addOptionalMultipleSubElements(EffectElements.values());
				}});
				break;
			case Starburst:
				e.addAttributes(
						att("lifetime", DICE_RANGE),
						att("primaryColor", HEX_COLOR),
						att("secondaryColor", HEX_COLOR),
						att("spikeCount", DICE_RANGE),
						att("spikeLength", DICE_RANGE),
						att("style", STYLE_STARBURST)
						);
				break;
			case Text:
				e.addAttributes(
						att("align", ALIGN_HORIZONTAL),
						att("font", FONT),
				        att("opacity", WHOLE),
				        att("primaryColor", HEX_COLOR),
				        att("text", STRING)
						);
				break;
			case Variants:
				e.addOptionalMultipleSubElements(VariantsElements.values());
				break;
			default:
				break;
			}
			e.addOptionalSingleSubElements(new DesignElement("Events") {{
				addOptionalSingleSubElements(new Event("GetParameters"));
			}});
			return e;
		}
		public static enum VariantsElements implements ElementType {
			Beam,
			Bolt,
			Damage,
			Ellipse,
			Flare,
			Group,
			Image,
			ImageAndTail,
			ImageFracture,
			LightningStorm,
			MoltenBolt,
			Null,
			Orb,
			Particle,
			ParticleCloud,
			ParticleExplosion,
			ParticlePattern, ParticleComet,
			ParticleSystem, ParticleJet,
			PlasmaSphere,
			Polyflash,
			Ray,
			Sequencer,
			Shape,
			Shockwave,
			SmokeTrail,
			Starburst,
			Text,
			Variants
			;

			@Override
			public DesignElement get() {
				DesignElement e = EffectElements.valueOf(name()).get();
				e.addAttributes(att("maxValue", INTEGER));
				return e;
			}
			
		}
	}
	public static enum AdventureDescElements implements ElementType {
		EncounterOverrides,

		ArmorDamageAdj,
		ShieldDamageAdj,
		
		;
		@Override
		public DesignElement get() {
			DesignElement result = new DesignElement(name());
			switch(this) {
			case EncounterOverrides:
				result = Types.StationType.get().getOptionalSingleByName("Encounter");
				result.addAttributes(att("unid", TYPE_STATION));
				break;
			case ArmorDamageAdj:
			case ShieldDamageAdj:
				result.addAttributes(
						att("level", WHOLE),
						att("damageAdj", STRING)
						);
				break;
			default:
				break;
			
			}
			return result;
		}
	}
	public static enum DeviceGeneratorElements implements ElementType {
		Device, Item,
		DeviceSlot,
		Table,
		Group, Devices,
		LevelTable,
		Null;

		@Override
		public DesignElement get() {
			DesignElement e = new DesignElement(name());
			switch(this) {
			case Device:
			case Item:
				e.addAttributes(
						att("deviceID", ValueType.TYPE_DEVICE),
						att("count", WHOLE),
						att("level", WHOLE),
						att("posAngle", INTEGER),
						att("posRadius", INTEGER),
						att("posZ", INTEGER),
						att("external", BOOLEAN),
						att("omnidirectional", BOOLEAN),
						att("minFireArc", INTEGER),
						att("maxFireArc", INTEGER),
						att("linkedFire", ValueType.LINKED_FIRE_OPTIONS),
						att("secondaryWeapon", BOOLEAN),
						att("hpBonus", INTEGER)
						);
				e.addOptionalMultipleSubElements(
						ItemGeneratorElements.values()
						);
				break;
			case DeviceSlot:
				e.addAttributes(
						att("criteria", STRING),
						att("maxCount", WHOLE),
						
						att("posAngle", INTEGER),
						att("posRadius", INTEGER),
						att("posZ", INTEGER),
						att("external", BOOLEAN),
						att("omnidirectional", BOOLEAN),
						att("minFireArc", INTEGER),
						att("maxFireArc", INTEGER),
						att("linkedFire", ValueType.LINKED_FIRE_OPTIONS),
						att("secondaryWeapon", BOOLEAN),
						att("hpBonus", INTEGER)
						);
				break;
			case Group:
			case Devices:
			case Table:
				e.addOptionalMultipleSubElements(DeviceTableElements.values());
				break;
			case LevelTable:
				e.addOptionalMultipleSubElements(DeviceLevelTableElements.values());
				break;
			case Null:
				break;
			}
			return e;
		}
		
		//Same as DeviceGeneratorElements, but every element has a chance attribute
		enum DeviceTableElements implements ElementType {
			Device, Item,
			DeviceSlot,
			Table,
			Group, Devices,
			LevelTable,
			Null;
			public DesignElement get() {
				DesignElement result = DeviceGeneratorElements.valueOf(name()).get();
				result.addAttributes(att("chance", WHOLE));
				return result;
			}
		}
		
		//Same as DeviceGeneratorElements, but every element has a levelFrequency attribute
		enum DeviceLevelTableElements implements ElementType {
			Device, Item,
			DeviceSlot,
			Table,
			Group, Devices,
			LevelTable,
			Null;
			public DesignElement get() {
				DesignElement result = DeviceGeneratorElements.valueOf(name()).get();
				result.addAttributes(att("levelFrequency", LEVEL_FREQUENCY));
				return result;
			}
		}
	}
	public static enum ItemElements implements ElementType {
		Weapon;
		public DesignElement get() {
			DesignElement e = new DesignElement(name());
			switch(this) {
			case Weapon:
				e = createWeaponDescElement("Weapon");
				e.addAttributes(
						att("fireRate", WHOLE),
						att("powerUse", WHOLE),
						att("idlePowerUse", WHOLE),
						att("recoil", WHOLE),
						att("failureChance", WHOLE),
						att("minFireArc", WHOLE),
						att("maxFireArc", WHOLE),
						att("charges", BOOLEAN),
						att("omnidirectional", BOOLEAN),
						att("multiTarget", BOOLEAN),
						att("reportAmmo", BOOLEAN),
						att("targetStationsOnly", BOOLEAN),
						att("configuration", WEAPON_CONFIGURATION),
						att("counter", WEAPON_COUNTER),
						att("counterActivate", INTEGER),
						att("counterUpdate", INTEGER),
						att("counterUpdateRate", INTEGER),
						att("heating", INTEGER),
						att("coolingRate", INTEGER),
						att("linkedFire", LINKED_FIRE_OPTIONS),
						att("launcher", BOOLEAN)
						);
				ElementType failure = () -> {
					return new DesignElement("Failure") {{
						addAttributes(
								att("type", FAILURE_TYPE),
								att("chance", WHOLE)
								);
					}};
				};
				e.addOptionalSingleSubElements(new DesignElement("Configuration") {{
					addAttributes(
							att("aimTolerance", INTEGER),
							att("alternating", BOOLEAN)
							);
					addOptionalMultipleSubElements(() -> {
						return new DesignElement("Shot") {{
							addAttributes(
									att("angle", DICE_RANGE),
									att("posAngle", INTEGER),
									att("posRadius", INTEGER)
									);
						}};
					});
				}}, new DesignElement("DamageFailure") {{
					addOptionalMultipleSubElements(failure);
				}}, new DesignElement("OverheatFailure") {{
					addOptionalMultipleSubElements(failure);
				}}, new DesignElement("Missiles") {{
					addOptionalMultipleSubElements(() -> {
						DesignElement missile = createWeaponDescElement("Missile");
						missile.addAttributes(att("ammoID", TYPE_ITEM));
						return missile;
					});
				}}, new DesignElement("Variants") {{
					addOptionalMultipleSubElements(() -> {
						return createWeaponDescElement("Variant");
					});
				}});
				for(String s : new String[] {"Missiles", "Variants"}) {
					e.addOptionalSingleSubElements(new DesignElement(s) {{
						addAttributes(att("type", VARIANT_TYPE));
					}});
				}
				
				break;
			}
			return e;
		}
		
	}
	public static enum ItemGeneratorElements implements ElementType {
		Item,
		Table,
		RandomItem,
		Group, Components, Items, AverageValue,
		Lookup,
		LevelTable,
		LocationCriteria,
		Null;

		@Override
		public DesignElement get() {
			// TODO Auto-generated method stub
			DesignElement e = new DesignElement(name());
			e.addAttributes(
					att("chance", WHOLE),						//Every element//Table, LevelTable, Group, Components, Items, AverageValue, LocationCriteria
					att("count", DICE_RANGE)						//Every element//Table, LevelTable, Group, Components, Items, AverageValue, LocationCriteria
					);
			switch(this) {
			case Item:
				e.addAttributes(
						att("item", ValueType.TYPE_ITEM),
						att("damaged", WHOLE),
						att("debugOnly", BOOLEAN),
						
						att("enhanced", WHOLE),
						att("enhancement", STRING)
						);
				break;
			case Table:
				e.addOptionalMultipleSubElements(
						ItemGeneratorElements.values()
						);
				break;
			case RandomItem:
				e.addAttributes(
						att("criteria", STRING),
						att("attributes", STRING),
						att("modifiers", STRING),
						att("categories", STRING),
						att("levelFrequency", LEVEL_FREQUENCY),
						att("level", WHOLE),
						att("levelCurve", WHOLE),
						att("damaged", WHOLE),
						
						att("enhanced", WHOLE),
						att("enhancement", STRING)
						);
				break;
			case Group:
			case Components:
			case Items:
			case AverageValue:
				e.addAttributes(
						att("levelValue", ValueType.CURRENCY_VALUE_SEQUENCE),
						att("value", CURRENCY_VALUE_SEQUENCE)
						);
				e.addOptionalMultipleSubElements(ItemGeneratorElements.values());
				break;
			case Lookup:
				e.addAttributes(att("table", ValueType.TYPE_ITEM_TABLE));
				break;
			case LevelTable:
				e.addOptionalMultipleSubElements(LevelTableElements.values());
				break;
			case LocationCriteria:
				e.addOptionalMultipleSubElements(LocationCriteriaElements.values());
				break;
			}
			return e;
		}
		enum LocationCriteriaElements implements ElementType {
			Item,
			Table,
			RandomItem,
			Group, Components, Items, AverageValue,
			Lookup,
			LevelTable,
			LocationCriteria,
			Null;
			public DesignElement get() {
				DesignElement e = ItemGeneratorElements.valueOf(name()).get();
				e.addAttributes(att("criteria", STRING));
				return e;
			}
			
		}
		enum LevelTableElements implements ElementType {
			Item,
			Table,
			RandomItem,
			Group, Components, Items, AverageValue,
			Lookup,
			LevelTable,
			LocationCriteria,
			Null;
			public DesignElement get() {
				DesignElement e = ItemGeneratorElements.valueOf(name()).get();
				e.addAttributes(att("levelFrequency", LEVEL_FREQUENCY));
				return e;
			}
		}
	}
	public static enum TradeElements implements ElementType {
		AcceptDonation,
		Buy,
		Sell,
		Refuel,
		RepairArmor,
		ReplaceArmor,
		InstallDevice,
		UpgradeDevice,
		RemoveDevice,
		EnhanceItem,
		RepairItem,
		BuyShip,
		SellShip,
		Custom,;

		@Override
		public DesignElement get() {
			DesignElement e = new DesignElement(name());
			e.addAttributes(
					att("actualPrice", BOOLEAN),
					att("criteria", STRING),
					att("inventoryAdj", WHOLE),
					att("messageID", STRING),
					att("priceAdj", PRICE_ADJ),					
					att("noDescription", BOOLEAN),
					att("upgradeInstallOnly", BOOLEAN),
					att("levelFrequency", LEVEL_FREQUENCY)
					);
			//All trade elements have the same attributes
			return e;
		}
	}
	public static enum SovereignElements implements ElementType {
		//Relationships,
			Relationship,
			
		;

		@Override
		public DesignElement get() {
			// TODO Auto-generated method stub
			DesignElement e = new DesignElement(name());
			switch(this) {
			case Relationship:
				e.addAttributes(
						att("sovereign", TYPE_SOVEREIGN),
						att("disposition", DISPOSITION),
						att("mutual", BOOLEAN)
						);
				break;
			}
			return e;
		}
		
	}
	public static enum ShipGeneratorElements implements ElementType {
		;

		@Override
		public DesignElement get() {
			// TODO Auto-generated method stub
			return new DesignElement("W.I.P.");
		}
		
	}
	public static enum SystemCriteria implements ElementType {
		Attributes,
		Chance,
		DistanceBetweenNodes,
		DistanceTo,
		StargateCount,;

		@Override
		public DesignElement get() {
			DesignElement e = new DesignElement(name());
			switch(this) {
			case Attributes:
				e.addAttributes(att("criteria", STRING));
				break;
			case Chance:
				e.addAttributes(att("chance", WHOLE));
				break;
			case DistanceBetweenNodes:
				e.addAttributes(
						att("min", WHOLE),
						att("max", WHOLE)
						);
				break;
			case DistanceTo:
				e.addAttributes(
						att("criteria", STRING),
						att("nodeID", STRING),
						att("min", WHOLE),
						att("max", WHOLE)
						);
				break;
			case StargateCount:
				e.addAttributes(
						att("min", WHOLE),
						att("max", WHOLE)
						);
				break;
			default:
				break;
			}
			return e;
		}
	}
	public static enum ExtensionElements implements ElementType {
		Module, Library;

		@Override
		public DesignElement get() {
			DesignElement e = new DesignElement(name());
			switch(this) {
			case Library:
				e.addAttributes(att("unid", TYPE_MOD));
				break;
			case Module:
				e.addAttributes(att("filename", STRING));
				break;
			}
			return e;
		}
	}
	
	/*
	switch(s) {
	
		
	case Relationship:
		e = new Element("Relationship");
		
		break;
	case EdgeMask:
		e = new Element("EdgeMask");
		initializeImage(e);
		break;
	case Image:
		e = new Element("Image");
		initializeImage(e);
		break;
	default:
		System.out.println("Not supported: " + s.toString());
		/*
		try {
			throw new Exception("Not supported: " + s.toString());
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		*//*
		e = new Element(s.name());
		break;
	}
	*/
	public static DesignAttribute[] createImageDescAttributes() {
		return new DesignAttribute[] {
				att("imageID", TYPE_IMAGE),
				att("imageX", WHOLE),
				att("imageY", WHOLE),
				att("imageWidth", WHOLE),
				att("imageHeight", WHOLE),
				att("imageFrameCount", WHOLE),
				att("rotationCount", WHOLE),
				att("rotationColumns", WHOLE),
				att("animationColumns", WHOLE),
				att("imageTicksPerFrame", WHOLE),
				att("flashTicks", WHOLE),
				att("blending", BLENDING),
				att("viewportRatio", DECIMAL),
				att("viewportSize", INTEGER),
				att("rotationOffset", INTEGER),
				att("xOffset", INTEGER),
				att("yOffset", INTEGER)
		};
	}
	public static DesignAttribute[] createNameAttributes() {
		return new DesignAttribute[] {
				att("definiteArticle", BOOLEAN),
				att("firstPlural", BOOLEAN),
				att("esPlural", BOOLEAN),
				att("customPlural", BOOLEAN),
				att("secondPlural", BOOLEAN),
				att("reverseArticle", BOOLEAN),
				att("noArticle", BOOLEAN),
				att("personalName", BOOLEAN)
		};
	}
	public static DesignElement createEffect(String name) {
		return new DesignElement(name) {{
			addOptionalMultipleSubElements(TypeFactory.createMultipleSubElementsForType(Types.EffectType));
			addOptionalSingleSubElements(TypeFactory.createSingleSubElementsForType(Types.EffectType));
		}};
	}
	public static DesignElement createWeaponDescElement(String name) {
		return new DesignElement(name) {{
			addAttributes(
					att("type", FIRE_TYPE),
					att("lifetime", DICE_RANGE),
					att("canHitSource", BOOLEAN),
					att("autoAcquireTarget", BOOLEAN),
					att("targetRequired", BOOLEAN),
					att("initialDelay", DICE_RANGE),
					att("noFriendlyFire", BOOLEAN),
					att("noWorldHits", BOOLEAN),
					att("noImmutableHits", BOOLEAN),
					att("noStationHits", BOOLEAN),
					att("noImmobileHits", BOOLEAN),
					att("noShipHits", BOOLEAN),
					att("relativisticSpeed", STRING),
					att("missileSpeed", DICE_RANGE),
					att("effect", TYPE_EFFECT),
					att("stealth", WHOLE),
					att("directional", BOOLEAN),
					att("accelerationFactor", INTEGER),
					att("maxMissileSpeed", INTEGER),
					att("hitPoints", INTEGER),
					att("interaction", INTEGER),
					att("expansionSpeed", DICE_RANGE),
					att("areaDamageDensity", DICE_RANGE),
					att("particleCount", DICE_RANGE),
					att("particleEmitTime", DICE_RANGE),
					att("particleSpreadWidth", DICE_RANGE),
					att("particleSpreadAngle", DICE_RANGE),
					att("particleSplashChange", WHOLE_100),
					att("particleMissChange", WHOLE_100),
					att("minDamage", DICE_RANGE),
					att("minRadius", INTEGER),
					att("maxRadius", INTEGER),
					att("ammoID", TYPE_ITEM),
					att("maneuverability", WHOLE),
					att("maneuverRate", WHOLE_100),
					att("repeating", INTEGER),
					att("passthrough", INTEGER),
					att("damage", STRING),
					att("failsafe", INTEGER),
					att("fragmentRadius", DECIMAL),
					att("fragmentInterval", DICE_RANGE),
					att("hitEffect", TYPE_EFFECT),
					att("vaporTrailWidth", INTEGER),
					att("vaporTrail", INTEGER),
					att("vaporTrailWidthInc", INTEGER),
					att("sound", TYPE_SOUND)
					);
			addOptionalSingleSubElements(
					createEffect("Effect"),
					new DesignElement("Image") {{
						addAttributes(createImageDescAttributes());
					}}, new DesignElement("Exhaust") {{
						addAttributes(
								att("exhaustRate", INTEGER),
								att("exhaustLifetime", INTEGER),
								att("exhaustDrag", INTEGER)
								);
						addSubElements(new DesignElement("Image") {{
							addAttributes(createImageDescAttributes());
						}});
					}}, EffectElements.ParticleSystem.get(),
					createEffect("HitEffect"),
					createEffect("FireEffect"),
					new DesignElement("Events") {{
						addOptionalSingleSubElements(
								new Event("OnFireWeapon"),
								new Event("OnCreateShot"),
								new Event("OnDamageOverlay"),
								new Event("OnDamageShields"),
								new Event("OnDamageArmor"),
								new Event("OnDamageAbandoned"),
								new Event("OnDestroyShot"),
								new Event("OnFragment")
								);
					}}
					);
			addOptionalMultipleSubElements(() -> {
				DesignElement fragment = createWeaponDescElement("Fragment");
				fragment.addAttributes(
						att("count", DICE_RANGE),
						att("fragmentCount", DICE_RANGE),
						att("multiTarget", BOOLEAN),
						att("fragmentTarget", BOOLEAN)
						);
				return fragment;
			});
		}};
	}
	
}