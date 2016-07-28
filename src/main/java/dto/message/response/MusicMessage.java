package dto.message.response;

import com.thoughtworks.xstream.annotations.XStreamAlias;

public class MusicMessage extends BaseMessage {
	@XStreamAlias("Music")
	private Music music;

	public Music getMusic() {
		return music;
	}

	public void setMusic(Music music) {
		this.music = music;
	}
}
