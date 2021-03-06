package sbnz.integracija.example.dto;

import java.util.HashSet;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Value;
import sbnz.integracija.example.facts.*;

public class RecommendDto {
	
	String genre;
	float lowerPrice;
	float higherPrice;
	String platform;
	String theme;
	String playerSupport;
	String specialSection;
	
	public RecommendDto(
			String genre,
			float lowerPrice,
			float higherPrice,
			String platform,
			String theme,
			String playerSupport,
			String specialSection
			) {
		this.genre = genre;
		this.platform = platform;
		this.theme = theme;
		this.playerSupport = playerSupport;
		this.specialSection = specialSection;
		if( higherPrice == 0) {
			this.higherPrice = (float) Double.POSITIVE_INFINITY;
		} else {
			this.higherPrice = higherPrice;
		}
		this.lowerPrice = lowerPrice;
	}
	
	public RecommendDto () {
		this.genre = "";
		this.platform =  "";
		this.theme =  "";
		this.playerSupport =  "";
		this.specialSection =  "";
		this.higherPrice = (float) Double.POSITIVE_INFINITY;
		this.lowerPrice = 0;	
	}
	
	public Set<Tag> dtoToTags() {
		Set<Tag> tags = new HashSet<Tag>();
		
		if(!this.genre.equals("") && this.genre != null) {
			tags.add(new Tag(null, Tag.TagType.GENRE, this.genre));
		}
		if(!this.platform.equals("") && this.platform != null) {
			tags.add(new Tag(null, Tag.TagType.PLATFORM, this.platform));
		}
		if(!this.theme.equals("") && this.theme != null) {
			tags.add(new Tag(null, Tag.TagType.THEME, this.theme));
		}
		if(!this.playerSupport.equals("") && this.playerSupport != null) {
			tags.add(new Tag(null, Tag.TagType.PLAYER_SUPPORT, this.playerSupport));
		}
		if(!this.specialSection.equals("") && this.specialSection != null) {
			tags.add(new Tag(null, Tag.TagType.SPECIAL_SECTION, this.specialSection));
		}
		
		return tags;		
		
	}
	
	public void setGenre(String genre) {
		this.genre = genre;
	}

	public void setLowerPrice(float lowerPrice) {
		this.lowerPrice = lowerPrice;
	}

	public void setHigherPrice(float higherPrice) {
		if( higherPrice == 0) {
			this.higherPrice = (float) Double.POSITIVE_INFINITY;
		} else {
			this.higherPrice = higherPrice;
		}
	}

	public String getGenre() {
		return genre;
	}

	public float getLowerPrice() {
		return lowerPrice;
	}

	public float getHigherPrice() {
		return higherPrice;
	}

	public String getPlatform() {
		return platform;
	}

	public String getTheme() {
		return theme;
	}

	public String getPlayerSupport() {
		return playerSupport;
	}

	public String getSpecialSection() {
		return specialSection;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public void setPlayerSupport(String playerSupport) {
		this.playerSupport = playerSupport;
	}

	public void setSpecialSection(String specialSection) {
		this.specialSection = specialSection;
	}
}
