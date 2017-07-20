package designType.subElements;

import static xml.DesignAttribute.att;
import static xml.DesignAttribute.ValueType.STRING;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import designType.Types;
import panels.XMLPanel;
import window.FrameOld;
import window.Window;
import xml.DesignAttribute;
import xml.DesignElementOld;
import static window.Window.Fonts.*;
public final class Language {

	//Done
	public static DesignElementOld createLanguage(Types t) {
		DesignElementOld e = new DesignElementOld("Language");
		e.addOptionalMultipleSubElements(
				() -> {
					DesignElementOld text = new DesignElementOld("Text");
					text.addAttributes(att("id", STRING));
					return text;
				},
				() -> {
					DesignElementOld string = new DesignElementOld("String");
					string.addAttributes(att("id", STRING));
					return string;
				},
				() -> {
					DesignElementOld message = new DesignElementOld("Message");
					message.addAttributes(
							att("id", STRING),
							att("text", STRING)
							);
					return message;
				}
				);
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

}
class Text extends DesignElementOld {
	public Text(String id) {
		super();
		addAttributes(att("id", STRING, id));
	}
	public String getDisplayName() {
		return String.format("%-16s%s", "Text", getAttributeByName("id").getValue());
	}
	//Make uneditable
	public void initializeFrame(XMLPanel panel) {
		JPanel labelPanel = panel.labelPanel;
		JPanel fieldPanel = panel.fieldPanel;
		JPanel subElementPanel = panel.subElementPanel;
		JTextArea textArea = panel.textArea;
		labelPanel.removeAll();
		fieldPanel.removeAll();
		subElementPanel.removeAll();
		
		for(DesignAttribute a : getAttributes()) {
			JLabel label = new JLabel(a.getName() + "=");
			label.setFont(Medium.f);
			labelPanel.add(label);
			JLabel value = new JLabel(a.getValue());
			value.setFont(Medium.f);
			fieldPanel.add(value);
		}
		
		textArea.setText(getText());
	}
}
