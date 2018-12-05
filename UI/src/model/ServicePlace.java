package model;

public class ServicePlace {

	private Integer id;
	private Boolean status;
	private AutoMaster masterId;
	private AutoMaster masterId2;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((masterId == null) ? 0 : masterId.hashCode());
		result = prime * result + ((masterId2 == null) ? 0 : masterId2.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ServicePlace other = (ServicePlace) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (masterId == null) {
			if (other.masterId != null)
				return false;
		} else if (!masterId.equals(other.masterId))
			return false;
		if (masterId2 == null) {
			if (other.masterId2 != null)
				return false;
		} else if (!masterId2.equals(other.masterId2))
			return false;
		return true;
	}

	public ServicePlace() {

	}

	public ServicePlace(Integer id, Boolean status, AutoMaster masterId, AutoMaster masterId2) {
		this.id = id;
		this.status = status;
		this.masterId = masterId;
		this.masterId2 = masterId2;
	}

	public AutoMaster getMasterId2() {
		return masterId2;
	}

	public void setMasterId2(AutoMaster masterId2) {
		this.masterId2 = masterId2;
	}

	public AutoMaster getMasterid() {
		return masterId;
	}

	public void setMasterId(AutoMaster masterId) {
		this.masterId = masterId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String toString() {
		return "palce [id=" + id + ", status= " + status + ", masterId= " + masterId + ", masterId2= " + masterId2
				+ "]";
	}

}
