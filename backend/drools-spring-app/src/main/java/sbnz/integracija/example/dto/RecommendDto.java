package sbnz.integracija.example.dto;

import java.util.HashSet;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Value;
import sbnz.integracija.example.facts.*;

@Getter
@Setter
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
	
	public RecommendDto () {}
	
	public Set<Tag> dtoToTags() {
		Set<Tag> tags = new HashSet<Tag>();
		
		if(!this.genre.equals("")) {
			tags.add(new Tag(null, Tag.TagType.GENRE, this.genre));
		}
		if(!this.platform.equals("")) {
			tags.add(new Tag(null, Tag.TagType.PLATFORM, this.platform));
		}
		if(!this.theme.equals("")) {
			tags.add(new Tag(null, Tag.TagType.THEME, this.theme));
		}
		if(!this.playerSupport.equals("")) {
			tags.add(new Tag(null, Tag.TagType.PLAYER_SUPPORT, this.playerSupport));
		}
		if(!this.specialSection.equals("")) {
			tags.add(new Tag(null, Tag.TagType.SPECIAL_SECTION, this.specialSection));
		}
		
		return tags;		
		
	}
}
