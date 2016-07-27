package util;

import java.io.InputStream;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;

import dto.message.response.ImageMessage;
import dto.message.response.MusicMessage;
import dto.message.response.NewsMessage;
import dto.message.response.TextMessage;
import dto.message.response.VedioMesage;
import dto.message.response.VoiceMessage;

public class MessageUtil {
	public static final String REQ_MESSAGE_TYPE_TEXT = "text";
	public static final String REQ_MESSAGE_TYPE_IMAGE = "image";
	public static final String REQ_MESSAGE_TYPE_VOICE = "voice";
	public static final String REQ_MESSAGE_TYPE_VEDIO = "vedio";
	public static final String REQ_MESSAGE_TYPE_LOCATION = "location";
	public static final String REQ_MESSAGE_TYPE_LINK = "link";
	public static final String REQ_MESSAGE_TYPE_EVENT = "event";
	
	public static final String EVENT_TYPE_SUBSCRIBE = "subscribe";
	public static final String EVENT_TYPE_UNSUBSCRIBE = "unsubscribe";
	public static final String EVENT_TYPE_LOCATION = "location";
	public static final String EVENT_TYPE_SCAN = "scan";
	public static final String EVENT_TYPE_CLICK = "click";
	
	public static final String RESP_MESSAGE_TYPE_TEXT = "text";
	public static final String RESP_MESSAGE_TYPE_IMAGE = "image";
	public static final String RESP_MESSAGE_TYPE_VOICE = "voice";
	public static final String RERESP_MESSAGE_TYPE_VEDIO = "vedio";
	public static final String RESP_MESSAGE_TYPE_MUSIC = "music";
	public static final String RESP_MESSAGE_TYPE_NEWS = "news";
	
	public static Map<String, String> parseXML(HttpServletRequest request) throws Exception {
		SAXReader reader = new SAXReader();
		InputStream inputStream = request.getInputStream();
		Document document = reader.read(inputStream);
		
		Element root = document.getRootElement();
		@SuppressWarnings("unchecked")
		List<Element> elementList = root.elements();
		Map<String, String> map = new HashMap<>();
		for (Element e : elementList) {
			map.put(e.getName(), e.getText());
		}
		inputStream.close();
		return map;
	}
	
	private static XStream xstream = new XStream(new XppDriver() {
		@Override
		public HierarchicalStreamWriter createWriter(Writer out) {
			return new PrettyPrintWriter(out) {
				boolean cdata = true;
				
				public void startNode(String name, @SuppressWarnings("rawtypes") Class clazz) {
					super.startNode(name, clazz);
				}
				
				protected void writeText(QuickWriter writer, String text) {
					if (cdata) {
						writer.write("<![CDATA[");
						writer.write(text);
						writer.write("]]>");
					} else {
						writer.write(text);
					}
				}
			};
		}
	});
	
	public static String messageToXML(TextMessage textMessage) {
		xstream.alias("xml", textMessage.getClass());
		return xstream.toXML(textMessage);
	}
	
	public static String messageToXML(VoiceMessage voiceMessage) {
		xstream.alias("xml", voiceMessage.getClass());
		return xstream.toXML(voiceMessage);
	}
	
	public static String messageToXML(VedioMesage vedioMessage) {
		xstream.alias("xml", vedioMessage.getClass());
		return xstream.toXML(vedioMessage);
	}
	
	public static String messageToXML(MusicMessage musicMessage) {
		xstream.alias("xml", musicMessage.getClass());
		return xstream.toXML(musicMessage);
	}
	
	public static String messageToXML(ImageMessage imageMessage) {
		xstream.alias("xml", imageMessage.getClass());
		return xstream.toXML(imageMessage);
	}
	
	public static String messageToXML(NewsMessage newsMessage) {
		xstream.alias("xml", newsMessage.getClass());
		return xstream.toXML(newsMessage);
	}
}
