package designType.subElements;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import designType.TypeFactory.Types;
import designType.subElements.SubElementFactory.MiscElements;
import designType.subElements.SubElementFactory.SovereignElements;
import window.Frame;
import window.Window;
import xml.Attribute;
import xml.Element;
import xml.Attribute.ValueType;

public class SingleSubElementFactory {

	//Done
	public static Element createEvents(Types type) {
		Element e = new Element("Events");
		e.addOptionalSingleSubElements(
					new Event("GetGlobalAchievements"),
					new Event("GetGlobalDockScreen"),
					new Event("GetGlobalPlayerPriceAdj"),
					new Event("OnGlobalPaneInit"),
					new Event("OnGlobalMarkImages"),
	
					new Event("OnGlobalObjDestroyed"),
					new Event("OnGlobalPlayerBoughtItem"),
					new Event("OnGlobalPlayerSoldItem"),
					new Event("OnGlobalSystemStarted"),
					new Event("OnGlobalSystemStopped"),
	
					new Event("OnGlobalUniverseCreated"),
					new Event("OnGlobalUniverseLoad"),
					new Event("OnGlobalUniverseSave"),
					new Event("OnGlobalUpdate")
				);
		switch(type) {
		case AdventureDesc:
			e.addOptionalSingleSubElements(
					new Event("OnGameStart"),
					new Event("OnGameEnd")
					);
			break;
		case DockScreen:			break;
		case EconomyType:			break;
		case EffectType:			break;
		case Image:					break;
		case ItemTable:				break;
		case ItemType:				break;
		case MissionType:
			e.addOptionalSingleSubElements(
					new Event("OnCreate"),
					new Event("OnDestroy"),
					new Event("OnAccepted"),
					new Event("OnAcceptedUndock"),
					new Event("OnDeclined"),
					new Event("OnStarted"),
					new Event("OnInProgress"),
					new Event("OnInProgressUndock"),
					new Event("OnSetPlayerTarget"),
					new Event("OnCompleted"),
					new Event("OnCanDebrief"),
					new Event("OnDebriefedUndock"),
					new Event("OnGetNextScreen"),
					new Event("OnReward")
				);
		case NameGenerator:			break;
		case OverlayType:
			e.addOptionalSingleSubElements(
					new Event("OnCreate"),
					new Event("OnUpdate"),
					new Event("OnDamage"),
					new Event("OnDestroy"),
					new Event("OnObjDestroyed")
					);
			break;
		case Power: 				break;
		case ShipClass:
		case StationType:
			e.addOptionalSingleSubElements(
					new Event("CanDockAsPlayer"),
					new Event("CanInstallItem"),
					new Event("GetDockScreen"),
					new Event("GetExplosionType"),
					new Event("GetPlayerPriceAdj"),
					new Event("OnAttacked"),
					new Event("OnAttackedByPlayer"),
					new Event("OnCreate"),
					new Event("OnCreateOrders"),
					new Event("OnDamage"),
					new Event("OnDataTransfer"),
					new Event("OnDeselected"),
					new Event("OnDestroy"),
					new Event("OnDockObjAdj"),
					new Event("OnEnteredGate"),
					new Event("OnEnteredSystem"),
					new Event("OnLoad"),
					new Event("OnMining"),
					new Event("OnObjBlacklistedPlayer"),
					new Event("OnObjDestroyed"),
					new Event("OnObjDocked"),
					new Event("OnObjEnteredGate"),
					new Event("OnObjJumped"),
					new Event("OnObjJumpPosAdj"),
					new Event("OnObjReconned"),
					new Event("OnOrderChanged"),
					new Event("OnOrdersCompleted"),
					new Event("OnEventHandlerInit"),
					new Event("OnMissionAccepted"),
					new Event("OnMissionCompleted"),
					new Event("OnPlayerBlacklisted"),
					new Event("OnPlayerEnteredShip"),
					new Event("OnPlayerEnteredSystem"),
					new Event("OnPlayerLeftShip"),
					new Event("OnPlayerLeftSystem"),
					new Event("OnRandomEncounter"),
					new Event("OnSelected"),
					new Event("OnSubordinateAttacked"),
					new Event("OnSystemExplosion"),
					new Event("OnSystemObjAttacked"),
					new Event("OnSystemObjDestroyed"),
					new Event("OnSystemWeaponFire"),
					new Event("OnTranslateMessage"),
					new Event("OnUpdate")
					);
			break;
		case ShipTable:				break;
		case Sound:					break;
		case Sovereign:				break;
		case SpaceEnvironmentType:
			e.addOptionalSingleSubElements(new Event("OnObjUpdate"));
			break;
		case SystemMap: 			break;
		case SystemTable: 			break;
		case SystemType:
			e.addOptionalSingleSubElements(
					new Event("OnCreate"),
					new Event("OnObjJumpPosAdj")
					);
			break;
		case TemplateType:
			e.addOptionalSingleSubElements(
					new Event("GetTypeSource")
					);
			break;
		case Type:					break;
		default:					break;
		}
		return e;
	}
	//Done
	public static Element createLanguage(Types t) {
		Element e = new Element("Language");
		
		switch(t) {
		case AdventureDesc:
			e.addOptionalSingleSubElements(
					new Text("description")
					);
			break;
		case DockScreen:			break;
		case EconomyType:			break;
		case EffectType:			break;
		case Image:					break;
		case ItemTable:				break;
		case ItemType:				break;
		case MissionType:
			e.addOptionalSingleSubElements(
					new Text("Name"),
					new Text("Summary"),
					new Text("Intro"),
					new Text("Briefing"),
					new Text("AcceptReply"),
					new Text("DeclineReply"),
					new Text("InProgress"),
					new Text("SuccessMsg"),
					new Text("FailureMsg"),
					new Text("SuccessDebrief"),
					new Text("FailureDebrief"),
					new Text("AlreadyDebriefed"),
					new Text("Unavailable")
					);
			break;
		case NameGenerator:			break;
		case OverlayType:			break;
		case Power:					break;
		case ShipClass:				break;
		case ShipTable:				break;
		case Sound:					break;
		case Sovereign:
			e.addOptionalSingleSubElements(
					new Text("AttackTarget"),				//	msgAttack
					new Text("AttackTargetBroadcast"),	//	msgDestroyBroadcast
					new Text("HitByFriendlyFire"),		//	msgHitByFriendlyFire
					new Text("QueryEscortStatus"),		//	msgQueryEscortStatus
					new Text("QueryFleetStatus"),			//	msgQueryFleetStatus
					new Text("EscortAttacked"),			//	msgEscortAttacked
					new Text("EscortReportingIn"),		//	msgEscortReportingIn
					new Text("WatchYourTargets"),			//	msgWatchTargets
					new Text("NiceShooting"),				//	msgNiceShooting
					new Text("FormUp"),					//	msgFormUp
					new Text("BreakAndAttack"),			//	msgBreakAndAttack
					new Text("QueryComms"),				//	msgQueryCommunications
					new Text("AbortAttack"),				//	msgAbortAttack
					new Text("Wait"),						//	msgWait
					new Text("QueryWaitStatus"),			//	msgQueryWaitStatus
					new Text("AttackInFormation"),		//	msgAttackInFormation
					new Text("DeterTarget"),				//	msgAttackDeter
					new Text("QueryAttackStatus"),		//	msgQueryAttackStatus
					new Text("DockingSequenceEngaged"),	//	msgDockingSequenceEngaged
					new Text("HitByHostileFire"),			//	msgHitByHostileFire
					new Text("DestroyedByFriendlyFire"),	//	msgDestroyedByFriendlyFire
					new Text("DestroyedByHostileFire"),	//	msgDestroyedByHostileFire
					new Text("BaseDestroyedByTarget")		//	msgBaseDestroyedByTarget
					);
			break;
		case SpaceEnvironmentType:	break;
		case StationType:			break;
		case SystemMap:				break;
		case SystemTable:			break;
		case SystemType:			break;
		case TemplateType:			break;
		case Type:					break;
		default:
			break;
		}
		return e;
	}

