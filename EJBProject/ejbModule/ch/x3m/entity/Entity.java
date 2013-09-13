package ch.x3m.entity;

import java.io.Serializable;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Entity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(columnDefinition = "VARCHAR(22)", length = 22, updatable = false, nullable = false)
	private String id;

	public Entity() {
		this.id = UUID.randomUUID().toString().replace("-", "").substring(0, 22);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		return id.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Entity)) {
			return false;
		}
		Entity other = (Entity) obj;
		return getId().equals(other.getId());
	}

}
