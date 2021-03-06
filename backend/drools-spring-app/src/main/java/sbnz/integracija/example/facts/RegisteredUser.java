package sbnz.integracija.example.facts;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "registered_user")
public class RegisteredUser extends User {
	
	@OneToMany(mappedBy="user", fetch = FetchType.EAGER)
    private Set<Purchase> purchases;
	
	@OneToMany(mappedBy="user", fetch = FetchType.EAGER)
    private Set<Rating> ratings;
	
	@ManyToMany(fetch = FetchType.EAGER)
    private Set<Tag> tags;

	public RegisteredUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	private UserRelation status;
    
    public enum UserRelation {
		NA, USER_SIMILAR,  FORM_SIMILAR
	}

	public RegisteredUser(Long id, String email, String password, String firstName, String lastName,
			Set<Authority> authorities) {
		super(id, email, password, firstName, lastName, authorities);
		// TODO Auto-generated constructor stub
    	this.status = UserRelation.NA;
	}

	public Set<Tag> getTags() {
		return tags;
	}

	public void setTags(Set<Tag> tags) {
		this.tags = tags;
	}
	
	public void addRating(Rating rating) {
		if(ratings == null) {
			ratings = new HashSet<>();
		}
		ratings.add(rating);
	}
	
	public void addPurchase(Purchase purchase) {
		if(purchases == null) {
			purchases= new HashSet<>();
		}
		purchases.add(purchase);
	}
	
	
}