	public static Element[] createSingleSubElementsForType(Types t) {
		switch(t) {
		case AdventureDesc:			break;
		case DockScreen:			break;
		case EconomyType:			break;
		case EffectType:			break;
		case Image:					break;
		case ItemTable:				break;
		case ItemType:				break;
		case MissionType:			break;
		case NameGenerator:			break;
		case OverlayType:			break;
		case Power:
			return new Element[] {
					new Element("OnShow"),
					new Element("OnInvokedByPlayer"),
					new Element("OnInvoke"),
					new Element("OnDestroyCheck")	
			};
		case ShipClass:				break;
		case ShipTable:				break;
		case Sound:					break;
		case Sovereign:
			Element e = new Element("Relationships");
			e.addOptionalMultipleSubElements(SovereignElements.Relationship);
			return new Element[] {
					e
			};
		case SpaceEnvironmentType:	break;
		case StationType:			break;
		case SystemMap:				break;
		case SystemTable:			break;
		case SystemType:			break;
		case TemplateType:			break;
		case Type:					break;
		default:					break;
		}
		return new Element[] {
		};
	}
	public static Element[] createSpaceObjectSubElements() {
		Element dockingPorts = new Element("DockingPorts");
		dockingPorts.addAttributes(
				new Attribute("bringToFront", ValueType.STRING),
				new Attribute("sendToBack", ValueType.STRING),
				new Attribute("maxDist", ValueType.WHOLE),
				new Attribute("portAngle", ValueType.INTEGER),
				new Attribute("portCount", ValueType.WHOLE),
				new Attribute("portRadius", ValueType.INTEGER),
				new Attribute("rotation", ValueType.INTEGER),
				new Attribute("x", ValueType.INTEGER),
				new Attribute("y", ValueType.INTEGER)
				);
		Element trade = new Element("Trade");
		trade.addAttributes(
				new Attribute("currency", ValueType.STRING),
				new Attribute("creditConversion", ValueType.WHOLE),
				new Attribute("max", ValueType.WHOLE),
				new Attribute("replenish", ValueType.WHOLE)
				);
		return new Element[0];
	}
	
