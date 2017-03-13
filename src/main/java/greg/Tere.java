package greg;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "springmsgs")
public class Tere {

	@Id
  	@GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    private String content;



    public Tere() { }


	public Tere(long id) { 
	    this.id = id;
	}

	public Tere(String content) { 
	    this.content = content;
	}	

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}