	//Done
	public static enum DataElements implements SubElementType {
		StaticData,
		GlobalData,
		InitialData,
		;
		@Override
		public Element create() {
			Element e = new Element(name());
			e.addOptionalMultipleSubElements(MiscElements.Data);
			return e;
		}
	}
}

class Event extends Element {
	public Event(String name) {
		super(name);
	}
}
class Text extends Element {
	String displayName;
	public Text(String id) {
		super();
		displayName = id;
		addAttributes(new Attribute("id", ValueType.STRING, id));
	}
	public String getDisplayName() {
		return displayName;
	}
	//Make uneditable
	public void initializeFrame(Frame frame) {
		JPanel labelPanel = frame.getAttributeLabelPanel();
		JPanel fieldPanel = frame.getAttributeFieldPanel();
		JPanel subElementPanel = frame.getSubElementPanel();
		JTextArea textArea = frame.getTextArea();
		labelPanel.removeAll();
		fieldPanel.removeAll();
		subElementPanel.removeAll();
		
		for(Attribute a : getAttributes()) {
			JLabel label = new JLabel(a.getName() + "=");
			label.setFont(Window.FONT_MEDIUM);
			labelPanel.add(label);
			JLabel value = new JLabel(a.getValue());
			value.setFont(Window.FONT_MEDIUM);
			fieldPanel.add(value);
		}
		
		textArea.setText(getText());
	}
}